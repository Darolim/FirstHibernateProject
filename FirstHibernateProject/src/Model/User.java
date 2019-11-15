package Model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="korisnik")

public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;
	@Column(name="User_Name")
	private String UserName;
	private String password;
	private double novcanik;
	@Embedded
	private VisitCard visitCard;
	@OneToOne	
	private Car auto;
	
	public Car getAuto() {
		return auto;
	}
	public void setAuto(Car auto) {
		this.auto = auto;
	}
	public VisitCard getVisitCard() {
		return visitCard;
	}
	public void setVisitCard(VisitCard visitCard) {
		this.visitCard = visitCard;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getNovcanik() {
		return novcanik;
	}
	public void setNovcanik(double novcanik) {
		this.novcanik = novcanik;
	}
	
}
