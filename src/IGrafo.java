import java.util.ArrayList;
import java.util.List;

public interface IGrafo<T> {
    //Manipulação
    //void criarGrafo(int numVertices); -> precisa?

    void inserirAresta(int verticeOrigem, int verticeDestino);

    void removerAresta(int verticeOrigem, int verticeDestino);

    void ponderarVertice(int vertice, int peso);

    void rotularVertice(int vertice, String rotulo);

    void ponderarAresta(int verticeOrigem, int verticeDestino, int peso);

    void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo);

    boolean verificaAdjacenciaVertice(int verticeOrigem, int verticeDestino);

    boolean verificaAdjacenciaArestas(int vertice1, int vertice2);

    boolean verificaIncidenciaArestaVertice(int vertice);

    boolean verificaExistenciaArestas(int verticeOrigem, int verticeDestino);

    int getNumeroVertices();

    int getNumeroArestas();

    boolean isGrafoVazio();

    boolean isGrafoCompleto();

    List<Integer> getVizinhanca(int vertice);

    void exportarGrafo(); // Ponto extra

    T importarGrafo(); // Ponto extra

    void dijkstra();
    
    void bellmanFord();

    void floydWarshall();

    int dijkstraMenorDistanciaUmParaTodos();

    int dijkstraMenorDistanciaTodosParaTodos();

    int bellmanFordMenorDistanciaUmParaTodos();

    int bellmanFordMenorDistanciaTodosParaTodos();

    int floydWarshallMenorDistanciaUmParaTodos();

    int floydWarshallMenorDistanciaTodosParaTodos();

    void AEstrela(); // Ponto extra
}
