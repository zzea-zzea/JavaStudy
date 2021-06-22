package shape.main;
import shape.MyShape;
import shape.basic.MyPoint;

public class ShapeMain {

	public static void main(String[] args) {
		MyPoint pt1 = new MyPoint(); 
			// ���̻����� ȣ���Ͽ� �����ϸ�.. ���� ��ü 
		pt1.printPoint(); // �� PT(0,0) 
		MyPoint pt2 = new MyPoint();
		pt2.x = 100;
		pt2.tag = ""; 
		pt2.printPoint(); // x�࿡�� 100��ŭ +�������� ������ �� ��ǥ
		
		MyPoint pt3 = new MyPoint(80, 40, "�սʸ���", 
				MyShape.COLOR_RED);
		pt3.printPoint();
		
		MyPoint pt4 = new MyPoint(150, true); // x�� ���� �ִ� ��
		pt4.printPoint();
		MyPoint pt5 = new MyPoint(150, false); // y�� ���� �ִ� ��
		pt5.printPoint();
		
		MyPoint pt6 = pt3; // ��������ü(�ּ�)�� pt3, pt6�� ���ÿ� ����Ŵ.
		MyPoint pt7 = new MyPoint(pt3); // ������ ���� ������ �� ����ü
		
		pt3.tag = "���� �սʸ���!";
		pt6.printPoint();		
		pt7.printPoint();
		
		System.out.println("------------");
		System.out.println(pt6);
		System.out.println(pt7); // toString()�� �ڵ� ȣ���.
	}

}
/*
�� PT(0,0) 
�� PT(100,0) 

�� PT(0,0) �±�: ����[�÷�: 000000] 
�� PT(100,0) �±�: ����[�÷�: 000000] 

�� PT(0,0) �±�: ����[�÷�: 000000] 
�� PT(100,0) �±�: ����[�÷�: 000000] 

�� PT(0,0) �±�: ����[�÷�: 000000] 
�� PT(100,0) �±�: ����[�÷�: 000000] 
�� PT(80,40) �±�: �սʸ���[�÷�: FF0000] 
�� PT(150,0) �±�: ����[�÷�: 000000] 
�� PT(0,150) �±�: ����[�÷�: 000000] 
�� PT(80,40) �±�: �սʸ���[�÷�: FF0000] 
shape.basic.MyPoint@1540e19d�� ���� �Ϸ���..
�� PT(80,40) �±�: �սʸ���[�÷�: FF0000] 

�� PT(0,0) �±�: ����[�÷�: 000000] 
�� PT(100,0) �±�: ����[�÷�: 000000] 
�� PT(80,40) �±�: �սʸ���[�÷�: FF0000] 
�� PT(150,0) �±�: ����[�÷�: 000000] 
�� PT(0,150) �±�: ����[�÷�: 000000] 
shape.basic.MyPoint@1540e19d�� ���� �Ϸ���..
�� PT(80,40) �±�: ���� �սʸ���![�÷�: FF0000] 
�� PT(80,40) �±�: �սʸ���[�÷�: FF0000] 
------------
shape.basic.MyPoint@1540e19d
shape.basic.MyPoint@677327b6

*/