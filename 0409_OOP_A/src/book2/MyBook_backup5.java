package book2;

// 클래스 class 정의 == java에서 클래스란 '새로운 타입'을 만드는 것.
// 		설계도...? 
//     객체지향적인 세상에서... (이 세상은 객체지향인 물리적으론 3차원)  
// 객체 object라는 것은 클래스의 설계대로 객체지향 세상에 만들어진 단위.
// '책'이라는 개념(스키마 Schema)을 클래스로 표현..
//  해당 스키마의 특징들을 클래스에 구성요소 삼아야 함. 
//  책을 떠올리면... 제목, 분야(장르), 저자, 출판사, 쪽수, 가격 (바코드), 표지..
// 클래스는 이런 특징을 개별 변수들로 표현하지 않고, 그 변수들을 하나의 클래스 범위 묶음.
// 여기에 스키마에 처리에 관계된 기능들을 함수로써 해당 클래스 포함해서 구현함.
// 즉, 클래스는 고유 데이터 구성요소(필드,속성property) + 고유 기능 (함수;메소드)들로 표현됨. 
// class = fields + methods
// 변수 구성요소, 상수 구성요소, 함수 구성요소(메소드)
// 클래스는 새로운 타입을 위해 "데이터 + 기능"을 하나로 묶은 설계 도면. (blueprint)
// java에서는 특정 클래스의 객체를 자바 JVM메모리 세상에 태어나게 하기 위해 
// 반드시 new의 과정을 거치며... new 정상으로수행되면 객체로 활동함.

// book2.MyBook 타입 정의   !=  book.MyBook 다름..

// 책스키마 표현 (설계도)
public class MyBook_backup5 {	
	// 데이터 표현 (필드) ------------
	// (공통) 상수 필드
	public static final int DEF_PRICE = 2900; 
	public static final String DEF_GENRE = "소설";
	public static final String DEF_TITLE = "제목없음";// null보단 좋아..
	public static final String DEF_AUTHOR = "저자없음";
	public static final int DEF_PUB = 0;
	public static final String DEF_ISBN = "0000000000123";
	public static final String NO_COMMENT = "댓글없음";
	
	// 변수 필드 (멤버변수) // v1.0
	// public 으로 선언하면 패키지가 다른 클래스들에서도 사용가능함.
	public int no; // 번호 numeric order
	//int no; // 번호 numeric order
	public String bookTitle; // 제목
	public String bookGenre; // 분야(장르)
	public String bookAuthor; // 저자(이름)
	public int bookPages; // 쪽수 (pp)
	public int bookPrice; // 가격 (원)
	// 스키마 변경됨... // v1.1
	public int publisher; // 출판사 (번호)
	public String ISBN; // 바코드/국제표준서적번호(인덱스 13자리..)
	public float rate; // 평점 5점만점 척도 0.0 ~ 5.0
	public String comment; // 코멘트
	
	
	// 생성자 함수 정의 (클래스와 이름이 동일하면서 반드시 new로 호출되는 함수로, 
	//      생성된 메모리의 객체의 필드들 등을 초기화하는 역할)
	//   클래스로 특정 객체를 생성할 때 오직 단 한번만 호출됨.
	// 생성자 함수는 리턴형이 없다.. 하지만..!! 
	// 생성자 함수는 반드시 실행 후  초기화를 마친 객체의 주소를 내부적으로 리턴함. 
//	public MyBook() { 
//		// 더미 생성자 함수 (dummy) - 기본 생성자
//		// 
//		// 클래스의 new로 만들어진 공간에 개체를 각 필드형의 기본값으로 자동초기화 함.
//		// 정수형 0, long 0L, 실수형 0.0, float 0.0f, 문자형 '\0', 
//		// 논리형 false, 레퍼런스형(클래스형, 배열형...) null 로 초기화.
//	}
	
	public MyBook_backup5() { // 기본 생성자.. default, basic, dummy
		bookTitle = DEF_TITLE; 
		bookAuthor = DEF_AUTHOR;
		bookGenre = DEF_GENRE; //"IT 개발";		
		bookPrice = DEF_PRICE; //원		
		publisher = DEF_PUB;		
		ISBN = DEF_ISBN;
		comment = NO_COMMENT;
		bookPages = 0;// pp
		no = 0;
		rate = 0.0f;
		
		// 생략이 가능하나 생락말자..
//		bookPages = 0;// pp
//		no = 0;
//		rate = 0.0f;
		System.out.println("1번 MyBook() 생성자 실행됨");
	}
	
