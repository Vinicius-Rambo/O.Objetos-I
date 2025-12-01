import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProgramaTransportadora {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        Transportadora transp = new Transportadora();
        System.out.println("Arquivo de configuração: ");
        String arqConfig = teclado.readLine();

        transp.carregarConfiguracoes(arqConfig);
        String opcao;
        do{
            System.out.println("===== MENU =====");
            System.out.println("[1] - Importar arquivo de encomendas");
            System.out.println("[2] - Listar encomendas normais");
            System.out.println("[3] - Listar encomendas expressas");
            System.out.println("[0] - Sair");
            System.out.print("Opção: ");
            opcao = teclado.readLine();

            limparTela();
            
            switch (opcao) {
                case "1":
                    System.out.println("Arquivo de dados:");
                    String arqDados = teclado.readLine();
                    transp.importarDados(arqDados);
                    break;
                
                case "2":
                    transp.listarNormais();
                    break;
                
                case "3":
                    transp.listarExpressas();
                    break;

                case "0":
                    System.out.println("Bye....");
                    break;

                default:
                    System.out.println("Opção invalida!");
            }

        }while (!opcao.equals("0"));
    }
    static void limparTela() {
        try { //Tenta limpar a tela 
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) { //Se não conseguir repete o \n 40 vezes.
            System.out.println("\n".repeat(40));
        } //Fiz dessa forma pois estou programando no Windows.
    }
}

