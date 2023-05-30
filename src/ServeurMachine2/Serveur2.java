package ServeurMachine2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import ServeurMachine1.StoreManager1;
import Store.StoreInterface;

public class Serveur2 {

	public static void main(String[] args) throws RemoteException {
		
		StoreInterface mag2 = new StoreManage2("Magazin2");
		
		Registry registry = LocateRegistry.createRegistry(1098);
		registry.rebind("magazin2", mag2);
		
		System.out.println("le serveur du magazin 2 demare");
		
		System.out.println(mag2.toString());
		System.out.println("le prix est : "+mag2.getPrice("poivre"));

		
	}

}
