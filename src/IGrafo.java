import java.io.IOException;
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

    List<T> dijkstra(int verticeOrigem);

    List<T> bellmanFord(int verticeOrigem);

    List<T> floydWarshall();

    IGrafo<T> dijkstraMenorDistanciaTodosParaTodos();

    void bellmanFordMenorDistanciaTodosParaTodos();

    void floydWarshallMenorDistanciaTodosParaTodos();

    void AEstrela(int verticeOrigem, int verticeDestino); // Ponto extra

    void imprimeGrafo();
}
