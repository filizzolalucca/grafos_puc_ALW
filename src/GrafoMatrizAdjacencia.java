import java.util.List;

public class GrafoMatrizAdjacencia implements IGrafo{

    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino, int idAresta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserirAresta'");
    }

    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerAresta'");
    }

    @Override
    public void ponderarVertice(int vertice, int peso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ponderarVertice'");
    }

    @Override
    public void rotularVertice(int vertice, String rotulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotularVertice'");
    }

    @Override
    public void ponderarAresta(int verticeOrigem, int verticeDestino, int peso) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ponderarAresta'");
    }

    @Override
    public void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rotularAresta'");
    }

    @Override
    public boolean verificaAdjacencia(int verticeOrigem, int verticeDestino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaAdjacencia'");
    }

    @Override
    public boolean verificaIncidencia(int vertice, int aresta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaIncidencia'");
    }

    @Override
    public boolean verificaExistenciaArestas(int vertice1, int vertice2) {
        return false;
    }

    @Override
    public int getNumeroVertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumeroVertices'");
    }

    @Override
    public int getNumeroArestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumeroArestas'");
    }

    @Override
    public boolean isGrafoVazio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGrafoVazio'");
    }

    @Override
    public boolean isGrafoCompleto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGrafoCompleto'");
    }

    @Override
    public List<Integer> getVizinhanca(int vertice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVizinhanca'");
    }

    @Override
    public void exportarGrafo(String nomeArquivo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarGrafo'");
    }

    @Override
    public IGrafo<List<Vertice>> importarGrafo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'importarGrafo'");
    }

    @Override
    public void dijkstra() {

    }

    @Override
    public void bellmanFord() {

    }

    @Override
    public void floydWarshall() {

    }

    @Override
    public int dijkstraMenorDistanciaUmParaTodos() {
        return 0;
    }

    @Override
    public int dijkstraMenorDistanciaTodosParaTodos() {
        return 0;
    }

    @Override
    public int bellmanFordMenorDistanciaUmParaTodos() {
        return 0;
    }

    @Override
    public int bellmanFordMenorDistanciaTodosParaTodos() {
        return 0;
    }

    @Override
    public int floydWarshallMenorDistanciaUmParaTodos() {
        return 0;
    }

    @Override
    public int floydWarshallMenorDistanciaTodosParaTodos() {
        return 0;
    }

    @Override
    public void AEstrela() {

    }

}