	// 풀 설정 생성자 full
	public MyBook_backup5(String newbookTitle, String bookAuthor, 
			String bookGenre, int bookPages, int bookPrice, 
			int no, int publisher, float rate, 
			String ISBN, String comment) {
//		bookTitle = bookTitle; // 인자변수 = 인자변수 저장?;
			// 이름 충돌? 지역변수가 필드와 연결이 안됨?
		//this 객체 자기 자신의 주소 자체를 표현하는 것.
		// this.ooo로 모든 필드와 모든 메소드(함수)를 선택할 수 있음.
		// this.ABC는  그냥 ABC와 다른 이름? 이름공간(namespace) 
//		this.bookTitle = bookTitle;
//		this.bookTitle = newbookTitle;
		bookTitle = newbookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre; //"IT 개발";
		this.bookPages = bookPages;// pp
		this.bookPrice = bookPrice; //원
		this.no = no;
		this.publisher = publisher;
		this.rate = rate;
		this.ISBN = ISBN;
		this.comment = comment;
	
		System.out.println("3번 MyBook() 생성자 실행됨");
	}	
	
	// 생성자 함수 오버로딩 - 모든 필드 (Full) 풀생성자
//	public MyBook(String newTitle, String newAuthor, 
//			String newGenre, int newPages, int newPrice, 
//			int newNo, int newPublisher, float newRate, 
//			String newISBN, String newComment) {
//		bookTitle = newTitle; 
//		bookAuthor = newAuthor;
//		bookGenre = newGenre; //"IT 개발";
//		bookPages = newPages;// pp
//		bookPrice = newPrice; //원
//		no = newNo;
//		publisher = newPublisher;
//		rate = newRate;
//		ISBN = newISBN;
//		comment = newComment;
//	}
	
	
	
	// 기능 표현 (메소드; 멤버함수)
//	public void printBook() {
//		//String bookTitle;
//		System.out.println("BOOK");
//		System.out.println("\t 제목: " + bookTitle);
//		System.out.println("\t 분야: " + bookGenre);
//		System.out.println("\t 가격(정가제): " + bookPrice +"won");
//		System.out.println("\t 저자: '" + bookAuthor + "'님");
//		System.out.println("\t 쪽수: " + bookPages + "pp");
//		System.out.println("-----------------------------");
//	}
	
	// 객체의 각 필드를 기본 초기화하는 함수 (객체 초기화 initialization 함수)
	public void init() {
		bookTitle = "자바가 제일 쉬워요!"; 
		bookAuthor = "제임스 고즐링";
		bookGenre = DEF_GENRE; //"IT 개발";
		bookPages = 500;// pp
		bookPrice = DEF_PRICE; //원
		no = 1;
		publisher = 5;
		rate = 4.12f;
		ISBN = "9876543210111";
		comment = "쉽지 않았어요... ";
	}
	
	// 필드 입력을 모두 받아서 객체를 초기화하는 함수 
	// 함수 오버로딩(Overloading 다형성 -- 함수 호출시 인자의 개수와 타입으로
	// 해당 함수 정의를 실행)
	public void init(String newTitle, String newAuthor, 
			String newGenre, int newPages, int newPrice, 
			int newNo, int newPublisher, float newRate, 
			String newISBN, String newComment) {
		bookTitle = newTitle; 
		bookAuthor = newAuthor;
		bookGenre = newGenre; //"IT 개발";
		bookPages = newPages;// pp
		bookPrice = newPrice; //원
		no = newNo;
		publisher = newPublisher;
		rate = newRate;
		ISBN = newISBN;
		comment = newComment;
		System.out.println("별도의 init() 초기화 실행...");
	}
	
	// 객체의 각 필드 변수 출력 메소드(함수)
	public void printBook() {
		//String bookTitle;
		System.out.println("BOOK " + no);
		System.out.println("\t 제목: " + bookTitle);
		System.out.println("\t 분야: " + bookGenre);
		System.out.println("\t 가격(정가제): " + bookPrice +"won");
		System.out.println("\t 저자: '" + bookAuthor + "'님");
		System.out.println("\t 쪽수: " + bookPages + "pp");
		System.out.println("\t 출판사 번호: " + publisher);
		System.out.println("\t ISBN: " + ISBN);
		System.out.println("\t 평점: " + rate);
		System.out.println("\t 리뷰코멘트: " + comment);
		System.out.println("-----------------------------");
	}
}





