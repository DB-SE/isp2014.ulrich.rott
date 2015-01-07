import java.sql.SQLException;
import java.util.*;

import functions.*;
import features.*;
import interfaces.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		System.out.println("Wilkommen beim Budgetcontrol");

		ArrayList<FeatureInterface> features = new ArrayList<FeatureInterface>();
		ArrayList<FunctionInterface> featurefc = new ArrayList<FunctionInterface>();
		
		// Login
		LoginManager LM = new LoginManager();
		LM.login();
		
		
		FeatureInterface Login = new LoginManager();
		FunctionInterface FctLogin = new FcLogin(LM);
		
		FeatureInterface Account = new AccountManager(LM.getUid());
		FeatureInterface Transaction = new TransactionManager(LM.getUid());
		FeatureInterface User = new UserManager(LM.getUid());
		
		features.add(Login);
		featurefc.add(FctLogin);
		
		features.add(Account);
		features.add(Transaction);
		features.add(User);
		
		// Show selected Features
		showSelectedFeatures(features);
	
		
		//Show Menu
		MenuCreator Menu = new MenuCreator(features, featurefc);
		Menu.show();
	}

	
	private static void showSelectedFeatures(ArrayList<FeatureInterface> selected){
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
