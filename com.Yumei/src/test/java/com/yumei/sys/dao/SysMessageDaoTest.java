package com.yumei.sys.dao;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yumei.sys.entity.SysMessage;

/**
 * 状态码DAO测试类。
 * 
 * @author Tei
 * @Date 2018年11月17日
 */
@RunWith(SpringRunner.class)
@MapperScan("com.yumei.*.dao")
@SpringBootTest
public class SysMessageDaoTest {
	
	@Autowired
	SysMessageDao sysMessageDao;
	
	/**
	 * 测试获取所有状态码
	 */
	@Test
	public void findAll() {
		List<SysMessage> messages = sysMessageDao.findAll();
		assertNotNull(messages);
	}
}
