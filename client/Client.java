import messervices.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
	MonService port = new MonServiceService().getMonServicePort();
	Scanner sc = new Scanner(System.in);
	System.out.print("Votre nom : ");
	String nom = sc.nextLine();
	System.out.println(port.hello(nom));
    }

}
