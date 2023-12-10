import exceptions.NotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GrafoListaAdjacencia implements IGrafo<Vertice> {
    private List<Vertice> adjacencia;
    private boolean direcionado;

    public GrafoListaAdjacencia(boolean direcionado) {
        this.direcionado = direcionado;
        adjacencia = new ArrayList<>();
    }

    // ALEKS
    public boolean inserirVertice(int id) {
        Vertice novo = new Vertice(id);
        return this.adjacencia.add(novo);
    }

    // ALEKS
    @Override
    public void inserirAresta(int verticeOrigem, int verticeDestino, int idAresta) {
        var origem = this.getVertice(verticeOrigem);
        var destino = this.getVertice(verticeDestino);

        origem.addAresta(destino, idAresta);
        if (!this.direcionado) {
            destino.addAresta(origem, idAresta);
        }
    }

    // ALEKS
    @Override
    public void removerAresta(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        origem.removeAresta(verticeDestino);
    }

    // LUCCA
    @Override
    public void ponderarVertice(int verticeOrigem, int peso) {
        var origem = this.adjacencia.get(verticeOrigem);
        origem.setPesoVertice(peso);
    }

    // LUCCA
    @Override
    public void rotularVertice(int vertice, String rotulo) {
        var origem = this.getVertice(vertice);
        origem.setRotulo(rotulo);
    }

    // LUCCA
    @Override
    public void ponderarAresta(int verticeOrigem, int verticeDestino, int peso) {
        var origem = this.getVertice(verticeOrigem);
        var destino = this.getVertice(verticeDestino);
        origem.ponderarAresta(destino, peso);
    }

    // LUCCA
    @Override
    public void rotularAresta(int verticeOrigem, int verticeDestino, String rotulo) {
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);
        origem.rotularAresta(destino, rotulo);
    }

    // ALEKS
    @Override
    public boolean verificaAdjacenciaVertice(int verticeOrigem, int verticeDestino) {
        var origem = this.adjacencia.get(verticeOrigem);
        var destino = this.adjacencia.get(verticeDestino);
        return origem.existeAresta(verticeDestino) || destino.existeAresta(verticeOrigem);
    }

    @Override
    public boolean verificaAdjacenciaArestas(int vertice1, int vertice2) {
        return verificaAdjacenciaVertice(vertice1, vertice2);
    }

    // LUCCA VER COM WEMERSON -> Ver com alek
    @Override
    public boolean verificaIncidenciaArestaVertice(int vertice, int aresta) {
        Vertice origem = this.adjacencia.get(vertice);

        // Verificando se a aresta informada pelo id chega no vertice origem
        for (Vertice verticeX : this.adjacencia) {
            if (verticeX.getId() != origem.getId()) {
                if (verticeX.existeAresta(origem.getId())) {
                    for (Aresta aresta1 : verticeX.getArestas()) {
                        if (aresta1.getId() == aresta) {
                            if (aresta1.destino().getId() == origem.getId()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        // Verifico se a aresta informada pelo id sai do vertice origem
        for (Aresta arestaOrigem : origem.getArestas()) {
            if (arestaOrigem.getId() == aresta) {
                if (arestaOrigem.destino().getId() == origem.getId()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean verificaExistenciaArestas(int vertice1, int vertice2) {
        var v1 = this.adjacencia.get(vertice1);
        var v2 = this.adjacencia.get(vertice2);

        return v1.existeAresta(v2.getId()) || v2.existeAresta(v1.getId());
    }

    // ALEKS
    @Override
    public int getNumeroVertices() {
        return adjacencia.size();
    }

    // ALEKS
    @Override
    public int getNumeroArestas() {
        int numArestas = 0;
        for (Vertice vertice : this.adjacencia) {
            numArestas += vertice.getArestas().size();
        }
        return numArestas;
    }

    @Override
    public boolean isGrafoVazio() {
        return adjacencia.isEmpty();
    }

    // LUCCA
    @Override
    public boolean isGrafoCompleto() {
        int contArestas = 0;
        int numVertices = this.adjacencia.size();
        for (Vertice vertice : this.adjacencia) {
            contArestas += vertice.getArestas().size();
        }

        return contArestas == ((numVertices - 1) * numVertices) / 2;
    }

    @Override
    public List<Vertice> getVizinhanca(int vertice) {
        var verticeOrigem = this.getVertice(vertice);
        var arestas = verticeOrigem.getArestas();
        List<Vertice> vizinhanca = new ArrayList<>();
        for (Aresta aresta : arestas) {
            vizinhanca.add(aresta.destino());
        }
        return vizinhanca;
    }

    @Override
    public void exportarGrafo(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<gexf xmlns=\"http://www.gexf.net/1.3draft\" version=\"1.3\">\n");
            writer.write("<graph mode=\"static\" defaultedgetype=\"undirected\">\n");

            // Escreve os vértices
            writer.write("<nodes>\n");
            for (Vertice vertice : adjacencia) {
                writer.write("<node id=\"" + vertice.getId() + "\" label=\"" + vertice.getId() + "\"/>\n");
            }
            writer.write("</nodes>\n");

            // Escreve as arestas
            writer.write("<edges>\n");
            int idAresta = 0;
            for (Vertice verticeOrigem : adjacencia) {
                for (Aresta aresta : verticeOrigem.getArestas()) {
                    Vertice verticeDestino = aresta.destino();
                    double peso = aresta.peso(); // Obtém o peso da aresta
                    writer.write("<edge id=\"" + idAresta++ + "\" source=\"" + verticeOrigem.getId() + "\" target=\""
                            + verticeDestino.getId() + "\" weight=\"" + peso + "\"/>\n");
                }
            }
            writer.write("</edges>\n");

            writer.write("</graph>\n");
            writer.write("</gexf>\n");

            System.out.println("Grafo exportado com sucesso para " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao exportar o grafo para GEXF: " + e.getMessage());
        }
    }

    @Override
    public void imprimeGrafo() {
        for (Vertice vertice : adjacencia) {

            String linha = vertice.getRotulo() + " -> ";
            for (Aresta aresta : vertice.getArestas()) {
                linha += aresta.destino().getRotulo() + " ->";
            }
            linha += "|";
            System.out.println(linha);
        }
    }

    // ALEKS
    @Override
    public void importarGrafo(String arquivo) {
        List<Vertice> vertices = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(arquivo));

            NodeList nodeList = document.getElementsByTagName("node");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int id = Integer.parseInt(element.getAttribute("id"));
                    String rotulo = element.getAttribute("label");

                    Vertice vertice = new Vertice(id);
                    vertice.setRotulo(rotulo);

                    this.adjacencia.add(vertice);
                }
            }

            // Agora você tem a lista de vértices, você precisa lidar com as arestas
            // O código abaixo é um exemplo básico e você precisará ajustá-lo conforme
            // necessário

            NodeList edgeList = document.getElementsByTagName("edge");

            for (int j = 0; j < edgeList.getLength(); j++) {
                Node node = edgeList.item(j);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    int sourceId = Integer.parseInt(element.getAttribute("source"));
                    int targetId = Integer.parseInt(element.getAttribute("target"));
                    int id = Integer.parseInt(element.getAttribute("id"));
                    this.getVertice(sourceId).addAresta(this.getVertice(targetId), id);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao importar o grafo GEXF: " + e.getMessage());
        }
        this.adjacencia = vertices;
    }

    @Override
    public void dijkstra() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dijkstra'");
    }

    @Override
    public void bellmanFord(int verticeOrigem) {
        // Find the minimum vertex ID
        int minVertexId = Integer.MAX_VALUE;
        for (Vertice v : adjacencia) {
            if (v.getId() < minVertexId) {
                minVertexId = v.getId();
            }
        }

        // Adjust indices based on the minimum vertex ID
        int adjustment = -minVertexId;
        int numVertices = adjacencia.size();

        double[] distancia = new double[numVertices];
        for (int i = 0; i < numVertices; i++) {
            distancia[i] = Double.POSITIVE_INFINITY;
        }

        // Set distance to the source vertex as 0
        Vertice source = this.getVertice(verticeOrigem);
        distancia[source.getId() + adjustment] = 0;

        // Relax edges repeatedly
        for (int i = 0; i < numVertices - 1; i++) {
            for (Vertice u : adjacencia) {
                for (Aresta aresta : u.getArestas()) {
                    Vertice v = aresta.destino();
                    if (distancia[u.getId() + adjustment] + aresta.peso() < distancia[v.getId() + adjustment]) {
                        distancia[v.getId() + adjustment] = distancia[u.getId() + adjustment] + aresta.peso();
                    }
                }
            }
        }
        for (Vertice u : adjacencia) {
            for (Aresta aresta : u.getArestas()) {
                Vertice v = aresta.destino();
                if (distancia[u.getId() + adjustment] + aresta.peso() < distancia[v.getId() + adjustment]) {
                    System.out.println("Graph contains a negative weight cycle");
                    return;
                }
            }
        }
        // Print the shortest distances
        for (int i = 0; i < numVertices; i++) {
            System.out.println(
                    "Menor distância de " + source.getId() + " para " + (i + minVertexId) + ": " + distancia[i]);
        }
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
        for (Vertice vertice : this.adjacencia) {
            this.bellmanFord(vertice.getId());
        }
        return 1;
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
    public List<Vertice> AEstrela(Vertice inicio, Vertice objetivo) {
        Set<Vertice> visitados = new HashSet<>();
        PriorityQueue<Vertice> fronteira = new PriorityQueue<>(
                Comparator.comparingDouble(vertice -> vertice.getG() + vertice.getH()));

        inicio.setG(0);
        inicio.setH(calcularHeuristica(inicio, objetivo));
        fronteira.add(inicio);

        while (!fronteira.isEmpty()) {
            Vertice atual = fronteira.poll();

            if (atual.equals(objetivo)) {
                return reconstruirCaminho(atual);
            }

            visitados.add(atual);

            for (Aresta aresta : atual.getArestas()) {
                Vertice vizinho = aresta.destino();

                if (!visitados.contains(vizinho)) {
                    double novoG = atual.getG() + aresta.peso();

                    if (novoG < vizinho.getG() || !fronteira.contains(vizinho)) {
                        vizinho.setG(novoG);
                        vizinho.setH(calcularHeuristica(vizinho, objetivo));
                        vizinho.setPai(atual);

                        if (!fronteira.contains(vizinho)) {
                            fronteira.add(vizinho);
                        }
                    }
                }
            }
        }

        return Collections.emptyList(); // Caminho não encontrado
    }

    // Restante da classe...

    private double calcularHeuristica(Vertice origem, Vertice destino) {
        // Substitua pelo cálculo da heurística desejada (distância euclidiana,
        // Manhattan, etc.)
        return 0;
    }

    private List<Vertice> reconstruirCaminho(Vertice objetivo) {
        List<Vertice> caminho = new ArrayList<>();
        Vertice atual = objetivo;

        while (atual != null) {
            caminho.add(atual);
            atual = atual.getPai();
        }

        Collections.reverse(caminho);
        return caminho;
    }

    private Vertice getVertice(int id) {
        for (Vertice vertice : this.adjacencia) {
            if (vertice.getId() == id) {
                return vertice;
            }
        }
        throw new NotFoundException("Vertice " + id + " nao encontrado");
    }

    private Vertice getVertice(String rotulo) {
        for (Vertice vertice : this.adjacencia) {
            if (vertice.getRotulo() == rotulo) {
                return vertice;
            }
        }
        throw new NotFoundException("Vertice " + rotulo + " nao encontrado");
    }

    @Override
    public String toString() {
        String r = "";
        for (Vertice u : adjacencia) {
            r += u.getRotulo() + u.getId() + " -> ";
            for (Aresta e : u.getArestas()) {
                Vertice v = e.destino();
                r += v.getRotulo() + ", ";
            }
            r += "\n";
        }
        return r;
    }

}
