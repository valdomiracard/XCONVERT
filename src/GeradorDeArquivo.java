import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class GeradorDeArquivo {
        private static final String NOME_ARQUIVO = "log_conversoes.txt";

        public void registrarConversao(String moedaOrigem, String moedaDestino, double valor, double resultado) {
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            String linha = String.format("[%s] %s -> %s | Valor: %.2f | Resultado: %.2f",
                    timestamp, moedaOrigem, moedaDestino, valor, resultado);

            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
                escritor.write(linha);
                escritor.newLine();
            } catch (IOException e) {
                System.out.println("Erro ao salvar histórico de conversões: " + e.getMessage());
            }
        }
    }


