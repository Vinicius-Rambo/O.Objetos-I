import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExemploVet2 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        
        int num = -1;
        Meses meses = new Meses();
        while (num != 0){
            System.out.println("Informe o número do mês ou 0 para sair");
            num = Integer.parseInt(reader.readLine()); //entrada do usuario
            String mes = meses.pegarNomemMes(num);

            if(!mes.equals("")){
                System.out.println("O mês é " + mes);
            }else if (num != 0){
                System.out.println("Entrada invalida");
            }else {
                System.out.println("Fechando......");
            }
        }     
    }
}
