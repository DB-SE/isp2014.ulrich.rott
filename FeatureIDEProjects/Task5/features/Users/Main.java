import java.util.ArrayList;

public class Main {
	public static ArrayList<FeatureInterface> loadFeatures(){
		ArrayList<FeatureInterface> features = original();
		FeatureInterface User = new UserManager(100);
		features.add(User);
		return features;
	}
	
	public static ArrayList<FunctionInterface> loadFunctions(ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = original(features);
		FunctionInterface FctUser = new FcAccount((UserManager) features.get(features.size() - 1));
		featurefc.add(FctAccount);
		return featurefc;
	}
}