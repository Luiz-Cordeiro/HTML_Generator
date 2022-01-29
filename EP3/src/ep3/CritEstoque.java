
package ep3;

public class CritEstoque implements Criterio{
Produto[] produtos;
Determinante determinante;    
    

 @Override
    public Determinante getCriterio(Produto[] produtos){ //novo met
        this.produtos = new Produto[produtos.length];
        for(int i = 0; i < produtos.length;i++)
            this.produtos[i] = produtos[i];   
        determinante = new Determinante();//novo teste
        determinante.setTamanho(produtos.length);
        for(int i = 0; i < produtos.length; i++)
            determinante.setArrayDouble(produtos[i].getQtdEstoque(), i);
        return determinante;
    }
}
