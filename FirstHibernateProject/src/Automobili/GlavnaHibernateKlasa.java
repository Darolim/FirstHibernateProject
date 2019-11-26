package Automobili;

import java.util.ArrayList;
import java.util.List;

import Controler.HibernateDAO;
import Model.Car;
import Model.User;
import Model.VisitCard;
import Model.VrstaVozila;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao=new HibernateDAO();

		Car auto1 = dao.VratiAuto(1);
		Car auto2 = dao.VratiAuto(3);
		
		List<Car> ruziniAutici = new ArrayList<Car>();
		 ruziniAutici.add(auto1);
		 ruziniAutici.add(auto2);
		 
		User user=dao.VratiUsera(1);
		
		if(dao.daLiUserImaDovoljnoParaZaAutomobile(user, ruziniAutici)) {
			
			dao.spojiUseraIcar(user, ruziniAutici);
	
		} 
		/*Car car1=new Car("Chrysler", "300c", 2010, 35000, false,VrstaVozila.PUTNIČKO);
		Car car2=new Car("Dodge", "Caliber", 2017, 10000, false,VrstaVozila.PUTNIČKO);
		Car car3=new Car("Lexus", "lc500", 20109, 110000, false,VrstaVozila.PUTNIČKO);
		Car car4=new Car("Lada", "Niva", 2019, 19000, false,VrstaVozila.TERENAC);
		
		dao.SnimiAutoUBazu(car1);
		dao.SnimiAutoUBazu(car2);
		dao.SnimiAutoUBazu(car3);
		dao.SnimiAutoUBazu(car4);
		
		VisitCard visitCard1=new VisitCard();
		visitCard1.setIme("ruzica");
		visitCard1.setEmail("ruza@gmail.com");
		visitCard1.setBrojTelefona("064123456789");
		
		VisitCard visitCard2=new VisitCard();
		visitCard2.setIme("ruzica");
		visitCard2.setEmail("ruza@gmail.com");
		visitCard2.setBrojTelefona("064123456789");
		
		List<VisitCard> vizitke = new ArrayList<VisitCard>();
		vizitke.add(visitCard1);
		vizitke.add(visitCard2);
		
		User user=new User();
		
		user.setUserName("Ruža");
		user.setPassword("ruza123");
		user.setNovcanik(200000);
		user.setVisitCards(vizitke);
		
		dao.SnimiUseraUBazu(user);*/
		
		/*User user=dao.VratiUsera(1);
		System.out.println(user.getUserName());
		
		dao.izlistajAutomobile(user);*/
		
		/*Car auto1 = dao.VratiAuto(2);
		Car auto2 = dao.VratiAuto(3);
		Car auto3 = dao.VratiAuto(5);
		
		List<Car> ruziniAutomobili = new ArrayList<Car>();
		
		ruziniAutomobili.add(auto1);
		ruziniAutomobili.add(auto2);
		ruziniAutomobili.add(auto3);
		
		if(dao.daLiUserImaDovoljnoParaZaAutomobile(user, ruziniAutomobili)) {
			
			dao.spojiUseraIcar(user, ruziniAutomobili);
			
		}
		
		
		
		
		*/
		
		
	}
}
