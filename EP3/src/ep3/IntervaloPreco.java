
package ep3;

public class IntervaloPreco implements Filtro{

    Produto[] produtos;
    Produto[] saida;
    Object argFiltro1;
    Object argFiltro2;
    
    public IntervaloPreco (Object argFiltro1, Object argFiltro2){
        this.argFiltro1 = argFiltro1;
        this.argFiltro2 = argFiltro2;
    }
    
    @Override
    public Produto[] filtrar (Produto[] produtos){
        int qtd = 0;
        int i = 0;
        for(Produto produto : produtos)
            if(produto.getPreco() >= (Integer)argFiltro1 && produto.getPreco() <= (Integer)argFiltro2)
                qtd++;
                
        saida = new Produto[qtd];
        
        for(Produto produto : produtos)
            if(produto.getPreco() >= (Integer)argFiltro1 && produto.getPreco() <= (Integer)argFiltro2){
                saida[i] = produto;
                i++;
            }
        return saida;
    }
}
