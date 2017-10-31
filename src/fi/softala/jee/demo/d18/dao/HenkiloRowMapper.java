package fi.softala.jee.demo.d18.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.jee.demo.d18.bean.Henkilo;
import fi.softala.jee.demo.d18.bean.Sana;

public class HenkiloRowMapper implements RowMapper<Henkilo> {

	@Override
	public Henkilo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Henkilo k = new Henkilo();
		k.setId(rs.getInt("id"));
		k.setKayttajatunnus(rs.getString("kayttajatunnus"));
		return k;
	}
}