package com.michelalves.turismoControle.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity
public class Viagem implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
