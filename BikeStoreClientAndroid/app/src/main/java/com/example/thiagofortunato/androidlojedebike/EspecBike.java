package com.example.thiagofortunato.androidlojedebike;

public class EspecBike
{
	private int tamanho;
	private String marca;
	private int ano;
	private String relacao;
	private String suspensao;
	

	public EspecBike(int tamanho, String marca, int ano, String relacao, String suspensao)
	{
		this.tamanho = tamanho;
		this.marca = marca;
		this.ano = ano;
		this.relacao = relacao;
		this.suspensao = suspensao;
	}

	public int getTamanho() 
	{
		return tamanho;
	}
	
	public void setTamanho(int tamanho) 
	{
		this.tamanho = tamanho;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) 
	{
		this.ano = ano;
	}
	
	public String getRelacao() 
	{
		return relacao;
	}
	
	public void setRelacao(String relacao) 
	{
		this.relacao = relacao;
	}
	
	public String getSuspensao() 
	{
		return suspensao;
	}
	
	public void setSuspencao(String suspencao) 
	{
		this.suspensao = suspencao;
	}
	
	public String getMarca() 
	{
		return marca;
	}
	
	public void setMarca(String marca){
		this.marca = marca;
	}
	
	public boolean comparar(EspecBike specBikeCliente){
		if((tamanho == specBikeCliente.tamanho) && (marca.equals(specBikeCliente.marca) && (ano == specBikeCliente.ano))) return true;
		return false;
	}
	
	public String toString()
	{
		return "Tamanho: "+tamanho+" \nAno: "+ano+" \nRelacao: "+relacao+" \nSuspensao: "+suspensao+" \nMarca: "+marca+"\n\n";
	}
}
