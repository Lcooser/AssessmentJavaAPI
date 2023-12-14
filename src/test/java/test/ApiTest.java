package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiTest {

    @Test
    public void testListarUsuariosEndpoint() throws IOException {
        URL url = new URL("http://localhost:4567/api/usuarios");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");
        ObjectMapper objectMapper = new ObjectMapper();
        int responseCode = conexao.getResponseCode();
        assertEquals(200,responseCode);
    }
}
