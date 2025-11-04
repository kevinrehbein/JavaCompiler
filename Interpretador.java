class Interpretador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			Computador backend = new Computador();
			Integer resultado = backend.computa(arv); 	
			System.out.println(resultado);

		}catch(Exception e)
		{			
			System.out.println("Erro no interpretador:\n" + e);
		}
	}
}
