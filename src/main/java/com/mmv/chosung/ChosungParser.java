package com.mmv.chosung;

public class ChosungParser extends AbstractJamoParser {

	@Override
	protected void processWhenKorean(StringBuilder meanningfulChars, char chosung, char jungsung, char jongsung) {
		meanningfulChars.append(chosung);

	}

	@Override
	protected void processWhenNotKorean(StringBuilder meanningfulChars, char eachToken) {

	}

}
