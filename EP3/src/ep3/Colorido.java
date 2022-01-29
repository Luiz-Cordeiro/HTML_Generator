
package ep3;


public class Colorido extends ProdutoDecorator{
    String cor;
    public Colorido(Produto p, String cor){
        produto = p;
        this.cor = cor;
    }
    
    @Override
    public String formataParaImpressao(){
        return "<font color=\""+cor+"\">"+produto.formataParaImpressao()+"</font>"+"</span></span>";
    }
}