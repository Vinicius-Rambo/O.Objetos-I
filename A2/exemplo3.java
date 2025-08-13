public class exemplo3 {
    public static void main(String args[]){
        String cliente = "Humberto";
        
        Pet pet1 = new Pet(); // instancia um objeto da classe pet
        pet1.especie = "Gato";
        pet1.nome = "Calvin";
        pet1.idade = 14;


        System.out.println("O cliente é " + cliente + " possui um pet chamado " + pet1.nome + " que é " + pet1.especie + " e tem " 
        + pet1.idade + " anos");

        Pet pet2 = new Pet();
        pet2.especie = "Cão";
        pet2.nome = "Clayson";
        pet2.idade = 20;
    }
}
