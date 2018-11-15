package com.yumei.sys.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yumei.sys.entity.SysRole;

/**
 * 角色Dao测试类。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
@RunWith(SpringRunner.class)
@MapperScan("com.yumei.*.dao")
@SpringBootTest
public class SysRoleDaoTest {
	@Autowired
	private SysRoleDao sysRoleDao;
	
	/**
	 * 测试根据用户ID获取角色
	 */
	@Test
	public void getRoleByUserId() {
		List<SysRole> roles = sysRoleDao.getRoleByUser(1);
		
		for (SysRole role : roles) {
			role.getRoleId();
		}
	}
}
