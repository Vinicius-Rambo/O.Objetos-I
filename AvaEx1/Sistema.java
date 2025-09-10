
import java.io.BufferedReader; //Biblioteca de buffer
import java.io.InputStreamReader; //Biblioteca de input de teclado

public class Sistema {
   BufferedReader reader;
   Companhia companhia;
   
   public static void main(String[] args) throws Exception{
        Sistema s = new Sistema(); //Criação do objeto s
        s.companhia = new Companhia(); // Companhia aérea vazia
        s.reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Nome da Companhia Aérea: "); 
        s.companhia.setNome(s.reader.readLine()); //Scanf do Java

        s.menu();
   }

   private void menu() throws Exception {
        String opcao = "";
        while(!opcao.equals("0")){
            System.out.println("\n - - Menu - - ");
            System.out.println("[1] Cadastrar Voo");
            System.out.println("[2] Listar Voos");
            System.out.println("[3] Consultar Voo");
            System.out.println("[4] Cadastrar Passageiro em um Voo");
            System.err.println("[0 Sair]");
            opcao = reader.readLine();
            
            switch(opcao){
                case "1": cadastrarVoo(); break;
                case "2": listarVoos(); break;
                case "3": consultarVoo(); break;
                case "4": cadastrarPassageiro(); break;
                default:  break;
            }
        }
    }
    private void cadastrarVoo() throws Exception{
        Voo v = new Voo(); 
        System.out.println("Número do Voo: ");
        v.setNumero(Integer.parseInt(reader.readLine()));

        System.out.println("Local do embarque: ");
        v.setLocalEmbarque(reader.readLine());

        System.out.println("Destino: ");
        v.setDestino(reader.readLine());

        companhia.addVoo(v);
        System.out.println("Voo cadastrado com sucesso!");
    }

    private void listarVoos(){
        System.out.println("\n - - - Lista de Voos - - -");
        for(int i= 0; i < companhia.getQtdVoos(); i++){
            Voo v = companhia.getVoo(i);
            System.out.println("Número: " + v.getNumero() + "| local de Embarque: " + v.getLocalEmbarque() + "| Destino: " + v.getDestino() + "| passageiros: " + v.getQtdPassageiros());   
        }
    }
    private void consultarVoo() throws Exception{
        System.out.println("Digite o número do voo: ");
        int numero = Integer.parseInt(reader.readLine());
        boolean achou = false;

        for(int i = 0; i<companhia.getQtdVoos(); i++){
            Voo v = companhia.getVoo(i);
            if(v.getNumero() == numero){ 
                 System.out.println("\n--- Detalhes do Voo ---");
                System.out.println("Número: " + v.getNumero());
                System.out.println("Local de Embarque: " + v.getLocalEmbarque());
                System.out.println("Destino: " + v.getDestino());
                System.out.println("Assentos livres: " + v.getAssentosLivres());
                System.out.println("Passageiros:");

                for(int j = 0; j < v.getQtdPassageiros(); j++){
                    Passageiro p = v.getPassageiro(j);
                    System.out.println("Nome: " + p.getNome() + " | CPF: " + p.getCpf());
                    System.out.println("Passaporte" + p.getNumPassaporte());
                    System.out.println("Idade: " + p.getIdade() + " | Telefone: " + p.getTelefone());
                    System.out.println("Endereço: " + p.getEndereco());
                    System.out.println("Peso Bagagem: " + p.getPeso() + "kg | Assento: " + p.getAssento());
                    System.out.println("--------------------------------------------------"); 

                achou = true;
                break;
            }
        }
        if(!achou){ System.out.println("Voo não foi achado."); }
    }

    private void cadastrarPassageiro() throws Exception {
        System.out.println("Digite o número do voo: ");
        int numero = Integer.parseInt(reader.readLine());
        boolean achou = false;

        for(int i = 0; i < companhia.getQtdVoos(); i++){
            Voo v = companhia.getVoo(i);

            if(v.getNumero() == numero){
                Passageiro p = new Passageiro();

                System.out.println("Nome: ");
                p.setNome(reader.readLine());

                System.out.println("CPF: ");
                p.setCpf(reader.readLine());

                System.out.println("Passaporte: ");
                p.setNumPassaporte(reader.readLine());

                System.out.println("Endereço: ");
                p.setEndereco(reader.readLine());

                System.out.println("Idade: ");
                p.setIdade(Integer.parseInt(reader.readLine()));

                System.out.println("Telefone: ");
                p.setTelefone((reader.readLine()));

                System.out.println("Peso(kg): ");
                p.setPeso(Integer.parseInt(reader.readLine()));

                System.out.println("Número do Assento: ");
                p.setAssento(reader.readLine());

                v.addPassageiro(p);
                System.out.println("Passageiro cadastrado com sucesso");
                achou = true;
                break;
            }
        }
        if(!achou){
            System.out.println("Voo não encontrado");
        }
    }

}
