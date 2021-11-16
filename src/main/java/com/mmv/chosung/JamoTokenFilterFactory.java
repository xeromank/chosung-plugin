package com.mmv.chosung;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class JamoTokenFilterFactory extends AbstractTokenFilterFactory {

	private final String PARAM_PARSER_TYPE = "parserType";  

	private JamoParserType parserType;

	public JamoTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
		super(indexSettings, name, settings);
		String parserType = settings.get(PARAM_PARSER_TYPE, JamoParserType.JAMO.name()).toUpperCase();
		this.parserType = JamoParserType.getParserTypeByString(parserType);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new JamoTokenFilter(tokenStream, parserType);
	}

}
