package com.mmv.chosung;

public abstract class AbstractJamoParser implements IJasoParser {

	// Unicode 호환형 자모의 초성 CodePoint
	protected final char[] COMPATIBILITY_CHOSUNGs = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, // ㄱ, ㄲ, ㄴ, ㄷ, ㄸ
			0x3139, 0x3141, 0x3142, 0x3143, 0x3145, // ㄹ, ㅁ, ㅂ, ㅃ, ㅅ
			0x3146, 0x3147, 0x3148, 0x3149, 0x314A, // ㅆ, ㅇ, ㅈ, ㅉ, ㅊ
			0x314B, 0x314C, 0x314D, 0x314E // ㅋ, ㅌ, ㅍ, ㅎ
	};
	// Unicode 호환형 자모의 중성 CodePoint
	protected final char[] COMPATIBILITY_JUNGSUNGs = { 0x314F, 0x3150, 0x3151, 0x3152, 0x3153, // ㅏ, ㅐ, ㅑ, ㅒ, ㅓ
			0x3154, 0x3155, 0x3156, 0x3157, 0x3158, // ㅔ, ㅕ, ㅖ, ㅗ, ㅘ
			0x3159, 0x315A, 0x315B, 0x315C, 0x315D, // ㅙ, ㅚ, ㅛ, ㅜ, ㅝ
			0x315E, 0x315F, 0x3160, 0x3161, 0x3162, // ㅞ, ㅟ, ㅠ, ㅡ, ㅢ
			0x3163 // ㅣ
	};
	// Unicode 호환형 자모의 종성 CodePoint
	protected final char[] COMPATIBILITY_JONGSUNG = { 0x0000, 0x3131, 0x3132, 0x3133, 0x3134, // 채움, ㄱ, ㄲ, ㄳ, ㄴ
			0x3135, 0x3136, 0x3137, 0x3139, 0x313A, // ㄵ, ㄶ, ㄷ, ㄹ, ㄺ
			0x313B, 0x313C, 0x313D, 0x313E, 0x313F, // ㄻ, ㄼ, ㄽ, ㄾ, ㄿ
			0x3140, 0x3141, 0x3142, 0x3144, 0x3145, // ㅀ, ㅁ, ㅂ, ㅄ, ㅅ
			0x3146, 0x3147, 0x3148, 0x314A, 0x314B, // ㅆ, ㅇ, ㅈ, ,ㅊ, ㅋ
			0x314C, 0x314D, 0x314E // ㅌ, ㅍ, ㅎ
	};

	@Override
	public final String parse(String token) {
		StringBuilder result = new StringBuilder();

		if (null != token && !"".equals(token)) {
			char ch, expectedKorean;
			int chosung, jungsung, jongsung;

			for (int i = 0, length = token.length(); i < length; i++) {
				ch = token.charAt(i);
				expectedKorean = (char) (ch - UNICODE_SYLLABLES_START_CODEPOINT);

				// 현재의 char가 Unicode 한글 소리 마디, 즉 완성형에 포함되면
				// 자모 분해가 가능하므로 분리
				if (expectedKorean >= 0 && expectedKorean <= COUNT_IN_UNICODE) {
					chosung = expectedKorean / JAMO_SPLIT_VALUE;
					jungsung = expectedKorean % JAMO_SPLIT_VALUE / COUNT_JONGSUNG_IN_UNICODE;
					jongsung = expectedKorean % JAMO_SPLIT_VALUE % COUNT_JONGSUNG_IN_UNICODE;

					processWhenKorean(result, COMPATIBILITY_CHOSUNGs[chosung], COMPATIBILITY_JUNGSUNGs[jungsung],
							COMPATIBILITY_JONGSUNG[jongsung]);
				}
				// 자모 분해가 불가하다면 Letter일 경우 결과 셋에 추가
				else {
					processWhenNotKorean(result, ch);
				}
			}
		}

		return result.toString();
	}

	protected abstract void processWhenKorean(StringBuilder meanningfulChars, char chosung, char jungsung,
			char jongsung);

	protected abstract void processWhenNotKorean(StringBuilder meanningfulChars, char eachToken);

}
