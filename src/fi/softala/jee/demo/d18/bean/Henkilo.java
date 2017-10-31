package fi.softala.jee.demo.d18.bean;

public class Henkilo {
	private int id;
	private String kayttajatunnus;

	public Henkilo() {
	}
	
	public Henkilo(int id) {
		this.id = id;
	}

	public Henkilo(int id, String kayttajatunnus) {
		super();
		this.id = id;
		this.kayttajatunnus = kayttajatunnus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKayttajatunnus() {
		return kayttajatunnus;
	}

	public void setKayttajatunnus(String kayttajatunnus) {
		this.kayttajatunnus = kayttajatunnus;
	}

	@Override
	public String toString() {
		return "Kayttaja [id=" + id + ", kayttajatunnus=" + kayttajatunnus
				+ "]";
	}
}
