package principal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.BuscadorEndereco;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n||||||    SISTEMA DE CONSULTA CEP    ||||||\n");
        System.out.print("> Digite o CEP ou 999 para sair: ");
        String cep = scanner.next();

        List<String> enderecosRegistrados = new ArrayList<>();

        String validacao = "";
        while(!cep.isEmpty()){
            try{
                BuscadorEndereco buscarEndereco = new BuscadorEndereco();

                if (validacao.isEmpty()){
                    System.out.println(buscarEndereco.pesquisaCep(cep));
                }
                String menu = """
                        
                          [ 1 ] - Salvar endereço pesquisado
                          [ 2 ] - Fazer nova busca
                          [ 3 ] - Gerar arquivo dos endereços salvos
                          [ 4 ] - Sair
                        
                        Opção desejada:\s""";

                System.out.println(menu);

                int navegacao = scanner.nextInt();
                while(true){
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    if (navegacao == 1){
                        enderecosRegistrados.add(gson.toJson(buscarEndereco.pesquisaCep(cep)));

                        System.out.println("Pesquisa salva com sucesso!");
                        System.out.print("""
                                  [ 2 ] - Fazer nova busca
                                  [ 3 ] - Para gerar arquivo dos endereços salvos
                                  [ 4 ] - Sair
                                Opção desejada:\s""");
                        navegacao = scanner.nextInt();
                        validacao = "menu";
                    } else if (navegacao == 2){
                        System.out.print("> Digite o CEP: ");
                        validacao = "menu";
                        cep = scanner.next();
                        System.out.println(buscarEndereco.pesquisaCep(cep));
                        break;
                    } else if (navegacao == 3) {
                        FileWriter fw = new FileWriter("endereçosSalvos.json", false);
                        fw.write("[");
                        for (String enderecos: enderecosRegistrados ) {
                            if(enderecosRegistrados.get(enderecosRegistrados.size()-1) == enderecos){
                                fw.write(enderecos);
                            }else{
                                fw.write(enderecos + ",");
                            }
                        }
                        fw.write("]");
                        fw.close();
                        break;
                    } else if (navegacao == 4){
                        break;
                    } else if (navegacao != 1 || navegacao != 2 || navegacao != 3 || navegacao != 4){
                        System.out.println("Valor inválido, digite novamente: ");
                        navegacao = scanner.nextInt();
                    }
                }
                if (navegacao == 4) break;

            } catch (RuntimeException e){
                System.out.print("\n> Cep inválido, digite novamente: ");
                cep = scanner.next();
            }

        }

        System.out.println("\n=*=*=*=* Programa finalizado com sucesso *=*=*=*=");




    }

}
