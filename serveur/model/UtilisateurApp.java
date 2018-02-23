package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.ControleConnexion;

public class UtilisateurApp {
	String nom;
	String prenom;
	String pseudo;
	String motDePass;
	String cni;
	
	public UtilisateurApp() {
		list();
	}
	public UtilisateurApp(String pseudo,String mdp,String nom,String prenom,String cni) {
		this.pseudo=pseudo;
		this.nom=nom;
		this.motDePass=mdp;
		this.nom=nom;
		this.prenom=prenom;
		this.cni=cni;
	}
	private ArrayList<UtilisateurApp> listUtilisateur = new ArrayList<UtilisateurApp>();
	static Connection laConnexionStatique = ControleConnexion.getConnexion();
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPeusdo() {
		return pseudo;
	}
	public void setPeusdo(String peusdp) {
		this.pseudo = peusdp;
	}
	public String getMotDePass() {
		return motDePass;
	}
	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}
	
	public String getCni() {
		return cni;
	}
	public void setCni(String cni) {
		this.cni = cni;
	}
	public ArrayList<UtilisateurApp> getListUtilisateur() {
		return listUtilisateur;
	}
	public void setListUtilisateur(ArrayList<UtilisateurApp> listUtilisateur) {
		this.listUtilisateur = listUtilisateur;
	}
	
	public ArrayList<UtilisateurApp> list(){
		try {
			String requete = "SELECT *, COUNT(*) AS nb FROM utilisateur";
			Statement state = laConnexionStatique.createStatement();
			ResultSet rs= state.executeQuery(requete);
			while(rs.next()) {
				String pseudo = rs.getString("pseudo");
				String mdp = rs.getString("mdp");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String cni = rs.getString("numcni");
				listUtilisateur.add((new UtilisateurApp(pseudo,mdp,nom,prenom,cni)));
			}
			return listUtilisateur;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean creer(UtilisateurApp user) {
		try {
			String requete = "INSERT INTO utilisateur(pseudo,mdp,nom,prenom,numcni) VALUES('"+user.getPeusdo()+"','"+user.getMotDePass()+"','"+user.getNom()+"','"+user.getPrenom()+"','"+user.getCni()+"')";
			Statement state = laConnexionStatique.createStatement();
			state.executeUpdate(requete);
			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modifier(UtilisateurApp user) {
		try {
			String requete = "UPDATE utilisateur SET " + "mdp= '" + user.getMotDePass()+"'," + "nom = '" + user.getNom() + "'," + "prenom = '" + user.getPrenom()+"'," + "numcni = '" + user.getCni()+ "'" + " WHERE pseudo = '" + user.getPeusdo() + "'";
			Statement state = laConnexionStatique.createStatement();
			state.executeUpdate(requete);
			state.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}

