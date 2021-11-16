package com.mmv.chosung;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class JamoTokenFilter extends TokenFilter {
	private final CharTermAttribute termAttribute = addAttribute(CharTermAttribute.class);
	private IJasoParser parser;

	protected JamoTokenFilter(TokenStream input, JamoParserType parserType) {
		super(input);
		this.parser = parserType.getParser();
	}

	@Override
	public final boolean incrementToken() throws IOException {
		
		if (input.incrementToken()) {  
			CharSequence parsedData = this.parser.parse(termAttribute.toString());
			termAttribute.setEmpty().append(parsedData);
			return true;
        }  
		
		return false;
	}

}
