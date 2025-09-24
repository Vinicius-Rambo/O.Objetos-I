import java.io.BufferedWriter;
import java.io.FileWriter;

public class ExEscritaArquivo{
    public static void main(String[] args) throws Exception{
        String nomeArqSaida = "arqSaida.csv";
        BufferedWriter arqGravacao = new BufferedWriter(new FileWriter(nomeArqSaida));
    
        String linha = "Produto;Preço;Estoque";
        arqGravacao.write(linha);
        arqGravacao.newLine();

        String nomeProduto = "Mouse Dell";
        String preco = "112,50";
        String estoque = "22";
        linha = nomeProduto +";"+ preco +";"+ estoque +";";
        arqGravacao.write(linha);

        arqGravacao.newLine();
        nomeProduto = "Notebook Acer";
        preco = "3240,50";
        estoque = "3";
        linha = nomeProduto +";"+ preco +";"+ estoque +";";
        arqGravacao.write(linha);

        arqGravacao.newLine();
        nomeProduto = "Cabo HDMI";
        preco = "114,00";
        estoque = "1";
        linha = nomeProduto +";"+ preco +";"+ estoque +";";
        arqGravacao.write(linha);
        arqGravacao.close();
    }    
}
