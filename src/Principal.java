import java.util.Scanner;

    public class Principal {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            ConversorDeMoeda conversor = new ConversorDeMoeda();

            while (true) {
                System.out.println("\n===== CONVERSOR DE MOEDAS =====");
                System.out.println("1. Converter moedas");
                System.out.println("2. Ver histórico de conversões");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite a moeda de origem (ex: USD): ");
                        String de = scanner.nextLine().toUpperCase();
                        System.out.print("Digite a moeda de destino (ex: BRL): ");
                        String para = scanner.nextLine().toUpperCase();
                        System.out.print("Digite o valor: ");
                        double valor = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            double resultado = conversor.converter(de, para, valor);
                            System.out.printf("\nResultado: %.2f %s = %.2f %s\n", valor, de, resultado, para);
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        break;
                    case 2:
                        conversor.mostrarHistorico();
                        break;
                    case 3:
                        System.out.println("Encerrando...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }
    }
