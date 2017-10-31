package fi.softala.jee.demo.d18.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.jee.demo.d18.bean.Henkilo;
import fi.softala.jee.demo.d18.bean.Sana;
import fi.softala.jee.demo.d18.dao.HenkiloDAO;
import fi.softala.jee.demo.d18.dao.SanaDAO;
import fi.softala.jee.demo.d18.helper.Email;

public class SanalistaHandler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("SanalistaHandler.main()");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		SanaDAO dao = (SanaDAO)context.getBean("daoLuokka");
		
		System.out.println("-------------------");
		System.out.println("LISTATAAN KAIKKI");
		System.out.println("-------------------");
		
		List<Sana> sanat = dao.haeKaikki();
		for (Sana s : sanat) {
			Date aikaKannasta = s.getAika();
			Date aikaNyt = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
			String aikaKannastaStringina = sdf.format(aikaKannasta);
			System.out.println(aikaKannastaStringina);
			String aikaNytStringina = sdf.format(aikaNyt);
			if(aikaKannastaStringina.equals(aikaNytStringina)) {
					Email email = new Email();
					try {
						email.lahetaSahkoposti("jjuslin@gmail.com",
								"Loskv94!", "jukka.juslin@haaga-helia.fi",
								"This day has new words!",
								"This day has new words - go and check!");
					} catch (Exception ex) {
						System.out.println("Google salasana tjsp. on vaarin.");
					}
			}
			
		}
	}

}
