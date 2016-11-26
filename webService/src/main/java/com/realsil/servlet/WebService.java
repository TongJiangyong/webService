package com.realsil.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.realsil.dao.interfaceGroup.IFrightRecordService;
import com.realsil.dao.interfaceGroup.IRoomService;
import com.realsil.dao.interfaceGroup.IUserService;
import com.realsil.modal.Room;
import com.realsil.modal.User;
import com.realsil.service.FrightRecordService;
import com.realsil.service.RoomService;
import com.realsil.service.UserService;

/**
 * Servlet implementation class WebService
 */
public class WebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserService userService = new UserService();
	private IRoomService roomService =  new RoomService();
	private IFrightRecordService frightRecordService =  new FrightRecordService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebService() {
        super();
        //this.invokeInit();
    }

    //看来不能用反射的方法做....
/*	private void invokeInit() {
		try {
			methodObject = Class.forName("com.realsil.service.WebService").newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   //返回方法名为“testMethod”的一个 Method 对象，后面跟的是该方法参数
		
	}*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action=request.getParameter("action");
		System.out.println("action:"+action);
		//测试连接是否成功
		if(action.equals("connectedTest")){
			this.connectedTest(request, response);
		//获取指定人的相关信息
		}else if (action.equals("getUserInfo")){
			this.getUserInfo(request, response);
		//获取所有人的相关信息
		}else if (action.equals("getAllUserInfo")){
			this.getAllUserInfo(request, response);
		//获取所有房间的相关信息
		}else if (action.equals("getAllRoomInfo")){
			this.getAllRoomInfo(request, response);
		//获取特定房间的相关信息
		}else if (action.equals("getRoomInfo")){
			this.getRoomInfo(request, response);
		//获取指定状态的用户
		}else if (action.equals("getUserInfoByState")){
			this.getUserInfoByState(request, response);
		}
		//获取制定状态的房间
		else if (action.equals("getRoomInfoByState")){
			this.getRoomInfoByState(request, response);
		}
		//增加新的用户
		else if (action.equals("getRoomInfoByState")){
			this.addNewUser(request, response);
		}
		//增加新的房间
		else if (action.equals("getRoomInfoByState")){
			this.addNewRoom(request, response);
		}
		//更新房间信息
		else if (action.equals("getRoomInfoByState")){
			this.updateRoomInfo(request, response);
		}
		//更新用户信息
		else if (action.equals("getRoomInfoByState")){
			this.updateUserInfo(request, response);
		}
		//暂时使用更改状态即可，不使用删除的命令，每次要更新房间状态的时候，顺便判断一下，房间是否为空，是否要更改状态即可 
		else{
			response.getWriter().print("error1");
		}
	}



	//测试连接是否成功	
	private void connectedTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//获取指定人的相关信息	
	private void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		Gson gson =new Gson();
		User user =userService.getById(userId);		
		response.getWriter().print(gson.toJson(user));		
	}	
	//获取所有人的相关信息
	private void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson =new Gson();
		List<User> users =userService.getAll();
		response.getWriter().print(gson.toJson(users));	
	}
	//获取所有房间的相关信息
	private void getAllRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson =new Gson();
		List<Room> rooms =roomService.getAll();
		response.getWriter().print(gson.toJson(rooms));	
	}
	
	//获取特定房间的相关信息 与id的处理相关
	private void getRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId=Integer.parseInt(request.getParameter("roomId"));
		Gson gson =new Gson();
		Room room =roomService.getById(roomId);
		response.getWriter().print(gson.toJson(room));	
	}
	//获取特定状态的相关信息 与state的处理相关	
	private void getRoomInfoByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int state=Integer.parseInt(request.getParameter("state"));
		Gson gson =new Gson();
		List<Room> rooms =roomService.getByState(state);
		response.getWriter().print(gson.toJson(rooms));	
		
	}
	//获取特定用户的相关信息 与state的处理相关		
	private void getUserInfoByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int state=Integer.parseInt(request.getParameter("state"));
		Gson gson =new Gson();
		List<User> users =userService.getByState(state);
		response.getWriter().print(gson.toJson(users));
	}
	

	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userInfo=request.getParameter("userInfo");
		Gson gson =new Gson();	
		User user =gson.fromJson(userInfo, User.class);
		if(userService.update(user)){
			//0表示正常
			response.getWriter().print(0);
		}else{
			//1表示出错
			response.getWriter().print(1);
		}
	}

	private void updateRoomInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomInfo=request.getParameter("roomInfo");
		Gson gson =new Gson();	
		Room room =gson.fromJson(roomInfo, Room.class);
		if(roomService.update(room)){
			//0表示正常
			response.getWriter().print(0);
		}else{
			//1表示出错
			response.getWriter().print(1);
		}
		
	}

	private void addNewRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomInfo=request.getParameter("roomInfo");
		Gson gson =new Gson();	
		Room room =gson.fromJson(roomInfo, Room.class);
		if(roomService.add(room)){
			//0表示正常
			response.getWriter().print(0);
		}else{
			//1表示出错
			response.getWriter().print(1);
		}
		
	}

	private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userInfo=request.getParameter("userInfo");
		Gson gson =new Gson();	
		User user =gson.fromJson(userInfo, User.class);
		if(userService.add(user)){
			//0表示正常
			response.getWriter().print(0);
		}else{
			//1表示出错
			response.getWriter().print(1);
		}
		
	}
	
}
