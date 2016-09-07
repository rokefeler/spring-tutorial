/*
 * Aqui, vamos a modificar el POM para crear una conexion jdbc 
	creación de Dao y Pojo
 */
package net.rokefeler.samplespring;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rokefeler.samplespring.dao.AdminDao;
import net.rokefeler.samplespring.pojo.Admin;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
		
		AdminDao adminDao=(AdminDao) ac.getBean("adminDao");
				
		Timestamp ts = new Timestamp(new Date().getTime());
		Admin admin = new Admin();
		admin.setCargo("Gerente");
		admin.setNombre("Jose Ruelas");
		admin.setFechacreacion(ts);
		
		if (adminDao.save(admin)){
			System.out.println("Admin Salvado Correctamente");
		}else
			System.out.println("Error al Insertar el Objeto");
		/*
		Calendar calendar=Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());*/
		
		((ClassPathXmlApplicationContext)ac).close();
	}
}
