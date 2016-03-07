package tsi.daw.upa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tsi.daw.upa.dao.DAO;
import tsi.daw.upa.modelo.Paciente;

@SessionScoped
@ManagedBean
public class PacienteBean
{
	private Paciente paciente = new Paciente();
	private List<Paciente> pacientes;
	
	
	public Paciente getPaciente()
	{
		return paciente;
	}
	
	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}
	
	public void grava()
	{
		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		
		if(paciente.getId()==null)
		{
			dao.add(paciente);
		}
		else
		{
			dao.update(paciente);
		}
		
		this.paciente = new Paciente();
		this.pacientes = dao.getList();
	}
	
	public List<Paciente> getPacientes()
	{
		if(pacientes==null)
		{
			pacientes = new DAO<Paciente>(Paciente.class).getList();
		}
		return pacientes;
	}
	
	public void setPacientes(List<Paciente> pacientes)
	{
		this.pacientes = pacientes;
	}
	
	public void remove(Paciente medico)
	{
		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		dao.remove(medico);
		this.pacientes = dao.getList();
	}
	
	public void cancela()
	{
		this.paciente = new Paciente();
	}
	
}
