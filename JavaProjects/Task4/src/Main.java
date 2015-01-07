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
		FunctionInterface FctLogin = new FcLogin((LoginManager) Login);
				
		FeatureInterface Account = new AccountManager(LM.getUid());
		FunctionInterface FctAccount = new FcAccount((AccountManager) Account);
		
		FeatureInterface Transaction = new TransactionManager(LM.getUid());
		FunctionInterface FctTransaction = new FcTransaction((TransactionManager) Transaction);
		
		FeatureInterface User = new UserManager(LM.getUid());
		FunctionInterface FctUser = new FcUser((UserManager) User);
		
		//Change here features
		features.add(Login);
		featurefc.add(FctLogin);
		
		features.add(Account);
		featurefc.add(FctAccount);
		
		features.add(Transaction);
		featurefc.add(FctTransaction);
		
		features.add(User);
		featurefc.add(FctUser);
		
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
