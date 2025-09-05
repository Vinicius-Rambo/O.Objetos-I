import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Atv {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 
        
        int[] vetorA = new int[4];
        String[] vetorB = new String[4];

        // Leitura dos inteiros
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite o " + i + "º valor: ");
            vetorA[i] = Integer.parseInt(reader.readLine()); //Lê uma linha do teclado, converte a string digitada em número inteiro
        }

        // Leitura das strings
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a " + i + "ª string: ");
            vetorB[i] = reader.readLine(); //Lê a linha do teclado.
        }

        // Impressão do resultado
        System.out.println("\nResultado:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < vetorA[i]; j++) {
                System.out.println(vetorB[i] + " [" + i + "] [" + j + "]");
            }
            System.out.println(); // Linha em branco entre os grupos
        }
    }
}
