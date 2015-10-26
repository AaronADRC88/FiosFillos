package fiosfillos;

public class Fios extends Thread {

    public Fios() {
        super();
    }

    @Override
    public void run() {
        int contador = 0;
        while (contador < 5) {
            contador++;
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + getName());

                }

                System.out.println("Termina thread " + getName());
                Thread.sleep(500);
                if (contador <= 5) {
                    Thread fio = new Fios();
                    fio.start();
                    fio.join();
                }

            } catch (InterruptedException ie) {
                System.out.println("erro " + ie);
            }
        }
    }
}
