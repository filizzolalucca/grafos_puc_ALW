import java.util.ArrayList;

public class Distancia {
    private int origem;
    private int[] distancia;
    private ArrayList<Vertice> caminho;

    @Override
    public String toString() {
        return "Distancia [caminho=" + caminho + ", distancia=" + distancia + ", origem=" + origem + "]";
    }
}
