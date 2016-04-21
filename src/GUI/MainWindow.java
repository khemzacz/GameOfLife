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
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.BoxLayout;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private CellsViewModel cellGrid;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private Area a;
	/**
	 * Create the frame.
	 */
	public MainWindow(Area a) {
		this.a =a ;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 908, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		cellGrid = new CellsViewModel(a);
		contentPane.add(cellGrid, BorderLayout.CENTER);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(20);
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnNewButton = new JButton("NextStep");
		panel.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter(){
			
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.nextStep();
            }
			
		});
		
		btnNewButton_1 = new JButton("Next15Steps");
		btnNewButton_1.addMouseListener(new MouseAdapter(){
			
            @Override
            public void mousePressed(MouseEvent e) {
            	cellGrid.gameOfLife(15);
            }
			
		});
		panel.add(btnNewButton_1);
		this.setSize(800,700);
		

		
	}

}
