import java.io.*;

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			
			try {
				OutputStream os = new FileOutputStream("CodigoCompilado.txt"); 
				Writer wr = new OutputStreamWriter(os); 
				BufferedWriter br = new BufferedWriter(wr); 
				br.write(codigo);
				br.close();
				System.out.println("Resultado da compilação em CodigoCompilado.txt");
			} catch (IOException e){
				System.out.println("Erro na criação do arquivo CodigoCompilado.txt");
			}
			

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
