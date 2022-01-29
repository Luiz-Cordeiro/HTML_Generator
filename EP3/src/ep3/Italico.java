
package ep3;


public class Italico extends ProdutoDecorator{
    
    public Italico(Produto p){
        produto = p;
    }
    
    @Override
    public String formataParaImpressao(){
        return "<span style=\"font-style:italic\">"+produto.formataParaImpressao()+"</span></span>";
    }
}

