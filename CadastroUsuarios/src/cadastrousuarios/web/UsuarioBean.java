package cadastrousuarios.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cadastrousuarios.usuario.Usuario;
import cadastrousuarios.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
private Usuario usuario = new Usuario();
private String confirmarSenha;

public String novo() {
	this.usuario = new Usuario();
	this.usuario.setAtivo(true);
	return "usuario";
}

public String salvar() {
	FacesContext context = FacesContext.getCurrentInstance();
	
	String senha = this.usuario.getSenha();
	if(!senha.equals(this.confirmarSenha)) {
		FacesMessage facesMessage = new FacesMessage("A senha nao foi confirmada corretamente");
		context.addMessage(null, facesMessage);
		return null;
	}
	UsuarioRN usuarioRN = new UsuarioRN();
	usuarioRN.salvar(this.usuario);
	
	return "usuarioSucesso";
}

public Usuario getUsuario() {
	return usuario;
}
public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public String getConfirmarSenha() {
	return confirmarSenha;
}
public void setConfirmarSenha(String confirmarSenha) {
	this.confirmarSenha = confirmarSenha;
}

	
}
