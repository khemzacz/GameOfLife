package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import mainPackage.Area;
import mainPackage.Cell;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class MainWindow extends JFrame {
	private boolean running;
	private JPanel contentPane;
	private CellsViewModel cellGrid;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Area a;
	private JButton btnTogglerealtimesimulation;
	/**
	 * Create the frame.
	 */
	public MainWindow(Area a) {
		running = false;
		setSize(new Dimension(600, 582));
		setMaximumSize(new Dimension(1880, 1060));
		setMinimumSize(new Dimension(500, 500));
		this.a =a ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 25));
		panel.setSize(new Dimension(600, 25));
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("NextStep");
		btnNewButton.setBounds(0, 0, 108, 23);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Next15Steps");
		btnNewButton_1.setBounds(118, 0, 115, 23);
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.addMouseListener(new MouseAdapter(){
			
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.gameOfLife(15);
            }
			
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SpawnGliderAtCenter");
		btnNewButton_2.setBounds(245, 0, 135, 23);
		btnNewButton_2.addMouseListener(new MouseAdapter(){
			
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.spawnGliderGun();
            }
			
		});
		panel.add(btnNewButton_2);
		
		btnTogglerealtimesimulation = new JButton("ToggleRealTimeSimulation");
		btnTogglerealtimesimulation.setBounds(398, 0, 192, 23);
		btnTogglerealtimesimulation.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
            	Runnable r1 = (Runnable)cellGrid; 
    			Thread t1 = new Thread(r1);
            	if(running){
            		cellGrid.onOff();
            		btnNewButton.setEnabled(true);
            		btnNewButton_1.setEnabled(true);
            		btnNewButton_2.setEnabled(true);
            	} else{
            		
            		btnNewButton.setEnabled(false);
            		btnNewButton_1.setEnabled(false);
            		btnNewButton_2.setEnabled(false);
            		cellGrid.onOff();
            		t1.start();
            		
            	}
            	running = !running;
            }
			
		});
		panel.add(btnTogglerealtimesimulation);
		btnNewButton.addMouseListener(new MouseAdapter(){
			
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.nextStep();
            }
			
		});
		cellGrid = new CellsViewModel(a);
		cellGrid.setPreferredSize(new Dimension(500, 500));
		cellGrid.setLayout(new GridBagLayout());
		contentPane.add(cellGrid);
		this.setSize(697,599);
		
		
	}
}
