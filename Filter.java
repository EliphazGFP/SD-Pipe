import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Filter extends Thread {
    private DataInputStream in;
    private DataOutputStream out;
    private double total = 0.0;
    private long count = 0;

    public Filter(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    public void run() {
        System.out.println("[Filtro] Iniciado - calculando média móvel");
        while (true) {
            try {
                double value = in.readDouble();
                total += value;
                count++;
                double avg = total / count;

                out.writeDouble(avg);
                out.flush();

                System.out.printf("[Filtro] Recebeu: %.6f | Média atual: %.6f (total: %d valores)%n", value, avg, count);
            } catch (IOException e) {
                System.err.println("[Filtro] Erro na comunicação: " + e.getMessage());
                break;
            }
        }
    }
}
