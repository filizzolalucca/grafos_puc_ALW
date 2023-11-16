import java.util.ArrayList;

public class Vertice {

    private ArrayList<Aresta> arestas;
    private int id;

    private String rotulo;
    private double pesoVertice;
    private boolean visitado;

    /**
     * Construtor para criação de vértice identificado
     *
     * @param id Número/id do vértice a ser criado (atributo final).
     */
    public Vertice(int id) {
        this.id = id;
        this.arestas = new ArrayList<>();
        this.pesoVertice = 0;
        this.rotulo = "";
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

    public double getPesoVertice() {
        return this.pesoVertice;
    }

    public void setRotulo(String rotulo) {
        this.rotulo = rotulo;
    }

    public void setPesoVertice(double pesoVertice) {
        this.pesoVertice = pesoVertice;
    }

    public String getRotulo(){
        return this.rotulo;
    }

    /**
     * Retorna a lista de arestas
     *
     * @return ArrayList<Aresta>
     */
    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }

    public void addAresta(Vertice destino, double peso, int id) {
        this.arestas.add(destino.id, new Aresta(peso, destino, id));
    }

    /**
     * Adiciona uma aresta não ponderada neste vértice para um destino
     *
     * @param destino Vértice de destino
     */
    public void addAresta(Vertice destino, int idAresta) {
        this.arestas.add(destino.id, new Aresta(-1, destino, idAresta));
    }

    public void ponderarAresta(Vertice destino,double pesoVertice) {
        this.arestas.forEach((aresta) -> {
            if (aresta.destino().getId() == destino.getId()){
                aresta.setPeso(pesoVertice);
            } else {
                //se der tempo fazer tratamento de erro
                System.out.println("Nao existe uma aresta entre os vertices informados");
            }
        });
    }

    public void rotularAresta(Vertice destino, String rotulo) {
        this.arestas.forEach((aresta) -> {
            if (aresta.destino().getId() == destino.getId()){
                aresta.setRotulo(rotulo);
            } else {
                //se der tempo fazer tratamento de erro
                System.out.println("Nao existe uma aresta entre os vertices informados");
            }
        });
    }





    public boolean existeAresta(int destino) {
        try {
            return this.arestas.get(destino) != null;
        } catch ( IndexOutOfBoundsException e ) {
            return false;
        }
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