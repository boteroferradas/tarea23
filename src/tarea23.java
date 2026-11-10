import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class tarea23 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress yo = InetAddress.getLocalHost();
        System.out.println("Mi equipo: " + yo.getHostName());
        System.out.println("Mi Ip " + yo.getHostAddress());

        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("Escriba el nombre de un dominio (ej. www.xunta.gal) o 'salir' para terminar: ");
            String dominio = teclado.nextLine();
            if (dominio.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }
            try {
                InetAddress web = InetAddress.getByName(dominio);
                System.out.println(web.getHostName() + " -> " + web.getHostAddress());

                for (InetAddress ip : InetAddress.getAllByName(dominio)) {
                    if (ip instanceof Inet4Address) {
                        System.out.println("Ipv4: " + ip.getHostAddress());
                    } else if (ip instanceof Inet6Address) {
                        System.out.println("Ipv6: " + ip.getHostAddress());
                    }
                }
            } catch (UnknownHostException e) {
                System.err.println("No se pudo resolver: " + e.getMessage());
            }

            teclado.close();
        }
    }
}
