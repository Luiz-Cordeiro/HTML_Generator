
package ep3;

public class InsertionSortCresc implements Ordenar{
    Produto[] produtos;

    
    @Override
    public Produto[] ordenar(Produto[] produtos, Determinante determinante){
        this.produtos = new Produto[produtos.length];   
        this.produtos = produtos;
        
        int ini;
        int fim = produtos.length-1;
        ini = 0;   
         if(determinante.arrayStringVazia()){
            for(int i = ini; i <= fim; i++){
                Produto x = produtos[i];
                double z = determinante.getArrayDouble(i);
                int j = (i - 1);
                while(j >= ini){
                    if(z < determinante.getArrayDouble(j)){
                        determinante.internalChangeArrayDouble(j + 1, j);
                        produtos[j + 1] = produtos[j];
                        j--;
                    }
                    else break;
                }
                determinante.setArrayDouble(z, j + 1);
                produtos[j + 1] = x;
            }
         }
         else{
             for(int i = ini; i <= fim; i++){
                Produto x = produtos[i];
                String z = determinante.getArrayString(i);
                int j = (i - 1);
                while(j >= ini){
                    if(z.compareToIgnoreCase(determinante.getArrayString(j)) < 0){ //Condição de ordem crescente
                        determinante.internalChangeArrayString(j + 1, j);
                        produtos[j + 1] = produtos[j];
                        j--;
                    }
                    else break;
                }
                produtos[j + 1] = x;
                determinante.setArrayString(z, j + 1);
            }
        }
        return this.produtos;
    }
}
