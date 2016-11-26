package webService;

import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.realsil.dao.A_GetSqlSessionFactory;
import com.realsil.dao.FrightRecordDao;
import com.realsil.dao.RoomDao;
import com.realsil.dao.UserDao;
import com.realsil.modal.FrightRecord;
import com.realsil.modal.Room;
import com.realsil.modal.User;

import junit.framework.TestCase;

public class MybatisTest extends TestCase {
	UserDao userDao = new UserDao();
	FrightRecordDao frightRecordDao = new FrightRecordDao();
	RoomDao roomDao = new RoomDao();
	public void testAdd(){
    	//User user = UserDao.getById(1);
		//实例化日期格式
		SimpleDateFormat formatTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*		User  user= new User();
		user.setLastLoginDate(new Date());
		FrightRecord frightRecord = new FrightRecord();
		frightRecord.setId(3);
		user.setFrightRecord(frightRecord);
		userDao.add(user);
    	System.out.println(formatTime.format(user.getLastLoginDate()));*/
    	//update
    	User updateUser= userDao.getById(1);
    	System.out.println("frightRecord num:"+updateUser.getFrightRecord().getId());
    	updateUser.setRegisterDate(new Date());
    	userDao.update(updateUser);
/*		List<User> users =UserDao.getAll();
		System.out.println(users.size());
	     for(User user:users){
	    	 System.out.println("User:"+user.toString());
         }
         
*/
    	for(Room r:roomDao.getAll()){
    		System.out.println(r.getRoomName());
    	}
	}
	
/*	public void testFrightRecord(){

    	FrightRecord frightRecord= frightRecordDao.getById(1);
    	frightRecord=frightRecordDao.getById(2);
    	System.out.println("frightRecordDao:"+frightRecord.toString());
		List<User> users =UserDao.getAll();
		System.out.println(users.size());
	     for(User user:users){
	    	 System.out.println("User:"+user.toString());
         }

	}*/
}
