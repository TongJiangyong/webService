package com.realsil.servlet;

import java.io.IOException;
import java.util.Date;
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
		//��¼��Ϣ�鿴
		}else if (action.equals("userLogin")){
			this.userLogin(request, response);
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
		else if (action.equals("addNewUser")){
			this.addNewUser(request, response);
		}
		//�����µķ���
		else if (action.equals("addNewRoom")){
			this.addNewRoom(request, response);
		}
		//���·�����Ϣ
		else if (action.equals("updateRoomInfo")){
			this.updateRoomInfo(request, response);
		}
		//�����û���Ϣ
		else if (action.equals("updateUserInfo")){
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
		System.out.println("getRoomInfo :"+roomId);
		Gson gson =new Gson();
		Room room =roomService.getById(roomId);
		response.getWriter().print(gson.toJson(room));	
	}
	//��ȡ�ض�״̬�������Ϣ ��state�Ĵ������	
	private void getRoomInfoByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int state=Integer.valueOf(request.getParameter("state"));
		System.out.println("getRoomInfoByState :"+state);
		Gson gson =new Gson();
		//����������ǳ����ã�mybatis���������⣬������
		if(state ==3){
			List<Room> rooms_1  =roomService.getByState(1);	
			List<Room> rooms_2 =roomService.getByState(2);	
			if(rooms_2.size()!=0){
				rooms_1.addAll(rooms_2);
			}
			response.getWriter().print(gson.toJson(rooms_1));	
		}else{
			List<Room> rooms =roomService.getByState(state);
			response.getWriter().print(gson.toJson(rooms));			
		}

		
	}
	//��ȡ�ض��û��������Ϣ ��state�Ĵ������		
	private void getUserInfoByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int state=Integer.parseInt(request.getParameter("state"));
		System.out.println("getUserInfoByState :"+state);
		Gson gson =new Gson();
		List<User> users =userService.getByState(state);
		response.getWriter().print(gson.toJson(users));			
	}
	

	private void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userInfo=request.getParameter("userInfo");
		System.out.println("updateUserInfo :"+userInfo);	
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
		System.out.println("updateRoomInfo :"+roomInfo);
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
		System.out.println("addNewRoom :"+roomInfo);
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
		System.out.println("addNewUser ***************************************");
		String userInfo=request.getParameter("userInfo");
		System.out.println("addNewUser :"+userInfo);
		Gson gson =new Gson();	
		User user =gson.fromJson(userInfo, User.class);
		//�ж�ע���Ƿ�����
		List<User> users = userService.getAll();
		System.out.println("userService :"+users.size());
		boolean flag =false;
		for(User u:users){
			//System.out.println("addNewUser u  :"+u.toString());
			if(u.getUsername().equals(user.getUsername().trim())){
				//System.out.println("has user");
				flag = true;
				break;		
			}

		}
		if(flag){	
			//#��ʾ ����
			response.getWriter().print("#");	
		}else{
			user.setRegisterDate(new Date());
			if(userService.add(user)){
				//0��ʾ����
				response.getWriter().print(0);
			}else{
				//$��ʾ����
				response.getWriter().print(1);
			}
		}
	}
	
	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userInfo=request.getParameter("userInfo");
		System.out.println("userLogin :"+userInfo);	
		Gson gson =new Gson();	
		User user =gson.fromJson(userInfo, User.class);
		System.out.println("user getUsername :"+user.getUsername()+"user getPassword :"+user.getPassword());
		List<User> users = userService.getAll();
		User loginUser = new User();
		boolean flag =false;
		//�ж��û����������Ƿ���ȷ 
		for(User u:users){
			//System.out.println("list user:"+u.toString());
			if(u.getUsername().equals(user.getUsername())&&u.getPassword().equals((user.getPassword()))){
				flag = true;
				loginUser = u;
				//���¸��û��ĵ�¼��Ϣ
				loginUser.setLastLoginDate(new Date());
				userService.update(loginUser);
				break;		
			}
		}
		//���ظ��û���ID��
		//���ݿ����и��û�
		if(flag){	
			//n��ʾ ���û�,���û�IDΪ����ֵ
			response.getWriter().print(gson.toJson(loginUser));	
		}else{
			//0��ʾû���û�
			response.getWriter().print(0);	
		}
	}
	
}
