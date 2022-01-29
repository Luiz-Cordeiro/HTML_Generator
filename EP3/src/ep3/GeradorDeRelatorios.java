package ep3;
import java.io.PrintWriter;
import java.io.IOException;

public class GeradorDeRelatorios {
	private Produto [] produtos;
	private Object argFiltro;
        Criterio criterio;
        Ordenar algoritmoOrd;
        Filtro filtro;
        int tamTotal;

        public GeradorDeRelatorios(Produto [] produtos, Ordenar algoritmoOrd, Criterio criterio, Filtro filtro){
		this.produtos = new Produto[produtos.length];
		for(int i = 0; i < produtos.length; i++)
			this.produtos[i] = produtos[i];
                this.criterio = criterio; 
                this.algoritmoOrd = algoritmoOrd;
		this.filtro = filtro;
                this.tamTotal = produtos.length;
	}
        
        public void ordena(){
            Ordenacao ordenacao = new Ordenacao(produtos);
            ordenacao.setCriterio(criterio);
            ordenacao.perfazCrit();
            ordenacao.setAlgoritmo(algoritmoOrd);
            ordenacao.ordena();
            ordenacao.setFiltro(filtro);
            ordenacao.filtrar();
            produtos = ordenacao.getProdutos();
        }
        
	public void geraRelatorio(String arquivoSaida) throws IOException {
            ordena();
            PrintWriter out = new PrintWriter(arquivoSaida);
            out.println("<!DOCTYPE html><html>");
            out.println("<head><title>Relatorio de produtos</title></head>");
            out.println("<body>");
            out.println("Relatorio de Produtos:");
            out.println("<ul>");
            for(int i = 0; i < produtos.length; i++){
		Produto p = produtos[i];
                out.print("<li>");
                out.print(p.formataParaImpressao());
                out.print("</span>");
                out.println("</li>");
            }   
            out.println("</ul>");
            out.println(produtos.length + " produtos listados, de um total de " + tamTotal + ".");
            out.println("</body>");
            out.println("</html>");
            out.close();  
	}

	public static Produto [] carregaProdutos(){

		return new Produto [] { 
			new ProdutoPadrao( 1, "O Hobbit", "Livros", 2, 34.90),
			new ProdutoPadrao( 2, "Notebook Core i7", "Informatica", 5, 1999.90),
			new ProdutoPadrao( 3, "Resident Evil 4", "Games", 7, 79.90),
			new ProdutoPadrao( 4, "iPhone", "Telefonia", 8, 4999.90),
			new ProdutoPadrao( 5, "Calculo I", "Livros", 20, 55.00),
			new ProdutoPadrao( 6, "Power Glove", "Games", 3, 499.90),
			new ProdutoPadrao( 7, "Microsoft HoloLens", "Informatica", 1, 19900.00),
			new ProdutoPadrao( 8, "OpenGL Programming Guide", "Livros", 4, 89.90),
			new ProdutoPadrao( 9, "Vectrex", "Games", 1, 799.90),
			new ProdutoPadrao(10, "Carregador iPhone", "Telefonia", 15, 499.90),
			new ProdutoPadrao(11, "Introduction to Algorithms", "Livros", 7, 315.00),
			new ProdutoPadrao(12, "Daytona USA (Arcade)", "Games", 1, 12000.00),
			new ProdutoPadrao(13, "Neuromancer", "Livros", 5, 45.00),
			new ProdutoPadrao(14, "Nokia 3100", "Telefonia", 4, 249.99),
			new ProdutoPadrao(15, "Oculus Rift", "Games", 1, 3600.00),
			new ProdutoPadrao(16, "Trackball Logitech", "Informatica", 1, 250.00),
			new ProdutoPadrao(17, "After Burner II (Arcade)", "Games", 2, 8900.0),
			new ProdutoPadrao(18, "Assembly for Dummies", "Livros", 30, 129.90),
			new ProdutoPadrao(19, "iPhone (usado)", "Telefonia", 3, 3999.90),
			new ProdutoPadrao(20, "Game Programming Patterns", "Livros", 1, 299.90),
			new ProdutoPadrao(21, "Playstation 2", "Games", 10, 499.90),
			new ProdutoPadrao(22, "Carregador Nokia", "Telefonia", 14, 89.00),
			new ProdutoPadrao(23, "Placa Aceleradora Voodoo 2", "Informatica", 4, 189.00),
			new ProdutoPadrao(24, "Stunts", "Games", 3, 19.90),
			new ProdutoPadrao(25, "Carregador Generico", "Telefonia", 9, 30.00),
			new ProdutoPadrao(26, "Monitor VGA 14 polegadas", "Informatica", 2, 199.90),
			new ProdutoPadrao(27, "Nokia N-Gage", "Telefonia", 9, 699.00),
			new ProdutoPadrao(28, "Disquetes Maxell 5.25 polegadas (caixa com 10 unidades)", "Informatica", 23, 49.00),
			new ProdutoPadrao(29, "Alone in The Dark", "Games", 11, 59.00),
			new ProdutoPadrao(30, "The Art of Computer Programming Vol. 1", "Livros", 3, 240.00),
			new ProdutoPadrao(31, "The Art of Computer Programming Vol. 2", "Livros", 2, 200.00),
			new ProdutoPadrao(32, "The Art of Computer Programming Vol. 3", "Livros", 4, 270.00)
      		};
	} 

