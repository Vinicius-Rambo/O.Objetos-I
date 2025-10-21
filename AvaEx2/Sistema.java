import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
 
public class SistemaLoja {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader arqLeitura = new BufferedReader(new FileReader("preco_custo.csv"));
        BufferedWriter arqEscrita = new BufferedWriter(new FileWriter("preco_venda.csv"));
        


        String linhaLeitura = arqLeitura.readLine();
        String linhaEscrita = "codigo;produto;preco_venda";

        while((linhaLeitura = arqLeitura.readLine()) != null){
            String[] coluna = linhaLeitura.split(";");

            

        }
    }
}
