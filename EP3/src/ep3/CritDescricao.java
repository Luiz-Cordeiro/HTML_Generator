
package ep3;

public class CritDescricao implements Criterio{

    Produto[] produtos;
    Determinante determinante;
    
    @Override
    public Determinante getCriterio(Produto[] produtos){ 
        this.produtos = new Produto[produtos.length];
        for(int i = 0; i < produtos.length;i++)
            this.produtos[i] = produtos[i];   
        determinante = new Determinante();
        determinante.setTamanho(produtos.length);
        for(int i = 0; i < produtos.length; i++)
            determinante.setArrayString(produtos[i].getDescricao(), i);
        return determinante;
    }
  
}