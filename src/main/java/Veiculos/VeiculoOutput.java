package Veiculos;

import java.util.Date;

public class VeiculoOutput extends Veiculo{
	private Double custo;
	private Double combustivel;
	
	
	public VeiculoOutput(String nome,String marca,String modelo,int dataFabricacao,Double combustivel,Double custo) {
		super(nome,marca,modelo,dataFabricacao);
		this.custo       = custo;
		this.combustivel = combustivel;
		
	}


	public Double getCusto() {
		return custo;
	}


	public void setCusto(Double custo) {
		this.custo = custo;
	}


	public Double getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(Double combustivel) {
		this.combustivel = combustivel;
	}

}
