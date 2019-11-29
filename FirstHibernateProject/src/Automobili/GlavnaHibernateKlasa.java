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

		User user = new User();
			user.setUserName("Perhan");
		
		Prodavac prodavac=new Prodavac();
			prodavac.setUserName("Elvis");
			prodavac.setPIB(1);
			
		Kupac kupac =new Kupac();
			kupac.setUserName("Milica");
			kupac.setJMBG("1234567890123");
			
			dao.SnimiUseraUBazu(user);
			dao.SnimiUseraUBazu(kupac);
			dao.SnimiUseraUBazu(prodavac);
		
			}
}
