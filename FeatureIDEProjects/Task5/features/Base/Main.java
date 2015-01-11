import java.sql.SQLException;
import java.util.*;

public class Main {

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

	public static ArrayList<FeatureInterface> loadFeatures(){
		ArrayList<FeatureInterface> features = new ArrayList<FeatureInterface>();
		return features;
	}
	
	public static ArrayList<FunctionInterface> loadFunctions(ArrayList<FeatureInterface> features){
		ArrayList<FunctionInterface> featurefc = new ArrayList<FunctionInterface>();
		return featurefc;
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
