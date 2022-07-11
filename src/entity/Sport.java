package entity;

public class Sport {
	private int sportId;
	private String sport;
	
	public Sport(int sportId, String sport) {
		this.setSportId(sportId);
		this.setSport(sport);
	}
	
	public int getSportId() {
		return sportId;
	}
	
	public void setSportId(int sportId) {
		this.sportId = sportId;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
	
	

}
