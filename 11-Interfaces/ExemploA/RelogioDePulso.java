package ExemploA;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RelogioDePulso implements Relogio{
    
    public String getHoras() {
        //LocalTime horaAtual = LocalTime.now();
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        //return horaAtual.format(dtf);

        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")); //Forma compacta em apenas uma unica linha 
    }

    public String iniciarCronometro(){
        return "Iniciando cronômetro...";
    }
}

