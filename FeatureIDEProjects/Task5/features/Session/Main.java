import java.util.ArrayList;

public class Main {
	public static ArrayList<FeatureInterface> loadFeatures(){
		ArrayList<FeatureInterface> features = original();
		FeatureInterface Login = new LoginManager();
		features.add(Login);
		return features;
	}
	
	public static ArrayList<FunctionInterface> loadFunctions(ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = original(features);
		FunctionInterface FctLogin = new FcLogin((LoginManager) features.get(features.size() - 1));
		Featurefc.add(FctLogin);
		return featurefc;
	}
}

