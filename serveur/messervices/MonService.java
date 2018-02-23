package messervices;

import java.util.ArrayList;

import javax.jws.*;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.*;

import model.UtilisateurApp;

@WebService(name="MonService")
@SOAPBinding(style=Style.RPC,use=Use.LITERAL)
public class MonService {

	private static Double tva=0.18;
	
    @WebMethod(operationName="getTva")
    @WebResult(name="un-getTva")
    public Double getTva(/*@WebParam(name="nom") String nom*/) {
    	return tva;
    }

    @WebMethod(operationName="salut")
    @WebResult(name="un-salut")
    public String saluer(@WebParam(name="nom") String nom) {
    	return "Salut "+nom;
    }
    
    @WebMethod(operationName="listUtilisateur")
    @WebResult(name="un-listUtilisateur")
    public ArrayList<UtilisateurApp> listUtilisateur() {
    	return (new UtilisateurApp()).getListUtilisateur();
    }

	public static void setTva(Double tva) {
		MonService.tva = tva;
	}
}
