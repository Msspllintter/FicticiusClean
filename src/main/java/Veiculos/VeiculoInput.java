package Veiculos;

import java.text.DecimalFormat;
import java.util.Date;

public class VeiculoInput extends Veiculo{
	private Double consumoCidade;
	private Double consumoEstrada;
	public VeiculoInput(String nome,String marca,String modelo,Date dataFabricacao,Double consumoCidade,Double consumoEstrada) {
		super(nome,marca,modelo,dataFabricacao);
		this.consumoCidade = consumoCidade;
		this.consumoEstrada = consumoEstrada;
	}
	public Double getConsumoCidade() {
		return consumoCidade;
	}

	public void setConsumoCidade(Double consumoCidade) {
		this.consumoCidade = consumoCidade;
	}

	public Double getConsumoEstrada() {
		return consumoEstrada;
	}

	public void setConsumoEstrada(Double consumoEstrada) {
		this.consumoEstrada = consumoEstrada;
	}
	public Double getCusto(int kmCidade, int kmEstrada, Double precoCombustivel) {
		Double custo = 0.00;
		Double litrosCidade = kmCidade/this.consumoCidade;
		Double litrosEstrada = kmEstrada/this.consumoEstrada;
		custo = (litrosCidade + litrosEstrada) * precoCombustivel;
		DecimalFormat decim = new DecimalFormat("0.00");
		return Double.parseDouble(decim.format(custo).replace(",", "."));
	}
	public Double getLitros(int kmCidade, int kmEstrada) {
		Double litrosCidade = kmCidade/this.consumoCidade;
		Double litrosEstrada = kmEstrada/this.consumoEstrada;
		DecimalFormat decim = new DecimalFormat("0.00");
		return Double.parseDouble(decim.format((litrosCidade + litrosEstrada)).replace(",", "."));
	}
}
