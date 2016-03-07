package tsi.daw.upa.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import tsi.daw.upa.modelo.Usuario;

public class UsuarioDAO
{
	public boolean verificaUsuario(Usuario usuario)
	{
		EntityManager manager = new JPAUtil().getEntityManager();
		Query query = manager.createQuery("FROM Usuario u WHERE u.login= :pLogin AND u.senha= :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		
		boolean encontrado = !query.getResultList().isEmpty();
		manager.close();
		
		return encontrado;
	}

}
