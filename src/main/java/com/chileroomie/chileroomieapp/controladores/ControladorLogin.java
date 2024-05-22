package com.chileroomie.chileroomieapp.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.modelos.UsuarioLogin;
import com.chileroomie.chileroomieapp.servicios.EmailService;
import com.chileroomie.chileroomieapp.servicios.LoginServicio;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControladorLogin {

    private final LoginServicio loginServ;
	private final EmailService emailService;
	
	public ControladorLogin(LoginServicio loginServ, EmailService emailService) {
		this.loginServ = loginServ;
		this.emailService = emailService;
	}
	
	@RequestMapping("/login")
	public String index(@ModelAttribute("usuario") Usuario usuario,
						@ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin) {
		return "Login.jsp";
	}

	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario,
						@ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin){
		return "Registro.jsp";
	}
	
	@RequestMapping(value="/registro", method = RequestMethod.POST)
	public String procesarRegistro(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario,
								    BindingResult resultado,
								    @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin,
								    HttpSession sesion) {
		
		
		resultado = this.loginServ.validarRegistro(resultado, nuevoUsuario);
		if(resultado.hasErrors()) {
			return "Registro.jsp";
		}
		this.loginServ.insertarUsuario(nuevoUsuario);
		String verificationLink = "localhost:8080/verify?token=" + nuevoUsuario.getId();

		emailService.sendVerificationEmail(nuevoUsuario.getCorreo(), "Verificacion ChileRoomie", verificationLink);
		
		return "notVerified.jsp";
	}
	
	@GetMapping("/verify")
	public String getMethodName(@RequestParam("token") Long id) {
		Usuario usuario = this.loginServ.selectPorId(id);
		usuario.setVerified(true);
		this.loginServ.actualizarUsuario(usuario);
		return "Verified.jsp";
	}
	

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String procesarLogin(@Valid @ModelAttribute("usuarioLogin") UsuarioLogin usuarioLogin,
								BindingResult resultado,
								@ModelAttribute("usuario") Usuario usuario,
								HttpSession sesion){
		resultado = this.loginServ.validarLogin(resultado, usuarioLogin);
		if(resultado.hasErrors()) {
			return "Login.jsp";
		}
		
		Usuario usuarioExistente = this.loginServ.selectPorGmail(usuarioLogin.getCorreoLogin());
		
		if(!usuarioExistente.isVerified()){
			return "notVerified.jsp";
		}

		sesion.setAttribute("idUsuario", usuarioExistente.getId());
		sesion.setAttribute("nombre", usuarioExistente.getNombre());
		return "redirect:/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession sesion) {
		sesion.invalidate();
		return "redirect:/";
	}
}
