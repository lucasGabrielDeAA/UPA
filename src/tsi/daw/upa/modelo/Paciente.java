package tsi.daw.upa.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Paciente
{
	@Id
	@SequenceGenerator(name="paciente_id", sequenceName="paciente_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="paciente_id")
	private Long id;
	@CPF
	private String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String sexo;
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento = Calendar.getInstance();
	@OneToMany(mappedBy="paciente", cascade=CascadeType.ALL)
	private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
	
	public Paciente()
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
	
	public String getCpf()
	{
		return cpf;
	}
	
	public void setCpf(String cpf)
	{
		this.cpf = cpf;
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
	
	public String getEndereco()
	{
		return endereco;
	}
	
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}
	
	public String getSexo()
	{
		return sexo;
	}
	
	public void setSexo(String sexo)
	{
		this.sexo = sexo;
	}
	
	public Calendar getDataNascimento()
	{
		return dataNascimento;
	}
	
	public void setDataNascimento(Calendar dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public List<Atendimento> getAtendimentos()
	{
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos)
	{
		this.atendimentos = atendimentos;
	}

}
