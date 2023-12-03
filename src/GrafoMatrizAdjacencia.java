import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoMatrizAdjacencia implements IGrafo<Integer> {

    private int[][] matriz;
    private boolean direcionado;
    private int[] pesosVertices;
    private String[] rotulosVertices;
    // private int[] pesosArestas;
    private Map<String, String> rotulosArestas = new HashMap<>();
    private int totalArestas = 0;

    GrafoMatrizAdjacencia(int[][] MatrizAdjacencia, boolean direcionado) {
        int linhas = MatrizAdjacencia.length;
        int colunas = MatrizAdjacencia[0].length;
        this.direcionado = direcionado;

        if (linhas == colunas) {
            this.matriz = new int[linhas][colunas];

            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    this.matriz[i][j] = MatrizAdjacencia[i][j];
                }
            }
        }

    }

    public GrafoMatrizAdjacencia(int tamanho, boolean direcionado) {
        matriz = new int[tamanho][tamanho];
        this.direcionado = direcionado;
        pesosVertices = new int[tamanho];
        rotulosVertices = new String[tamanho];
    }

    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino, int idAresta) {
        if (verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length
                && verticeDestino < matriz.length) {
            matriz[verticeOrigem][verticeDestino] = 1;
            totalArestas++;
        }
    }

    public void inserirAresta(int verticeOrigem, int verticeDestino) {
        inserirAresta(verticeOrigem, verticeDestino, 0);
    }

    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        if (verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length
                && verticeDestino < matriz.length) {
            matriz[verticeOrigem][verticeDestino] = 0;
            totalArestas--;
        }
    }

    @Override
    public void ponderarVertice(int vertice, int peso) {
        if (vertice >= 0 && vertice < pesosVertices.length) {
            pesosVertices[vertice] = peso;
        }
    }

    @Override
    public void rotularVertice(int vertice, String rotulo) {
        if (vertice >= 0 && vertice < rotulosVertices.length) {
            rotulosVertices[vertice] = rotulo;
        }
    }

    @Override
    public void ponderarAresta(int verticeOrigem, int verticeDestino, int peso) {
        if (verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length
                && verticeDestino < matriz.length) {
            matriz[verticeOrigem][verticeDestino] = peso;
        }
    }

    @Override
    public void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo) {
        if (verificaAdjacenciaVertice(verticeOrigem, verticeDestino)) {
            if (verticeOrigem >= 0 && verticeDestino >= 0 && verticeOrigem < matriz.length
                    && verticeDestino < matriz.length) {
                String chave = verticeOrigem + "-" + verticeDestino;
                rotulosArestas.put(chave, rotulo);
                System.out.println("Rótulo adicionado com sucesso: " + chave + " -> " + rotulo);
            } else {
                System.out.println("Aresta inexistente ou inválida");
            }
        } else {
            System.out.println("Aresta não adjacente");
        }
    }

    @Override
    public boolean verificaExistenciaArestas(int verticeOrigem, int verticeDestino) {
        // duplicado com verificaAdjacenciaVertice()
        return matriz[verticeOrigem][verticeDestino] != 0;
    }

    @Override
    public boolean verificaAdjacenciaVertice(int verticeOrigem, int verticeDestino) {
        if (direcionado) {
            return matriz[verticeOrigem][verticeDestino] != 0;
        } else {
            return matriz[verticeOrigem][verticeDestino] != 0 || matriz[verticeDestino][verticeOrigem] != 0;
        }
    }

    // Este método deveria ser realmente um boolean? Ou retornar um vetor de arestas
    // adjacentes?
    @Override
    public boolean verificaAdjacenciaArestas(int vertice1, int vertice2) {
        List<int[]> arestasAdjacentes = new ArrayList<>();
        if (verificaExistenciaArestas(vertice1, vertice2)) {
            for (int i = 0; i < matriz.length; i++) {
                if (i != vertice2 && matriz[vertice1][i] != 0) {
                    arestasAdjacentes.add(new int[] { vertice1, i });
                }
                if (!direcionado && i != vertice1 && matriz[vertice2][i] != 0) {
                    arestasAdjacentes.add(new int[] { vertice2, i });
                }
            }
        }
        // return arestasAdjacentes;
        return true;
    }

    // Método é realmente necessário? Visto que não tenho dado de aresta. Possivel
    // contorno: receber dois vertices(que formam aresta) e ver arestas ligadas a
    // eles.
    @Override
    public boolean verificaIncidenciaArestaVertice(int vertice, int aresta) {
        return true;
    }

    private ArrayList<int[]> listarArestasIncidentes(int vertice) {
        ArrayList<int[]> arestasIncidentes = new ArrayList<>();
        if (vertice >= 0 && vertice < matriz.length) {
            for (int i = 0; i < matriz[vertice].length; i++) {
                if (matriz[vertice][i] != 0) {
                    int[] parArestaIncidente = { vertice, i };
                    arestasIncidentes.add(parArestaIncidente);
                }
            }
        }
        return arestasIncidentes;
    }

    @Override
    public int getNumeroVertices() {
        return matriz.length;
    }

    @Override
    public int getNumeroArestas() {
        return totalArestas;
    }

    public int[][] getMatrizAdjacencia() {
        int linhas = matriz.length;
        int colunas = matriz[0].length;

        int[][] matrizCopia = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizCopia[i][j] = matriz[i][j];
            }
        }
        return matrizCopia;
    }

    @Override
    public boolean isGrafoVazio() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isGrafoCompleto() {
        int maxArestas;

        if (direcionado)
            maxArestas = (matriz.length * (matriz.length - 1));

        else
            maxArestas = (matriz.length * (matriz.length - 1)) / 2;

        if (totalArestas < maxArestas)
            return false;

        else
            return true;
    }

    @Override
    public List<Integer> getVizinhanca(int vertice) {
        List<Integer> vizinhos = new ArrayList<>();
        for (int j = 0; j < matriz[vertice].length; j++) {
            if (matriz[vertice][j] != 0) {
                vizinhos.add(j);
            }
        }
        return vizinhos;
    }

    @Override

    public void exportarGrafo(String caminho) throws IOException {
        PrintWriter escreve = new PrintWriter(new FileWriter(caminho));
        escreve.println("*Vertices " + matriz.length);
        for (int i = 0; i < matriz.length; i++) {
            escreve.println((i + 1) + "  \"" + rotulosVertices[i] + "\" " + pesosVertices[i]);
        }

        if (direcionado)
            escreve.println("*Arcs");
        else
            escreve.println("*Edges");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) { // Comece j de 0, não de i
                if (matriz[i][j] != 0) {
                    String rotulo = i + "-" + j;
                    escreve.println(
                            (i + 1) + " " + (j + 1) + " " + matriz[i][j] + " \"" + rotulosArestas.get(rotulo) + "\"");
                }
            }
        }
        escreve.close();
    }

    /**
     * Este método não importa grafos rotulados ainda.
     * 
     */
    @Override
    public void importarGrafo(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha;
        while ((linha = reader.readLine()) != null) {
            String[] partes = linha.split(" ");

            if (partes[0].equals("*Vertices")) {
                int numVertices = Integer.parseInt(partes[1]);
                this.matriz = new int[numVertices][numVertices];
                continue;
            }
            if (partes[0].equals("*Edges")) {
                while ((linha = reader.readLine()) != null) {
                    partes = linha.split(" ");
                    int v1 = Integer.parseInt(partes[0]) - 1; // Pajek começa a contagem em 1
                    int v2 = Integer.parseInt(partes[1]) - 1; // Pajek começa a contagem em 1
                    int peso = partes.length > 2 ? Integer.parseInt(partes[2]) : 1; // Pega o peso se existir, senão
                                                                                    // assume 1
                    matriz[v1][v2] = peso; // Adicione a aresta ao seu grafo aqui
                    if (!direcionado) {
                        matriz[v2][v1] = peso; // Para grafos não direcionados
                    }
                }
            }
        }
        reader.close();
    }

    @Override
    public void imprimeGrafo() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void dijkstra(int verticeOrigem) {
        int vertices = matriz.length;
        int[] distancia = new int[vertices];
        boolean[] visitados = new boolean[vertices];
        int infinito = Integer.MAX_VALUE - 1;
        int[] antecessor = new int[vertices];

        Arrays.fill(distancia, infinito);
        Arrays.fill(visitados, false);
        distancia[verticeOrigem] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            // Encontrar o vértice com a menor distância ainda não visitado
            int u = distaciaMinima(distancia, visitados);

            // Marcar o vértice como visitado
            visitados[u] = true;

            // Atualizar as distâncias dos vértices adjacentes ao vértice escolhido
            for (int v = 0; v < vertices; v++) {
                if (!visitados[v] && matriz[u][v] != 0 && distancia[u] != infinito &&
                        distancia[u] + matriz[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + matriz[u][v];
                    antecessor[v] = u;
                }
            }

        }

        // Imprime as distâncias mínimas
        System.out.println("Distâncias mínimas a partir do vértice de origem:");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Vértice " + i + ": " + distancia[i] + " antecessor:" + antecessor[i]);
        }
    }

    private int distaciaMinima(int[] distancia, boolean[] visitados) {
        int minimo = Integer.MAX_VALUE - 1;
        int minIndex = -1;

        for (int v = 0; v < distancia.length; v++) {
            if (!visitados[v] && distancia[v] <= minimo) {
                minimo = distancia[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    @Override
    public void bellmanFord(int verticeOrigem) {
        int vertices = matriz.length;
        int[] distancia = new int[vertices];
        int[] antecessor = new int[vertices];
        int infinito = Integer.MAX_VALUE - 1;

        Arrays.fill(distancia, infinito);
        distancia[verticeOrigem] = 0;

        // Relaxamento das arestas repetidamente
        for (int i = 0; i < vertices - 1; i++) {
            for (int u = 0; u < vertices; u++) {
                for (int v = 0; v < vertices; v++) {
                    if (matriz[u][v] != 0 && distancia[u] != infinito && distancia[u] + matriz[u][v] < distancia[v]) {
                        distancia[v] = distancia[u] + matriz[u][v];
                        antecessor[v] = u;
                    }
                }
            }
        }

        // Verifica se há ciclo de peso negativo
        for (int u = 0; u < vertices; u++) {
            for (int v = 0; v < vertices; v++) {
                if (matriz[u][v] != 0 && distancia[u] != infinito && distancia[u] + matriz[u][v] < distancia[v]) {
                    System.out.println("Há um ciclo de peso negativo, impossibilitando o algoritmo");
                    return;
                }
            }
        }

        // Imprime as distâncias mínimas
        System.out.println("Distâncias mínimas a partir do vértice de origem:");
        for (int i = 0; i < distancia.length; i++) {
            System.out.println("Vértice " + i + ": " + distancia[i] + " antecessor:" + antecessor[i]);
        }
    }

    @Override
    public void floydWarshall() {
        int vertices = matriz.length;
        int[][] distancias = new int[vertices][vertices];

        // Inicialização da matriz de distâncias
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                distancias[i][j] = matriz[i][j];
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (distancias[i][k] != 0 && distancias[k][j] != 0 &&
                            (distancias[i][j] == 0 || distancias[i][j] > distancias[i][k] + distancias[k][j])) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }

        // Imprime as distâncias mínimas
        System.out.println("Matriz de distâncias mínimas entre todos os pares de vértices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(distancias[i][j] + " ");
            }
            System.out.println();
        }
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
