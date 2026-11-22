public class TesisPrestamo implements Prestable {

    @Override
    public double calcularMultaDemora(int diasAtraso) {

        return diasAtraso * 200;
    }
}