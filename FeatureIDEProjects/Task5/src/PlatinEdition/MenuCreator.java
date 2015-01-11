import java.sql.SQLException; 
import java.util.ArrayList; 
import java.util.Scanner; 

public  class  MenuCreator {
	
	private ArrayList<FeatureInterface> selected;

	
	private ArrayList<FunctionInterface> selectedfc;

	
	private int selectedMainMenu;

	 // ID of feature
	private int selectedFeatureMenu;

	 // ID of feature
	private boolean exit = false;

	
	private boolean goMainMenu = false;

	
	private boolean featurepart = false;

	

	public MenuCreator(ArrayList<FeatureInterface> selected, ArrayList<FunctionInterface> selectedfc) {
		this.selected = selected;
		this.selectedfc = selectedfc;
	}

	

	private void showMainMenu() {
		for (int i = 0; i < selected.size(); i++) {
			System.out.println("[" + i + "] " + selected.get(i).getTitle());
		}
	}

	

	private void showFeatureMenu() {
		System.out.println(selected.get(selectedMainMenu).getTitle());
		for (int i = 0; i < selected.get(selectedMainMenu).getFunctions().size(); i++) {
			System.out.println("\t[" + i + "] " + selected.get(selectedMainMenu).getFunctions().get(i));
		}
	}

	

	private int getUserInput(int stage) {
		System.out.print("Go to: ");
		Scanner userInput = new Scanner(System.in);
		int tmp = userInput.nextInt();

		if (tmp == 10 && stage == 0) {
			exit = true;
			goMainMenu = true;
		} else if (tmp == 10 && stage == 1) {
			goMainMenu = true;
		}
		userInput.reset();

		return tmp;
		// return selected.get(tmp).getID();
	}

	

	public void getSelectMainMenu() {
		this.showMainMenu();
		int tmp = getUserInput(0);

		if (tmp != 10) {
			this.selectedMainMenu = tmp;
			goMainMenu = false;
		} else {
			this.selectedMainMenu = -1;
			goMainMenu = true;
		}
	}

	

	public void getSelectUnderMenu() {
		this.showFeatureMenu();
		int tmp = getUserInput(1);
		if (tmp != 10) {
			this.selectedFeatureMenu = tmp;
		} else {
			this.selectedFeatureMenu = -1;
		}
	}

	

	public boolean getMainMenu() {
		return goMainMenu;
	}

	

	public boolean getExit() {
		return exit;
	}

	

	public boolean getFeaturepart() {
		return featurepart;
	}

	

	public void show() throws SQLException {
		System.out.println("[ ============= MENU ============= ]");
		System.out.println("[ (GO BACK WITH OPTION [10]) ]");
		while (getExit() == false) {
			this.getSelectMainMenu();
			while (getMainMenu() == false) {
				this.getSelectUnderMenu();
				while (getFeaturepart() == false) {
					selectedfc.get(selectedMainMenu).runFeature(selectedFeatureMenu);
					break;
				}
			}
		}
		System.out.println("Exit application... Bye!");
	}


}
