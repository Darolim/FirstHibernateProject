package Controler;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Car;
import Model.User;

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

	public User VratiUsera (int id) {
		
		Session sesija = factory.openSession();
		sesija.beginTransaction();
		
		User user=null;
		
	try {
	
		user = sesija.get(User.class, id);
		sesija.getTransaction().commit();
		return user;
		
	} catch (Exception e) {
		
		sesija.getTransaction().rollback();
		return user;
		
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
			sesija.getTransaction().commit();
			return true;
		} catch (Exception e) {
			sesija.getTransaction().rollback();
			return false;
		}finally {
			sesija.close();	
		}
	}

	public boolean SnimiUseraUBazu (User user) {
		
		Session sesija = factory.openSession();
			sesija.beginTransaction();
			
		try {
		
			sesija.save(user);
			sesija.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			return false;
			
		}	finally {
			
			sesija.close();
		}
	}

	public boolean daLiUserImaDovoljnoParaZaAutomobile (User user, List<Car>listaAutomobila) {
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		double novcanik=user.getNovcanik();
		
		double krajnjaCena=0;
		
		for (Car car : listaAutomobila) {
			
			krajnjaCena+=car.getCena();
		}
		
		try {
		
			if(novcanik>=krajnjaCena) {
				
				System.out.println("Uspešna kupovina automobila");
				sesija.getTransaction().commit();
				return true;
			}else {
				System.out.println("Nemate dovoljno novca");
				sesija.getTransaction().commit();
				return false;
			}
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			return false;
			 
		} finally {
			
			sesija.close();
			
		}
		}
	
	public void spojiUseraIcar(User user, List<Car>listaAutomobila) {
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		user.setAutomobili(listaAutomobila);
		
		double krajnjaCena=0;
		for (Car car : listaAutomobila) {
			krajnjaCena += car.getCena();
		}
		
		user.setNovcanik(user.getNovcanik()-krajnjaCena);
		
		try {
				
			for (Car car : listaAutomobila) {
				car.setKorisnik(user);
				sesija.update(car);
				krajnjaCena += car.getCena();
			}
			
				sesija.update(user);
				sesija.getTransaction().commit();
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			 
		} finally {
			
			sesija.close();
			
		}
		
		
	}
	
	public void izlistajAutomobile (User user) {
		
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		List<Car> automobili = new ArrayList<Car>();
				
		try {
		
			User u=sesija.get(User.class,user.getIdUser());
			
			// u.getAutomobili().size();
			
			// Hibernate.initialize(u);
			
			// automobili = u.getAutomobili();
			
			automobili = user.getAutomobili();
			
			System.out.println("Korisnik "+user.getUserName()+ " je kupio: ");
			
			for (Car car : automobili) {
				System.out.println(car.getMarka()+" "+car.getModel());
			}
			
			sesija.getTransaction().commit();
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			 
		} finally {
			
			sesija.close();
			
		}
		
	}
	
	public List<Car> dajMiSveAutomobileIzBaze () {
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		List<Car> automobili = new ArrayList<Car>();
		
		try {
			
			String upit = "FROM Car";
			Query query = sesija.createQuery(upit);
			automobili=query.getResultList();
					
			sesija.getTransaction().commit();
			
			return automobili;
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			
			return null;
			
		} finally {
			
			sesija.close();
			
		}
		
	}
	
	public List<Car> dajMiSveJeftinijeAutomobile (double odabranaCena) {
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		List<Car> automobili = new ArrayList<Car>();
		
		try {
			
			String upit = "FROM Car WHERE cena < :Snupi";
			Query query = sesija.createQuery(upit);
				query.setParameter("Snupi", odabranaCena);
			automobili=query.getResultList();
					
			sesija.getTransaction().commit();
			
			return automobili;
			
		} catch (Exception e) {
			
			sesija.getTransaction().rollback();
			
			return null;
			
		} finally {
			
			sesija.close();
			
		}
		
	}
/*	public void linkujUseraiAuto (int idCar, int idUser) {
		
		Session sesija=factory.openSession();
		sesija.beginTransaction();
		
		Car car;
		User user;
		
		try {
			car=sesija.get(Car.class, idCar);
			user=sesija.get(User.class, idUser);
			
			car.setKorisnik(user);
			user.setAuto(car);
			
			sesija.getTransaction().commit();
		} catch (Exception e) {
			sesija.getTransaction().rollback();
		} finally {
			sesija.close();
		}
		
	}*/
}
