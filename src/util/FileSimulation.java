/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;

/**
 *
 * @author debora
 */
public class FileSimulation implements Processavel {

    @Override
    public void processaArquivo(BufferedReader br) {
        String linhaLida = "";
        String[] dados = new String[10];
        try {
            while (br.ready()) {
                linhaLida = br.readLine();
                if (linhaLida.contains("Geracao: 499")) {
                    linhaLida = br.readLine();
                    linhaLida = linhaLida.replaceAll("[a-zA-Z:]", "");
                    dados = linhaLida.split("-");
                    break;
                }
            }
        } catch (Exception e) {
        }

    }

}
