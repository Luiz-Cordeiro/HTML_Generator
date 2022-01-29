
package ep3;


public class EstoqueMenorIgual implements Filtro{
    
    Produto[] produtos;
    Produto[] saida;
    Object argFiltro;
    
    public EstoqueMenorIgual (Object argFiltro){
        this.argFiltro = argFiltro;
    }
    
    @Override
    public Produto[] filtrar (Produto[] produtos){
        int qtd = 0;
        int i = 0;
        for(Produto produto : produtos)
            if(produto.getQtdEstoque() <= (Integer)argFiltro)
                qtd++;
                
        saida = new Produto[qtd];
        
        for(Produto produto : produtos)
            if(produto.getQtdEstoque() <= (Integer)argFiltro){
                saida[i] = produto;
                i++;
            }
        return saida;
    }
    
    
    
}
