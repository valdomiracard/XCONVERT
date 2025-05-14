import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

        public class ConversorDeMoeda {
        private static final String API_KEY = "fb073f4ddd56a5b9bcc60a4e";
        private final List<String> historico = new ArrayList<>();
        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public double converter(String de, String para, double valor) throws IOException, InterruptedException {
            String url = "https://v6.exchangerate-api.com/v6/" + "fb073f4ddd56a5b9bcc60a4e" + "/pair/" + de + "/" + para;
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

            if (!json.get("result").getAsString().equals("success")) {
                throw new RuntimeException("Erro ao converter moedas: " + json);
            }

            double taxa = json.get("conversion_rate").getAsDouble();
            double convertido = taxa * valor;
            String log = formatter.format(LocalDateTime.now()) + " - " + valor + " " + de + " = " + convertido + " " + para;

            historico.add(log);
            salvarLog(log);
            return convertido;
        }

        public void mostrarHistorico() {
            System.out.println("\nHistórico de Conversões:");
            historico.forEach(System.out::println);
        }

        private void salvarLog(String log) {
            try (FileWriter writer = new FileWriter("log_conversoes.txt", true)) {
                writer.write(log + "\n");
            } catch (IOException e) {
                System.out.println("Erro ao salvar log: " + e.getMessage());
            }
        }
    }

