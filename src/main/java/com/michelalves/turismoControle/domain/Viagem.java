package com.michelalves.turismoControle.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ForeignKey;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name="Viagem")
public class Viagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idViagem;
	
	private Date dataIda;
	private Date dataVolta;
	private Long valorHotel;
	private Long valorTransporte;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@ForeignKey(name="estados_fk")
	private Estados estados = new Estados();
	
	@ManyToOne(fetch=FetchType.EAGER)
	@ForeignKey(name="cidades_fk")
	private Cidades cidades = new Cidades();
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "VIAGEM_PASSAGEIRO", joinColumns = @JoinColumn(name = "viagem_id"), inverseJoinColumns = @JoinColumn(name = "passageiro_id"))
	private List<Passageiro> passageiros = new ArrayList<>();
	
	@OneToMany(mappedBy="viagem")
	private List<Financeiro> financeiros = new ArrayList<>();
	
	public Viagem(Integer id, Date dataIda, Date dataVolta, Long valorHotel, Long valorTransporte, Estados estados,
			Cidades cidades) {
		super();
		this.idViagem = id;
		this.dataIda = dataIda;
		this.dataVolta = dataVolta;
		this.valorHotel = valorHotel;
		this.valorTransporte = valorTransporte;
		this.estados = estados;
		this.cidades = cidades;
		}


	public Integer getId() {
		return idViagem;
	}


	public void setId(Integer id) {
		this.idViagem = id;
	}


	public Date getDataIda() {
		return dataIda;
	}


	public void setDataIda(Date dataIda) {
		this.dataIda = dataIda;
	}


	public Date getDataVolta() {
		return dataVolta;
	}


	public void setDataVolta(Date dataVolta) {
		this.dataVolta = dataVolta;
	}


	public Long getValorHotel() {
		return valorHotel;
	}


	public void setValorHotel(Long valorHotel) {
		this.valorHotel = valorHotel;
	}


	public Long getValorTransporte() {
		return valorTransporte;
	}


	public void setValorTransporte(Long valorTransporte) {
		this.valorTransporte = valorTransporte;
	}


	public Estados getEstados() {
		return estados;
	}


	public void setEstados(Estados estados) {
		this.estados = estados;
	}


	public Cidades getCidades() {
		return cidades;
	}


	public void setCidades(Cidades cidades) {
		this.cidades = cidades;
	}

	public Integer getIdViagem() {
		return idViagem;
	}


	public void setIdViagem(Integer idViagem) {
		this.idViagem = idViagem;
	}


	public List<Passageiro> getPassageiros() {
		return passageiros;
	}


	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}


	public List<Financeiro> getFinanceiros() {
		return financeiros;
	}


	public void setFinanceiros(List<Financeiro> financeiros) {
		this.financeiros = financeiros;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idViagem == null) ? 0 : idViagem.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Viagem other = (Viagem) obj;
		if (idViagem == null) {
			if (other.idViagem != null)
				return false;
		} else if (!idViagem.equals(other.idViagem))
			return false;
		return true;
	}
	
	
}
