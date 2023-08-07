package com.web.restaurante.business.impl;

import java.util.List;
import java.util.Optional;
import java.util.Objects;
import javax.swing.JOptionPane;
import java.util.Arrays;

import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.restaurante.business.UsuarioService;
import com.web.restaurante.model.TipoUsuario;
import com.web.restaurante.model.Usuario;
import com.web.restaurante.repository.TipoUsuarioRepository;
import com.web.restaurante.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioRepository repository;
	private TipoUsuarioRepository tipRepository;
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Usuario> listarUsuario() {
		
		return repository.findAll();
	}

	@Override
	public void registrarUsuario(Usuario obj) {
		Usuario usuario=new Usuario();
		usuario.setPasswordUsuario(passwordEncoder.encode(obj.getPasswordUsuario()));
		usuario.setNomUsuario(obj.getNomUsuario());
		usuario.setApeUsu(obj.getApeUsu());
		usuario.setCodUsuario(obj.getCodUsuario());
		usuario.setTelUsuario(obj.getTelUsuario());
		usuario.setCelUsuario(obj.getCelUsuario());
		usuario.setDirUsuario(obj.getDirUsuario());
		usuario.setEmailUsuario(obj.getEmailUsuario());
		usuario.setImagenUsuario(obj.getImagenUsuario());
		usuario.setTipoUsuario(obj.getTipoUsuario());
		usuario.setDistritoUsuario(obj.getDistritoUsuario());
		usuario.setDniUsuario(obj.getDniUsuario());
		usuario.setEstadoUsuario(obj.getEstadoUsuario());
		usuario.setFecharegUsuario(obj.getFecharegUsuario());
		usuario.setFechaactUsuario(obj.getFechaactUsuario());
		usuario.setEstadoUsuario(obj.getEstadoUsuario());
		TipoUsuario rol=tipRepository.findByDesTipoUsuario("CLIENTE");
		//Condicionamos si en caso rol sea null
				if( Objects.isNull(rol) ) {
					//que rol sea igual a checkRol , donde este checkRol asigna y guarda
					rol=checkRol();
				} //Fi nde condicion
				//al campo roles de usuario le pasamos el rol de arriba
				//usuario.setTipoUsuario(Arrays.asList(rol));
				usuario.setTipoUsuario(rol);
				
		repository.save(usuario);
	} //Fin de registrar Usuario
	
	//Creamos metodo checkRol de tipo TipoUsuario
		private TipoUsuario checkRol() {
			//creamos objeto rol
			TipoUsuario rol=new TipoUsuario();
			//seteamos el campo nombre de rol  a ROLE_ADMIN
			rol.setDesTipoUsuario("CLIENTE");
			//y llamamos con rolRepository a save y le pasamos el rol
			//con el campo Nombre seteado
			return tipRepository.save(rol);
		} //Fin de checkRol

	@Override
	public void eliminarUsuario(int id) {

		repository.deleteById(id);
		
	}

	@Override
	public Usuario buscarUsuario(int id) {
		// TODO Auto-generated method stub
		Optional<Usuario> optional = repository.findById(id);
		Usuario obj = null;
		
		if(optional.isPresent()) {
			obj = optional.get();
		}else {
			JOptionPane.showMessageDialog(null, "Usuario no fue encontrado");
		}
		
		return obj;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findByEmailUsuario(email);
	}

}
