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
public interface Produto {
    public void setQtdEstoque(int qtdEstoque);
	public void setPreco(double preco);
	
	public int getId();
	public String getDescricao();
	public String getCategoria();
	public int getQtdEstoque();	
	public double getPreco();

	public String formataParaImpressao();
}
