package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import mainPackage.Cell;
import mainPackage.Area;

import javax.swing.JPanel;

public class CellsViewModel extends JPanel implements ComponentListener, MouseListener, Runnable {
	
	private int lineThickness;
	private int cellSize;
	private int distance;
	private ArrayList<Cell> cells;
	
	public CellsViewModel(){
		cells = new ArrayList<Cell>();
		lineThickness=3;
		cellSize = 7;
		distance = lineThickness+cellSize;
	}
	
	public void getCellsFromArea(Area a){
		cells=a.getCellsAsArrayList();		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=0; int y=0; int iteration=1;
		g.setColor(Color.blue);
		for(Cell cell : cells){
			if (cell.isAlive())
			{
				x = (distance*cell.getJ());
				y = (distance*cell.getI());
				g.fillRect(x+lineThickness,y+lineThickness , cellSize, cellSize);
				
			}
			iteration++;
		}
		
		g.setColor(Color.WHITE);
		x=0;y=0;
		int line_length = (int) (Math.sqrt(cells.size()) *distance);
		for (int i = 0; i<Math.sqrt(cells.size());i++){
			g.fillRect(x, y+i*distance,line_length, lineThickness );
			g.fillRect(x+i*distance, y, lineThickness,line_length);
			
		}
		g.fillRect(x, y+line_length,line_length+lineThickness, lineThickness );
		g.fillRect(x+line_length, y, lineThickness,line_length + lineThickness);
		
	}

}
