package com.mmv.chosung;

public class JamoParser extends AbstractJamoParser {

	private final char CHAEUM_POINT = 0x0000;

	@Override
	protected void processWhenKorean(StringBuilder meanningfulChars, char chosung, char jungsung, char jongsung) {
		meanningfulChars.append(chosung).append(jungsung);

		if (jongsung != CHAEUM_POINT) {
			meanningfulChars.append(jongsung);
		}

	}

	@Override
	protected void processWhenNotKorean(StringBuilder meanningfulChars, char eachToken) {
		if (Character.isLetterOrDigit(eachToken)) {
			meanningfulChars.append(eachToken);
		}
	}

}
