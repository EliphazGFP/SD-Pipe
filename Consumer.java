import java.io.DataInputStream;
import java.io.IOException;

public class Consumer extends Thread {
    private DataInputStream in;
    private double old_avg = 0.0;

    public Consumer(DataInputStream in) {
        this.in = in;
    }

    public void run() {
        System.out.println("[Consumidor] Iniciado - exibindo médias");
        while (true) {
            try {
                double avg = in.readDouble();
                System.out.printf("[Consumidor] Média atual recebida: %.6f (variação: %.6f)%n", avg, avg - old_avg);
                old_avg = avg;
            } catch (IOException e) {
                System.err.println("[Consumidor] Erro ao ler média: " + e.getMessage());
                break;
            }
        }
    }
}
