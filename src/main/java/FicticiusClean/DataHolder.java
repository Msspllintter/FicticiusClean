package FicticiusClean;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import Veiculos.VeiculoInput;


public class DataHolder {
    private static Map<String, WeakReference<VeiculoInput>> data = new HashMap<String, WeakReference<VeiculoInput>>();
    static int i = 0;
    public static void save(VeiculoInput object) {
        data.put(Integer.toString(i), new WeakReference<VeiculoInput>(object));
        i++;
    }
    public static VeiculoInput retrieve(String id) {
        WeakReference<VeiculoInput> objectWeakReference = data.get(id);
        return objectWeakReference.get();
    }
    public static int getLast() {
        return i;
    }
}

