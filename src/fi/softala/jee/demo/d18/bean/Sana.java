package fi.softala.jee.demo.d18.bean;

import java.util.Date;

public class Sana {
	private int id;
	private String sana;
	private String seloste;
	private Henkilo kayttaja;
	private Date aika;

	public Sana() {
	}

	public Sana(int id, String sana, String seloste, Henkilo kayttaja, Date aika) {
		super();
		this.id = id;
		this.sana = sana;
		this.seloste = seloste;
		this.kayttaja = kayttaja;
		this.aika = aika;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSana() {
		return sana;
	}

	public void setSana(String sana) {
		this.sana = sana;
	}

	public String getSeloste() {
		return seloste;
	}

	public void setSeloste(String seloste) {
		this.seloste = seloste;
	}

	public Henkilo getKayttaja() {
		return kayttaja;
	}

	public void setKayttaja(Henkilo kayttaja) {
		this.kayttaja = kayttaja;
	}

	public Date getAika() {
		return aika;
	}

	public void setAika(Date aika) {
		this.aika = aika;
	}

	@Override
	public String toString() {
		return "Sana [id=" + id + ", sana=" + sana + ", seloste=" + seloste
				+ ", kayttaja=" + kayttaja + ", aika=" + aika + "]";
	}

}
