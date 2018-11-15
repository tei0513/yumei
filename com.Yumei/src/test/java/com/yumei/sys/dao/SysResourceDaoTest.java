package com.yumei.sys.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yumei.sys.entity.SysResource;

/**
 * 资源DAO测试类。
 * 
 * @author Tei
 * @Date 2018年11月14日
 */
@RunWith(SpringRunner.class)
@MapperScan("com.yumei.*.dao")
@SpringBootTest
public class SysResourceDaoTest {
	
	@Autowired
	private SysResourceDao resouceDao;
	
	/**
	 * 测试根据用户ID获取资源
	 */
	@Test
	public void getResouceByUserId() {
		List<SysResource> resources = resouceDao.getResourceByUserId(1);
		for (SysResource resource:resources) {
			resource.getResourceCode();
		}
	}
}
