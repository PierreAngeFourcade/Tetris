package modele;

import java.util.List;

public class Score {
	
	private String name;
	private int total;
	
	public Score(String name, int total){
		this.name = name;
		this.total = total;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
