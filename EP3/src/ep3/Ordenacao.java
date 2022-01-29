
package ep3;

public class Ordenacao {
    
    public Ordenar ordenar;
    public Criterio criterio;
    public Filtro filtro;
    Produto[] produtos;
    Determinante determinante;
    
    public Ordenacao(Produto[] produtos){
        this.produtos = produtos;
    }
    
    public void setCriterio(Criterio criterio){
       this.criterio = criterio;
    }
    
    public void perfazCrit(){
        determinante = criterio.getCriterio(produtos);
    }
    
    public void setAlgoritmo(Ordenar ordenar){
        this.ordenar = ordenar;
    }
    
    public void ordena(){
        this.produtos = ordenar.ordenar(produtos, determinante);
    }
    
    public void setFiltro(Filtro filtro){
        this.filtro = filtro;
    }
    
    public void filtrar(){
        this.produtos = filtro.filtrar(produtos);
    }
    
    public Produto[] getProdutos(){
        return this.produtos;
    }
}
