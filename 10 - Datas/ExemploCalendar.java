import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ExemploCalendar {
    public static void main(String[] args) {
        Calendar agora = Calendar.getInstance();
        //System.out.println("Agora: " + agora);

        Calendar vencimento = agora;
        vencimento.add(Calendar.DATE, 7);

        //Formatações tops
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println("Ano: " + gc.get(Calendar.YEAR));
        System.out.println("Mês: " + gc.get(Calendar.MONTH));
        System.out.println("Dia do mês: " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println("Dia da semana: " + gc.get(Calendar.DAY_OF_WEEK));
        System.out.println("Dia do ano: " + gc.get(Calendar.DAY_OF_YEAR));
        System.out.println("Semana do mês: " + gc.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Semana do semana no mês: " + gc.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println("Hora: " + gc.get(Calendar.HOUR));
        System.out.println("AM/PM: " + gc.get(Calendar.AM_PM));
        System.out.println("Hora do dia: " + gc.get(Calendar.HOUR_OF_DAY));
        System.out.println("Minuto: " + gc.get(Calendar.MINUTE));
        System.out.println("Segundo: " + gc.get(Calendar.SECOND));

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data abreviada: " + df.format(gc.getTime()));

        System.out.println("Vencimento: " + vencimento.getTime());
        System.out.println("Vencimento formatado: " + df.format(vencimento.getTime()));

        //Criar uma data especifica
        System.out.println("Criando uma data especifica");
        GregorianCalendar dtNasc = new GregorianCalendar();
        dtNasc.set(1977, Calendar.OCTOBER, 20);
        System.out.println("Aniversario: " + df.format(dtNasc.getTime()));

        System.out.println("Criando uma data a partir de um String");
        String dataString = "03/03/2007";
        String[] vetDataStrings = dataString.split("/");
        dtNasc.set(Calendar.YEAR, Integer.parseInt(vetDataStrings[2]));
        dtNasc.set(Calendar.MONTH, Integer.parseInt(vetDataStrings[1]) - 1);
        dtNasc.set(Calendar.DAY_OF_MONTH, Integer.parseInt(vetDataStrings[0]));
        System.out.println("Nova data: " + df.format(dtNasc.getTime()));
    }
}
