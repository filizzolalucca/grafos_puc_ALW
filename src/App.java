import exceptions.NotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        try {
            System.out.println("Lista de adjacencia:");

            var grafo2 = new GrafoListaAdjacencia(true);
            grafo2.inserirVertice(1);
            grafo2.inserirVertice(2);
            grafo2.inserirVertice(3);
            grafo2.inserirVertice(4);
            grafo2.rotularVertice(1, "A");
            grafo2.rotularVertice(2, "B");
            grafo2.rotularVertice(3, "C");
            grafo2.rotularVertice(4, "D");

            grafo2.inserirAresta(1, 2, 1);
            grafo2.inserirAresta(1, 3, 2);
            grafo2.inserirAresta(2, 4, 3);
            grafo2.inserirAresta(3, 4, 4);

            grafo2.ponderarAresta(1, 2, 1);
            grafo2.ponderarAresta(1, 3, 2);
            grafo2.ponderarAresta(2, 4, 3);
            grafo2.ponderarAresta(3, 4, 1);

            grafo2.imprimeGrafo();

            //grafo2.bellmanFordMenorDistanciaTodosParaTodos();

            grafo2.dijkstraMenorDistanciaTodosParaTodos();

            grafo2.floydWarshall();

            grafo2.exportarGrafo("src/grafo.gexf");

            System.out.println("Matriz de adjacencia");
            // var grafoM = new GrafoMatrizAdjacencia(5, true);

            // grafoM.inserirAresta(0, 2);
            // grafoM.inserirAresta(0, 3);
            // grafoM.inserirAresta(1, 0);
            // grafoM.inserirAresta(1, 3);
            // grafoM.inserirAresta(2, 3);
            // grafoM.inserirAresta(3, 4);

            // grafoM.ponderarAresta(0, 2, 5);
            // grafoM.ponderarAresta(0, 3, 10);
            // grafoM.ponderarAresta(1, 0, 20);
            // grafoM.ponderarAresta(1, 3, 7);
            // grafoM.ponderarAresta(2, 3, 2);
            // grafoM.ponderarAresta(3, 4, 3);

            // grafoM.ponderarVertice(1, 5);
            // grafoM.ponderarVertice(2, 6);
            // grafoM.ponderarVertice(2, 7);

            // grafoM.rotularVertice(0, "vertice 1");
            // grafoM.rotularVertice(1, "vertice 2");
            // grafoM.rotularVertice(2, "vertice 3");

            // grafoM.rotularAresta(1, 0, "aresta 1 - 0");
            // grafoM.rotularAresta(0, 3, "aresta 0 - 3");

            // grafoM.imprimeGrafo();

            // grafoM.dijkstra(0);

            // grafoM.exportarGrafo("src/grafoexportado.net");

            // var grafoM2 = new GrafoMatrizAdjacencia(7, true);

            // // Primeira linha da matriz
            // grafoM2.inserirAresta(0, 1);
            // grafoM2.ponderarAresta(0, 1, 6);
            // grafoM2.inserirAresta(0, 2);
            // grafoM2.ponderarAresta(0, 2, 5);
            // grafoM2.inserirAresta(0, 3);
            // grafoM2.ponderarAresta(0, 3, 5);

            // // Segunda linha da matriz
            // grafoM2.inserirAresta(1, 4);
            // grafoM2.ponderarAresta(1, 4, -1);

            // // Terceira linha da matriz
            // grafoM2.inserirAresta(2, 1);
            // grafoM2.ponderarAresta(2, 1, -2);
            // grafoM2.inserirAresta(2, 4);
            // grafoM2.ponderarAresta(2, 4, 1);

            // // Quarta linha da matriz
            // grafoM2.inserirAresta(3, 5);
            // grafoM2.ponderarAresta(3, 5, -1);
            // grafoM2.inserirAresta(3, 2);
            // grafoM2.ponderarAresta(3, 2, -2);

            // // Quinta linha da matriz
            // grafoM2.inserirAresta(4, 6);
            // grafoM2.ponderarAresta(4, 6, 3);

            // // Sexta linha da matriz
            // grafoM2.inserirAresta(5, 6);
            // grafoM2.ponderarAresta(5, 6, 3);

            // grafoM2.bellmanFord(0);

            // grafoM2.imprimeGrafo();

            // System.out.println("Floyd Warshall:");
            // grafoM2.floydWarshall();

        } catch (NotFoundException err) {
            System.out.println(err.getMessage());
        }
    }
}
