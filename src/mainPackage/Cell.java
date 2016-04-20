package mainPackage;

public class Cell {
	boolean alive;
	private int i=0; private int j=0;
	int grain;
	
	public Cell(int i, int j){
		alive=false;
		grain=0;
		this.i=i; this.j=j;
	}
	
	public Cell(Cell cell) {
		this.i=cell.i;
		this.j=cell.j;
		this.alive = cell.alive;
		this.grain=cell.grain;
	}

	public boolean isAlive(){
		if(alive)
			return true;
		else
			return false;
	}
	
	public void on(){
		alive=true;
	}
	public void off(){
		alive=false;
	}
	
	public int getI(){
		return i;
	}
	
	public int getJ(){
		return j;
	}
	
}
