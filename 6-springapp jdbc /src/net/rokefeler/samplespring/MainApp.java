/*
 * Aqui, vamos a modificar el POM para crear una conexion jdbc 
	creación de Dao y Pojo
 */
package net.rokefeler.samplespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.rokefeler.samplespring.pojo.Admin;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
		Admin administrador=(Admin) ac.getBean("admin");
		System.out.println(administrador);
		//administrador.ImprimirDireccion();
		((ClassPathXmlApplicationContext)ac).close();
	}
}
