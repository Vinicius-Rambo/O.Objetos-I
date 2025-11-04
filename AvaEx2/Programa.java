import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Programa {
    public static void main(String[] args) throws Exception {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

        String entrada = "preco_custo.csv";
        float margem = 0;
        String opcao = "";

        while (!opcao.equals("0")) {
            System.out.println("\n===== MENU =====");
            System.out.println("[1] - Mostrar produtos e preço de venda");
            System.out.println("[2] - Mostrar produtos com preço de custo e estoque");
            System.out.println("[3] - Recarregar arquivo de entrada");
            System.out.println("[4] - Mostrar produtos com estoque < 10");
            System.out.println("[5] - Gerar CSV com estoque < 10");
            System.out.println("[6] - Inserir item na base");
            System.out.println("[7] - Gerar CSV com preço de venda");
            System.out.println("[0] - Sair");
            System.out.print("Escolha: ");
            opcao = teclado.readLine();

            switch (opcao) {
                case "1":
                    if (margem == 0) {
                        System.out.print("Digite a margem de lucro (%): ");
                        margem = Float.parseFloat(teclado.readLine());
                    }
                    BufferedReader arq1 = new BufferedReader(new FileReader(entrada));
                    arq1.readLine(); // pula cabeçalho
                    System.out.println("\nCódigo | Produto | Preço de Venda");
                    String linha1;
                    while ((linha1 = arq1.readLine()) != null) {
                        String[] col = linha1.split(";");
                        float custo = Float.parseFloat(col[3].replace(",", "."));
                        float venda = custo * (1 + margem / 100);
                        System.out.println(col[0] + " | " + col[2] + " | " + String.format("%.2f", venda));
                    }
                    arq1.close();
                    break;

                case "2":
                    BufferedReader arq2 = new BufferedReader(new FileReader(entrada));
                    arq2.readLine();
                    System.out.println("\nCódigo | Produto | Preço de Custo | Estoque");
                    String linha2;
                    while ((linha2 = arq2.readLine()) != null) {
                        String[] col = linha2.split(";");
                        System.out.println(col[0] + " | " + col[2] + " | " + col[3] + " | " + col[1]);
                    }
                    arq2.close();
                    break;

                case "3":
                    System.out.print("Novo arquivo de entrada (ou Enter para manter): ");
                    String novo = teclado.readLine();
                    if (!novo.equals("")) entrada = novo;
                    margem = 0;
                    System.out.println("Arquivo atualizado: " + entrada);
                    break;

                case "4":
                    BufferedReader arq4 = new BufferedReader(new FileReader(entrada));
                    arq4.readLine();
                    System.out.println("\nProdutos com estoque menor que 10:");
                    String linha4;
                    while ((linha4 = arq4.readLine()) != null) {
                        String[] col = linha4.split(";");
                        int estoque = Integer.parseInt(col[1]);
                        if (estoque < 10) {
                            System.out.println(col[0] + " | " + col[2] + " | Estoque: " + estoque);
                        }
                    }
                    arq4.close();
                    break;

                case "5":
                    System.out.print("Nome do arquivo de saída: ");
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
                    break;

                case "6":
                    System.out.println("\n=== Novo Produto ===");
                    System.out.print("Código: ");
                    String codigo = teclado.readLine();

                    System.out.print("Estoque: ");
                    String estoque = teclado.readLine();

                    System.out.print("Produto: ");
                    String nome = teclado.readLine();

                    System.out.print("Preço de custo: ");
                    String custo = teclado.readLine();

                    BufferedWriter writer = new BufferedWriter(new FileWriter(entrada, true));
                    writer.write(codigo + ";" + estoque + ";" + nome + ";" + custo);
                    writer.newLine();
                    writer.close();
                    System.out.println("Produto adicionado!");
                    break;

                case "7":
                    if (margem == 0) {
                        System.out.print("Digite a margem de lucro (%): ");
                        margem = Float.parseFloat(teclado.readLine());
                    }
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
                    break;

                case "0":
                    System.out.println("Bye...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        teclado.close();
    }
}
