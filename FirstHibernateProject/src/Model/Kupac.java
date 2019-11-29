package Model;

import javax.persistence.Entity;

@Entity

public class Kupac extends User {

	private String JMBG;

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}


	
	
}
