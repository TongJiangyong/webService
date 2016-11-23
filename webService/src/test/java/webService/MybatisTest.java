package webService;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.realsil.dao.GetSqlSessionFactory;
import com.realsil.dao.UserDao;
import com.realsil.modal.User;

import junit.framework.TestCase;

public class MybatisTest extends TestCase {
	UserDao UserDao = new UserDao();
	
	@Test
	public void testAdd(){
    	//User user = UserDao.getById(1);
		List<User> users =UserDao.getAllUsers();
	     for(User user:users){
	         System.out.println(user.getId());
	         System.out.println(user.getPassword());
         }

	}
}
