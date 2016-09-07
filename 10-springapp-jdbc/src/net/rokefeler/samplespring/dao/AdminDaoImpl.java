package net.rokefeler.samplespring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import net.rokefeler.samplespring.pojo.Admin;
import net.rokefeler.samplespring.pojo.AdminRowMapper;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{

	private NamedParameterJdbcTemplate jdbctemplate;
	
	@Autowired
	private void setDataSource(DataSource dataSource){
		this.jdbctemplate = new NamedParameterJdbcTemplate(dataSource);
		
	}
	
	public Boolean save(Admin admin) {
//		MapSqlParameterSource paraMap = new MapSqlParameterSource();
//		paraMap.addValue("nombre", admin.getNombre());
//		paraMap.addValue("cargo", admin.getCargo());
//		paraMap.addValue("fechacreacion", admin.getFechacreacion());
//		
		BeanPropertySqlParameterSource paraMap = new BeanPropertySqlParameterSource(admin);
		
		String sql="Insert into Admin (nombre, cargo, fechacreacion) values (:nombre, :cargo, :fechacreacion)";
		return jdbctemplate.update(sql, paraMap)==1;
	}

	@Override
	public List<Admin> findAll() {
		return jdbctemplate.query("select * from Admin", new AdminRowMapper());			
		
	}

	@Override
	public Admin findById(int id) {
//		return (Admin) jdbctemplate.query("select * from Admin where idAd=:idAd", 
//											new MapSqlParameterSource("idAd",id), 
//											new AdminRowMapper()); 
		return jdbctemplate.queryForObject("select * from Admin where idAd=:idAd", 
				new MapSqlParameterSource("idAd",id), 
				new AdminRowMapper());
	}

	@Override
	public List<Admin> findByNombre(String nombre) {
		nombre = "%" + nombre + "%";
		return jdbctemplate.query("select * from Admin where nombre like :nombre", 
											new MapSqlParameterSource("nombre",nombre), 
											new AdminRowMapper());
	}
	

}
