import java.io.IOException;
import java.util.Random;

public class App {
    public static void main(String[] args) throws IOException {
       IGrafo grafo = new GrafoMatrizAdjacencia(5, true);

        grafo.inserirAresta(0, 2);
        grafo.inserirAresta(0, 3);
        grafo.inserirAresta(1, 0);
        grafo.inserirAresta(1, 3);
        grafo.inserirAresta(2, 3);
        grafo.inserirAresta(3, 4);

        grafo.imprimeGrafo();

        grafo.exportarGrafo("D:\\Faculdade\\Algoritmos em Grafos\\Grafo\\grafoexportado.net");
    }
}
