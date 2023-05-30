package ServeurMachine3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ServeurMachine1.StoreManager1;
import Store.StoreInterface;

public class Serveur3 {

	public static void main(String[] args) throws RemoteException {
		
		StoreInterface mag3 = new StoreManager3("Magazin3");
		
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("magazin3", mag3);
		
		System.out.println("le serveur du magazin 3 demare");
		
		System.out.println(mag3.toString());
		System.out.println("le prix est : "+mag3.getPrice("sel"));

	}

}
