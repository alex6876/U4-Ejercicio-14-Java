public class RevistaPrestamo implements Prestable {

    @Override
    public double calcularMultaDemora(int diasAtraso) {

        return diasAtraso * 150;
    }
}