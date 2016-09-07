/*
 * Consultas Personalizadas FindById, FindByNombre
 */
package net.rokefeler.samplespring;

import java.sql.Timestamp;
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

		try {
	
			System.out.println("Datos Id=4 es: " + adminDao.findById(1));
			System.out.println("Datos Id=4 es: " + adminDao.findById(4));
			System.out.println("Datos con [Jo] es: " + adminDao.findByNombre("Jo").toString());
						
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Error al Conectar a Servidor - " + ex.getMessage());
		} catch (DataAccessException ex) {
			System.out.println("Error de Acceso a los Datos - " + ex.getMessage());
		}
		((ClassPathXmlApplicationContext) ac).close();
		/*
		 * Calendar calendar=Calendar.getInstance(); java.util.Date now =
		 * calendar.getTime(); java.sql.Timestamp currentTimestamp = new
		 * java.sql.Timestamp(now.getTime());
		 */
	}
}
