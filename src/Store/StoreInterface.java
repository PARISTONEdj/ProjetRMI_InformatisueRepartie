package Store;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StoreInterface extends Remote{
	
	public float getPrice(String ingredient)throws RemoteException;
	

}
