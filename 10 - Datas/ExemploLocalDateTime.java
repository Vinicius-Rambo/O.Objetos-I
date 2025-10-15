import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExemploLocalDateTime {
    public static void main(String[] args) {
        LocalDate data = LocalDate.now();
        System.out.println(data);

        LocalTime hora = LocalTime.now();
        System.out.println(hora);

        LocalDateTime dataHora = LocalDateTime.now();
        System.out.println(dataHora);

        //Formatação
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Data formatada: " + data.format(formatoData));

        //Calcular Datas
        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);

        System.out.println("Hoje: " + hoje.format(formatoData) );
        System.out.println("Amanhã: " + amanha.format(formatoData) );

        LocalTime horaAtual = LocalTime.now();
        LocalTime menosUmaHora = horaAtual.minusHours(1);
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("Hora atual: " + horaAtual.format(formatoHora));
        System.out.println("Menos 1h: " + menosUmaHora.format(formatoHora));

        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime futuro = agora.plusDays(5).minusHours(12).plusMinutes(5);
        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/YYYY - HH:mm:ss");

        System.out.println("Agora: " + agora.format(formatoDataHora));
        System.out.println("Futuro: " + futuro.format(formatoDataHora));

        //Comparar 
        if(agora.equals(futuro)){} //Coloca seus argumentos.

        //criar uma data especifica
        LocalDate minhaData = LocalDate.parse("06/03/2020", formatoData);
        System.out.println("Minha data: " + minhaData);
        System.out.println("Minha data Formatada: " + minhaData.format(formatoData));

    }
}
