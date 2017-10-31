package fi.softala.jee.demo.d18.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fi.softala.jee.demo.d18.bean.Henkilo;
import fi.softala.jee.demo.d18.bean.Sana;
import fi.softala.jee.demo.d18.dao.HenkiloDAO;
import fi.softala.jee.demo.d18.dao.SanaDAO;
import fi.softala.jee.demo.d18.service.JarjestaSanatService;

@WebServlet("/Kontrolleri")
public class Kontrolleri extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Kontrolleri.doGet()");
				
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		SanaDAO dao = (SanaDAO) context.getBean("daoLuokka");
		ArrayList<Sana> sanat = (ArrayList<Sana>) dao.haeKaikki();
		req.setAttribute("sanat", sanat);
		
		ArrayList<HashMap<String, ArrayList<Sana>>> noodit = new ArrayList<HashMap<String, ArrayList<Sana>>>();
		JarjestaSanatService sanaRakenne = new JarjestaSanatService();
		noodit = sanaRakenne.annaSanatPaivittain();
		req.setAttribute("sanarakenne", sanaRakenne);
		
		RequestDispatcher disp = req.getRequestDispatcher("sanat.jsp");
		disp.forward(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Kontrolleri.doPost()");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		SanaDAO dao = (SanaDAO) context.getBean("daoLuokka");
		String sana = req.getParameter("sana");
		String seloste = req.getParameter("seloste");
		String kayttajatunnus = req.getParameter("kayttajatunnus");
		Henkilo henkilo = new Henkilo();
		if(kayttajatunnus.equals("jukka")) {
			henkilo.setId(1);
			henkilo.setKayttajatunnus(kayttajatunnus);
		} else if(kayttajatunnus.equals("inara")) {
			henkilo.setId(2);
			henkilo.setKayttajatunnus(kayttajatunnus);
		}
		Sana nytLisattavaSana = new Sana();
		nytLisattavaSana.setSana(sana);
		nytLisattavaSana.setSeloste(seloste);
		nytLisattavaSana.setKayttaja(henkilo);
		dao.talleta(nytLisattavaSana);
		doGet(req, res);
	}
}
