package net.rokefeler.samplespring.dao;

import java.util.List;

import net.rokefeler.samplespring.pojo.Admin;

public interface AdminDao {
	
	public Boolean save(Admin admin);
	
	public List<Admin> findAll();
	
	public Admin findById(int id);
	
	public List<Admin> findByNombre(String nombre);

}
