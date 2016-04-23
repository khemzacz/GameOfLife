package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Canvas;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JList;

public class MainWindow extends JFrame {
	private boolean running;
	private JPanel contentPane;
	private CellsViewModel cellGrid;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private Area a; private JComboBox bcScroll;
	private JButton btnTogglerealtimesimulation;
	/**
	 * Create the frame.
	 */
	public MainWindow(Area a) {
		running = false;
		setSize(new Dimension(900, 601));
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
		panel.setPreferredSize(new Dimension(875, 25));
		panel.setSize(new Dimension(875, 25));
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
		
		btnNewButton_2 = new JButton("SpawnGliderAtCenter");
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
            		btnNewButton_3.setEnabled(true);
            		bcScroll.setEnabled(true);
            		cellGrid.addCellListeners();
            	} else{
            		cellGrid.removeListenersFromCells();
            		btnNewButton.setEnabled(false);
            		btnNewButton_1.setEnabled(false);
            		btnNewButton_2.setEnabled(false);
            		btnNewButton_3.setEnabled(false);
            		bcScroll.setEnabled(false);
            		cellGrid.onOff();
            		t1.start();
            		
            	}
            	running = !running;
            }
			
		});
		panel.add(btnTogglerealtimesimulation);
		
		btnNewButton_3 = new JButton("ClearAll");
		btnNewButton_3.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.clearTheArea();
            }
			
		}); 
		btnNewButton_3.setBounds(601, 0, 89, 23);
		panel.add(btnNewButton_3);
		
		ArrayList<String> pom1 = new ArrayList<String>();
		pom1.add("Periodic");
		pom1.add("Zeros");
		String[] listData = new String [pom1.size()];
		listData = pom1.toArray(listData);
		//bc.setBounds(700, 0, 77, 23);
		bcScroll = new JComboBox(listData);
		bcScroll.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String choice = (String)bcScroll.getSelectedItem();
				if (choice.equals("Periodic")){
					cellGrid.setPeriodicBC();
				}
				else if (choice.equals("Zeros")){
					cellGrid.setZeroBC();
				}
			}
			
			
		});
		bcScroll.setBounds(700, 0, 77, 23);
		panel.add(bcScroll);
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
		
		
	}
}
