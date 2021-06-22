package soeulmetro;

import shape.basic.MyPoint;
import shape.util.output.SubwayPrint;
//import soeulmetro.subway.Station;
//import soeulmetro.subway.RailWay;
//import soeulmetro.subway.SubwayLine;
import soeulmetro.subway.*;

/* ���� ����ö ���翡 ���ָ� �޾�.. �뼱�� ������Ʈ 
 https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B6%84%EB%8B%B9%EC%84%A0
 https://www.sisul.or.kr/open_content/skydome/introduce/pop_subway.jsp
 http://seoulmetro.co.kr/kr/cyberStation.do#stationInfo
 
 �� ȣ������ �� ���� �����Ͽ� �ϳ��� ��η� ǥ���ϴ� ����.
 
 
 ��߿�  ~ ������������ ��ü ���� = ���  SubwayLine (8ȣ��)
 �� ��θ� �����ϴ� �� ����ö���� Station  (MyCircle/MyPoint)
 ���� ���� �����ϴ� ����(����) ���� RailWay (MyLine)

 => �䱸�Ǵ� ��ȹ������ ��� ��� ǥ���ϴ� ��Ű�� Ŭ������...

** �źд缱 

D07	����	Gangnam	˰��	�� ���� ����ö 2ȣ��	-	0.0	����Ư����	������
D08	����(���ʱ�û)	Yangjae
(Seocho-gu Office)	���(����ϡ��)	�� ������ ��ö 3ȣ��	1.5	1.5	���ʱ�
D09	����ù��ǽ�(����)	Yangjae Citizen's Forest
(Maeheon)	�������ǽ�(����)		1.6	3.1
D10	û����Ա�	Cheonggyesan	��͢ߣ��Ϣ		2.9	6.0
D11	�Ǳ�(�Ǳ���ũ��븮)	Pangyo
(Pangyo Techno Valley)	����(������ũ��븮)	�� ������ ��ö �氭��	8.2	14.2	��⵵	������
D12	����	Jeongja	����	�� ������ ��ö ���Ρ��д缱	3.1	17.3
D13	�̱�(�д缭��뺴��)	Migeum(Seoul National University Bundang Hospital)	ڸ��	�� ������ ��ö ���Ρ��д缱	1.9	19.2
D14	��õ	Dongcheon	����		1.6	20.8	���ν�
D15	������û	Suji-gu Office	��ϡ��		2.1	22.9
D16	����	Seongbok	����		1.7	24.6
D17	����	Sanghyeon	߾��		2.1	26.7
D18	�����߾�(���ִ�)	Gwanggyo Jungang
(Ajou University)	��������(����)		2.4	29.1	������
D19	����(����)	Gwanggyo
(Kyonggi University)	����(��Ѳ��)		1.9

*/
public class MetroMain2 {

	public static void main(String[] args) {
		// �źд缱 
		String sbName = "�źд缱"; // �뼱 ���� �̸�
		int sbOrder = 7; // �뼱 ������ȣ  d07~d19�� �뼱��
		String sbColor = "FF0000"; // �뼱 ���� �÷�
		String[] stNames = {
				"����", 
				"����(���ʱ�û)",
				"����ù��ǽ�(����)",
				"û����Ա�",
				"�Ǳ�(�Ǳ���ũ��븮)",
				"����",
				"�̱�(�д缭��뺴��)",
				"��õ",
				"������û",
				"����",
				"����",
				"�����߾�(���ִ�)",
				"����(����)"
		}; // �� �뼱�� �����ϴ� ������ �̸� �迭
		String[] stNamesEn = {
				"Gangnam", 
				"Yangjae",
				"Yangjae Citizen's Forest",
				"Cheonggyesan",
				"Pangyo",
				"Jeongja",
				"Migeum",
				"Dongcheon",
				"Suji-gu Office",
				"Seongbok",
				"Sanghyeon",
				"Gwanggyo Jungang",
				"Gwanggyo"
		}; 
		final int sbStationNumber = stNamesEn.length; //13
		//
//		Station[] stations = {new Station()};
//		RailWay[] railways = {};
		Station[] stations = new Station[sbStationNumber];
			// null ���� �ʱ�ȭ�� 13���� ������ ���� �迭
		RailWay[] railways = new RailWay[sbStationNumber-1]; //12
		
//		MyPoint[] pts = {
//			new MyPoint( 30, 130 ), new MyPoint( 30+80,130 ), 
//			new MyPoint( 30+80+80, 130 ),
//			new MyPoint( 30+80+80+80,130 ),
//			new MyPoint( 30+80+80+80+80, 130 ),
//			new MyPoint( 30+80+80+80+80+80,130 ),
//			
//			new MyPoint( 30, 130 ), new MyPoint( 30+80,130 ),
//			// ...
//		};
		// ���� ���� �����Ͽ� ���迭�� ��ġ, ���� ö�θ� �����Ͽ� �����迭�� ��ġ ����.
		for (int i = 0; i < stations.length; i++) {
			Station st = new Station(
					i < 7 ? 30 + 80*i:
							//30 + 80*(i ??? i),
							30 + 480 - 80*(i-7),
					i < 7 ? 130: 260, 		
//					(int)(60*i+10+Station.DEF_ST_RADIUS),
//					(int)(60*i+10+Station.DEF_ST_RADIUS),
//					stNames[i], // kr
					stNamesEn[i], // eng
					i + sbOrder, 
					sbColor, sbOrder);
			stations[i] = st; // �迭 ��ġ
			if( i > 0 ) { // ù��° ���� �����ϰ�...
				RailWay rw = 
				 new RailWay(stations[i-1], stations[i],
					sbColor, sbOrder, i-1);
				railways[i-1] = rw; // �迭 ��ġ
			}
		}
		Station sbStartSt = stations[0]; // ���ۿ�
		Station sbEndSt = stations[stations.length-1]; // ������
		SubwayLine sbShinBundang
			= new SubwayLine(sbName, sbOrder, sbColor,
					0.0, sbStationNumber,
				stations, railways, sbStartSt, sbEndSt);
//		sbShinBundang.computeTotalDist();
//		System.out.println(sbShinBundang); // toString()�ڵ�ȣ��
		SubwayPrint.printSubwayLine(sbShinBundang, 4);// html���
	}
// ����â����.. 
// c:\dev2021\java_ws\ShapeProject\bin>java soeulmetro.MetroMain > subway_�źд缱1.html
}

