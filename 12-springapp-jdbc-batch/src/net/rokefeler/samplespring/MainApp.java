/*
 * Insertar Registros en BLoque, uso de JDBC Batch 
 */
package net.rokefeler.samplespring;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import net.rokefeler.samplespring.dao.AdminDao;
import net.rokefeler.samplespring.pojo.Admin;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-config.xml");

		AdminDao adminDao = (AdminDao) ac.getBean("adminDao");
		Timestamp ts = new Timestamp(new Date().getTime()); 
		try {
			List<Admin> admins=new ArrayList<Admin>();
			for(int i=1; i<=10; i++){
				admins.add(new Admin("Owen " + i, "Alumno " + i, ts));
			}
			int res[]=adminDao.saveAll(admins);
			for (int i : res) {
				System.out.println("filas afectadas para la operacion: " + i);
			}
			
			System.out.println("Datos de Registros son: " + adminDao.findAll().toString());
						
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Error al Conectar a Servidor - " + ex.getMessage());
		} catch (DataAccessException ex) {
			System.out.println("Error de Acceso a los Datos - " + ex.getMessage());
		}
		((ClassPathXmlApplicationContext) ac).close();
		
	}
}
