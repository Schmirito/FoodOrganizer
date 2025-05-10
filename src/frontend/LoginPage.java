package frontend;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import backend.AppManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.Popup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordField;

	public LoginPage(AppManager am) {
		setAlwaysOnTop(true);
		setTitle("FoodOrganizer Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 133, 58, 96, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 19, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel loginLabel = new JLabel("FoodOrganizer Login");
		loginLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
		GridBagConstraints gbc_loginLabel = new GridBagConstraints();
		gbc_loginLabel.gridwidth = 3;
		gbc_loginLabel.insets = new Insets(0, 0, 5, 0);
		gbc_loginLabel.gridx = 0;
		gbc_loginLabel.gridy = 0;
		panel.add(loginLabel, gbc_loginLabel);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setFont(new Font("Monospaced", Font.PLAIN, 10));
		GridBagConstraints gbc_usernameLabel = new GridBagConstraints();
		gbc_usernameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLabel.gridx = 0;
		gbc_usernameLabel.gridy = 1;
		panel.add(usernameLabel, gbc_usernameLabel);

		usernameText = new JTextField();
		usernameText.setFont(new Font("Monospaced", Font.PLAIN, 10));
		GridBagConstraints gbc_usernameText = new GridBagConstraints();
		gbc_usernameText.gridwidth = 2;
		gbc_usernameText.fill = GridBagConstraints.BOTH;
		gbc_usernameText.insets = new Insets(0, 0, 5, 0);
		gbc_usernameText.gridx = 1;
		gbc_usernameText.gridy = 1;
		panel.add(usernameText, gbc_usernameText);
		usernameText.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Monospaced", Font.PLAIN, 10));
		GridBagConstraints gbc_passwordLabel = new GridBagConstraints();
		gbc_passwordLabel.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLabel.gridx = 0;
		gbc_passwordLabel.gridy = 2;
		panel.add(passwordLabel, gbc_passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Monospaced", Font.PLAIN, 10));
		passwordField.setColumns(1);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridwidth = 2;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 2;
		panel.add(passwordField, gbc_passwordField);

		ButtonGroup bg = new ButtonGroup();

		JRadioButton rbFoodOrganizer = new JRadioButton("FoodOrganizer");
		rbFoodOrganizer.setSelected(true);
		rbFoodOrganizer.setFont(new Font("Monospaced", Font.PLAIN, 10));
		GridBagConstraints gbc_rbFoodOrganizer = new GridBagConstraints();
		gbc_rbFoodOrganizer.anchor = GridBagConstraints.EAST;
		gbc_rbFoodOrganizer.insets = new Insets(0, 0, 5, 5);
		gbc_rbFoodOrganizer.gridx = 1;
		gbc_rbFoodOrganizer.gridy = 3;
		bg.add(rbFoodOrganizer);
		panel.add(rbFoodOrganizer, gbc_rbFoodOrganizer);

		JButton btLogin = new JButton("Login");
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				char[] pwd = passwordField.getPassword();
				String username = usernameText.getText();
				char[] checkPwd = { 'a', 'd', 'm', 'i', 'n' };
				String checkUsername = "admin";

				if (username.isEmpty() || pwd.length == 0) {
					System.out.println("Please enter a username and a password.");
				}
				if (username.equals(checkUsername) && Arrays.equals(pwd, checkPwd)) {
					System.out.println("admin login complete");
					closeLoginPage();
					am.loginSuccessful();
					

				}

			}
		});
		
				JRadioButton rbBackend = new JRadioButton("Backend");
				rbBackend.setFont(new Font("Monospaced", Font.PLAIN, 10));
				GridBagConstraints gbc_rbBackend = new GridBagConstraints();
				gbc_rbBackend.anchor = GridBagConstraints.WEST;
				gbc_rbBackend.insets = new Insets(0, 0, 5, 5);
				gbc_rbBackend.gridx = 2;
				gbc_rbBackend.gridy = 3;
				bg.add(rbBackend);
				panel.add(rbBackend, gbc_rbBackend);
		btLogin.setFont(new Font("Monospaced", Font.BOLD, 12));
		GridBagConstraints gbc_btLogin = new GridBagConstraints();
		gbc_btLogin.gridheight = 2;
		gbc_btLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_btLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btLogin.gridwidth = 3;
		gbc_btLogin.gridx = 0;
		gbc_btLogin.gridy = 4;
		panel.add(btLogin, gbc_btLogin);
		pack();
	}
	
	private void closeLoginPage() {
		dispose();
	}

}
