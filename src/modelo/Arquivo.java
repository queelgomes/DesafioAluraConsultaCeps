package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public void salvarArquivo(Endereco endereco) throws IOException, InterruptedException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escreverArquivo = new FileWriter("endereçosSalvos.json", true);

        escreverArquivo.write( gson.toJson(endereco));
        escreverArquivo.close();

    }
}
