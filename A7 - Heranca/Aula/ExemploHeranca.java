package Aula;
public class ExemploHeranca {
   public static void main(String[] args) {
    
      // Forma 1 mais linhas, mais seguro
      Pessoa p1 = new Pessoa();
      p1.setNome("João");
      p1.setEmail("Joaozinho@gmail.com");
      p1.setIdade(28);
      System.out.println("Nome da pessoa 1: " + p1.getNome());    

      //Forma 2, mais destrutivo, menos linhas
      Pessoa p2 = new Pessoa("Marcos" , "marcos@ifpr.edu.br", 19);
      System.out.println("Nome da pessoa 2: " + p2.getNome());
      
      //Usando herança para aluno de pessoa
      Aluno a1 = new Aluno();
      a1.setNome("Márcia");
      a1.setNota1(89);

      System.out.println("Aluna 1: " + a1.getNome() + " - nota 1: " + a1.getNota1());

      Aluno a2 = new Aluno(86f, 56f, 88.5f, 77f, "Fernanda", "Fernandinha@gmail.com", 42);
      System.out.println("Aluna 2: " + a2.getNome() + " - nota1 = " + a2.getNota1());
   } 
}
