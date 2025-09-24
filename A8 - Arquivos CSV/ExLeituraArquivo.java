import java.io.BufferedReader;
import java.io.FileReader;

public class ExLeituraArquivo{
    public static void main(String[] args) throws Exception{
        String nomeArquivo = "ArquivoEntrada.csv";
        BufferedReader arqLeitura = new BufferedReader(new FileReader(nomeArquivo));    

        String linha; //Armazena o valor lido do arquivo em uma variavel
        while((linha = arqLeitura.readLine()) != null){
            System.out.println(linha);
        }
        arqLeitura.close();

        System.out.println();
        //Metodo mostrando só primeira linha e sem o cabeçalho.
        arqLeitura = new BufferedReader(new FileReader(nomeArquivo));
        linha = arqLeitura.readLine(); // Ignora o primeiro
        while((linha = arqLeitura.readLine()) != null){ //Enquanto a linha não for nula
            String vetCampos[] = linha.split(";"); //Split separando a string a partir do ; em um vetor
            System.out.println(vetCampos[0]);  //Mostra apenas o primeiro valor do vetor.
        }
        arqLeitura.close(); //Fecha o arquivo
    }
}
