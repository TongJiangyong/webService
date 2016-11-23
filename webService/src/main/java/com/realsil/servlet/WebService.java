package com.realsil.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

/**
 * Servlet implementation class WebService
 */
public class WebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		}
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
		response.getWriter().print("succesed");
	}	
	//��ȡ�����˵������Ϣ
	private void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//��ȡ���з���������Ϣ
	private void getAllRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//��ȡ�ض�����������Ϣ
	private void getRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
}
