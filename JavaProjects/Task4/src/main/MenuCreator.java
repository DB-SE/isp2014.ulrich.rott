package main;

import java.util.ArrayList;
import java.util.Scanner;

import interfaces.*;

public class MenuCreator implements MenuInterface {
	private ArrayList<DataPlugin> selected;
	private int selectedMenu; // ID of feature
	private boolean exit = false;
	private boolean goMainMenu = false;

	public MenuCreator(ArrayList<DataPlugin> selected) {
		this.selected = selected;
	}

	@Override
	public String getTitle() {
		return "Main-Menu";
	}

	@Override
	public ArrayList<String> getButtonstitles() {
		ArrayList<String> result = new ArrayList<String>();

		for (int i = 0; i < selected.size(); i++) {
			result.add(selected.get(i).getTitle());
		}
		return result;
	}

	private void showMainMenu() {
		for (int i = 0; i < selected.size(); i++) {
			System.out.println("[" + i + "] " + selected.get(i).getTitle());
		}
	}

	private void showFeatureMenu() {
		for (int i = 0; i < selected.get(selectedMenu).getFunctions().size(); i++) {
			System.out.println("[" + i + "] " + selected.get(selectedMenu).getFunctions().get(i));
		}
	}

	private int getUserInput(int stage) {
		System.out.print("Go to: ");
		Scanner userInput = new Scanner(System.in);
		//userInput.nextInt();
		int tmp = userInput.nextInt();

		if (tmp == 10 && stage == 0) {
			exit = true;
			goMainMenu = true;
		}

		if (tmp == 10 && stage == 1) {
			goMainMenu = true;
		}
		userInput.reset();
		
		return tmp;
		// return selected.get(tmp).getID();
	}

	public void getSelectMainMenu() {
		this.showMainMenu();
		if (getUserInput(1) != 10)
			this.selectedMenu = getUserInput(0);
		else 
			this.selectedMenu = 0;
	}

	public void getSelectUnderMenu() {
		this.showFeatureMenu();
		if (getUserInput(1) != 10)
			this.selectedMenu = getUserInput(1);
		else 
			this.selectedMenu = 0;
	}

	public boolean getMainMenu() {
		return goMainMenu;
	}

	public boolean getExit() {
		return exit;
	}
}
