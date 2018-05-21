import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RGB extends JFrame implements ChangeListener{

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RGB window = new RGB();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public RGB() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		initialize();
	}
	
	private JPanel panel_1;
	private JSlider rSlider;
	private JSlider gSlider;
	private JSlider bSlider;
	
	private JLabel lblRed;
	private JLabel lblGreen;
	private JLabel lblBlue;

	/**
	 * Initialize the contents of the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		setTitle("RGB Crappy Thingy");
		setResizable(false);
		setBounds(100, 100, 666, 434);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		lblRed = new JLabel("Red : 0");
		lblRed.setForeground(Color.WHITE);
		lblRed.setFont(new Font("Ethnocentric Rg", Font.PLAIN, 12));
		lblRed.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblRed);
		
		rSlider = new JSlider();
		rSlider.setBackground(Color.BLACK);
		rSlider.setValue(0);
		rSlider.setMaximum(255);
		rSlider.setFocusable(false);
		panel.add(rSlider);
		
		lblGreen = new JLabel("Green : 0");
		lblGreen.setForeground(Color.WHITE);
		lblGreen.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreen.setFont(new Font("Ethnocentric Rg", Font.PLAIN, 12));
		panel.add(lblGreen);
		
		gSlider = new JSlider();
		gSlider.setBackground(Color.BLACK);
		gSlider.setValue(0);
		gSlider.setMaximum(255);
		gSlider.setFocusable(false);
		panel.add(gSlider);
		
		lblBlue = new JLabel("Blue : 0");
		lblBlue.setForeground(Color.WHITE);
		lblBlue.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlue.setFont(new Font("Ethnocentric Rg", Font.PLAIN, 12));
		panel.add(lblBlue);
		
		bSlider = new JSlider();
		bSlider.setBackground(Color.BLACK);
		bSlider.setForeground(Color.WHITE);
		bSlider.setValue(0);
		bSlider.setMaximum(255);
		bSlider.setFocusable(false);
		panel.add(bSlider);
		getContentPane().setLayout(groupLayout);
		
		rSlider.addChangeListener(this);
		gSlider.addChangeListener(this);
		bSlider.addChangeListener(this);
		
		panel_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				JOptionPane.showMessageDialog(new JFrame(), "new Color(" + rSlider.getValue() + "," + 
//				gSlider.getValue() + "," + bSlider.getValue() + ")", "Your String", JOptionPane.DEFAULT_OPTION);
				
				JDialog r = new JDialog();
				r.add(new JPanel().add(new JTextArea("new Color(" + rSlider.getValue() + "," + 
						gSlider.getValue() + "," + bSlider.getValue() + ")")));
				
				r.setSize(200, 100);
				r.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				r.setLocationRelativeTo(null);			
				r.setVisible(true);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		panel_1.setBackground(new Color(rSlider.getValue(), gSlider.getValue(), bSlider.getValue()));
		
		lblRed.setText("Red : " + rSlider.getValue());
		lblGreen.setText("Green : " + gSlider.getValue());
		lblBlue.setText("Blue : " + bSlider.getValue());
	}
}
