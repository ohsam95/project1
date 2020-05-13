package project02;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Result extends JFrame{
	
	Result resultframe = this;
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lbmain = new JLabel("\uB2F9\uC2E0\uC5D0\uAC8C \uB9DE\uB294 \uCCB4\uD06C\uCE74\uB4DC");
		lbmain.setHorizontalAlignment(JLabel.CENTER);
		lbmain.setFont(new Font("���� ���", Font.PLAIN, 25));
		lbmain.setBounds(0, 0, 984, 85);
		getContentPane().add(lbmain);
		
		
		JLabel lbname = new JLabel(CardM.CName);
		lbname.setFont(new Font("���� ���", Font.PLAIN, 16));
		lbname.setHorizontalAlignment(JLabel.CENTER);
		lbname.setBounds(0, 83, 984, 37);
		getContentPane().add(lbname);
		
		

		
		String imgPath = selectCard();
		ImageIcon cardIcon = new ImageIcon(imgPath);
		Image cardimg = cardIcon.getImage();
		Image cardimg2 = cardimg.getScaledInstance(500,500, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(cardimg2);
		
		JLabel lbimg = new JLabel(Icon);
		lbimg.setHorizontalAlignment(JLabel.CENTER);
		lbimg.setBounds(96, 125, 774, 655);
		getContentPane().add(lbimg);
		
		JLabel lbnu = new JLabel("\u203B \uC6D0\uD558\uB294 \uD61C\uD0DD\uC774 \uAC00\uC7A5 \uB9CE\uC740 \uCCB4\uD06C\uCE74\uB4DC\uB97C \uC54C\uB824\uC8FC\uAE30 \uB54C\uBB38\uC5D0, \uB204\uB77D\uB41C \uD61C\uD0DD\uC774 \uC788\uC744 \uC218\uB3C4 \uC788\uC2B5\uB2C8\uB2E4.");
		lbnu.setFont(new Font("���� ���", Font.PLAIN, 11));
		lbnu.setHorizontalAlignment(JLabel.CENTER);
		lbnu.setBounds(0, 921, 984, 15);
		getContentPane().add(lbnu);
		
		JButton btnout = new JButton("\uB098\uAC00\uAE30");
		btnout.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnout.setBounds(822, 23, 109, 37);
		getContentPane().add(btnout);
		
		btnout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MsgeBox mb = new MsgeBox();
				try {
					final String SQL = "delete usercheck where id = ?";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
						PreparedStatement pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, PollSession.id);

						pstmt.executeUpdate();
					
					mb.messageBox(resultframe.getContentPane(), "�̿����ּż� �����մϴ�!");
					ResultCard.cardname();
					new Login();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	
		setSize(1000,1000);
		setVisible(true);
	}
	public String selectCard() {
		String Url;
		if (CardM.CName.equals("û����� 369 üũī��")) {
			Url = "img/û�����.png";
		}else if(CardM.CName.equals("YO üũī��")) {
			Url = "img/yoī��.png";
		}else if(CardM.CName.equals("DingDing üũī��")) {
			Url = "img/����ī��.png";
		}else if(CardM.CName.equals("���ũ ī��")) {
			Url = "img/���ũī��.png";
		}else if(CardM.CName.equals("BNK���ڵǼ��� �� ���ϸ��� üũī��")) {
			Url = "img/���ڵǼ���.png";
		}else if(CardM.CName.equals("�����ູüũī��")) {
			Url = "img/�����ູī��.png";
		}else {
			Url = "img/������ī��.png";
		}
		return Url;
	}
	
	
	public static void main(String[] args) {
		new Result();
	}
}
