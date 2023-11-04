package modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscadorEndereco {

    public Endereco pesquisaCep(String cep) throws IOException, InterruptedException {
        URI url = URI.create("http://viacep.com.br/ws/" + cep + "/json");

        //esse modelo abaixo foi pego na documentacao do Java.
        HttpClient client = HttpClient.newHttpClient(); //quem esta solicitando algo
        HttpRequest request = HttpRequest.newBuilder() //quem esta devolvendo algo solicitado
                .uri(url)
                .build();
        HttpResponse<String> response = client //aqui é a resposta final da solicitacao
                .send(request, HttpResponse.BodyHandlers.ofString());   //esse send obriga lançar
        // exceções que sera tratadas pelo sistema

        String json = response.body(); //aqui body do json solicitado em texto

        Gson gson = new Gson();

        return gson.fromJson(json, Endereco.class);
        // para transformar esse json em um objeto java, pode usar a biblioteca GSON,
        // mas existe outras: https://mvnrepository.com
        // busca por gson >> versao >> files: jar **
        // no intellij >> File >> Project Structure >> Modules >> + >> JARs or Directories >> Seleciona o arquivo.

    }



}
