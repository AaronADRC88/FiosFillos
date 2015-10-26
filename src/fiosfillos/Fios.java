package fiosfillos;

public class Fios extends Thread {
    //El contador aqui para que no se reinicie cada vez qe se ejecuta el run de un nuevo hilo
    static int contador = 0;

    public Fios() {
        super();
    }

    @Override
    public void run() {
        
        while (contador < 5) {
            contador++;
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + getName());

                }
                
                Thread.sleep(500);
                if (contador <= 5) {
                    Thread fio = new Fios();
                    fio.start();
                    fio.join();
                }
                //El hilo realmente termina aqui por que el join() lo unico que hace es esperar a que termine el hilo hijo
                System.out.println("Termina thread " + getName());
                
            } catch (InterruptedException ie) {
                System.out.println("erro " + ie);
            }
        }
    }
}
