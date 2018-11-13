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
}
