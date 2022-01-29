
package ep3;

public class CategoriaIgual implements Filtro{
    
    Produto[] produtos;
    Produto[] saida;
    Object argFiltro;
    
    public CategoriaIgual (Object argFiltro){
        this.argFiltro = argFiltro;
    }
    
    @Override
    public Produto[] filtrar (Produto[] produtos){
        int qtd = 0;
        for (Produto produto : produtos) 
            if (produto.getCategoria().equalsIgnoreCase((String)argFiltro)) 
                qtd++;
        
        saida = new Produto[qtd];
        int j = 0;
        
        for (Produto produto : produtos) {
            if (produto.getCategoria().equalsIgnoreCase((String)argFiltro)) {
                saida[j] = produto;
                j++;
            }
        }
        return saida;
    }
}
    
    
    

