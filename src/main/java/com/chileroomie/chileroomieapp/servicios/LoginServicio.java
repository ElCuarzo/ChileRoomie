package com.chileroomie.chileroomieapp.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.chileroomie.chileroomieapp.modelos.Usuario;
import com.chileroomie.chileroomieapp.modelos.UsuarioLogin;
import com.chileroomie.chileroomieapp.repositorios.UsuarioRepositorio;

@Service
public class LoginServicio {
    @Autowired
	private UsuarioRepositorio usuarioRep;
	
	//Validar Registro
	public BindingResult validarRegistro(BindingResult resultado,
										Usuario nuevoUsuario) {
		if(! nuevoUsuario.getContrasena().equals(nuevoUsuario.getConfirmacionContrasena())) {
			resultado.rejectValue("confirmacionContrasena", "Matches", "Las contraseñas no coinciden");
		}
		Usuario usuarioExistente = this.usuarioRep.getByCorreo(nuevoUsuario.getCorreo());
		if(usuarioExistente != null) {
			resultado.rejectValue("correo", "Unique", "Este correo ya existe, porfavor seleccionar otro.");
		}
		return resultado;
	}
	
	//Validar Login
	public BindingResult validarLogin(BindingResult resultado, UsuarioLogin usuarioLogin) {
		Usuario usuarioExistente = this.usuarioRep.getByCorreo(usuarioLogin.getCorreoLogin());
		if(usuarioExistente == null || ! BCrypt.checkpw(usuarioLogin.getContrasenaLogin(), usuarioExistente.getContrasena())) {
			resultado.rejectValue("correoLogin", "Matches", "Credenciales incorrectas.");
		}
		return resultado;
	}
	
	//Encriptar contraseña
	public Usuario insertarUsuario(Usuario nuevoUsuario) {
		String contraseñaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasena(), BCrypt.gensalt());
		nuevoUsuario.setContrasena(contraseñaEncriptada);
		return this.usuarioRep.save(nuevoUsuario);
	}
	
	//Obtener Usuario por gmail
	public Usuario selectPorGmail(String correo) {
		return this.usuarioRep.getByCorreo(correo);
	}
	
	//Seleccionar Usuario por id
	public Usuario selectPorId(Long id) {
		return this.usuarioRep.getById(id);
	}
}
