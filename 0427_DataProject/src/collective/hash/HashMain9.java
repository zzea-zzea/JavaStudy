package collective.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMain9 {

	public static void main(String[] args) {
		// 한글 문자 리스트?
		ArrayList<Character> cList1
						= new ArrayList<>();
		for(char c = '가'; c <= '힣'; c++ ) {
//			cList1.add( new Character(c));
			cList1.add(c);
		}
		for (int i = 0; i < cList1.size(); i++) {
			System.out.print(cList1.get(i) +" ");
			if( (i + 1) % 10 == 0)
				System.out.println();
		}
		
		// 영웅팀맵: 맵의 요소가 리스트인 경우
		// 리스트의 요소가 맵인 경우..?
		
		// 문자열키  => 문자밸류 맵을 표현 
		// 리스트의 요소로써 이 맵을 순서대로 저장.
		
		// 영문 문자맵(?) 리스트
		// 영문 문자맵 객체 요소의 키는 String값은 모드이름
		//		https://www.compart.com/en/unicode/U+0041
		// 		영문 대문자UPPER 모드,  
		//  	https://www.compart.com/en/unicode/U+0061
		//		영문 소문자LOWER 모드...
		//		
		// 		영문 서클문자 CIRCLE 모드...
		//
		//		영문 스퀘어문자 SQUARE 모드...
		
		ArrayList<HashMap<String,Character>>
			cList2 = new ArrayList<>();
		
		// 영문 대문자 탐색 루프 A ~ Z
		for (char c = 'A'; c <= 'Z'; c++) {
			HashMap<String,Character>
			 eng = new HashMap<String,Character>();
			eng.put("UPPER", c); // 'A'
			eng.put("LOWER", (char)(c+' ')); // 'a' = 'A' + 32
			//
			cList2.add(eng);
		}
	}

}

