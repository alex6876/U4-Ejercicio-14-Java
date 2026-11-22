public class Main {

    public static void main(String[] args) {

        ControlVencimientos control = new ControlVencimientos();

        Prestable libro = new LibroPrestamo();
        Prestable revista = new RevistaPrestamo();
        Prestable tesis = new TesisPrestamo();

        control.procesarDevolucion(libro, 3);

        System.out.println("----------------");

        control.procesarDevolucion(revista, 3);

        System.out.println("----------------");

        control.procesarDevolucion(tesis, 3);

    }
}