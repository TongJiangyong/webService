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
		}
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
		response.getWriter().print("succesed");
	}	
	//获取所有人的相关信息
	private void getAllUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//获取所有房间的相关信息
	private void getAllRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
	//获取特定房间的相关信息
	private void getRoomInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("connected");
	}
}
