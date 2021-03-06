package HomeWork_0309;
/* 
	?­?¨    <==>   ??¨   ?¨? λ³??κΈ? 

	https://ko.wikipedia.org/wiki/%EC%84%AD%EC%94%A8

1) ?¨? ?¨? λ³?? ?¨? cToF(), fToC() κ΅¬ν??¬ ?€?
  
2) μΆλ ₯?¨? printResult() λ³λ κ΅¬ν. 
	λͺ¨λ  ?€? float ?? ₯κ³? μΆλ ₯?? ???  2?λ¦¬κΉμ§? ??.

// μΆλ ₯ ?
// 
//========= ?¨?λ³??κΈ? ===========
//	?? ₯: 36.50C (?­?¨) 
//	κ²°κ³Ό: ??.??F (??¨)
//-----------------------------			
//	?? ₯: 80.00F (??¨) 
//	κ²°κ³Ό: ??.??C (?­?¨)
//=============================

3) inputC?? inputFλ₯? ??€? λ²μ? ?¨?κ°? ?? ₯??¬ ?€??΄λ³΄κΈ°. 
	Math.random() ?¬?©, 
	?­?¨ λ²μ: -20.00 ~ +40.00 (?? λ―Έν¬?¨) 
	??¨ λ²μ: 4.00 ~ 104.00 (λ―Έλ§)

*/
public class TemperatureMain_0309 {

	public static void main(String[] args) {
		float inputC = 36.50f; //?­?¨
		float inputF = 80.00f; //??¨
		float inputCR = (float)((Math.random()*60)-20); //?­?¨
		float inputFR = (float)((Math.random()*100)+4); //??¨
		
		printResult(inputC,inputF);
		printResult(inputCR,inputFR);
	}

	private static void printResult(float inputC,float inputF) {
		System.out.println("========= ?¨?λ³??κΈ? ===========");
		System.out.printf("?? ₯: %.2fC (?­?¨)\n",inputC);
		System.out.printf("κ²°κ³Ό: %.2fF (??¨)\n",cToF(inputC));
		System.out.println("--------------------------------");
		System.out.printf("κ²°κ³Ό: %.2fF (??¨)\n",inputF);
		System.out.printf("?? ₯: %.2fC (?­?¨)\n",fToC(inputF));
		System.out.println("=============================");
	}

	/*++++++++     Β°F -> Β°C (?­?¨->??¨)     ++++++++*/      
	public static float cToF(float c) {
		float f = 0.0f;
		f = (float)(c * 1.8 + 32) ; // Β°F = Β°C Γ 1.8 + 32
		return f;
	}
	
	/*++++++++     Β°C -> Β°F (??¨->?­?¨)    ++++++++*/      
	public static float fToC(float f) {
		float c = 0.0f;
		 c = (float)((f - 32) / 1.8f); // Β°C = (Β°F ? 32) / 1.8
		return c;
	}
}

