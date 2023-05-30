package ServeurClient;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Store.StoreInterface;

public class StoreClient {
	

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		StoreInterface mag1 =  (StoreInterface) Naming.lookup("rmi://localhost:1097/magazin1");

		StoreInterface mag2 =  (StoreInterface) Naming.lookup("rmi://localhost:1098/magazin2");
		
		StoreInterface mag3 =  (StoreInterface) Naming.lookup("rmi://localhost:1099/magazin3");
		
		System.out.println("Interface client demarer");

		System.out.println("Séleconner le numéro de l’ingrédient, puis cliquez sur « Entrée » : \n");
		
		System.out.println("[1] cornichons \n");
		System.out.println("[2] safran \n");
		System.out.println("[3] sel \n");
		System.out.println("[4] poivre \n");
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int a = sc.nextInt();
			System.out.println("vous avez saisie : "+a);

			String ingredient;
			if(a ==1) {
				ingredient = "cornichons";
			}
			else {
				if(a ==2) {
				ingredient = "safran";
				}
				else if(a ==3) {
					ingredient = "sel";
				} 
				else if(a ==4) {
					ingredient = "poivre";
				}
				else {
					ingredient = "";
				}
				
			}
			
			System.out.println("Ingredient : "+ingredient);
			
			if(ingredient.equals("")) {
				System.out.println("saisir un bon chiffre");
				a = sc.nextInt();
			}
			else {
				System.out.println(" ingredient dans le else : "+ingredient);
				
				float m1 = mag1.getPrice(ingredient);
				float m2 = mag2.getPrice(ingredient);
				float m3 = mag3.getPrice(ingredient);
				
				System.out.println("prix mag 1 : "+m1);
				System.out.println("prix mag 2 : "+m2);
				System.out.println("prix mag 3 : "+m3);

				
				if(m1<m2 && m1<m3) {
					System.out.println("Le prix le plus bas de l’ingrédient « "+ingredient+" » est de « "+mag1.getPrice(ingredient)+" DT » et se trouve chez « magazin1 ». ");
				}
				else {
					
					if(m2<m1 && m2<m3) {
						System.out.println("Le prix le plus bas de l’ingrédient « "+ingredient+" » est de « "+mag2.getPrice(ingredient)+" DT » et se trouve chez « magazin2 ». ");

					}
					else if(m3<m1 && m3<m2) {
						System.out.println("Le prix le plus bas de l’ingrédient « "+ingredient+" » est de « "+mag3.getPrice(ingredient)+" DT » et se trouve chez « magazin3 ». ");

					}
					else {
						System.out.println("Ingredient introuvable");

					}

				}
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("le nombre doit etre un integer");
		}
		
	}
	
	public void getIngredient() {
		
	}
	
}
