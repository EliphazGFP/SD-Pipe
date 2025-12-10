import java.io.*;

public class PipeTest {
    public static void main(String[] args) throws IOException {
        System.out.println("=== PRODUTOR → FILTRO → CONSUMIDOR com PIPES ===\n");

        // Primeiro pipe: Produtor → Filtro
        PipedOutputStream pout1 = new PipedOutputStream();
        PipedInputStream pin1 = new PipedInputStream(pout1);
        DataOutputStream producerOut = new DataOutputStream(pout1);
        DataInputStream filterIn = new DataInputStream(pin1);

        // Segundo pipe: Filtro → Consumidor
        PipedOutputStream pout2 = new PipedOutputStream();
        PipedInputStream pin2 = new PipedInputStream(pout2);
        DataOutputStream filterOut = new DataOutputStream(pout2);
        DataInputStream consumerIn = new DataInputStream(pin2);

        // Criar e iniciar as threads
        Producer p = new Producer(producerOut);
        Filter f = new Filter(filterIn, filterOut);
        Consumer c = new Consumer(consumerIn);

        p.start();
        f.start();
        c.start();

        System.out.println("Todas as threads iniciadas. Deixe rodar por alguns segundos e pressione CTRL+C para parar.\n");
    }
}
