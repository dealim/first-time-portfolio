package serverGui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Select;
import model.Person;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SeverGui extends JFrame{
	private JPanel contentPane;
	private JList list;
	private JButton btnNewButton;
	private Vector<Person>  personList ;

	public SeverGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 10, 410, 241);
		contentPane.add(scrollPane);

		list = new JList();
		list.setListData(new Select().returnSelect());
		scrollPane.setViewportView(list);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 261, 406, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("관리자 화면입니다. 화면을 업데이트 하시려면 버튼을 클릭하세요");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 11));
		lblNewLabel.setBounds(43, 10, 339, 28);
		panel.add(lblNewLabel);

		btnNewButton = new JButton("화면 업데이트");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				personList = new Select().returnSelect();
				list.setListData(personList);
			}
		});

		btnNewButton.setBounds(143, 48, 147, 23);
		panel.add(btnNewButton);
		
		setVisible(true);
	} // main
}