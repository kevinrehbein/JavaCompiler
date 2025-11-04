import java.io.*;
import java.util.Stack;

class MaquinaPilha {

    public static void main(String[] args) {

        Stack<Integer> pilha = new Stack<>();
        String arquivoDeEntrada = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
               
                String[] partes = linha.split(" ", 2); 
                String instrucao = partes[0];

                switch (instrucao) {

                    case "PRINT":
                        int resultadoFinal = pilha.pop();
                        System.out.println(resultadoFinal);
                        return; 

                    case "PUSH":
                        int valor = Integer.parseInt(partes[1]);
                        pilha.push(valor);
                        break;

                    default: 
                        int a = pilha.pop(); // arg2
                        int b = pilha.pop(); // arg1
                        int resultado = 0;

                        switch (instrucao) {
                            case "SUM":
                                resultado = b + a;
                                break;
                            case "MULT":
                                resultado = b * a;
                                break;
                            case "SUB":
                                resultado = b - a;
                                break;
                            case "DIV":
                                if (a == 0) {
                                    throw new Exception("Erro de divisão por zero.");
                                }
                                resultado = b / a;
                                break; 
                        }
                        pilha.push(resultado);
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado - " + arquivoDeEntrada);
        } catch (Exception e) {
            System.err.println("Erro na máquina de pilha: " + e.getMessage());
        }
    }
}