package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import mainPackage.Cell;
import mainPackage.Area;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CellsViewModel extends JPanel implements ComponentListener, MouseListener, Runnable {
	private JPanel self;
	private int lineThickness;
	private int cellSize;
	private int distance;
	private ArrayList<Cell> cells;
	private Area a;
	private boolean shutdown;
	//private ArrayList<JPanel> panels;
	
	public CellsViewModel(Area a){
		shutdown=true;
		self = this;
		cells = new ArrayList<Cell>();
		//panels = new ArrayList<JPanel>();
		lineThickness=1;
		cellSize = 8;
		distance = lineThickness+cellSize;
		this.a =a ;
		getCellsFromArea();
		for(Cell cell : cells){
			add(cell);
			cell.addMouseListener(new MouseAdapter(){
				@Override
	            public void mousePressed(MouseEvent e) {
	            	Cell clicked = (Cell) e.getSource();
	            	clicked.switchState();
	            	cell.repaint();
	            }
				
			});
		}
	}
	
	public void getCellsFromArea(){
		cells=a.getReferencesToCells();		
	}
	
	@Override
	public void run() {
		while(!shutdown){
			a.gameOfLifeStep();
			self.setIgnoreRepaint(true);
			try {
				self.repaint();	
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
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
	
	public void paintCell(int x, int y){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int x=0; int y=0; int iteration=1;
		g.setColor(Color.red);
		for(Cell cell : cells){
			x = (distance*cell.getJ());
			y = (distance*cell.getI());
			cell.setLayout(null);
			cell.setLocation(x+lineThickness, y+lineThickness);
			cell.setSize(cellSize, cellSize);
			if (cell.isAlive())
			{
				
				cell.setBackground(Color.red);

				
				//g.fillRect(x+lineThickness,y+lineThickness , cellSize, cellSize);
				
			}
			cell.repaint();

			
			
			
			
			iteration++;
		}
		
		g.setColor(Color.GRAY);
		x=0;y=0;
		int line_length = (int) (Math.sqrt(cells.size()) *distance);
		for (int i = 0; i<Math.sqrt(cells.size());i++){
			g.fillRect(x, y+i*distance,line_length, lineThickness );
			g.fillRect(x+i*distance, y, lineThickness,line_length);
			
		}
		g.fillRect(x, y+line_length,line_length+lineThickness, lineThickness );
		g.fillRect(x+line_length, y, lineThickness,line_length + lineThickness);
		
	}

	public void nextStep() {
		a.gameOfLifeStep();
		repaint();
	}
	
	public void gameOfLife(int steps){
		a.gameOfLife(steps);
		repaint();
	}

	public void spawnGliderGun() {
		a.insertGliderGun((int)Math.sqrt(cells.size())/2, (int)Math.sqrt(cells.size())/2-15);
		repaint();
		
	}
	public void onOff(){
		shutdown=!shutdown;
	}
	
	
	public void removeListenersFromCells(){
		for ( Cell cell: cells){
			cell.removeMouseListener(cell.getMouseListeners()[0]);			
		}		
	}
	public void addCellListeners(){
		for (Cell cell:cells){
			cell.addMouseListener(new MouseAdapter(){
				@Override
	            public void mousePressed(MouseEvent e) {
	            	Cell clicked = (Cell) e.getSource();
	            	clicked.switchState();
	            	cell.repaint();
	            }
			});
		}
		
	}

	public void clearTheArea() {
		for (Cell cell:cells)
		{
			cell.off();
		}
		repaint();
		
	}

	public void setPeriodicBC() {
		a.setPeriodicBC();
		
	}

	public void setZeroBC() {
		a.setZeroBC();
		
	}
	
}
