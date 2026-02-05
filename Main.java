import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome da pessoa: ");
        String nome = entrada.nextLine();

        Pessoa p1 = new Pessoa(nome);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n--- Controlando: " + p1.getNome() + " ---");
            System.out.println("""
                    1. Acordar
                    2. Comer
                    3. Parar de comer
                    4. Dirigir
                    5. Parar de dirigir
                    6. Dormir
                    7. Visualizar Status
                    0. Sair do programa.
                    """);
            System.out.print("Escolha uma opção numérica referente a cada ação: ");

            int escolha = entrada.nextInt();
            entrada.nextLine();

            switch (escolha) {
                case 1 -> p1.acordar();
                case 2 -> p1.comer();
                case 3 -> p1.pararDeComer();
                case 4 -> p1.dirigir();
                case 5 -> p1.pararDeDirigir();
                case 6 -> p1.dormir();
                case 7 -> p1.visualizarPessoa();
                case 0 -> {
                    rodando = false;
                    System.out.println("Saindo...");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
        entrada.close();
    }
}