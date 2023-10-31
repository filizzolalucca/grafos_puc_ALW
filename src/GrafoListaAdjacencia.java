import java.util.ArrayList;
import java.util.List;

public class GrafoListaAdjacencia implements IGrafo<List<List<Integer>>> {
    private List<List<Integer>> adjacencia;

    public GrafoListaAdjacencia() {
        adjacencia = new ArrayList<>();
    }

    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino) {
        adjacencia.get(verticeOrigem).add(verticeDestino);
    }

    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        adjacencia.get(verticeOrigem).remove(verticeDestino);
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
    public boolean verificaAdjacenciaArestas(int aresta1, int aresta2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaAdjacenciaArestas'");
    }

    @Override
    public boolean verificaIncidencia(int vertice, int aresta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaIncidencia'");
    }

    @Override
    public boolean verificaExistenciaArestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaExistenciaArestas'");
    }

    @Override
    public int getNumeroVertices() {
        return adjacencia.size();
    }

    @Override
    public int getNumeroArestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumeroArestas'");
    }

    @Override
    public boolean isGrafoVazio() {
        return adjacencia.isEmpty();
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
    public void exportarGrafo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarGrafo'");
    }

    @Override
    public List<List<Integer>> importarGrafo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'importarGrafo'");
    }

    @Override
    public void dijkstra() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dijkstra'");
    }

    @Override
    public void bellmanFord() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bellmanFord'");
    }

    @Override
    public void floydWarshall() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'floydWarshall'");
    }

    @Override
    public int dijkstraMenorDistanciaUmParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dijkstraMenorDistanciaUmParaTodos'");
    }

    @Override
    public int dijkstraMenorDistanciaTodosParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dijkstraMenorDistanciaTodosParaTodos'");
    }

    @Override
    public int bellmanFordMenorDistanciaUmParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bellmanFordMenorDistanciaUmParaTodos'");
    }

    @Override
    public int bellmanFordMenorDistanciaTodosParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bellmanFordMenorDistanciaTodosParaTodos'");
    }

    @Override
    public int floydWarshallMenorDistanciaUmParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'floydWarshallMenorDistanciaUmParaTodos'");
    }

    @Override
    public int floydWarshallMenorDistanciaTodosParaTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'floydWarshallMenorDistanciaTodosParaTodos'");
    }

    @Override
    public void AEstrela() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AEstrela'");
    }

}
