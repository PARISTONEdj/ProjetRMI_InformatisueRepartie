package ServeurMachine1;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Store.StoreInterface;

public class Serveur1 {

	public static void main(String[] args) throws RemoteException {
		StoreInterface mag1 = new StoreManager1("Magazin1");
		
		Registry registry = LocateRegistry.createRegistry(1097);
		registry.rebind("magazin1", mag1);
		
		System.out.println("le serveur du magazin 1 demare");
		
		System.out.println(mag1.toString());
				
		System.out.println("le prix est : "+mag1.getPrice("sel"));


	}

}
