import exceptions.NotFoundException;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            int[][] grafo = {
                    {0, 0, 1, 1, 0, 1},
                    {0, 0, 1, 1, 0, 1},
                    {1, 1, 0, 1, 1, 0},
                    {1, 1, 1, 0, 1, 0},
                    {0, 0, 1, 1, 0, 0},
                    {1, 1, 0, 0, 0, 0}
            };
            var grafo2 = new GrafoListaAdjacencia();
//            grafo2.inserirVertice(1);
//            grafo2.inserirVertice(2);
//            grafo2.inserirVertice(3);
//            grafo2.inserirVertice(4);
//            grafo2.rotularVertice(1, "Aleks");
//            grafo2.rotularVertice(2, "Lucca");
//            grafo2.rotularVertice(3, "Weme");
//            grafo2.rotularVertice(6, "Weme");

            grafo2.importarGrafo();
        } catch(NotFoundException err){
            System.out.println(err.getMessage());
        }

    }

    public void buscaProfundidade(int[][] grafo){
        
    }
}
