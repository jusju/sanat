package fi.softala.jee.demo.d18.dao;

import java.util.List;

import fi.softala.jee.demo.d18.bean.Henkilo;

public interface HenkiloDAO {

	public abstract void talleta(Henkilo osallistuja);

	public abstract Henkilo etsi(int id);

	public abstract List<Henkilo> haeKaikki();

}