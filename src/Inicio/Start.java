/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import estattistico.Estatistica;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Util;

/**
 *
 * @author debora
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String regex = ".*\\.[0-9]{3}Z$";
        Estatistica e = new Estatistica();
        Util util = new Util();
        String diretorioAtual = System.getProperty("user.dir");
        List<String> arquivos = util.fileTreePrinter(new File(diretorioAtual), 0, regex);
        int numRepeticoes = arquivos.size();

        List<String[]> dados = new ArrayList<>();
        getDadosArquivoCSV(arquivos, dados, util);

        double[] acertos = new double[numRepeticoes];
        double[] micro = new double[numRepeticoes];
        double[] macro = new double[numRepeticoes];
        double[] atributos = new double[numRepeticoes];

        for (int i = 0; i < dados.size(); i++) {
            acertos[i] = Double.parseDouble(dados.get(i)[3]);
            micro[i] = Double.parseDouble(dados.get(i)[4]);
            macro[i] = Double.parseDouble(dados.get(i)[5]);
            atributos[i] = Double.parseDouble(dados.get(i)[8]);
        }

        Estatistica eAcertos = new Estatistica(acertos);
        Estatistica eMicro = new Estatistica(micro);
        Estatistica eMacro = new Estatistica(macro);
        Estatistica eAtributos = new Estatistica(atributos);

        System.out.println("\nAcertos");
        System.out.println("Media: " + eAcertos.getMedia());
        System.out.println("Desvio: " + eAcertos.getDesvioPadrao());

        System.out.println("\nMicro");
        System.out.println("Media: " + eMicro.getMedia());
        System.out.println("Desvio: " + eMicro.getDesvioPadrao());

        System.out.println("\nMacro");
        System.out.println("Media: " + eMacro.getMedia());
        System.out.println("Desvio: " + eMacro.getDesvioPadrao());

        System.out.println("\nAtributos");
        System.out.println(eAtributos.getMedia());
        System.out.println("Desvio: " + eAtributos.getDesvioPadrao());

       // simulacao(e);
    }

    public static void getDadosArquivoCSV(List<String> arquivos, List<String[]> dados, Util util) {
        try {
            for (String arquivo : arquivos) {
                dados.add(util.leDados(arquivo));
            }
        } catch (IOException ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void simulacao(Estatistica e) {
        e.dados[0] = 87.52;
        e.dados[1] = 86.62;
        e.dados[2] = 86.8;
        e.dados[3] = 86.71;
        e.dados[4] = 87.61;
        e.dados[5] = 87.25;
        e.dados[6] = 87.7;
        e.dados[7] = 87.25;
        e.dados[8] = 86.8;
        e.dados[9] = 86.45;

        System.out.println(e.getMedia());
        System.out.println(1 / (double) e.dados.length);
        System.out.println(e.getDesvioPadrao());
    }

}
