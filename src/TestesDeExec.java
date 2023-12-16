import java.util.Random;

public class TestesDeExec {
    public static void main(String[] args) {
        int[] tamanhos = {10};

        for (int tamanho : tamanhos) {
            GrafoMatrizAdjacencia grafo = criarGrafoAleatorio(tamanho);

            // Medindo o tempo para o método de caminho mínimo para todos os vértices
            long startTime = System.currentTimeMillis();
            grafo.dijkstraMenorDistanciaTodosParaTodos();
            long endTime = System.currentTimeMillis();

            long tempoExecucao = endTime - startTime;
            System.out.println("Tempo de execução para " + tamanho + " vértices: " + tempoExecucao + " ms");
        }
    }

    private static GrafoMatrizAdjacencia criarGrafoAleatorio(int tamanho) {
        GrafoMatrizAdjacencia grafo = new GrafoMatrizAdjacencia(tamanho, true);
        Random random = new Random();

        // Adicionando arestas aleatórias com pesos negativos
        for (int i = 0; i < tamanho - 1; i++) {
            int verticeOrigem = i;
            int verticeDestino = i + 1;
            int peso = random.nextInt(21) - 10; // Peso variando de -10 a 10

            grafo.inserirAresta(verticeOrigem, verticeDestino, peso);
        }

        // Adicionando uma aresta do último vértice para o primeiro para garantir que o grafo seja conexo
        int peso = random.nextInt(21) - 10;
        grafo.inserirAresta(tamanho - 1, 0, peso);

        return grafo;
    }
}
