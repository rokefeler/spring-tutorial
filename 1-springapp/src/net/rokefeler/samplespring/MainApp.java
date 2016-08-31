package net.rokefeler.samplespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-config.xml");
		Administrador administrador=(Administrador) ac.getBean("admin");
		administrador.ImprimirDireccion();
		((ClassPathXmlApplicationContext)ac).close();
	}
}
