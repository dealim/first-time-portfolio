package clientGui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Person;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.TextField;

public class ClientGui extends JFrame {

	private JPanel contentPane;
	public Person p;
	
	public ClientGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 255, 255));
		panel.setBounds(21, 12, 410, 241);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("채팅 프로그램");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(89, 33, 232, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(45, 104, 67, 15);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("비번");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(50, 156, 57, 15);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.setBounds(288, 99, 97, 74);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(124, 83, 152, 103);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		TextField textField = new TextField();
		textField.setColumns(10);
		textField.setBounds(25, 17, 102, 22);
		panel_1.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setColumns(10);
		textField_1.setBounds(26, 66, 101, 22);
		panel_1.add(textField_1);
		setVisible(true);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getName = textField.getText();
				String getPassword = textField_1.getText();
				System.out.println(getName);
				System.out.println(getPassword);
				textField.setText("");
				textField_1.setText("");
				
				//DB에 insert는 서버가
				p = new Person(getName, getPassword);
				new Event(p);	
			}
		});
	}
}
