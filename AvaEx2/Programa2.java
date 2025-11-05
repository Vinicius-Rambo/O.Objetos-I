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
                System.out.println("\n====== Menu ========");                      //é possivel tranformar toda essa
                System.out.println("[1] - Recarregar arquivo de entrada");       //parte em uma unica metodo "menu()"   
                System.out.println("[2] - Inserir item na base");                //e deixar no main apenas a chamada
                System.out.println("[3] - Mostrar produtos e preço de venda");   //dessa metodo.
                System.out.println("[4] - Gerar CSV com preço de venda"); 
                System.out.println("[5] - Gerar nova margem"); 
                System.out.println("[6] - Estoque:");                            
                System.out.println("[0] - Sair");
                System.out.print("Escolha sua opção: ");
                opcao = teclado.readLine();
                limparTela();//Apenas para fins esteticos

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


        // === metodos do Menu Principal ===//

        static void recarregarArquivo() throws Exception{ //Abre um novo arquivo para a entrada de valores.
            System.out.print("Novo arquivo de entrada (ou Enter para manter): ");
            String novo = teclado.readLine(); //Le a digitaçao

            if (!novo.equals("")){ //Se novo nao for vazio
                entrada = novo; //Entrada vira o novo.
            } 

            novaMargem(teclado);
            System.out.println("Arquivo atualizado: " + entrada);
            
            
        }

        static void inserirProduto() throws Exception {
            System.out.println("\n=== Novo Produto ===");
            System.out.print("Código: "); //Codigo do produto a ser adicionado
            String codigo = teclado.readLine();

            System.out.print("Estoque: "); //Estoque do produto a ser adicionado
            String estoque = teclado.readLine();

            System.out.print("Produto: "); //Produto a ser adicionado
            String nome = teclado.readLine();
            
            System.out.print("Preço de custo: ");  //Preço do produto a ser adicionado
            String custo = teclado.readLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter(entrada, true)); //Gera um Writer
            writer.write(codigo + ";" + estoque + ";" + nome + ";" + custo); //Coloca na linha os valores separados por ";"
            writer.newLine(); //Cria nova linha
            writer.close();
            System.out.println("Produto adicionado!");
            

        }

        static void mostrarProdutosVenda() throws Exception {
            String linha1; //Variavel local Linha4
            if (margem == 0) {
                novaMargem(teclado);
            }

            BufferedReader arq = new BufferedReader(new FileReader(entrada)); //Arq = arquivo da entrada.
            arq.readLine(); // pula cabeçalho da primeira linha

            System.out.println("\nCódigo | Produto | Preço de Venda");
            
            while ((linha1 = arq.readLine()) != null) { //Enquanto a linha 1 nao for nula
                String[] col = linha1.split(";"); //Separa os itens da linha pelo ";" e coloca em um array
                float custo = Float.parseFloat(col[3].replace(",", ".")); //No caso dos floats muda a "," por ".", por ser assim que o java le
                float venda = custo * (1 + margem / 100); //Valor deduzido da margem.
                System.out.println(col[0] + " | " + col[2] + " | " + String.format("%.2f", venda)); 
            }
            arq.close(); //Fecha o arquivo.
        }

        static void gerarCSVPrecoVenda() throws Exception {
            if (margem == 0) { novaMargem(teclado); }

            System.out.print("Nome do arquivo de saída: ");
            String saida = teclado.readLine() + ".csv";//Para gerar um .csv sempre

            BufferedReader arq = new BufferedReader(new FileReader(entrada));
            BufferedWriter out = new BufferedWriter(new FileWriter(saida));

            arq.readLine(); // pula cabeçalho
            out.write("codigo;produto;preco_venda");
            out.newLine();

            String linha;
            while ((linha = arq.readLine()) != null) {
                String[] col = linha.split(";");
                float custo7 = Float.parseFloat(col[3].replace(",", "."));
                float venda7 = custo7 * (1 + margem / 100);
                out.write(col[0] + ";" + col[2] + ";" + String.format("%.2f", venda7));
                out.newLine();
            }
            arq.close();
            out.close();
            System.out.println("Arquivo '" + saida + "' gerado com sucesso!");
            
        }

        public static void novaMargem(BufferedReader teclado) throws IOException { //Para criar uma margem de lucro
            System.out.print("Digite a margem de lucro (%): ");
            String entrada = teclado.readLine(); // lê o que o usuário digitou
            if (entrada.isEmpty()) { // se só apertou Enter a margem é nula
                margem = 0;
                System.out.println("Margem de lucro padrão de 10%");
            }else {
                margem = Float.parseFloat(entrada);
            }
        }

        // === Submenu Estoque ===
        static void menuEstoque() throws Exception { //Sub menu do estoque
        String opc;
        do {
           
            System.out.println("=== Estoque ====");
            System.out.println("[1] - Mostrar produtos com estoque < 10");
            System.out.println("[2] - Gerar CSV com estoque < 10");
            System.out.println("[3] - Mostrar produtos com preço de custo e estoque");
            System.out.println("[0] - Voltar ao Menu principal");
            System.out.print("Escolha sua opção: ");
            opc = teclado.readLine();
            limparTela();

            switch (opc) {
                case "1": mostrarEstoqueBaixo(); break;
                case "2": gerarCSVEstoqueBaixo(); break;
                case "3": mostrarProdutosCusto(); break;
                case "0": break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!opc.equals("0"));
    }

    //Metodos do SubMenu
    static void mostrarEstoqueBaixo() throws Exception {
        //limparTela();
        System.out.println("Produtos com estoque < 10:");
        BufferedReader arq = new BufferedReader(new FileReader(entrada)); //acessa o arquivo de entrada
        arq.readLine(); 
        String linha;
        while ((linha = arq.readLine()) != null) { //Enquanto a linha não for vazia
            String[] col = linha.split(";"); //separa as colunas das linhas separando pelo ";"
            int estoque = Integer.parseInt(col[1]); //coloca o valor da primeira coluna na variavel estoque como um inteiro.
            if (estoque < 10){ //apenas se o item no estoque for menor do que 10 é feito o print.
                System.out.println(col[0] + " | " + col[2] + " | Estoque: " + estoque);
            }
        }
    }

    static void gerarCSVEstoqueBaixo() throws Exception {
        System.out.println("Nome do arquivo de saída: ");
        String saida = teclado.readLine() + ".csv" ; //Captura a escrita do usuario já adicionando o ".csv"

        BufferedReader arq = new BufferedReader(new FileReader(entrada)); //Leitor do arquivo de entrada
        BufferedWriter out = new BufferedWriter(new FileWriter(saida)); //Escritor do arquivo de saida
        String linha = arq.readLine(); //Le a linha do arquivo de entrada e salva na string "Linha"
        out.write(linha);
        out.newLine();
        while ((linha = arq.readLine()) != null) {
            String[] col = linha.split(";");
            int estoque = Integer.parseInt(col[1]);
            if (estoque < 10) {
                out.write(linha);
                out.newLine();
            }
        }
        arq.close();
        out.close();
        System.out.println("Arquivo '" + saida + "' gerado!");
    }

    static void mostrarProdutosCusto() throws Exception {
        BufferedReader arq = new BufferedReader(new FileReader(entrada));
        arq.readLine();
        System.out.println("\nCódigo | Produto | Preço de Custo | Estoque");
        String linha;

        while ((linha = arq.readLine()) != null) {
            String[] col = linha.split(";");
            System.out.println(col[0] + " | " + col[2] + " | " + col[3] + " | " + col[1]);
        }

        arq.close();

    }
























}