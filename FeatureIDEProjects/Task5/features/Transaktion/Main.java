import java.util.ArrayList;

public class Main {
	public static ArrayList<FeatureInterface> loadFeatures(){
		ArrayList<FeatureInterface> features = original();
		FeatureInterface Transaction = new TransactionManager(100);
		features.add(Transaction);
		return features;
	}
	
	public static ArrayList<FunctionInterface> loadFunctions(ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = original(features);
		FunctionInterface FctTransaction = new FcTransaction((TransactionManager) features.get(features.size() - 1));
		featurefc.add(FctTransaction);
		return featurefc;
	}
}