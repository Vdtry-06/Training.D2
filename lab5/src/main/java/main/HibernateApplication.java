package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class HibernateApplication {
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		System.out.println("Hibernate đã kết nối PortgreSQL và đã tạo bảng thành công!");
		
		session.getTransaction().commit();
		session.close();
		
		
		HibernateUtil.end();
	}
}
