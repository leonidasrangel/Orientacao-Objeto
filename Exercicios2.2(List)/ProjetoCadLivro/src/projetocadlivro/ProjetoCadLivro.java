package projetocadlivro;
import classes.Livro;
import java.util.Scanner;
import classes.Biblioteca;
import java.util.List;


public class ProjetoCadLivro {

    public static int printMenu() {
        
        Scanner reader = new Scanner(System.in);
        
        System.out.println("-----------------------------------");
        System.out.println("1 - Insert book");
        System.out.println("2 - Search Book (Title)");
        System.out.println("3 - Search Book (Author)"); 
        System.out.println("4 - List all books"); 
        System.out.println("5 - Remove books by title"); 
        System.out.println("6 - Remove books by author"); 
        System.out.println("0 - Quit");
        System.out.println("-----------------------------------");
        System.out.print("Choose an option: ");
        
        int opcao = reader.nextInt();
        reader.nextLine(); // Consumir newline left-over
        return opcao;
        
    }
    public static void main(String[] args) {
        
        Biblioteca biblioteca = new Biblioteca();
        Scanner reader = new Scanner(System.in);
        int option;
        
        do{
        option = printMenu();
        switch (option) {
                case 1: {
                    Livro novoLivro = new Livro();
                    novoLivro.preencher();
                    biblioteca.adicionarLivro(novoLivro);
                    break;
                }
                case 2: {
                    System.out.println("Enter the title of the book to search for:");
                    String titulo = reader.nextLine();
                    
                    Livro livro = biblioteca.pesquisarLivroPorTitulo(titulo);
                    if (livro != null) {
                        livro.imprimir();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the name of the author to search for:");
                    String autor = reader.nextLine();

                    List<Livro> livrosAutor = biblioteca.pesquisarLivrosPorAutor(autor);
                    if (livrosAutor.isEmpty()) {
                        System.out.println("No books found for this author.");
                    } else {
                        for (Livro Ll : livrosAutor) {
                        Ll.imprimir();
                    }
                }
                    break;
                }
                case 4: {
                    System.out.println("Registered books:");
                    biblioteca.imprimirTodosLivros();
                    break;
                }

                case 5: {
                    System.out.println("Enter the title of the book to remove:");
                    String titulo = reader.nextLine();
                    
                    if (biblioteca.removerLivroTitulo(titulo)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter the title of the book to remove:");
                    String author = reader.nextLine();
                    
                    if (biblioteca.removerLivroPorAutor(author)) {
                        System.out.println("Book removed successfully.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                }
}
        }while(option != 0);
    }
}
