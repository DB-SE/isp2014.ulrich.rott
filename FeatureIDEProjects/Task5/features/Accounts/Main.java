import java.util.ArrayList;

public class Main {
	public static ArrayList<FeatureInterface> loadFeatures(){
		ArrayList<FeatureInterface> features = original();
		FeatureInterface Account = new AccountManager(100);
		features.add(Account);
		return features;
	}
	
	public static ArrayList<FunctionInterface> loadFunctions(ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = original(features);
		FunctionInterface FctAccount = new FcAccount((AccountManager) features.get(features.size() - 1));
		featurefc.add(FctAccount);
		return featurefc;
	}
}