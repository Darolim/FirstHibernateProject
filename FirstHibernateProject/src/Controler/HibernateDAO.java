package Controler;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Car;

public class HibernateDAO {

	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	
	public boolean SnimiAutoUBazu (Car car) {
		
		Session sesija = factory.openSession();
			sesija.beginTransaction();
			
		try {
		
			sesija.save(car);
			sesija.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			return false;
			
		}	finally {
			
			sesija.close();
		}
	}

	public Car VratiAuto (int id) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car=null;
		
	try {
	
		car = sesija.get(Car.class, id);
		sesija.getTransaction().commit();
		return car;
		
	} catch (Exception e) {
		
		sesija.getTransaction().rollback();
		return car;
		
	}	finally {
		
		sesija.close();
	}
	}

	public void updateCarPrice (int id, double novaCena) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car=null;
		
	try {
	
		car = sesija.get(Car.class, id);
			car.setCena(novaCena);
		sesija.update(car);
		sesija.getTransaction().commit();
		
	} catch (Exception e) {
		
		sesija.getTransaction().rollback();
		
	}	finally {
		
		sesija.close();
	}
	}
	
	public boolean deleteCar (int id) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		Car car=null;
		
	try {
	
		car = sesija.get(Car.class, id);
		sesija.delete(car);
		return true;
		
	} catch (Exception e) {
		
		sesija.getTransaction().rollback();
		return false;
		
	}	finally {
		
		sesija.close();
	}
	}
}
