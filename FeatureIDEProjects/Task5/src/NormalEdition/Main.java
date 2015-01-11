import java.util.ArrayList; import java.sql.SQLException; 
import java.util.*; 

public   class  Main {
	
	 private static ArrayList<FeatureInterface>  loadFeatures__wrappee__Transaktion  (){
		ArrayList<FeatureInterface> features = original();
		FeatureInterface Transaction = new TransactionManager(100);
		features.add(Transaction);
		return features;
	}

	
	 private static ArrayList<FeatureInterface>  loadFeatures__wrappee__Session  (){
		ArrayList<FeatureInterface> features = loadFeatures__wrappee__Transaktion();
		FeatureInterface Login = new LoginManager();
		features.add(Login);
		return features;
	}

	
	 private static ArrayList<FeatureInterface>  loadFeatures__wrappee__Accounts  (){
		ArrayList<FeatureInterface> features = loadFeatures__wrappee__Session();
		FeatureInterface Account = new AccountManager(100);
		features.add(Account);
		return features;
	}

	

	public static ArrayList<FeatureInterface> loadFeatures  (){
		ArrayList<FeatureInterface> features = new ArrayList<FeatureInterface>();
		return features;
	}

	
	
	 private static ArrayList<FunctionInterface>  loadFunctions__wrappee__Transaktion  (ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = original(features);
		FunctionInterface FctTransaction = new FcTransaction((TransactionManager) features.get(features.size() - 1));
		featurefc.add(FctTransaction);
		return featurefc;
	}

	
	
	 private static ArrayList<FunctionInterface>  loadFunctions__wrappee__Session  (ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = loadFunctions__wrappee__Transaktion(features);
		FunctionInterface FctLogin = new FcLogin((LoginManager) features.get(features.size() - 1));
		Featurefc.add(FctLogin);
		return featurefc;
	}

	
	
	 private static ArrayList<FunctionInterface>  loadFunctions__wrappee__Accounts  (ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = loadFunctions__wrappee__Session(features);
		FunctionInterface FctAccount = new FcAccount((AccountManager) features.get(features.size() - 1));
		featurefc.add(FctAccount);
		return featurefc;
	}

	
	
	public static ArrayList<FunctionInterface> loadFunctions  (ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = new ArrayList<FunctionInterface>();
		return featurefc;
	}

	

	public static void main(String[] args) throws SQLException {
		System.out.println("Wilkommen beim Budgetcontrol");

		ArrayList<FeatureInterface> features = loadFeatures();
		ArrayList<FunctionInterface> featurefc = loadFunctions(features);
		
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
