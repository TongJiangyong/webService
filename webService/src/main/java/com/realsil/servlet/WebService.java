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

    //���������÷���ķ�����....
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
		   //���ط�����Ϊ��testMethod����һ�� Method ���󣬺�������Ǹ÷�������
		
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
		//���������Ƿ�ɹ�
		if(action.equals("connectedTest")){
			this.connectedTest(request, response);
		//��ȡָ���˵������Ϣ
		}else if (action.equals("getUserInfo")){
			this.getUserInfo(request, response);
		//��ȡ�����˵������Ϣ
		}else if (action.equals("getAllUserInfo")){
			this.getAllUserInfo(request, response);
		//��ȡ���з���������Ϣ
		}else if (action.equals("getAllRoomInfo")){
			this.getAllRoomInfo(request, response);
		//��ȡ�ض�����������Ϣ
		}else if (action.equals("getRoomInfo")){
			this.getRoomInfo(request, response);
		//��ȡָ��״̬���û�
		}else if (action.equals("getUserInfoByState")){
			this.getUserInfoByState(request, response);
		}
		//��ȡ�ƶ�״̬�ķ���
		else if (action.equals("getRoomInfoByState")){
			this.getRoomInfoByState(request, response);
		}
		//�����µ��û�
		else if (action.equals("getRoomInfoByState")){
			this.addNewUser(request, response);
		}
		//�����µķ���
		else if (action.equals("getRoomInfoByState")){
			this.addNewRoom(request, response);
		}
		//���·�����Ϣ
		else if (action.equals("getRoomInfoByState")){
			this.updateRoomInfo(request, response);
		}
		//�����û���Ϣ
		else if (action.equals("getRoomInfoByState")){
			this.updateUserInfo(request, response);
		}
		//��ʱʹ�ø���״̬���ɣ���ʹ��ɾ�������ÿ��Ҫ���·���״̬��ʱ��˳���ж�һ�£������Ƿ�Ϊ�գ��Ƿ�Ҫ����״̬���� 
		else{
			response.getWriter().print("error1");
		}
	}



	//���������Ƿ�ɹ�	
	private void connectedTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//��ȡָ���˵������Ϣ	
	private void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId=Integer.parseInt(request.getParameter("userId"));
		Gson gson =new Gson();
		User user =userService.getById(userId);		
		response.getWriter().print(gson.toJson(user));		
	}	
	//��ȡ�����˵������Ϣ
	private void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson =new Gson();
		List<User> users =userService.getAll();
		response.getWriter().print(gson.toJson(users));	
	}
	//��ȡ���з���������Ϣ
	private void getAllRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson =new Gson();
		List<Room> rooms =roomService.getAll();
		response.getWriter().print(gson.toJson(rooms));	
	}
	
	//��ȡ�ض�����������Ϣ ��id�Ĵ������
	private void getRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roomId=Integer.parseInt(request.getParameter("roomId"));
		Gson gson =new Gson();
		Room room =roomService.getById(roomId);
		response.getWriter().print(gson.toJson(room));	
	}
	//��ȡ�ض�״̬�������Ϣ ��state�Ĵ������	
	private void getRoomInfoByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int state=Integer.parseInt(request.getParameter("state"));
		Gson gson =new Gson();
		List<Room> rooms =roomService.getByState(state);
		response.getWriter().print(gson.toJson(rooms));	
		
	}
	//��ȡ�ض��û��������Ϣ ��state�Ĵ������		
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
			//0��ʾ����
			response.getWriter().print(0);
		}else{
			//1��ʾ����
			response.getWriter().print(1);
		}
	}

	private void updateRoomInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomInfo=request.getParameter("roomInfo");
		Gson gson =new Gson();	
		Room room =gson.fromJson(roomInfo, Room.class);
		if(roomService.update(room)){
			//0��ʾ����
			response.getWriter().print(0);
		}else{
			//1��ʾ����
			response.getWriter().print(1);
		}
		
	}

	private void addNewRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String roomInfo=request.getParameter("roomInfo");
		Gson gson =new Gson();	
		Room room =gson.fromJson(roomInfo, Room.class);
		if(roomService.add(room)){
			//0��ʾ����
			response.getWriter().print(0);
		}else{
			//1��ʾ����
			response.getWriter().print(1);
		}
		
	}

	private void addNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userInfo=request.getParameter("userInfo");
		Gson gson =new Gson();	
		User user =gson.fromJson(userInfo, User.class);
		if(userService.add(user)){
			//0��ʾ����
			response.getWriter().print(0);
		}else{
			//1��ʾ����
			response.getWriter().print(1);
		}
		
	}
	
}
