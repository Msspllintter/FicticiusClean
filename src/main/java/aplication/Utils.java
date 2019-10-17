package aplication;

import java.util.Comparator;

import Veiculos.VeiculoOutput;

public class Utils implements Comparator<VeiculoOutput> {

    @Override
    public int compare(VeiculoOutput o1, VeiculoOutput o2) {
        return o1.getCusto().compareTo(o2.getCusto());
    }
    public static boolean validaString(String param) {
    	Boolean result = true;
    	if(param.trim().equals("")) {
    		result = false;
    	}
    	return result;
    }

}
