package tsi.daw.upa.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tsi.daw.upa.dao.UsuarioDAO;
import tsi.daw.upa.modelo.Usuario;

@SessionScoped
@ManagedBean
public class LoginBean
{
	private Usuario usuario = new Usuario();

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	public String login()
	{
		UsuarioDAO dao = new UsuarioDAO();
		
		boolean valido = dao.verificaUsuario(this.usuario);
		
		if(valido)
		{
			return "index?faces-redirect=true";
		}
		else
		{
			this.usuario = new Usuario();
			return "login";
		}
	}
	
	public boolean isLogged()
	{
		return usuario.getLogin() != null;
	}
	
	public String logout()
	{
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
}
