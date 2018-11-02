import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Pixabay {

	private JFrame frame;
	private JTextField search;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pixabay window = new Pixabay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pixabay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 779, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchItem = search.getText();
				Thread thd1 = new Thread(new SearchImages(panel,searchItem));
				thd1.start();
			}
		});
		btnSearch.setBounds(652, 447, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		search = new JTextField();
		search.setBounds(12, 448, 628, 22);
		frame.getContentPane().add(search);
		search.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 737, 421);
		frame.getContentPane().add(panel);
		

	}
}
