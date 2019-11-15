package Automobili;

import Controler.HibernateDAO;
import Model.Car;
import Model.User;
import Model.VisitCard;
import Model.VrstaVozila;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao=new HibernateDAO();

		/*Car car=new Car("Land rover", "Discovery", 2018, 39990, false,VrstaVozila.SUV);
		
		VisitCard visitCard=new VisitCard();
		
		visitCard.setIme("ruzica");
		visitCard.setEmail("ruza@gmail.com");
		visitCard.setBrojTelefona("0641234567");
		
		User user =new User();
		
		user.setUserName("Ruža");
		user.setPassword("ruzaprogramer123");
		user.setNovcanik(100000);
		user.setVisitCard(visitCard);
				
		dao.SnimiUseraUBazu(user);
		dao.SnimiAutoUBazu(car);*/
		
		dao.linkujUseraiAuto(1, 1);
		
		
	}
}
