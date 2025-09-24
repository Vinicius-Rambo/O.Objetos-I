import java.io.BufferedWriter;
import java.io.FileWriter;

public class Excercio {
    public static void main(String[] args) throws Exception{
        String nomeArqSaida = "tabela.html";
        BufferedWriter arqGravacao = new BufferedWriter(new FileWriter(nomeArqSaida));
        String linha = "<html> <table width=\"400\" align = \"center\" border=\"1\">";

        arqGravacao.write(linha);

        for(int i = 0; i < 16; i++){
            int red = i;
            String hexRed = Integer.toHexString(red);
        
            for(int j = 0; j < 16; j++){
                int green = j;
                String hexGreen = Integer.toHexString(green); 

                for(int k = 0; k < 16; k++){
                    int blue = k;
                    String hexBlue = Integer.toHexString(blue);  

                    String cores = hexRed + "0" + hexGreen + "0" + hexBlue + "0";

                    linha = "<tr>";
                    arqGravacao.write(linha);
                    arqGravacao.newLine();

                    linha = "<td bgcolor='#" + cores + "'></td>" + "<td>" + cores + "</td>";
                    arqGravacao.write(linha);
                    arqGravacao.newLine();

                    linha = "<tr>";
                    arqGravacao.write(linha);
                    arqGravacao.newLine();


                }  
            }
        }
        linha = "</table></html>";
        arqGravacao.write(linha);
        arqGravacao.newLine();
        arqGravacao.close();
    }   
}
