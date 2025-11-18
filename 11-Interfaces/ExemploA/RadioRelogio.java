package ExemploA;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class RadioRelogio implements Radio, Relogio{
    
    public String ligar(){
        return "Radio Ligado";
    }

    public String desligar(){
        return "Radio desligado";
    }

    public String trocarEstacao(float estacao){
        return "Mudando estação para " + estacao;
    }

    public String getHoras(){
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")); //Forma compacta em apenas uma unica linha 
    }

}
