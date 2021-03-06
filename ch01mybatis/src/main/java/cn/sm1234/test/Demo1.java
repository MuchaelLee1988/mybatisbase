package cn.sm1234.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.sm1234.domain.Customer;

/**
 * 演示MyBatis的入门程序
 * @author lenovo
 *
 */
public class Demo1 {

	public static void main(String[] args) throws Exception {
		//1.创建SqlSessionFactoryBuilder
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//2.创建SqlSessionFactory
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory factory = builder.build(inputStream);
		
		//3.创建SqlSession  （SqlSession可用于执行CRUD操作）
		SqlSession sqlSession = factory.openSession();

		//4.执行操作
		Customer customer = new Customer();
		customer.setName("peter");
		customer.setGender("man");
		customer.setTelephone("13455556666");
		
		sqlSession.insert("insertCustomer",customer);
		
		//5.如果是更新操作，则需要提交事务
		sqlSession.commit();
		
		//6.关闭连接
		sqlSession.close();
	}
}
