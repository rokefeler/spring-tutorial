package net.rokefeler.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.rokefeler.dao.AdminDao;
import net.rokefeler.pojo.Admin;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;
	
	//método wrapper
	public boolean save(Admin admin)
	{
		admin.setFechacreacion(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}
	
	public List<Admin> findAll(){
		return adminDao.findAll();
	}

	public Admin findById(int id) {
		return adminDao.findById(id);
	}
}
