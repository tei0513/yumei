package com.yumei.sys.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yumei.sys.entity.SysUser;

/**
 * 登陆用户DAO测试类。
 * 
 * @author Tei
 * @Date 2018年11月13日
 */
@RunWith(SpringRunner.class)
@MapperScan("com.yumei.*.dao")
@SpringBootTest
public class SysUserDaoTest {
	/** 测试用用户ID */
	private static final int TEST_ID = 9;
	
	@Autowired
	SysUserDao sysUserDao;
	
	/**
	 * 测试根据登陆名获取用户信息
	 */
	@Test
	public void getUserByName() {
		SysUser user = sysUserDao.getUserByName("test");
		// 判断是否为空
		assertNotNull(user);
		// 断言用户昵称是否正确
		assertEquals("test", user.getNickName());
	}
	
	
	/**
	 * 测试保存用户
	 */
	@Test
	public void saveUser() {
		SysUser user = new SysUser();
		user.setLoginName("Asahi");
		user.setNickName("Asahi");
		user.setPassword("123456");
		user.setPhone("15001715231");
		user.setStatus(1);
		user.setEmail("123@123.com");
		user.setCreateUserName("test");
		user.setUpdateUserName("test");
		int result = sysUserDao.saveUser(user);
		assertEquals(1, result);
	}
	
	/**
	 * 测试修改用户
	 */
	@Test
	public void updateUser() {
		SysUser user = new SysUser();
		user.setLoginName("Asahi");
		user.setUserId(TEST_ID);
		user.setNickName("Asahi");
		user.setPassword("88888888");
		user.setPhone("15001715231");
		user.setStatus(1);
		user.setEmail("123@123.com");
		user.setCreateUserName("test");
		user.setUpdateUserName("test");
		int result = sysUserDao.updateUserById(user);
		assertEquals(1, result);
	}
}
