package soeulmetro.subway;

import shape.d1.MyLine;

// ����ö�� �� �� ���� �̾��ִ� ª�� ���� ��Ű��
// �뼱�� �� ������ �մ� ���� ����...
// �����̼��� �� �� �ʿ���.   ���ۿ� => ���� ����Ǵ� ª�� ����. 
// �� 2��(����/��), ���� �̸�, ���� ����, ���� ������..,
// ������ �Ÿ�, �Ҽӵ� �뼱�� ������ȣ, ���� �ڽ��� ������ȣ...
public class RailWay extends MyLine {
	public Station rwSs; // �� 2��(����/��) start station ss
	public Station rwEs; 
	//public String rwName; // ���� �̸�
	public String rwColor; // ���� ����   //  ���� ������..
	public double rwDist; //������ �Ÿ�  (�����������Ÿ�, �뼱���ȼ�����)
	public int rwSubwayLineNumber; // �Ҽӵ� �뼱�� ������ȣ
	public int rwOrder; // ���� �ڽ��� ������ȣ
	
	public RailWay() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RailWay(Station rwSs, Station rwEs, 
			String rwColor, int rwSubwayLineNumber, 
			int rwOrder) {
		super();
		this.rwSs = rwSs;
		this.rwEs = rwEs;
		this.updateStartPoint(rwSs.ptCenter);
		this.setEp(rwEs.ptCenter);
		this.rwColor = rwColor;		
		this.rwSubwayLineNumber = rwSubwayLineNumber;
		this.rwOrder = rwOrder;
		this.rwDist = this.getDistance();
	}



	public RailWay(Station rwSs, Station rwEs, String rwColor, double rwDist, int rwSubwayLineNumber, int rwOrder) {
		super();
		this.rwSs = rwSs;
		this.rwEs = rwEs;
		this.rwColor = rwColor;
		this.rwDist = rwDist;
		this.rwSubwayLineNumber = rwSubwayLineNumber;
		this.rwOrder = rwOrder;
	}



	@Override
	public String toString() {
		return "RailWay [rwSs=" + rwSs + ", rwEs=" + rwEs + ", rwColor=" + rwColor + ", rwDist=" + rwDist
				+ ", rwSubwayLineNumber=" + rwSubwayLineNumber + ", rwOrder=" + rwOrder + ", tag=" + tag + ", color="
				+ color + ", strokeType=" + strokeType + ", width=" + width + ", getDistance()=" + getDistance() + "]";
	}
	
	
	
	
}