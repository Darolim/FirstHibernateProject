package Automobili;

import java.util.ArrayList;
import java.util.List;

import Controler.HibernateDAO;
import Model.Car;
import Model.Kupac;
import Model.Prodavac;
import Model.User;
import Model.VisitCard;
import Model.VrstaVozila;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao=new HibernateDAO();

		
		List<Car> C= dao.dajMiSveJeftinijeAutomobile(5000);
		
		for (Car car : C) {
			
			System.out.println(car.getMarka()+ " "+car.getModel());
			
		/*List<Car> C= dao.dajMiSveAutomobileIzBaze();
		
		for (Car car : C) {
			
			System.out.println(car.getMarka()+ " "+car.getModel());
		
		}*/
		
		/*User kupac=dao.VratiUsera(1);
		
		Car car1 = dao.VratiAuto(1);
		Car car2 = dao.VratiAuto(2);
		
		List<Car> automobili = new ArrayList<Car>();
		 automobili.add(car1);
		 automobili.add(car2);
		
		dao.spojiUseraIcar(kupac, automobili);*/
		
		/*VisitCard vizitKarta=new VisitCard();
			vizitKarta.setIme("Šone");
			vizitKarta.setEmail("nesa@gmail.com");
			vizitKarta.setBrojTelefona("064111333");
			
		List<VisitCard> kartice= new ArrayList<VisitCard>();
			kartice.add(vizitKarta);
			
		Kupac kupac =new Kupac();
			kupac.setUserName("Nenad");
			kupac.setPassword("nenad123");
			kupac.setJMBG("9876543210987");
			kupac.setNovcanik(3000000);
			kupac.setVisitCards(kartice);
			
		dao.SnimiUseraUBazu(kupac);
		
		Car car1=new Car();
			car1.setMarka("Fiat");
			car1.setModel("Punto");
			car1.setGodiste(2005);
			car1.setCena(3000);
			car1.setRegistracija(true);
			car1.setVrstaVozila(VrstaVozila.PUTNIČKO);
			
			Car car2=new Car();
			car2.setMarka("BMW");
			car2.setModel("740");
			car2.setGodiste(2018);
			car2.setCena(50000);
			car2.setRegistracija(true);
			car2.setVrstaVozila(VrstaVozila.PUTNIČKO);
		
			dao.SnimiAutoUBazu(car1);
			dao.SnimiAutoUBazu(car2);*/
		
			}
		
	}
	
}

