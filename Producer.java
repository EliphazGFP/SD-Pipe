import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Producer extends Thread {
    private DataOutputStream out;
    private Random rand = new Random();

    public Producer(DataOutputStream out) {
        this.out = out;
    }

    public void run() {
        System.out.println("[Produtor] Iniciado");
        while (true) {
            double value = rand.nextDouble();
            try {
                out.writeDouble(value);
                out.flush();
                System.out.printf("[Produtor] Enviou: %.6f%n", value);
                sleep(Math.abs(rand.nextInt() % 1000));
            } catch (IOException | InterruptedException e) {
                System.err.println("[Produtor] Erro: " + e.getMessage());
                break;
            }
        }
    }
}
