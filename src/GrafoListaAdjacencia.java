import java.util.ArrayList;
import java.util.List;

public class GrafoListaAdjacencia implements IGrafo<List<Vertice>> {
    private List<Vertice> adjacencia;
    private boolean direcionado;

    public GrafoListaAdjacencia() {
        adjacencia = new ArrayList<>();
    }

    //ALEKS
    public boolean inserirVertice(int rotulo){
        Vertice novo = new Vertice(rotulo);
        return this.adjacencia.add(novo);
    }

    //ALEKS
    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino, int idAresta) {
        //Coloquei um id na aresta por conto do metodo verificaIncidencia que busca uma aresta especifica,a aceito sugestoes
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);

        origem.addAresta(destino, idAresta);
        if(!this.direcionado) {
            destino.addAresta(origem, idAresta);
        }
    }

    //ALEKS
    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        origem.removeAresta(verticeDestino);
    }

    //LUCCA
    @Override
    public void ponderarVertice(int verticeOrigem, int peso) {
        var origem = this.adjacencia.get(verticeOrigem);
        origem.setPesoVertice(peso);
    }

    //LUCCA
    @Override
    public void rotularVertice(int vertice, String rotulo) {
        var origem = this.adjacencia.get(vertice);
        origem.setRotulo(rotulo);
    }

    //LUCCA
    @Override
    public void ponderarAresta(int verticeOrigem, int verticeDestino, int peso) {
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);
        origem.ponderarAresta(destino, peso);
    }

    //LUCCA
    @Override
    public void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo) {
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);
        origem.rotularAresta(destino, rotulo);
    }

    //ALEKS
    @Override
    public boolean verificaAdjacencia(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        return origem.existeAresta(verticeDestino);
        // TODO Auto-generated method stub
    }

    //ALEKS
    @Override
    public boolean verificaAdjacenciaArestas(int aresta1, int aresta2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verificaAdjacenciaArestas'");
    }

    // LUCCA VER COM WEMERSON -> Ver com  alek
    @Override
    public boolean verificaIncidencia(int vertice, int aresta) {
        Vertice origem = this.adjacencia.get(vertice);

        //Verificando se a aresta informada pelo id chega no vertice origem
        for (Vertice verticeX : this.adjacencia ) {
            if(verticeX.getId() != origem.getId()) {
                if(verticeX.existeAresta(origem.getId())) {
                    for( Aresta aresta1 : verticeX.getArestas()) {
                        if(aresta1.getId() == aresta) {
                            if (aresta1.destino().getId() == origem.getId()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        //Verifico se a aresta informada pelo id sai do vertice origem
        for(Aresta arestaOrigem : origem.getArestas()) {
            if(arestaOrigem.getId() == aresta) {
                if (arestaOrigem.destino().getId() == origem.getId()) {
                    return  true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean verificaExistenciaArestas(int vertice1, int vertice2) {
        var v1 = this.adjacencia.get(vertice1);
        var v2 = this.adjacencia.get(vertice2);

        return  v1.existeAresta(v2.getId()) || v2.existeAresta(v1.getId());
    }

    //ALEKS
    @Override
    public int getNumeroVertices() {
        return adjacencia.size();
    }

    //ALEKS
    @Override
    public int getNumeroArestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumeroArestas'");
    }

    @Override
    public boolean isGrafoVazio() {
        return adjacencia.isEmpty();
    }

    //LUCCA
    @Override
    public boolean isGrafoCompleto() {
        int contArestas = 0;
        int numVertices = this.adjacencia.size();
        for(Vertice vertice : this.adjacencia) {
            contArestas += vertice.getArestas().size();
        }

        return contArestas == ((numVertices - 1) *numVertices)/ 2;
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

    //ALEKS
    @Override
    public void exportarGrafo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exportarGrafo'");
    }

    //ALEKS
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
