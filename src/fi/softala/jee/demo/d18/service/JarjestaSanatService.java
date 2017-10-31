package fi.softala.jee.demo.d18.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.jee.demo.d18.bean.Sana;
import fi.softala.jee.demo.d18.dao.SanaDAO;

public class JarjestaSanatService {

	public void aja() {
		annaSanatPaivittain();
	}
	
	public ArrayList<HashMap<String, ArrayList<Sana>>> annaSanatPaivittain() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		SanaDAO dao = (SanaDAO) context.getBean("daoLuokka");
		ArrayList<HashMap<String, ArrayList<Sana>>> noodit = new ArrayList<HashMap<String, ArrayList<Sana>>>();
		ArrayList<Sana> sanat = dao.haeKaikki();
		Date aika = null;
		Sana sana = sanat.get(0);
		aika = sana.getAika();
		SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
		System.out.println(sdf.format(aika));
		ArrayList<Sana> paivanSanat = new ArrayList<Sana>();
		paivanSanat.add(sana);
		
		String edellinenAika = sdf.format(aika);
		for (int i = 1; i < sanat.size(); i++) {
			sana = sanat.get(i);
			aika = sana.getAika();
			sdf = new SimpleDateFormat("d.M.yyyy");
			System.out.println(sdf.format(aika));
			if(edellinenAika.equals(sdf.format(aika))) {
				paivanSanat.add(sana);
				//noodit.add(new HashMap<>(sdf.format(aika),))
			} else {
				HashMap<String, ArrayList<Sana>> sanatNyt = new HashMap<String, ArrayList<Sana>>(); 
				sanatNyt.put(edellinenAika, paivanSanat);
				noodit.add(sanatNyt);
				paivanSanat = new ArrayList<Sana>();
			}
			edellinenAika = sdf.format(aika);
		}
		HashMap<String, ArrayList<Sana>> vikatSanat = new HashMap<String, ArrayList<Sana>>(); 
		vikatSanat.put(sdf.format(aika), paivanSanat);
		noodit.add(vikatSanat);
		return noodit;
	}
	
	public static void main(String[] args) {
		JarjestaSanatService olio = new JarjestaSanatService();
		olio.aja();
	}
}
