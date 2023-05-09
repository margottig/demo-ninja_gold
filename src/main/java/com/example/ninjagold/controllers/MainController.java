package com.example.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@SuppressWarnings("unchecked")
	@PostMapping("/gold")
	public String enviarGold(HttpSession sesion, @RequestParam(value = "lugar", required = false) String lugar) {
//		System.out.println(lugar);
		
		//variables de inicio
		int gold = 0;
		ArrayList<String> actividades = new ArrayList<String>();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("MMMM D Y h:mm a");
//		ing timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		// iniciar gold key
		if (sesion.getAttribute("gold") == null) {
			sesion.setAttribute("gold", gold);
			sesion.setAttribute("actividades", actividades);
		} else {
			gold = (int) sesion.getAttribute("gold");
			actividades = (ArrayList<String>) sesion.getAttribute("actividades");
//			System.out.println(actividades);
		}

		if (lugar.equals("farm")) {
			int cantidad = new Random().nextInt(11) + 10;
			System.out.println("Farm suma: " + cantidad);
			gold += cantidad;
			actividades.add(0, "You entered a farm and earned " + cantidad + " gold " + formatoFecha.format(new Date()));
			sesion.setAttribute("actividades", actividades);
			System.out.println(gold + " cuanto hay de oro aca");
			sesion.setAttribute("gold", gold);
			return "redirect:/gold";
		}

		if (lugar.equals("cave")) {
			int cantidad = new Random().nextInt(5,11);
			System.out.println("Cave suma: " + cantidad);
			gold += cantidad;
			actividades.add(0,"You entered a cave and earned " + cantidad + "gold");
			sesion.setAttribute("actividades", actividades);
			System.out.println(gold + " cuanto hay de oro aca");
			sesion.setAttribute("gold", gold);
			return "redirect:/gold";
		}
		
		if (lugar.equals("house")) {
			int cantidad = new Random().nextInt(2,6);
			System.out.println("House suma: " + cantidad);
			gold += cantidad;
			actividades.add(0,"You entered a house and earned " + cantidad + "gold");
			sesion.setAttribute("actividades", actividades);
			System.out.println(gold + " cuanto hay de oro aca");
			sesion.setAttribute("gold", gold);
			return "redirect:/gold";
		}
		
		if (lugar.equals("casino")) {
			int cantidad = new Random().nextInt(-50,51);
			System.out.println("Casino suma: " + cantidad);
			if(cantidad >=0) {
				gold += cantidad;
				actividades.add(0,"You entered a casino and earned " + cantidad + "gold");	
			}else {
				gold += cantidad;
				actividades.add(0,"You entered a casino and lost " + cantidad + "gold");
			}
			sesion.setAttribute("actividades", actividades);
			System.out.println(gold + " cuanto hay de oro aca");
			sesion.setAttribute("gold", gold);
			return "redirect:/gold";
		}
		
		return "redirect:/gold";
	}

	@GetMapping("/gold")
	public String index(HttpSession sesion, Model modelView) {
//		System.out.println(sesion.getAttribute("gold"));
		modelView.addAttribute("gold", sesion.getAttribute("gold"));
		modelView.addAttribute("actividades", sesion.getAttribute("actividades"));
		return "index.jsp";
	}
	
	@GetMapping("/actividades")
	public String actividades() {
		return "actividades.jsp";
	}
	
	

}
