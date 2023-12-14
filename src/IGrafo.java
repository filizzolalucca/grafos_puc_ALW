import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IGrafo<T> {
    // Manipulação
    // void criarGrafo(int numVertices); -> precisa?

    void inserirAresta(int verticeOrigem, int verticeDestino, int idAresta);

    void removerAresta(int verticeOrigem, int verticeDestino);

    void ponderarVertice(int vertice, int peso);

    void rotularVertice(int vertice, String rotulo);

    void ponderarAresta(int verticeOrigem, int verticeDestino, int peso);

    void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo);

    boolean verificaAdjacenciaVertice(int verticeOrigem, int verticeDestino);

    boolean verificaAdjacenciaArestas(int vertice1, int vertice2);

    boolean verificaIncidenciaArestaVertice(int vertice, int aresta);

    boolean verificaExistenciaArestas(int verticeOrigem, int verticeDestino);

    int getNumeroVertices();

    int getNumeroArestas();

    boolean isGrafoVazio();

    boolean isGrafoCompleto();

    List<T> getVizinhanca(int vertice);

    void exportarGrafo(String caminho) throws IOException; // Ponto extra

    void importarGrafo(String arquivo) throws IOException; // Ponto extra

    void dijkstra(int verticeOrigem);

    void bellmanFord(int verticeOrigem);

    void floydWarshall();

    int dijkstraMenorDistanciaTodosParaTodos();

    int bellmanFordMenorDistanciaTodosParaTodos();

    List<Vertice> AEstrela(Vertice inicio, Vertice objetivo); // Ponto extra

    void imprimeGrafo();
}
