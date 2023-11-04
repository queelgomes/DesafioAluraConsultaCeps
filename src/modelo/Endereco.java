package modelo;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Endereco {


    // atributos
    private String cep;
    private String logradouro;
    private String bairro;
    @SerializedName("localidade") // na API esta com outro nome, entao aqui mudei para localizar certo
    private String cidade;
    private String uf;
    private String ddd;


    // getters
    public String getCep() {
        return cep;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getUf() {
        return uf;
    }
    public String getDdd() {
        return ddd;
    }

    // metodos
    public String salvarArquivo(){
        return String.format("Endereço: %s | CEP: %s | Bairro: %s | Cidade: %s | UF: %s", getLogradouro(), getCep(), getBairro(), getCidade(), getUf());
    }

    @Override
    public String toString() {
        return String.format("""
                
                CEP: %s
                Endereço: %s
                Bairro: %s | Cidade: %s | Estado: %s
                DDD da região: %s""", getCep(), getLogradouro(), getBairro(), getCidade(), getUf(),getDdd());
    }

}
