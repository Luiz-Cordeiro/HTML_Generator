
package ep3;

public class CritPreco implements Criterio{

    Produto[] produtos;
    double vetor[];
    Determinante determinante;

    @Override
    public Determinante getCriterio(Produto[] produtos){ 
        this.produtos = new Produto[produtos.length];
        for(int i = 0; i < produtos.length;i++)
            this.produtos[i] = produtos[i];   
        determinante = new Determinante();
        determinante.setTamanho(produtos.length);
        for(int i = 0; i < produtos.length; i++)
            determinante.setArrayDouble(produtos[i].getPreco(), i);
        return determinante;
    }
}
