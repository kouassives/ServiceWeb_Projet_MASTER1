import javax.xml.ws.Endpoint;

import java.util.Scanner;

//import javax.swing.JOptionPane;

import messervices.*;

public class Publieur {
	
    public static void main(String[] args) {
    Endpoint endpoint = Endpoint.publish("http://localhost:8088/services",
    			new MonService());
	Scanner sc = new Scanner(System.in);
	boolean redo=true;
	String choix;
	do {
		System.out.println("  1  - Changer la valeur de TVA");
		System.out.println("0x23 - Arreter le service");
		choix = sc.nextLine();
		if (choix.equals("1"))
		{
			System.out.println("Saisir la nouvelle valeur");
			String nv = sc.nextLine();
			if(nv != null)
				MonService.setTva(Double.valueOf(nv));
			else System.out.println("Entrer un bonne valeur");
		}
		if (choix.equals("0x23"))
				redo =false;
		
	}while(redo);
	sc.close();
	//JOptionPane.showMessageDialog(null, "Eteindre le serveur");
	endpoint.stop();
    }
}