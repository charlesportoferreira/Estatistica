/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public List<String> filePaths = new ArrayList<>();

    public String[] leDadosTec2(String filePath) throws FileNotFoundException, IOException {
        String[] dados = new String[9];
        int i = 0;
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                dados[i] = br.readLine().split(":")[1];
                i++;
            }
            br.close();
            fr.close();
        }
        return dados;
    }

    public String[] leDadosTec1(String filePath) throws FileNotFoundException, IOException {
        String[] dados = new String[10];
        String linhaLida;
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                linhaLida = br.readLine();
                if (linhaLida.contains("Geracao: 499")) {
                    linhaLida = br.readLine();
                    linhaLida = linhaLida.replaceAll("[a-zA-Z:]", "");
                    dados = linhaLida.split("-");
                    break;
                }
            }
            br.close();
            fr.close();
        }
        return dados;
    }

    public void leDados(String filePath, Processavel p) throws FileNotFoundException, IOException {
        String[] dados = new String[10];
        try (FileReader fr = new FileReader(filePath); BufferedReader br = new BufferedReader(fr)) {
            while (br.ready()) {
                p.processaArquivo(br);
            }
            br.close();
            fr.close();
        }
    }

    private void imprimeArquivo(String fileName, String texto) throws IOException {
        try (FileWriter fw = new FileWriter(fileName, true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(texto);
            bw.close();
            fw.close();
        }
    }

    private void deletaArquivoExistente(String newFile) {
        File arquivo = new File(newFile);
        if (arquivo.exists()) {
            arquivo.delete();
        }
    }

    public List<String> fileTreePrinter(File initialPath, int initialDepth, String regex) {
        if (initialPath.exists()) {
            File[] contents = initialPath.listFiles();
            for (File content : contents) {
                if (content.isDirectory()) {
                    fileTreePrinter(content, initialDepth + 1, regex);
                } else {
                    if (content.getName().matches(regex)) {
                        filePaths.add(content.toString());
                    }
                }
            }
        }
        return filePaths;
    }
}

// Atributos: 241
// Geracoes: 500
// Fitness: 58.62
// pctAcertos: 58.62
// microAverage: 0.65
// macroAverage: 0.61
// Duracao em minutos: 103
// Populacao: 12
// Numero de Grupos: 166
