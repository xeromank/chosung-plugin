package com.mmv.chosung;

import static java.util.Collections.singletonMap;

import java.util.Map;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

public class ChosungPlugin extends Plugin implements AnalysisPlugin{
	
	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return singletonMap("chosung_filter", JamoTokenFilterFactory::new);
    }
}
