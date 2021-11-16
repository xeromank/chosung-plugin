package com.mmv.chosung;

public interface IJasoParser {
	// 한글 소리 마디의 Unicode 시작 지점 (가)  
   char UNICODE_SYLLABLES_START_CODEPOINT = 0xAC00;  
     
   // 한글의 Unicode 총 글자 수  
   int COUNT_IN_UNICODE = 11_172;  
   // 한글 중성의 Unicode 총 글자 수  
   int COUNT_JUNGSUNG_IN_UNICODE = 21;  
   // 한글 종성의 Unicode 총 글자 수  
   int COUNT_JONGSUNG_IN_UNICODE = 28;  
 
   // 한글 자모 분해의 계산 기본 값 (중성 글자 수 * 종성 글자 수)  
   int JAMO_SPLIT_VALUE = COUNT_JUNGSUNG_IN_UNICODE * COUNT_JONGSUNG_IN_UNICODE;  
     
   CharSequence parse(String token);


}
