package project02;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Check extends JFrame implements ItemListener{
	
	List<String> checkArr;
	Check checkFrame = this;
	
	public Check() {


		setTitle("�λ����� üũī�� ��õ");
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
		JLabel home = new JLabel("\uBD80\uC0B0\uC740\uD589 \uCCB4\uD06C\uCE74\uB4DC \uD61C\uD0DD");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.setFont(new Font("���� ����", Font.BOLD, 20));
		home.setBounds(0, 0, 472, 54);
		getContentPane().add(home);
		
		JLabel smalltitle = new JLabel("\uC6D0\uD558\uB294 \uD61C\uD0DD\uC744 \uC120\uD0DD\uD558\uC138\uC694!");
		smalltitle.setHorizontalAlignment(JLabel.CENTER);
		smalltitle.setFont(new Font("���� ����", Font.PLAIN, 15));
		smalltitle.setBounds(0, 117, 472, 41);
		getContentPane().add(smalltitle);
		
		JCheckBox cbgyo = new JCheckBox("\uAD50\uD1B5\uBE44 \uD61C\uD0DD");
		cbgyo.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbgyo.setBounds(39, 199, 150, 41);
		getContentPane().add(cbgyo);
		
		
		JCheckBox cbdo = new JCheckBox("\uB3C4\uC11C \uD61C\uD0DD");
		cbdo.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbdo.setBounds(237, 328, 132, 41);
		getContentPane().add(cbdo);
		
		JCheckBox cbtong = new JCheckBox("\uD1B5\uC2E0\uBE44 \uD61C\uD0DD");
		cbtong.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbtong.setBounds(39, 285, 150, 41);
		getContentPane().add(cbtong);
		
		JCheckBox cbco = new JCheckBox("\uCEE4\uD53C \uD61C\uD0DD");
		cbco.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbco.setBounds(39, 328, 150, 41);
		getContentPane().add(cbco);
		
		JCheckBox cbshon = new JCheckBox("\uC628\uB77C\uC778 \uBAB0 \uD560\uC778 \uD61C\uD0DD");
		cbshon.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbshon.setBounds(39, 371, 150, 41);
		getContentPane().add(cbshon);
		
		JCheckBox cbsi = new JCheckBox("\uC2DC\uD5D8\uC751\uC2DC\uB8CC \uD61C\uD0DD");
		cbsi.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbsi.setBounds(237, 371, 132, 41);
		getContentPane().add(cbsi);
		
		JCheckBox cble = new JCheckBox("\uB808\uC2A4\uD1A0\uB791 \uD61C\uD0DD");
		cble.setFont(new Font("���� ����", Font.PLAIN, 12));
		cble.setBounds(237, 199, 150, 41);
		getContentPane().add(cble);
		
		JCheckBox cbyoung = new JCheckBox("\uC601\uD654\uAD00 \uD61C\uD0DD");
		cbyoung.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbyoung.setBounds(39, 242, 150, 41);
		getContentPane().add(cbyoung);
		
		JCheckBox cbole = new JCheckBox("\uC62C\uB9AC\uBE0C\uC601 \uBC0F \uB2E4\uC774\uC18C \uD61C\uD0DD");
		cbole.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbole.setBounds(237, 285, 189, 41);
		getContentPane().add(cbole);
		
		JCheckBox cbfa = new JCheckBox("\uD328\uC2A4\uD2B8\uD478\uB4DC \uBC0F \uBCA0\uC774\uCEE4\uB9AC \uD61C\uD0DD");
		cbfa.setFont(new Font("���� ����", Font.PLAIN, 12));
		cbfa.setBounds(237, 242, 210, 41);
		getContentPane().add(cbfa);
		
		cbgyo.addItemListener(this);
		cbdo.addItemListener(this);
		cbtong.addItemListener(this);
		cbco.addItemListener(this);
		cbshon.addItemListener(this);
		cbsi.addItemListener(this);
		cble.addItemListener(this);
		cbyoung.addItemListener(this);
		cbole.addItemListener(this);
		cbfa.addItemListener(this);
		
		
		JButton btnnext = new JButton("\uACB0\uACFC \uBCF4\uAE30");
		btnnext.setBounds(173, 479, 125, 41);
		getContentPane().add(btnnext);
		
	
		JLabel hihi = new JLabel("�ȳ��ϼ���! " + PollSession.id +" ��");
		hihi.setHorizontalAlignment(JLabel.CENTER);
		hihi.setFont(new Font("���� ����", Font.PLAIN, 16));
		hihi.setBounds(12, 74, 460, 33);
		getContentPane().add(hihi);
	
		
		btnnext.addMouseListener(new next());
		
		setSize(488,600);
		setVisible(true);
		checkArr = new ArrayList<>();
	}
	
	
	
	JCheckBox temp;
	@Override
	
	public void itemStateChanged(ItemEvent e) {
		temp = (JCheckBox) e.getItem();
		checkArr.add(temp.getText());
//		System.out.println(temp.getText());
//		System.out.println(e.getStateChange());
//		System.out.println(checkArr);
	}
		
	class next implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) { 
				MsgeBox mb = new MsgeBox();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
					for (int i = 0; i < checkArr.size(); i++) {
						final String SQL = "insert into usercheck(num, benefit, id) values (usercheck_seq.nextval, ?, ?)";
						PreparedStatement pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, checkArr.get(i));
						pstmt.setString(2, PollSession.id);
						pstmt.executeUpdate();
					}
					mb.messageBox(checkFrame.getContentPane(), "��ø� ��ٷ��ּ���!");
					ResultCard.cardname();
					new Result();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {		
			}
			@Override
			public void mouseExited(MouseEvent e) {	
			}
	}
	
}
