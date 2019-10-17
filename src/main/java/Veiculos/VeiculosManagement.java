package Veiculos;

import java.util.ArrayList;
import java.util.Collections;

import com.google.gson.Gson;
import FicticiusClean.DataHolder;
import aplication.Utils;
public class VeiculosManagement {
	public String calculaMelhorCusto(Double preco, int distCidade, int distEstrada) {
		ArrayList<VeiculoOutput> listaVeiculos = new ArrayList<VeiculoOutput>();
		int numVeiculos = DataHolder.getLast();
		for(int i = 0;i<numVeiculos;i++) {
			VeiculoInput VeiculoSalvo = DataHolder.retrieve(Integer.toString(i));
			listaVeiculos.add(new VeiculoOutput(VeiculoSalvo.getNome(), VeiculoSalvo.getMarca(), VeiculoSalvo.getModelo(), VeiculoSalvo.getDataFabricacao(), VeiculoSalvo.getLitros(distCidade, distEstrada), VeiculoSalvo.getCusto(distCidade, distEstrada, preco)));
		}
		Collections.sort(listaVeiculos,new Utils()); 
		return new Gson().toJson(listaVeiculos);
	}
}
