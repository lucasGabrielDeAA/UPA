package tsi.daw.upa.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tsi.daw.upa.dao.DAO;
import tsi.daw.upa.modelo.Atendimento;
import tsi.daw.upa.modelo.Medico;
import tsi.daw.upa.modelo.Paciente;

@SessionScoped
@ManagedBean
public class AtendimentoBean
{
	private Atendimento atendimento = new Atendimento();
	private List<Atendimento> atendimentos;
	private Medico medico;
	private Paciente paciente;
	private Long idMedico;
	private Long idPaciente;
	
	public Atendimento getAtendimento()
	{
		return atendimento;
	}
	
	public void setAtendimento(Atendimento atendimento)
	{
		this.atendimento = atendimento;
	}
	
	public void grava()
	{
		DAO<Atendimento> dao = new DAO<Atendimento>(Atendimento.class);
		
		if(atendimento.getId()==null)
		{
			DAO<Medico> daoMedico = new DAO<Medico>(Medico.class);
			medico = daoMedico.idSearch(idMedico);
			atendimento.setMedico(medico);
			medico = new Medico();
			
			DAO<Paciente> daoPaciente = new DAO<Paciente>(Paciente.class);
			paciente = daoPaciente.idSearch(idPaciente);
			atendimento.setPaciente(paciente);
			paciente = new Paciente();
			
			dao.add(atendimento);
		}
		else
		{
			dao.update(atendimento);
		}
		
		this.atendimento = new Atendimento();
		this.atendimentos = dao.getList();
	}
	
	public List<Atendimento> getAtendimentos()
	{
		if(atendimentos==null)
		{
			atendimentos = new DAO<Atendimento>(Atendimento.class).getList();
		}
		
		return atendimentos;
	}
	
	public void setAtendimentos(List<Atendimento> atendimentos)
	{
		this.atendimentos = atendimentos;
	}
	
	public void remove(Atendimento atendimento)
	{
		DAO<Atendimento> dao = new DAO<Atendimento>(Atendimento.class);
		dao.remove(atendimento);
		this.atendimentos = dao.getList();
	}
	
	public void cancela()
	{
		this.atendimento = new Atendimento();
	}

	public Medico getMedico()
	{
		return medico;
	}

	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}
	
	public Long getIdMedico()
	{
		return idMedico;
	}

	public void setIdMedico(Long idMedico)
	{
		this.idMedico = idMedico;
	}

	public Long getIdPaciente()
	{
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente)
	{
		this.idPaciente = idPaciente;
	}

}
