
package ep3;


public class QuickSortDec implements Ordenar{
  Produto[] produtos;
 
  @Override
    public Produto[] ordenar(Produto[] produtos, Determinante determinante){
        this.produtos = new Produto[produtos.length];   
        this.produtos = produtos;
        
        int ini = 0;
        int fim = produtos.length-1;
        ordena(ini, fim, determinante);
        
        return produtos;
    }
    
    public Produto[] ordena(int ini, int fim, Determinante determinante){
        if(ini < fim) {
	    int q = particiona(ini, fim, determinante);
	    ordena(ini, q, determinante);
            ordena(q + 1, fim, determinante);
	}
        return produtos;
    }
    
    public int particiona(int ini, int fim, Determinante determinante){
        if(determinante.arrayStringVazia()){
            Produto x = produtos[ini];
            double z = determinante.getArrayDouble(ini);
            int i = (ini - 1);
            int j = (fim + 1);
            while(true){
                do{ 
                    j--;
                  } while(determinante.getArrayDouble(j) < z);
                do{
                    i++;		
                  } while(determinante.getArrayDouble(i) > z);			
                if(i < j){
                    Produto temp1 = produtos[i];
                    double temp2 = determinante.getArrayDouble(i);
                    produtos[i] = produtos[j]; 		
                    determinante.internalChangeArrayDouble(i, j);
                    produtos[j] = temp1;
                    determinante.setArrayDouble(temp2, j);
                }
                else return j;
            }
        }
        else{
            Produto x = produtos[ini];
            String z = determinante.getArrayString(ini);
            int i = (ini - 1);
            int j = (fim + 1);
            while(true){
                do{ 
                    j--;
                } while(determinante.getArrayString(j).compareToIgnoreCase(z) < 0);
                do{
                    i++;
                } while(determinante.getArrayString(i).compareToIgnoreCase(z) > 0);	
                if(i < j){
                    Produto temp1 = produtos[i];
                    String temp2 = determinante.getArrayString(i);
                    produtos[i] = produtos[j];
                    determinante.internalChangeArrayString(i, j);
                    produtos[j] = temp1;
                    determinante.setArrayString(temp2, j);
                }
                else return j;
            }
        }
    }
}
