public class StringE {
    public static void main(String[] args) {
        String str1, str2, stre3;
        str1 = " Um texto qualquer ...      ";
        System.out.println("[" + str1 + "]"); // Impressão com espaços do str1 no final e inicio;

        str1 = str1.trim(); // retira os espaços
        System.out.println("[" + str1 + "]"); // Sem os espaços desnecessarios.

        System.out.println("tamanho do Str1: " + str1.length());

        //Substitur um substring dentro de um String
        str2 = str1.replace("texto", "teste");
        System.out.println("[" + str2 + "]");

        str2 = str2.replace("t", "P");
        System.out.println("[" + str2 + "]");

        //Extrair um substring
        str2 = str1.substring(6,10); // 6 inclusive, 10 exclusive
        System.out.println("[" + str2 + "]");

        //Procurar substring
        str1 = "humberto.beneduzzi@ifpr.edu.br";
        int posicao = str1.indexOf("@");
        System.out.println("@ está na posição " + posicao);
        System.out.println("Usuario: " + str1.substring(0, str1.indexOf("@")));

        String dominio = str1.substring(str1.indexOf("@") + 1, str1.length());
        System.out.println("Dominio: " + dominio.toUpperCase()); //toUpperCase deixa em maiusculo.

        //converter de outros tipos para string
        int valor = 5;
        stre3 = String.valueOf(valor); // Conversor universal de numero para string.
        System.out.println("str3: " + stre3);

        //quebrar um String em vetor
        String valores = "4/7/22/7/0/5";
        String[] arrayValores = valores.split("/");
        //System.out.println("arrayValores[1] = " + arrayValores[1] );

        //percora o vetor arrayValores mostrando todos os itens na tela.

            for(int i = 0; i < arrayValores.length; i++){
                System.out.println("O valor: " + arrayValores[i]);
            }

    }
}
