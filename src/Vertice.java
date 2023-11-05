import java.util.ArrayList;

public class Vertice {

    private ArrayList<Aresta> arestas;
    private final int id;
    private boolean visitado;

    /**
     * Construtor para criação de vértice identificado
     *
     * @param id Número/id do vértice a ser criado (atributo final).
     */
    public Vertice(int id) {
        this.id = id;
        this.arestas = new ArrayList<>();
        this.visitado = false;
    }

    /**
     * Retorna o ‘id’ do vértice, caso seja necessário para verificações próprias
     *
     * @return Identificador do vértice (int)
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retorna a lista de arestas
     *
     * @return ArrayList<Aresta>
     */
    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }


    public void addAresta(int destino, double peso) {
        this.arestas.add(destino, new Aresta(peso, destino));
    }

    /**
     * Adiciona uma aresta não ponderada neste vértice para um destino
     *
     * @param destino Vértice de destino
     */
    public void addAresta(int destino) {
        this.arestas.add(destino, new Aresta(-1, destino));
    }

    public Aresta existeAresta(int destino) {
        return this.arestas.get(destino);
    }

    /**
     * Remove e retorna a aresta para o destino indicado. Retorna null caso não
     * exista a aresta.
     *
     * @param destino Destino da aresta a ser removida.
     * @return A aresta removida, ou null se não existir.
     */
    public Aresta removeAresta(int destino) {
        return this.arestas.remove(destino);
    }

    public int grau() {
        return this.arestas.size();
    }

    /**
     * Marca o vértice como visitado
     */
    public void visitar() {
        this.visitado = true;
    }

    /**
     * Marca o vértice como não visitado
     */
    public void limparVisita() {
        this.visitado = false;
    }

    /**
     * Indica se o vértice foi visitado (TRUE) ou não (FALSE)
     *
     * @return TRUE/FALSE conforme o vértice tenha sido ou não visitado.
     */
    public boolean visitado() {
        return this.visitado;
    }

    public void addPeso(int aresta, double peso){
        var arestaPeso = this.arestas.get(aresta);
        arestaPeso.setPeso(peso);
    }
}