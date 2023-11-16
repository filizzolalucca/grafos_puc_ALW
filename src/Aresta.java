public class Aresta {

    private double peso;
    private Vertice destino;
    private boolean visitada;

    private String rotulo;

    private int id;

    /**
     * Construtor para arestas com peso. A aresta é criada como não visitada.
     * 
     * @param peso2 Peso da aresta
     * @param destino  Vértice de destino
     */
    public Aresta(double peso2, Vertice destino, int id) {
        init(peso2, destino, id);
    }

    /**
     * Construtor para arestas sem peso. A aresta é criada como não visitada.
     * 
     * @param destino Vértice de destino
     */
    public Aresta(Vertice destino, int id) {
        init(-1, destino, id);
    }

    private void init(double peso2, Vertice destino, int id) {
        this.peso = peso2;
        this.id = id;
        this.destino = destino;
        this.visitada = false;
    }

    /**
     * Método de acesso para o peso da aresta
     * 
     * @return Peso da aresta (int)
     */
    public double peso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRotulo() {
        return rotulo;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    /**
     * Método de acesso para o destino da aresta
     * 
     * @return Id do vértice de destino
     */
    public Vertice destino() {
        return this.destino;
    }

    /**
     * Marca a aresta como visitada
     */
    public void visitar() {
        this.visitada = true;
    }

    /**
     * Marca a aresta como não visitada
     */
    public void limparVisita() {
        this.visitada = false;
    }

    /**
     * Indica se a aresta foi visitada (TRUE) ou não (FALSE)
     * 
     * @return TRUE/FALSE conforme a aresta foi visitada ou não.
     */
    public boolean visitada() {
        return this.visitada;
    }
}