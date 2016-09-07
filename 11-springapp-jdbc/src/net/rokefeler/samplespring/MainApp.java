/*
 * Métodos de Actualizacion y Eliminacion para registros
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
			Admin adm1 = adminDao.findById(1);
			System.out.println("Datos Id=1 es: " + adm1);
			adm1.setCargo("Tesorero");
			adm1.setNombre("Ines Saenz");
			adminDao.update(adm1);
			System.out.println("Datos Actualizados Id=1 es: " + adminDao.findById(1));
			
			if(adminDao.delete(3)){
				System.out.println("Datos de Id=3 Fue ELIMINADO SATISFACTORIAMENTE");
			}
			else{
				System.out.println("No pudo Eliminarse Id=3");
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
