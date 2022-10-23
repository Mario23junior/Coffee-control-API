package br.com.coffe.model;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class Coffe {

	private Long id;

	@NotBlank(message = "Nome do cafe não poder esta em branco.")
	private String nome;

	@NotNull(message = "O preço deve ser informado.")
	@PositiveOrZero(message = "Preço deve ser maior que zero")
	private Double preco;

	@PastOrPresent(message = "A data de fabricação dever deve ser menor ou igual a hoje.")
	private LocalDate dataDeFabricacao;

	@FutureOrPresent(message = "A data de validação dever ser anterior a data de hoje")
	private LocalDate dataDeValidade;
	
	

	public Coffe(Long id, @NotBlank(message = "Nome do cafe não poder esta em branco.") String nome,
			@NotNull(message = "O preço deve ser informado.") @PositiveOrZero(message = "Preço deve ser maior que zero") Double preco,
			@PastOrPresent(message = "A data de fabricação dever deve ser menor ou igual a hoje.") LocalDate dataDeFabricacao,
			@FutureOrPresent(message = "A data de validação dever ser anterior a data de hoje") LocalDate dataDeValidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.dataDeFabricacao = dataDeFabricacao;
		this.dataDeValidade = dataDeValidade;
	}

	public Coffe() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}

	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	@Override
	public String toString() {
		return "Coffe [id=" + id + ", nome=" + nome + ", preco=" + preco + ", dataDeFabricacao=" + dataDeFabricacao
				+ ", dataDeValidade=" + dataDeValidade + "]";
	}
	
	

}
