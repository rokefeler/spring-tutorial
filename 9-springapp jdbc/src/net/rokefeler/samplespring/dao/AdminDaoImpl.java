package net.rokefeler.samplespring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
		return jdbctemplate.query("select * from Admin", new RowMapper<Admin>() {

			@Override
			public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
				Admin admin=new Admin();
				
				admin.setIdAd(rs.getInt("idAd"));
				admin.setNombre(rs.getString("nombre"));
				admin.setCargo(rs.getString("cargo"));
				admin.setFechacreacion(rs.getTimestamp("fechacreacion"));
				
				return admin;
			}
			
		});
	}
	

}
