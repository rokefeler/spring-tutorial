package net.rokefeler.samplespring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import net.rokefeler.samplespring.pojo.Admin;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	private NamedParameterJdbcTemplate jdbctemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbctemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	public Boolean save(Admin admin) {
		MapSqlParameterSource paraMap = new MapSqlParameterSource();
		paraMap.addValue("nombre", admin.getNombre());
		paraMap.addValue("cargo", admin.getCargo());
		paraMap.addValue("fechacreacion", admin.getFechacreacion());
		
		String sql="Insert into Admin (nombre, cargo, fechacreacion) values (:nombre, :cargo, :fechacreacion)";
		return jdbctemplate.update(sql, paraMap)==1;
	}
	

}
