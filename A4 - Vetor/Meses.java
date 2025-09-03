public class Meses {
    String meses[] = new String[12]; //declara um vetor de String com 12 posições
    

    public Meses(){ //metodo construtor Executado automaticamente sempre que se cria objeto da classe
        atribuirValores();
    }
    
        private void atribuirValores(){

        meses[0] = "Janeiro";
        meses[1] = "Fevereiro";
        meses[2] = "Março";
        meses[3] = "Abril";
        meses[4] = "Maio";
        meses[5] = "Junho";
        meses[6] = "Julho";
        meses[7] = "Agosto";
        meses[8] = "Setembro";
        meses[9] = "Outubro";
        meses[10] = "Novembro";
        meses[11] = "Dezembro";
    }

    public String pegarNomemMes(int num){
        if(num > 0 && num <= 12){
            return meses[num -1];
        
         }else{
            return "";
         } 
        }
    }

