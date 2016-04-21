package mainPackage;
import GUI.MainWindow;

public class AppCore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Area field = new Area(50,50);
		
		MainWindow window = new MainWindow(field);
		
		
		
		field.injectTestingStructures();
		//field.printCells();
		field.gameOfLifeStep();
		//field.printCells();
		
		window.setVisible(true);
	}

}
