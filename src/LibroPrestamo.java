public class LibroPrestamo implements Prestable {

    @Override
    public double calcularMultaDemora(int diasAtraso) {

        return diasAtraso * 100;
    }
}