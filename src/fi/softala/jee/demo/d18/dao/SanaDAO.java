package fi.softala.jee.demo.d18.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fi.softala.jee.demo.d18.bean.Henkilo;
import fi.softala.jee.demo.d18.bean.Sana;

public class SanaDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void talleta(Sana sana) {
		String sql = "INSERT INTO Sanat(sana, seloste, kayttaja_id) VALUES(?,?,?)";
		Object[] parametrit = new Object[] { sana.getSana(), sana.getSeloste(), sana.getKayttaja().getId()};
	    jdbcTemplate.update(sql , parametrit);
	}
	
	
	public ArrayList<Sana> haeKaikki() {
		String sql = "SELECT s.id, s.sana, s.seloste, s.aika, s.kayttaja_id, h.kayttajatunnus, h.id FROM " +
		" Sanat s, Henkilot h WHERE s.kayttaja_id = h.id ORDER BY aika DESC";
		RowMapper<Sana> mapper = new SanaRowMapper();
		ArrayList<Sana> sanat = (ArrayList<Sana>)jdbcTemplate.query(sql,mapper);
		
		return sanat;
	}
}
