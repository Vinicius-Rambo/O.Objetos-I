import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExemploDate {
    public static void main(String[] args) {
        Date agora = new Date(); //Declara a data e hora do PC
        System.out.println("Agora: " + agora);

        //SimpleDateFormat

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Dias /Meses /Ano
        String dataFormatada = sdf.format(agora); //Formatação da variavel agora.
        System.out.println("Data formatada: " + dataFormatada);

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT); //Date Format (outra função)
        System.out.println("SHORT: " + df.format(agora)); //Forma direta
    }
}
 