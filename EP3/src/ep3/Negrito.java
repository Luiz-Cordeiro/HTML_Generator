/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ep3;

/**
 *
 * @author Luiz Felipe
 */
public class Negrito extends ProdutoDecorator{
    
    public Negrito(Produto p){
        produto = p;
    }
    
    @Override
    public String formataParaImpressao(){//Esse é o método que vai mudar de comportamento
        return "<span style=\"font-weight:bold\">"+produto.formataParaImpressao()+"</span></span>";
    }
}
