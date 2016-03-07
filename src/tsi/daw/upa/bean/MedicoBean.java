package tsi.daw.upa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tsi.daw.upa.dao.DAO;
import tsi.daw.upa.modelo.Medico;

@SessionScoped
@ManagedBean
public class MedicoBean
{
	private Medico medico = new Medico();
	private List<Medico> medicos;
	
	public Medico getMedico()
	{
		return medico;
	}
	
	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}
	
	public void grava()
	{
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		
		if(medico.getId()==null)
		{
			dao.add(medico);
		}
		else
		{
			dao.update(medico);
		}
		
		this.medico = new Medico();
		this.medicos = dao.getList();
	}
	
	public List<Medico> getMedicos()
	{
		if(medicos==null)
		{
			medicos = new DAO<Medico>(Medico.class).getList();
		}
		return medicos;
	}
	
	public void setMedicos(List<Medico> medicos)
	{
		this.medicos = medicos;
	}
	
	public void remove(Medico medico)
	{
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		dao.remove(medico);
		this.medicos = dao.getList();
	}
	
	public void cancela()
	{
		this.medico = new Medico();
	}

}
