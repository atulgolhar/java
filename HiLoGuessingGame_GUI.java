import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = ""; 
		
		try {
			int guess = Integer.parseInt(guessText); 	// assumes valid input
	 		if (guess < theNumber) 						// assumes valid input
				message = guess + " is too low. Guess again.";
			else if (guess > theNumber)
				message = guess + " is too high. Guess again.";
			else {
				message = guess + " is correct. You win! Let's play again!";
				newGame();
				}		
			} catch (Exception e) {
				message = "Enter a whole number between 1 and 100.";
			} finally {
		 		lblOutput.setText(message);
		 		txtGuess.requestFocusInWindow();
		 		txtGuess.selectAll();				
			}
	}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Atul Golhar Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblAtulGolharHilo = new JLabel("Atul Golhar Hi-Lo Guessing Game:)");
		lblAtulGolharHilo.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblAtulGolharHilo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtulGolharHilo.setBounds(6, 39, 320, 25);
		getContentPane().add(lblAtulGolharHilo);
		
		lblOutput = new JLabel("Guess a number between 1 and 100:");
		// JLabel lblGuessANumber = new JLabel("Guess a number between 1 and 100:"); OLD 
		lblOutput.setHorizontalAlignment(SwingConstants.RIGHT); // OLD lblGuessANumber
		lblOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 8)); // UPDATED TO lblOutput
		lblOutput.setBounds(6, 99, 178, 16);
		getContentPane().add(lblOutput);
		
		txtGuess = new JTextField();							// NEW. Erata
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();												// ATUL checkGuess #1
			}
		});
		txtGuess.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(184, 94, 46, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton lblOutput = new JButton("Enter a number above and click Guess!");
		lblOutput.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		lblOutput.setBounds(70, 214, 193, 29);
		getContentPane().add(lblOutput);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess(); 												// ATUL checkGuess #2
			}
		});
		btnGuess.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 13));
		btnGuess.setBounds(166, 150, 117, 29);
		getContentPane().add(btnGuess);
	}
	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
