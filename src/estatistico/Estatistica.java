



public class Estatistica {



    public double[] dados;

   
    public Estatistica(double[] dados) {
        this.dados = dados;
    }

    public Estatistica(int tamanho) {
        this.dados = new double[tamanho];
    }

    public Estatistica() {
        this.dados = new double[10];
    }

    public double getDesvioPadrao() {
        return Math.sqrt(getVariancia());
    }

    public double getVariancia() {
        double p1 = 1 / (double) dados.length;
        return p1 * getSomatorio();
    }

    public double getMedia() {
        double total = 0;
        for (double dado : dados) {
            total += dado;
        }
        return total / dados.length;
    }

    public double getSomatorio() {
        double media = getMedia();
        double somatorio = 0;
        for (double dado : dados) {
            somatorio += Math.pow(dado - media, 2);
        }
        return somatorio;
    }


    public static void main(String args[]){
        Estatistica e = new Estatistica(args.length);
        for(int i =0; i < e.dados.length; i++){
            e.dados[i] = Double.parseDouble(args[i]);
        }
        System.out.println(e.getDesvioPadrao());
    }

}
