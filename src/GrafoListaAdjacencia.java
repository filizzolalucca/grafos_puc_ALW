import java.util.ArrayList;
import java.util.List;

public class GrafoListaAdjacencia implements IGrafo<List<Vertice>> {
    private List<Vertice> adjacencia;
    private boolean direcionado;

    public GrafoListaAdjacencia() {
        adjacencia = new ArrayList<>();
    }

    public boolean inserirVertice(int rotulo){
        Vertice novo = new Vertice(rotulo);
        return this.adjacencia.add(novo);
    }

    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);

        origem.addAresta(destino);
    }

    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        origem.removeAresta(verticeDestino);
    }

    @Override
    public void ponderarVertice(int verticeOrigem, int peso) {
        var origem = this.adjacencia.get(verticeOrigem);
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
        var origem = this.adjacencia.get(verticeOrigem);
        return origem.existeAresta(verticeDestino);
        // TODO Auto-generated method stub
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
    public List<Vertice> getVizinhanca(int vertice) {
        var verticeOrigem = this.getVertice(vertice);
        var arestas = verticeOrigem.getArestas();
        List<Vertice> vizinhanca = new ArrayList<>();
        for (Aresta aresta:
             arestas) {
            vizinhanca.add(aresta.destino());
        }
        return vizinhanca;

    }

    // ATÉ AQUI

    @Override
    public void exportarGrafo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarGrafo'");
    }

    @Override
    public List<Vertice> importarGrafo() {
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

    private Vertice getVertice(int id){
        for (Vertice vertice:
             this.adjacencia) {
            if(vertice.getId() == id){
                return vertice;
            }
        }
        throw new RuntimeException("Vertice nao encontrado");
    }

    private Vertice getVertice(String rotulo){
        for (Vertice vertice:
                this.adjacencia) {
            if(vertice.getRotulo() == rotulo){
                return vertice;
            }
        }
        throw new RuntimeException("Vertice nao encontrado");
    }

}
