import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programa2 {
        static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in)); //buffer de teclado
        static String entrada = "preco_custo.csv"; //Arquivo de entrada padrao 
        static float margem = 0; //Inicialização da margem de lucro

        public static void main(String[] args) throws Exception {
            String opcao; //Escolha de opçao do Menu.
            do {
                limparTela(); //Apenas para fins esteticos
                System.out.println("====== Menu ========");                      //é possivel tranformar toda essa
                System.out.println("[1] - Recarregar arquivo de entrada");       //parte em uma unica funçao "menu()"   
                System.out.println("[2] - Inserir item na base");                //e deixar no main apenas a chamada
                System.out.println("[3] - Mostrar produtos e preço de venda");   //dessa função.
                System.out.println("[4] - Gerar CSV com preço de venda"); 
                System.out.println("[5] - Gerar nova margem"); 
                System.out.println("[6] - Estoque:");                            
                System.out.println("[0] - Sair");
                System.out.print("Escolha sua opção: ");
                opcao = teclado.readLine();

                switch (opcao) { //Executa as funçoes e retorna ao menu
                    case "1": recarregarArquivo(); break;
                    case "2": inserirProduto(); break;
                    case "3": mostrarProdutosVenda(); break;
                    case "4": gerarCSVPrecoVenda(); break;
                    case "5": novaMargem(teclado); break;
                    case "6": menuEstoque(); break;
                    case "0": System.out.println("Bye..."); break;
                    default:
                        System.out.println("Opção inválida!");
                        pausar();
                        break;
                }

            } while (!opcao.equals("0")); //Se for igual ao 0 fecha o laço do menu.
        }

        // === Metodos auxiliares ===
        static void limparTela() {
            try {
                new ProcessBuilder("clear").inheritIO().start().waitFor(); //Limpa o terminal
            }
            catch (Exception e) {                          //Se não conseguir dá um expaçamento de 40 linhas
                System.out.println("\n".repeat(40)); //fiz isso pois estou programando no Windows.
            }
        }

        static void pausar() throws IOException { //Apenas para quando o usuario digitar algo esperar.
            System.out.println("\nPressione ENTER para continuar...");
            teclado.readLine();
        } 

        // === Funções do Menu Principal ===//

        static void recarregarArquivo() throws Exception{ //Abre um novo arquivo para a entrada de valores.
            System.out.print("Novo arquivo de entrada (ou Enter para manter): ");
            String novo = teclado.readLine(); //Le a digitaçao

            if (!novo.equals("")){ //Se novo nao for vazio
                entrada = novo; //Entrada vira o novo.
            } 

            novaMargem(teclado);
            System.out.println("Arquivo atualizado: " + entrada);
            pausar();
            
        }

        static void inserirProduto() throws Exception {
            System.out.println("\n=== Novo Produto ===");
            System.out.print("Código: "); //Codigo do produto a ser adicionado
            String codigo = teclado.readLine();

            System.out.print("Estoque: "); //Estoque do produto a ser adicionado
            String estoque = teclado.readLine();

            System.out.print("Produto: "); //Produto do produto a ser adicionado
            String nome = teclado.readLine();
            
            System.out.print("Preço de custo: ");  //Preço do produto a ser adicionado
            String custo = teclado.readLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter(entrada, true)); //Gera um Writer
            writer.write(codigo + ";" + estoque + ";" + nome + ";" + custo); //Coloca na linha os valores separados por ";"
            writer.newLine(); //Cria nova linha
            writer.close();
            System.out.println("Produto adicionado!");
            pausar();

        }

        static void mostrarProdutosVenda() throws Exception {
            String linha1; //Variavel local Linha1
            if (margem == 0) {
                novaMargem(teclado);
            }
            BufferedReader arq1 = new BufferedReader(new FileReader(entrada));
            arq1.readLine(); // pula cabeçalho da primeira linha

            System.out.println("\nCódigo | Produto | Preço de Venda");
            
            while ((linha1 = arq1.readLine()) != null) { //Enquanto a linha 1 nao for nula
                String[] col = linha1.split(";"); //Separa os itens da linha pelo ";" e coloca em um array
                float custo = Float.parseFloat(col[3].replace(",", ".")); //No caso dos floats muda a "," por ".", por ser assim que o java le
                float venda = custo * (1 + margem / 100); //Valor deduzido da margem.
                System.out.println(col[0] + " | " + col[2] + " | " + String.format("%.2f", venda)); 
            }
            arq1.close(); //Fecha o arquivo.
        }

        static void gerarCSVPrecoVenda() throws Exception {
            if (margem == 0) { novaMargem(teclado); }

            System.out.print("Nome do arquivo de saída: ");
            String saida7 = teclado.readLine();

            BufferedReader arq7 = new BufferedReader(new FileReader(entrada));
            BufferedWriter out7 = new BufferedWriter(new FileWriter(saida7));

            arq7.readLine(); // pula cabeçalho
            out7.write("codigo;produto;preco_venda");
            out7.newLine();

            String linha7;
            while ((linha7 = arq7.readLine()) != null) {
            String[] col = linha7.split(";");
            float custo7 = Float.parseFloat(col[3].replace(",", "."));
            float venda7 = custo7 * (1 + margem / 100);
            out7.write(col[0] + ";" + col[2] + ";" + String.format("%.2f", venda7));
            out7.newLine();
            }
            arq7.close();
            out7.close();
            System.out.println("Arquivo '" + saida7 + "' gerado com sucesso!");
            
        }

        public static void novaMargem(BufferedReader teclado) throws IOException {
            System.out.print("Digite a margem de lucro (%): ");
            margem = Float.parseFloat(teclado.readLine()); //Define o valor da margem ao digitado.
            pausar();
        }

        // === Submenu Estoque ===
        static void menuEstoque() throws Exception {
        String opc;
        do {
            limparTela();
            System.out.println("=== Estoque ====");
            System.out.println("[1] - Mostrar produtos com estoque < 10");
            System.out.println("[2] - Gerar CSV com estoque < 10");
            System.out.println("[3] - Mostrar produtos com preço de custo e estoque");
            System.out.println("[0] - Voltar ao Menu principal");
            System.out.print("Escolha sua opção: ");
            opc = teclado.readLine();

            switch (opc) {
                case "1": mostrarEstoqueBaixo(); break;
                case "2": gerarCSVEstoqueBaixo(); break;
                case "3": mostrarProdutosCusto(); break;
                case "0": break;
                default:
                    System.out.println("Opção inválida!");
                    pausar();
                    break;
            }
        } while (!opc.equals("0"));
    }

    //Metodos do SubMenu
    static void mostrarEstoqueBaixo() throws Exception {
        limparTela();
        System.out.println("Produtos com estoque < 10:");
        try (BufferedReader arq = new BufferedReader(new FileReader(entrada))) {
            arq.readLine();
            String linha;
            while ((linha = arq.readLine()) != null) {
                String[] col = linha.split(";");
                int estoque = Integer.parseInt(col[1]);
                if (estoque < 10)
                    System.out.println(col[0] + " | " + col[2] + " | Estoque: " + estoque);
            }
        }
        pausar();
    }

    static void gerarCSVEstoqueBaixo() throws Exception {
        System.out.println("Nome do arquivo de saída: ");
        String saida5 = teclado.readLine();
        BufferedReader arq5 = new BufferedReader(new FileReader(entrada));
        BufferedWriter out5 = new BufferedWriter(new FileWriter(saida5));
        String linha5 = arq5.readLine();
        out5.write(linha5);
        out5.newLine();
        while ((linha5 = arq5.readLine()) != null) {
            String[] col = linha5.split(";");
            int estoque = Integer.parseInt(col[1]);
            if (estoque < 10) {
                out5.write(linha5);
                out5.newLine();
            }
        }
        arq5.close();
        out5.close();
        System.out.println("Arquivo '" + saida5 + "' gerado!");
    }

    static void mostrarProdutosCusto() throws Exception {
        BufferedReader arq2 = new BufferedReader(new FileReader(entrada));
        arq2.readLine();
        System.out.println("\nCódigo | Produto | Preço de Custo | Estoque");
        String linha2;
        
        while ((linha2 = arq2.readLine()) != null) {
            String[] col = linha2.split(";");
            System.out.println(col[0] + " | " + col[2] + " | " + col[3] + " | " + col[1]);
        }

        arq2.close();

    }
























}