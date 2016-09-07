/*
 * Aqui, verificar Try Catch en Conexiones, se prueba bajando el servicio de DDBB y error en nombre usuario spring-config.xml
 */
package net.rokefeler.samplespring;

import java.sql.Timestamp;
import java.util.Date;

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
		Admin admin = new Admin();
		admin.setCargo("Contador");
		admin.setNombre("Luis Salgado");
		admin.setFechacreacion(ts);

		try {
			if (adminDao.save(admin)) {
				System.out.println("Admin Salvado Correctamente");
			} else
				System.out.println("Error al Insertar el Objeto");
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Error al Conectar a Servidor - " + ex.getMessage());
		} catch (DataAccessException ex) {
			System.out.println("Error de Acceso a los Datos - " + ex.getMessage());
		}

		/*
		 * Calendar calendar=Calendar.getInstance(); java.util.Date now =
		 * calendar.getTime(); java.sql.Timestamp currentTimestamp = new
		 * java.sql.Timestamp(now.getTime());
		 */

		((ClassPathXmlApplicationContext) ac).close();
	}
}
