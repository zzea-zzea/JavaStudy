package text;


public class CharacterMain5 {

	// ������
	public static final char SPC = ' ';
	
	// �빮�� �ϳ��� �Է¹޾� �ҹ��ڷ� �����Ͽ� �����ϴ� �Լ�
	public static char upperToLower(char big) {
		// big ������� �Է����� �ϰ�!!! 
		// big�� �빮���� ���� �����ڵ尪���� ����.
		char small = 0; // '\0'; //0;
				// '0'�� 48������ ���ȵ�..
		small = (char)(big + SPC);
		return small;
	}
	
	// �ҹ��� �ϳ��� �Է¹޾� �빮�ڷ� �����Ͽ� �����ϴ� �Լ� 
	public static char lowerToUpper(char small) {
		// small�� �ҹ����� ���� �����ڵ尪���� ����. 97~122
		char big = (char)(small - SPC); //'\0';
		return big;
	}
	
	public static char lowerToUpper2(char small) {		
		return (char)(small - SPC);
	}
	
	
	public static void main(String[] args) {
		boolean flag = true;
		char start = 'a';//'A';
		int count = 0; // ī���� ���� ���� (�󵵼�, ���� ������ ������)
		final int ALPHABETS = 26;
		while(flag == true) { // �ݺ� ����	(å 119������)	
//			count++; // �ڽ��� ���� 1�� ������Ŵ; 
//			System.out.printf("%d�� ���� => %c \n", count, 
//					(char)(start + count - 1));			
//			System.out.printf("%d�� ���� => %c \n", count+1, 
//					(char)(start + count));
			char conv = (char)(start + count);
//			if( conv == 'k' ) // == 107 ) k�̸� �빮�ڷ� ����!!
//				conv = lowerToUpper(conv);
//			if( conv == 'q' ) // q��� �빮�ڷ� ����!!
//				conv = lowerToUpper(conv);
			if( conv == 'k' || conv == 'q' ) // or
				conv = lowerToUpper(conv);
			System.out.printf("%d�� ���� => %c \n", count+1, 
					conv);
			count++; // �ڽ��� ���� 1�� ������Ŵ; 
			//start = (char)(start + 1);
			if( count == ALPHABETS ) flag = false; // ��������
		} // �ݺ� �� loop
		System.out.println(start + "���� 26�� ���� ��� loop ����!!!");
		
	}

	

	private static void printCharWithCode(char c) {
		System.out.printf("���� %c => �ڵ尪 %d [0x%X] \n", 
				c, (int)c, (int)c); 
	}

}