import java.util.ArrayList;

import interfaces.*;

public class MenuLogin implements MenuInterface{
	private DataPlugin points; 
	
	public MenuLogin(DataPlugin points){
		this.points = points;
	}

	@Override
	public String getTitle() {
		return points.getTitle();
	}

	@Override
	public ArrayList<String> getButtonstitles() {
		return points.getFunctions();					
	}

}
