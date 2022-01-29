
package ep3;

public class Todos implements Filtro{
    Produto[] produtos;
    
    @Override
    public Produto[] filtrar (Produto[] produtos){
        this.produtos = new Produto[produtos.length];
        for(int i = 0; i < produtos.length; i++)
            this.produtos[i] = produtos[i];
      
        return this.produtos;
    }
}