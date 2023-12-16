import java.util.Arrays;
import java.util.Random;

public class TestesDeExec {
    
    public static void main(String[] args) {
         int[] tamanhos = { 10, 100, 500, 1000, 1500 };

        Arrays.stream(tamanhos).parallel().forEach(tamanho -> {
            GrafoMatrizAdjacencia grafo_Positivo = criarGrafoAleatorioSemValorNegativo(tamanho);

            // Medindo o tempo para o método de caminho mínimo para todos os vértices Dijkstra
            long startTime = System.currentTimeMillis();
            grafo_Positivo.dijkstraMenorDistanciaTodosParaTodos();
            long endTime = System.currentTimeMillis();
            long tempoExecucao = endTime - startTime;
            System.out.println("Tempo de execução para " + tamanho + " vértices (Dijkstra): " + tempoExecucao + " ms");

            // Medindo o tempo para o método de caminho mínimo para todos os vértices Bellman-Ford
            startTime = System.currentTimeMillis();
            grafo_Positivo.bellmanFordMenorDistanciaTodosParaTodos();
            endTime = System.currentTimeMillis();
            tempoExecucao = endTime - startTime;
            System.out.println("Tempo de execução para " + tamanho + " vértices (Bellman-Ford): " + tempoExecucao + " ms");

            // Medindo o tempo para o método de caminho mínimo para todos os vértices Floyd-Warshall
            startTime = System.currentTimeMillis();
            grafo_Positivo.floydWarshall();
            endTime = System.currentTimeMillis();
            tempoExecucao = endTime - startTime;
            System.out.println("Tempo de execução para " + tamanho + " vértices (Floyd-Warshall): " + tempoExecucao + " ms");
        });
    }

    private static GrafoMatrizAdjacencia criarGrafoAleatorio(int tamanho) {
        GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(tamanho, true);
        Random random = new Random();

        // Adicionando arestas aleatórias com pesos negativos ou positivos
        for (int i = 0; i < tamanho; i++) {
            // Garante que cada vértice tenha pelo menos uma aresta de saída
            int verticeDestino = (i + 1) % tamanho;

            int peso = random.nextInt(21) - 10; // Peso variando de -10 a 10
            grafo.inserirAresta(i, verticeDestino);
            grafo.ponderarAresta(i, verticeDestino, peso);

            // Adiciona outras arestas aleatórias
            for (int j = 1; j < tamanho - 1; j++) {
                verticeDestino = (i + j) % tamanho;
                peso = random.nextInt(21) - 10; // Peso variando de -10 a 10
                grafo.inserirAresta(i, verticeDestino);
                grafo.ponderarAresta(i, verticeDestino, peso);
            }
        }

        return grafo;
    }

    private static GrafoMatrizAdjacencia criarGrafoAleatorioSemValorNegativo(int tamanho) {
        GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(tamanho, true);
        Random random = new Random();

        // Adicionando arestas aleatórias com pesos positivos
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i != j) {
                    int peso = random.nextInt(21); // Peso variando de 0 a 20
                    grafo.inserirAresta(i, j);
                    grafo.ponderarAresta(i, j, peso);
                }
            }
        }

        return grafo;
    }
}