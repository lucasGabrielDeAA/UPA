package tsi.daw.upa.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Medico
{
	@Id
	@SequenceGenerator(name="medico_id", sequenceName="medico_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="medico_id")
	private Long id;
	private String crm;//00000000-0/UF
	private String nome;
	private String telefone;
	private String area;
	private Double salario;
	@OneToMany(mappedBy="medico", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	public Medico()
	{
		
	}
	
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCrm()
	{
		return crm;
	}
	
	public void setCrm(String crm)
	{
		this.crm = crm;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	
	public String getTelefone()
	{
		return telefone;
	}
	
	public void setTelefone(String telefone)
	{
		this.telefone = telefone;
	}
	
	public String getArea()
	{
		return area;
	}
	
	public void setArea(String area)
	{
		this.area = area;
	}
	
	public Double getSalario()
	{
		return salario;
	}
	
	public void setSalario(Double salario)
	{
		this.salario = salario;
	}
	
}
