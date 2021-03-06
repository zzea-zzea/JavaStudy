package text;

public class TextMain3 {

	public static void main(String[] args) { // args 은 null 체크부터 lenght체크
		// String[] 문자 char의 기준으로 보면 2차원 배열의 구조와 비슷함
//		String input = "abcdeXYZJQK012789 -+*/%$@&^가나다アエイオウ";
		String input = "규진씨가 English로 アイ를 외쳤다~~!";

		if (args.length == 0) {
			printStringInformation(input);
		} else {
			for (int i = 0; i < args.length; i++) { // args.length 상수 == 입력의 갯수
				String word = args[i];
				System.out.println(i+","+word);
				printStringInformation(word);
			}
		}

	}

	private static void printStringInformation(String input) {
		// for (int i = 0; i < cntInput; i++) {
		for (int i = 0; i < input.length(); i++) { // i=>0~34
			char c = input.charAt(i);
			if (isKorean(c) == true)
				System.out.println(c + " 문자는 한국어 글자입니다.");
			else if (isEngUpper(c))
				System.out.println(c + " 문자는 영어 대문자입니다.");
			else if (isEngLower(c))
				System.out.println(c + " 문자는 영어 소문자입니다.");
			else if (isNumeric(c))
				System.out.println(c + " 문자는 숫자 문자입니다.");
			else if (isJapenese(c))
				System.out.println(c + " 문자는 일본어 가나문자입니다.");
			else if (isSpaceBar(c))
				System.out.println(c + " 문자는 공백 기호문자입니다.");
			else
				System.out.println(c + " 문자는 기타 문자입니다.");
		}
	}

	public static boolean isSpaceBar(char c) {
		return c == ' ';
	}

	public static Boolean isNumeric(char c) {
		return c >= '0' && c <= '9';
	}

	public static boolean isEngUpper(char c) {

		return c >= 'A' && c <= 'Z';
	}

	public static boolean isEngLower(char c) {
		return c >= 'a' && c <= 'z';
	}

	public static boolean isKorean(char c) {
		return c >= '가' && c <= '힣';
	}

	public static boolean isJapenese(char c) {
		return c >= 0x3041 && c <= 0x30FF;

	}

}
