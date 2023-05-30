package ServeurMachine1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import Store.StoreInterface;

public class StoreManager1 extends UnicastRemoteObject implements StoreInterface {
	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "StoreManager1 [nom=" + nom + "]";
	}

	@Override
	public float getPrice(String ingredient) throws RemoteException {
	    String Fichier = "C:\\Users\\PARISTONE\\eclipse-workspace\\DJOYOU_Carlos_projet\\src\\ServeurMachine1/Magazin1.txt";

	    File file = new File(Fichier);
	    if (!file.exists()) {
	        System.err.println("Le fichier est introuvable");
	        return 0;
	    }

	    try (BufferedReader lecture = new BufferedReader(new FileReader(file))) {
	        String ligne;
	        while ((ligne = lecture.readLine()) != null) {
	            String[] parts = ligne.split(", ");
	            for (String part : parts) {
	                String[] item = part.split(" ");
	                if (item.length == 2 && item[0].equals(ingredient)) {
	                    return Float.parseFloat(item[1]);
	                }
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	

	public StoreManager1(String nom) throws RemoteException {
		super();
		this.nom = nom;
	}

}
