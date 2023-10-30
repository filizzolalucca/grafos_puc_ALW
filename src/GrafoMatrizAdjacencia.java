import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoMatrizAdjacencia implements IGrafo{

    private int[][] matriz;
    private boolean direcionado;
    private int[] pesosVertices;
    private String[] rotulosVertices;
    // private int[] pesosArestas;
    private Map<String, String> rotulosArestas = new HashMap<>();

    

    public GrafoMatrizAdjacencia(int tamanho, boolean direcionado) {
        matriz = new int[tamanho][tamanho];
        this.direcionado = direcionado;
        pesosVertices = new int[tamanho];
        rotulosVertices = new String[tamanho];
    }

    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino) {
        if(verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length && verticeDestino < matriz.length ){
            matriz[verticeOrigem][verticeDestino] = 1;
        }
    }

    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        if(verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length && verticeDestino < matriz.length){
            matriz[verticeOrigem][verticeDestino] = 0;
        }
    }

    @Override
    public void ponderarVertice(int vertice, int peso) {
        if(vertice >= 0 && vertice < pesosVertices.length){
            pesosVertices[vertice] = peso;
        }
    }

    @Override
    public void rotularVertice(int vertice, String rotulo) {
        if(vertice >= 0 && vertice < rotulosVertices.length){
            rotulosVertices[vertice] = rotulo;
        }
    }

    @Override
    public void ponderarAresta(int verticeOrigem, int verticeDestino, int peso) {
        if(verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length && verticeDestino < matriz.length){
            matriz[verticeOrigem][verticeDestino] = peso;
        }
    }

    @Override
    public void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo) {
        if(verificaExistenciaArestas(verticeOrigem, verticeDestino)){
            if(verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length && verticeDestino < matriz.length){
                String chave = verticeOrigem + "-" + verticeDestino;
                rotulosArestas.put(chave, rotulo);
            }
        }
        else{
            System.out.println("Aresta inexistente ou inválida");
        }
    }

     @Override
    public boolean verificaExistenciaArestas(int verticeOrigem, int verticeDestino) {
         return matriz[verticeOrigem][verticeDestino] != 0;
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
    public int getNumeroVertices() {
        return matriz.length;
    }

    @Override
    public int getNumeroArestas() {
        int numArestas = 0;
        int numVertices = matriz.length;

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (matriz[i][j] != 0) {
                    numArestas++;
                }
            }
    }
        if(direcionado) return numArestas/2;

        else return numArestas;
    }

    @Override
    public boolean isGrafoVazio() {
        for(int i = 0; i< matriz.length; i++){
            for(int j = 0; j< matriz[0].length; j++){
                if(matriz[i][j] != 0){
                    return false;
                }
            }
        }
        return true;
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
    public int[][] importarGrafo() {
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
