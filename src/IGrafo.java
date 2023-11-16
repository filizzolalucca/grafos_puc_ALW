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

    boolean verificaAdjacencia(int verticeOrigem, int verticeDestino);

    boolean verificaAdjacenciaArestas(int aresta1, int aresta2);

    boolean verificaIncidencia(int vertice, int aresta);

    boolean verificaExistenciaArestas();

    int getNumeroVertices();

    int getNumeroArestas();

    boolean isGrafoVazio();

    boolean isGrafoCompleto();

    List<Vertice> getVizinhanca(int vertice);

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
