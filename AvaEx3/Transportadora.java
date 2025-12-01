import java.io.BufferedReader;
import java.io.FileReader;

public class Transportadora implements ImportacaoArquivos {

    // Vetores para armazenar até 100 encomendas de cada tipo, foi feito um vetor de objetos
    private EncomendaNormal[] normais = new EncomendaNormal[100];
    private EncomendaExpressa[] expressas = new EncomendaExpressa[100];

    // Contadores de posição dos vetores
    private int indiceNormal = 0;
    private int indiceExpressa = 0;

    // Preços carregados do arquivo de configuração, variando com o tipo de Encomenda normal ou Expressa
    private double precoNormalKg;
    private double precoExpressoKg;

    @Override
    public void carregarConfiguracoes(String arquivo) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("Dados/" + arquivo));
        br.readLine(); // pula cabeçalho

        String linha;  //Declaração de cada linha
        while ((linha = br.readLine()) != null) { //Enquanto a linha não for vazia

            String[] col = linha.split(";"); //Separa as colunas da linha por ";"
            String tipo = col[0]; //Tipo está de entrega está na primeira coluna
            double preco = Double.parseDouble(col[2]); // preço por kg

            if (tipo.equals("Normal")) {
                precoNormalKg = preco;

            } else if (tipo.equals("Expressa")) { //Poderia ser apenas um Else, mas serve como expansão.
                precoExpressoKg = preco;

            }else{ //Caso não seja Normal nem Expresso, o que abre margem para novos tipos de Entrega como Premium etc...
                System.out.println("Tipo de Entrega não cadastrado!");
            }
        }

        br.close();
        System.out.println("Configurações carregadas.\n");
    }

    @Override
    public void importarDados(String arquivo) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Dados/" + arquivo));
        br.readLine(); // Pula cabeçalho

        String linha;
        while ((linha = br.readLine()) != null) {

            //if (linha.trim().equals("")) continue; // ignora linha vazia

            String[] col = linha.split(";", -1); // "-1" mantém colunas vazias, impede erro quando o CSV tem ;;

            int numero = Integer.parseInt(col[0]);
            String data = col[1];
            String tipo = col[2];

            String prazoTxt = "";
            if (col.length > 3) {
                prazoTxt = col[3];
            }

            double peso = Double.parseDouble(col[4]);

            String telefone = "";
            if (col.length > 5) {
                telefone = col[5];
            }

            // Encomenda Normal (EN)
            if (tipo.equals("EN")) {
                EncomendaNormal n = new EncomendaNormal(numero, data, peso, precoNormalKg);
                normais[indiceNormal] = n;
                indiceNormal++; // avança a posição

            }
            // Encomenda Expressa (EE)
            else if (tipo.equals("EE")) {
                int prazo = prazoTxt.equals("") ? 0 : Integer.parseInt(prazoTxt); //Operador Ternario, para evitar o If-Else

                EncomendaExpressa e = new EncomendaExpressa( numero, data, peso, precoExpressoKg, prazo, telefone);
                expressas[indiceExpressa] = e;
                indiceExpressa++; // avança
            }
        }

        br.close();
        System.out.println("Arquivo importado.\n");
    }

    // Lista Normais
    public void listarNormais() {
        if (indiceNormal == 0) {
            System.out.println("Nenhuma encomenda normal carregada.\n");
            return;
        }else{

            System.out.println("\n=== ENCOMENDAS NORMAIS ===");

            // Cabeçalho formatado
            System.out.printf("%10s | %12s | %10s%n", "Nro Pedido", "Peso (KG)", "Frete");

            // Cada linha formatada com printf
            for (int i = 0; i < indiceNormal; i++) {
            EncomendaNormal n = normais[i];
            System.out.printf("%10d | %12.2f | R$ %8.2f%n",n.getNumeroPedido(), n.getPeso(), n.calcularFrete());
        }

        System.out.println();
        }
    }

    // Lista Expressas
    public void listarExpressas() {

        if (indiceExpressa == 0) {
            System.out.println("Nenhuma encomenda expressa carregada.\n");
            return;
        }else{

            System.out.println("\n=== ENCOMENDAS EXPRESSAS ===");

            // Cabeçalho
            System.out.printf("%10s | %12s | %10s | %8s | %15s%n","Nro Pedido", "Peso (KG)", "Frete", "Prazo", "Telefone");

            // Linhas formatadas
            for (int i = 0; i < indiceExpressa; i++) {
                EncomendaExpressa e = expressas[i];

                System.out.printf("%10d | %12.2f | R$ %8.2f | %8d | %-15s%n",
                    e.getNumeroPedido(),
                    e.getPeso(),
                    e.calcularFrete(),
                    e.getPrazoEntrega(),
                    e.getTelefone()
                );
            }

            System.out.println();
        }
    }
}