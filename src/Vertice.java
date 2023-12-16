import java.util.ArrayList;

public class Vertice {
    private ArrayList<Aresta> arestas;
    private int id;

    private String rotulo;
    private double pesoVertice;
    private boolean visitado;

    private Vertice pai; // Vértice anterior no caminho
    // private double h; // Heurística estimada do vértice até o destino
    private double g; // Custo acumulado do ponto de partida até o vértice atual

    public Vertice(int id) {
        this.id = id;
        this.arestas = new ArrayList<>();
        this.pesoVertice = 0;
        this.rotulo = "";
        this.visitado = false;
        this.pai = null;
        // this.h = 0;
        this.g = Double.POSITIVE_INFINITY; // Inicializado como infinito até ser
        // definido

    }

    public Vertice(int id, int peso, String rotulo) {
        this.id = id;
        this.arestas = new ArrayList<>();
        this.pesoVertice = peso;
        this.rotulo = rotulo;
        this.visitado = false;
        this.pai = null;
        // this.h = 0;
        this.g = Double.POSITIVE_INFINITY; // Inicializado como infinito até ser
        // definido

    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

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

    public String getRotulo() {
        return this.rotulo;
    }

    public ArrayList<Aresta> getArestas() {
        return this.arestas;
    }

    public void addAresta(Vertice destino, double peso, int id) {
        this.arestas.add(destino.id, new Aresta(peso, destino, id));
    }

    public void addAresta(Vertice destino, int idAresta) {
        this.arestas.add(new Aresta(0, destino, idAresta));
    }

    public void ponderarAresta(Vertice destino, double pesoVertice) {
        this.arestas.forEach((aresta) -> {
            if (aresta.destino().getId() == destino.getId()) {
                aresta.setPeso(pesoVertice);
            } else {
                // Se der tempo, fazer tratamento de erro
                System.out.println("Não existe uma aresta entre os vértices informados");
            }
        });
    }

    public void rotularAresta(Vertice destino, String rotulo) {
        this.arestas.forEach((aresta) -> {
            if (aresta.destino().getId() == destino.getId()) {
                aresta.setRotulo(rotulo);
            } else {
                // Se der tempo, fazer tratamento de erro
                System.out.println("Não existe uma aresta entre os vértices informados");
            }
        });
    }

    public boolean existeAresta(int destino) {
        try {
            return this.arestas.get(destino) != null;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public Aresta removeAresta(int destino) {
        return this.arestas.remove(destino);
    }

    public int grau() {
        return this.arestas.size();
    }

    public void visitar() {
        this.visitado = true;
    }

    public void limparVisita() {
        this.visitado = false;
    }

    public boolean visitado() {
        return this.visitado;
    }

    public void addPeso(int aresta, double peso) {
        var arestaPeso = this.arestas.get(aresta);
        arestaPeso.setPeso(peso);
    }

    // Adicionados métodos para A*
    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    // public double getH() {
    // return h;
    // }

    // public void setH(double h) {
    // this.h = h;
    // }
}