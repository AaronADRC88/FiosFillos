package fiosfillos;

public class Fios extends Thread {

    //Con este contador delimitaremos a creación de fios ata 5
    static int contador = 0;

    public Fios() {
        super();
    }

    @Override
    //O método run herdado de Thread é onde iniciase o fio principal e os seus fios fillos 
    public void run() {
        while (contador < 5) {
            contador++;
            try {
                //O fio principal imprime por pantalla 10 veces
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " " + getName());

                }
                //Aqui faise unha pausa de medio segundo e comeza a execucion dos fios fillos
                Thread.sleep(500);
                Thread fio = new Fios();
                fio.start();
                fio.join();

                //Ao rematares a execución de todolos fios confirmase cunha mensaxe
                System.out.println("Termina thread " + getName());

            } catch (InterruptedException ie) {
                System.out.println("erro " + ie);
            }
        }
    }
}