    public static void main(String [] args){
	Produto [] produtos = carregaProdutos();
        Produto [] produtos2 = carregaProdutos();
        
        Criterio criterio = new CritPreco();
        Ordenar algoritmoOrd = new InsertionSortCresc();
        Filtro filtro = new Todos();
        GeradorDeRelatorios [] gdrs = new GeradorDeRelatorios[10];
        
        try{
       
        //-------------------------Testes--------------------------------------
        //Teste 1: InsertionSortCresc/Preco/Todos/SemDocorator
  
        gdrs[0] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[0].geraRelatorio("InsertionCres-Preco-Todos-SemDecorator.html");    
        //Teste 2: InsertionSortDec/Preco/Todos/SemDocorator
        algoritmoOrd = new InsertionSortDec();
        gdrs[1] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[1].geraRelatorio("InsertionDec-Preco-TodosSemDecorator.html");  
        
        //Teste 3: QuickSortCresc/Preco/Todos/SemDocorator
        algoritmoOrd = new QuickSortCresc();
        gdrs[2] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[2].geraRelatorio("QuickSortCresc-Preco-Todos-SemDecorator.html"); 
        
        //Teste 4: QuickSortDec/Preco/Todos/SemDocorator
        algoritmoOrd = new QuickSortDec();
        gdrs[3] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[3].geraRelatorio("QuickSortDec-Preco-Todos-SemDecorator.html"); 
        
        //Teste 5: QuickSortCresc/Descricao/Todos/SemDocorator
        algoritmoOrd = new QuickSortCresc();
        criterio = new CritDescricao();
        gdrs[4] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[4].geraRelatorio("QuickSortCresc-Descricao-Todos-SemDecorator.html"); 
        
        //Teste 6: QuickSortDec/Descricao/Todos/SemDocorator
        algoritmoOrd = new QuickSortDec();
        criterio = new CritDescricao();
        gdrs[5] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[5].geraRelatorio("QuickSortDec-Descricao-Todos-SemDecorator.html"); 
        
        //Teste 7: QuickSortCresc/QtdEstoque/Todos/SemDocorator
        algoritmoOrd = new QuickSortCresc();
        criterio = new CritEstoque();
        gdrs[6] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[6].geraRelatorio("QuickSortCresc-QtdEstoque-Todos-SemDecorator.html"); 
        
        //Teste 8: QuickSortCresc/Preco/EstoqueMenorIgual/SemDocorator
        filtro = new EstoqueMenorIgual(7);
        gdrs[7] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[7].geraRelatorio("QuickSortCresc-QtdEstoque-EstoqueMenorIgual-SemDecorator.html"); 
        
        
        //Teste 9: QuickSortCresc/Descricao/EstoqueMenorIgual/SemDocorator
        criterio = new CritDescricao();
        gdrs[8] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[8].geraRelatorio("QuickSortCresc-Descricao-EstoqueMenorIgual-SemDecorator.html"); 
        
        
        //Teste 9: QuickSortCresc/Preco/Todos/ComDecoradoresDiversos
        criterio = new CritPreco();
        filtro = new Todos();
        produtos[23] = new Negrito(produtos[23]);
        produtos[28] = new Italico(produtos[28]);
        produtos[22] = new Negrito(new Italico(produtos[22]));
        produtos[31] = new Colorido(produtos[31], "red");
        produtos[5] = new Negrito(new Colorido(produtos[5],"green"));
        produtos[1] = new Italico(new Colorido(produtos[1],"blue"));
        produtos[6] = new Negrito(new Italico(new Colorido(produtos[6],"orange")));
        
        gdrs[9] = new GeradorDeRelatorios(produtos, algoritmoOrd, criterio,  
    					filtro);
        gdrs[9].geraRelatorio("QuickSortCresc-Preco-Todos-ComDecoradoresDiversos.html"); 
        
        //Teste 9: QuickSortCresc/Preco/Todos/ComDecoradoresDiversos
        criterio = new CritPreco();
        filtro = new ParteDescricao("Computer");
                
        gdrs[9] = new GeradorDeRelatorios(produtos2, algoritmoOrd, criterio,  
    					filtro);
        gdrs[9].geraRelatorio("QuickSortCresc-Preco-ParteDescricao-SemDecorator.html"); 
	}
	catch(IOException e){
            e.printStackTrace();
	}
    }
}
