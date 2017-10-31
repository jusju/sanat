package fi.softala.jee.demo.d18.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.jee.demo.d18.bean.Henkilo;
import fi.softala.jee.demo.d18.bean.Sana;

public class SanaRowMapper implements RowMapper<Sana> {

	@Override
	public Sana mapRow(ResultSet rs, int rowNum) throws SQLException {
		Sana s = new Sana();
		s.setSana(rs.getString("sana"));
		s.setSeloste(rs.getString("seloste"));
		s.setKayttaja(new Henkilo(rs.getInt("kayttaja_id"), rs.getString("kayttajatunnus")));
		s.setAika(rs.getDate("aika"));
		return s;
	}
}