/*
SubwayLine [sbName=�źд缱, sbOrder=7, sbColor=FF0000, sbTotalDist=1018.2337649086285, sbNumberOfStations=13, sbStations=[Station [stName=����, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(30,30) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����(���ʱ�û), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(90,90) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(���ʱ�û)>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����ù��ǽ�(����), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(150,150) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����ù��ǽ�(����)>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=û����Ա�, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(210,210) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<û����Ա�>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=�Ǳ�(�Ǳ���ũ��븮), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(270,270) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�Ǳ�(�Ǳ���ũ��븮)>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(330,330) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=�̱�(�д缭��뺴��), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(390,390) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�̱�(�д缭��뺴��)>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=��õ, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(450,450) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<��õ>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=������û, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(510,510) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<������û>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(570,570) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(630,630) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=�����߾�(���ִ�), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(690,690) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�����߾�(���ִ�)>��, color=FF0000, area=0.0, perimeter=0.0], Station [stName=����(����), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(750,750) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(����)>��, color=FF0000, area=0.0, perimeter=0.0]], sbRailways=[RailWay [rwSs=Station [stName=����, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(30,30) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����(���ʱ�û), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(90,90) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(���ʱ�û)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=0, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=����(���ʱ�û), stOrder=8, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(90,90) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(���ʱ�û)>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����ù��ǽ�(����), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(150,150) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����ù��ǽ�(����)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=1, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=����ù��ǽ�(����), stOrder=9, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(150,150) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����ù��ǽ�(����)>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=û����Ա�, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(210,210) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<û����Ա�>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=2, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=û����Ա�, stOrder=10, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(210,210) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<û����Ա�>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=�Ǳ�(�Ǳ���ũ��븮), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(270,270) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�Ǳ�(�Ǳ���ũ��븮)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=3, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=�Ǳ�(�Ǳ���ũ��븮), stOrder=11, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(270,270) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�Ǳ�(�Ǳ���ũ��븮)>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(330,330) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=4, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=����, stOrder=12, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(330,330) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=�̱�(�д缭��뺴��), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(390,390) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�̱�(�д缭��뺴��)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=5, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=�̱�(�д缭��뺴��), stOrder=13, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(390,390) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�̱�(�д缭��뺴��)>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=��õ, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(450,450) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<��õ>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=6, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=��õ, stOrder=14, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(450,450) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<��õ>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=������û, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(510,510) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<������û>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=7, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=������û, stOrder=15, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(510,510) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<������û>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(570,570) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=8, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=����, stOrder=16, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(570,570) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(630,630) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=9, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=����, stOrder=17, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(630,630) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=�����߾�(���ִ�), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(690,690) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�����߾�(���ִ�)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=10, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857], RailWay [rwSs=Station [stName=�����߾�(���ִ�), stOrder=18, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(690,690) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<�����߾�(���ִ�)>��, color=FF0000, area=0.0, perimeter=0.0], rwEs=Station [stName=����(����), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(750,750) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(����)>��, color=FF0000, area=0.0, perimeter=0.0], rwColor=FF0000, rwDist=84.8528137423857, rwSubwayLineNumber=7, rwOrder=11, tag=�⺻��, color=000000, strokeType=0, width=1, getDistance()=84.8528137423857]], sbStartSt=Station [stName=����, stOrder=7, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(30,30) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����>��, color=FF0000, area=0.0, perimeter=0.0], sbEndSt=Station [stName=����(����), stOrder=19, stColor=FF0000, stSubwayLineNumber=7, ptCenter=�� PT(750,750) �±�: ����[�÷�: 000000] 
, radius=20.0, tag=<����(����)>��, color=FF0000, area=0.0, perimeter=0.0], computeTotalDist()=1018.2337649086285]
*/ 