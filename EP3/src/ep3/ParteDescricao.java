
package ep3;


public class ParteDescricao implements Filtro{
    
    Produto[] produtos;
    Produto[] saida;
    String argFiltro;
    
    public ParteDescricao (String argFiltro){
        this.argFiltro = argFiltro;
    }
    
    @Override
    public Produto[] filtrar (Produto[] produtos){
        int qtd = 0;
        for (Produto produto : produtos)
            if (produto.getDescricao().toLowerCase().contains(argFiltro.toLowerCase())) 
                qtd++;
        
        
        saida = new Produto[qtd];
        int j = 0;
        
        for (Produto produto : produtos) {
            if (produto.getDescricao().toLowerCase().contains(argFiltro.toLowerCase()))  {
                saida[j] = produto;
                j++;
            }
        }
        return saida;
    }
}