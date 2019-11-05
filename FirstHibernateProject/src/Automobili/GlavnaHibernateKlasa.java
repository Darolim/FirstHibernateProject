package Automobili;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Car;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		SessionFactory factory=new Configuration().configure().buildSessionFactory();
		
		Car car=new Car("Bugatti","Vayron",2015,1.8,true);
		
		Session sesija=factory.openSession();
			sesija.beginTransaction();
			
			try {
			
				sesija.save(car);
				System.out.println("Podaci su uspešno ubačeni u bazu");
				sesija.getTransaction().commit();
				
			} catch (Exception e) {
				sesija.getTransaction().rollback();
			}
			
		sesija.close();
	}
}
