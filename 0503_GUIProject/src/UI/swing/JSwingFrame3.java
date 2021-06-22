package UI.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class JSwingFrame3 extends JFrame
			implements ActionListener
{
	int first;  // 100 => btnNum1 ����...
	int second; // 50
	JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
	JLabel lbStatus;
	
	
	public JSwingFrame3() {
//		super();
//		this.setTitle("���� ������");
//		super("���� ������");
		this("���� ������");
	}
	
	public JSwingFrame3(String title) {		
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setSize(800, 400);
//		this.setLocation(100, 100);
		this.setBounds(100, 100, 800, 400);
		
		// ��ġ������
//		this.setLayout(new BorderLayout()); // ����
			// BorderLayout EWSN + C 5����..
		
		JLabel lb1 = new JLabel("���� ��ư �׽�Ʈ",
				JLabel.CENTER);
		lb1.setFont(new Font("����", Font.BOLD, 40));
		
		//this.add(lb1, BorderLayout.NORTH);
		this.getContentPane().add(lb1,BorderLayout.NORTH);
		
//		JButton btn = new JButton("+"); // add op ���� ��ư
//		this.getContentPane().add(btn, BorderLayout.SOUTH);
		
		// ��ġ�� 2��, ������, =���, ���� ��ư�� 5��...
//		JButton btnNum1, btnNum2, btnOP, btnCal, btnReset;
		
		this.first = 100; this.second = 50; 
		btnNum1 = new JButton(""+first);
		btnNum2 = new JButton(String.valueOf(second));
//		btnNum1 = new JButton("100");
//		btnNum2 = new JButton("50");
		
		// ������ ������ http://famfamfam.com/lab/icons/ ����...
		// https://thenounproject.com/
		// https://fontawesome.com/icons?d=gallery&p=2
		ImageIcon icNum1 = 
				new ImageIcon("./icons/bell.png");
		ImageIcon icNum2 =
				new ImageIcon("./icons/bug.png");
		btnNum1.setIcon(icNum1); 
		btnNum2.setIcon(icNum2);
		
		ImageIcon icPlus = 
				new ImageIcon("./icons/add.png"); 
		btnOP = new JButton("");
		btnOP.setIcon(icPlus);
		
		btnCal = new JButton("", 
		new ImageIcon("./icons/calculator.png"));
		
		btnReset = new JButton("",
		new ImageIcon("./icons/arrow_refresh.png"));
//		btnReset.setToolTipText("���� ���!");
		
		Font btFnt = new Font("�ü�", Font.BOLD, 26);
		
//		JPanel pn1 = new JPanel();
//		pn1.setLayout(new FlowLayout());
		JPanel pn1 = new JPanel(
			new FlowLayout(FlowLayout.CENTER,
					20, 10));
		pn1.setBackground(Color.ORANGE);
		pn1.setBorder(
			new EtchedBorder(Color.RED, Color.darkGray));
		// �гο� ��Īȿ�� ��輱(border) ����.
		
		
		// �г� �ϳ��� ��ư ��ü 5���� ��� ǥ��
		JButton[] btns = {
			btnNum1, btnOP, btnNum2, btnCal, btnReset			
		};		
		String[]  tooltips = {
			"��ġ1", "������", "��ġ2", "����ϱ�", "�����ϱ�"	
		};
//		pn1.add(btnNum1);
		int i = 0; 
		for (JButton jbtn : btns) {
			jbtn.setFont(btFnt);
			//jbtn.setToolTipText(tooltips[i++]);
			jbtn.setToolTipText(tooltips[i]);
			pn1.add(jbtn);			
			i++;
		}
		
		getContentPane().add(pn1, BorderLayout.CENTER);
		
//		getContentPane()
//		.add(btnNum1, BorderLayout.WEST);
//		getContentPane()
//		.add(btnNum2, BorderLayout.EAST);
		
		//JLabel lbStatus = new JLabel("���¹�:: ", // ��������
		this.lbStatus = new JLabel("���¹�:: ", // �ʵ�
				icNum1, JLabel.LEADING); 
		lbStatus.setFont(new Font("�ü�", Font.PLAIN, 24));
		
		getContentPane().add(lbStatus, BorderLayout.SOUTH);
		
		// �̺�Ʈ ���� ó�� --  �̺�Ʈ ������ ���
		btnCal.addActionListener(this);		
			// ActionListener �������̽� ������ ��ü�� ���� �ڰ�
		btnNum1.addActionListener(this);
		btnNum2.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		JSwingFrame3 frm = new JSwingFrame3();
//		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evBtn = (JButton)e.getSource();
		if( evBtn == btnNum1 ) { // �ּұ��� ������ ��ư?
			// btnNum1 ���
			int r = (int)(Math.random()*1000)+1;
			System.out.println("first ������: " + r);
			this.first = r;
			this.btnNum1.setText(""+first);
			btnNum1.setToolTipText("first ������: " + r);
		} else if( evBtn == btnNum2 ) {		
			// btnNum2 ���
			int r2 = (int)(Math.random()*1000)+1;
			System.out.println("second ������: " + r2);
			second = r2;
			btnNum2.setText(String.valueOf(r2));
			btnNum2.setToolTipText("second ������: " + r2);
		} else if( evBtn == btnCal ) { // ����ϱ�
			// btnCal ���
			int	result = this.first + this.second;
			System.out.printf(" %d + %d = %d \n", first, 
					second, result);
			
			this.lbStatus.setText("+ ���� ��� : " + result);		 
		} else if( evBtn == btnOP ) { // ������
			System.out.println("TBD ���� ����");
		} else if( evBtn == btnReset ) { // reset
			System.out.println("TBD ���� ����");
		}
		else {
			System.out.println("ó�����ϴ� ��ư???");
		}
	}
}