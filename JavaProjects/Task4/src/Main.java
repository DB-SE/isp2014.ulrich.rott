import java.sql.SQLException;
import java.util.*;

import main.*;
import interfaces.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("Wilkommen beim Budgetcontrol");

		String[] userInput = new String[2];
		ArrayList<DataPlugin> features = new ArrayList<DataPlugin>();
		ArrayList<MenuInterface> menutopics = new ArrayList<MenuInterface>();
		
		// Login
		LoginManager LM = new LoginManager();
		userInput = getUserInput();
		LM.login(userInput[0], userInput[1]);
		
		DataPlugin Login = new LoginManager();
		MenuInterface M_Login = new MenuLogin(Login);
		
		DataPlugin Account = new AccountManager(LM.getUid());
		DataPlugin Transaction = new TransactionManager(LM.getUid());
		DataPlugin User = new UserManager(LM.getUid());
		
		features.add(Login);
		menutopics.add(M_Login);
		
		features.add(Account);
		
		features.add(Transaction);
		
		features.add(User);
		
		// Show selected Features
		showSelectedFeatures(features);
	
		
		//Show Menu
		System.out.println("[ ============= MENU ============= ]");
		MenuCreator Menu = new MenuCreator(features);
		boolean exit = false;
		while(exit == false){
			Menu.getSelectMainMenu();
			boolean goMainMenu = false;
			while(goMainMenu == false){
				Menu.getSelectUnderMenu();
				goMainMenu = Menu.getMainMenu();
			}
			exit = Menu.getExit();
		}
		System.out.println("Exit application");
	}

	private static String[] getUserInput(){
		String[] result = new String[2];
		
		System.out.print("User: ");
		Scanner userInput = new Scanner(System.in);
		result[0] = userInput.nextLine();
        userInput.reset();
        
        System.out.print("Password: ");
        Scanner passwordInput = new Scanner(System.in);
        result[1] = userInput.nextLine();
        userInput.reset();
        System.out.println();
        
		return result;
	}
	
	private static void showSelectedFeatures(ArrayList<DataPlugin> selected){
		System.out.println("Unlocked Features:");
		for (int i = 0; i < selected.size(); i++){
			System.out.print("["+ i+"] " + selected.get(i).getTitle());
			System.out.println(" (" + selected.get(i).getDescription() + ")");
			
			for (int j = 0; j < selected.get(i).getFunctions().size(); j++){
				System.out.println("\t- " + selected.get(i).getFunctions().get(j));
			}
			
			System.out.println();
		}
	}
}
