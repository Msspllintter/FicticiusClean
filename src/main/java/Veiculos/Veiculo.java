package Veiculos;
import java.time.ZoneId;
import java.util.Date;
public class Veiculo {
	private Integer id;
	private String nome;
	private String marca;
	private String modelo;
	private Integer dataFabricacao;

	
	
	public Veiculo() {
	}
	
	public Veiculo(String nome,String marca,String modelo,Date dataFabricacao) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	}
	public Veiculo(String nome,String marca,String modelo,int dataFabricacao) {
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.dataFabricacao = dataFabricacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getDataFabricacao() {
		return this.dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getYear();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

}
