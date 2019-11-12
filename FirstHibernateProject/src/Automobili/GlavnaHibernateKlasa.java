package Automobili;

import Controler.HibernateDAO;
import Model.Car;

public class GlavnaHibernateKlasa {

	public static void main(String[] args) {

		HibernateDAO dao=new HibernateDAO();

		// Car car = new Car("Maserati","Ghilbi",2016,0.18,true);
		// dao.SnimiAutoUBazu(car);
		
		// Car car = dao.VratiAuto(2);
		// System.out.println(car.getMarka()+" "+car.getModel());
		
		// Car car =dao.VratiAuto(2);
		// dao.updateCarPrice(car.getIdCar(), 1800000);
	
		if(dao.deleteCar(2)) {
			System.out.println("Obrisan je auto");
		}else {
			System.out.println("Nije obrisan auto");
		}
	}
}
