package mainPackage;
import GUI.MainWindow;

public class AppCore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Area field = new Area(20,20);
		
		MainWindow window = new MainWindow();
		
		
		
		field.injectTestingStructures();
		field.printCells();
		field.gameOfLifeStep();
		field.printCells();
		
		window.initializeCells(field);
		window.setVisible(true);
	}

}
