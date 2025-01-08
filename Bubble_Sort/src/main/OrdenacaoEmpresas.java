package main;
import java.io.*;

class Empresa {
    String nome_fantasia;
    String inscricao_estadual;
    double valor_mercado;

    Empresa(String nome_fantasia, String inscricao_estadual, double valor_mercado) {
        this.nome_fantasia = nome_fantasia;
        this.inscricao_estadual = inscricao_estadual;
        this.valor_mercado = valor_mercado;
    }

    public String toString() {
        return nome_fantasia + " | " + inscricao_estadual + " | " + valor_mercado;
    }
}

public class OrdenacaoEmpresas {
    public static void main(String[] args) {
        Empresa[] empresa = new Empresa[10000];
        String caminhoArquivo = "C:\\\\Users\\\\victt\\\\Downloads\\\\Empresas_BubbleSort.txt";
        int contador = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo));
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split("\\|");
                String nome_fantasia = partes[0];
                String inscricao_estadual = partes[1];
                double valor_mercado = Double.parseDouble(partes[2]);
                empresa[contador] = new Empresa(nome_fantasia, inscricao_estadual, valor_mercado);
                contador++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro!");
        }

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (empresa[j].valor_mercado < empresa[j + 1].valor_mercado) {
                    Empresa temp = empresa[j];
                    empresa[j] = empresa[j + 1];
                    empresa[j + 1] = temp;
                }
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Empresas_Ordenadas.txt"));
            for (int i = 0; i < contador; i++) {
                bw.write(empresa[i].toString());
                bw.newLine();
            }
            bw.close();
            System.out.println("Arquivo salvo!");
        } catch (IOException e) {
            System.out.println("Erro!");
        }
    }
}
