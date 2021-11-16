package com.mmv.chosung;

import java.util.HashMap;
import java.util.Map;

public enum JamoParserType {
	JAMO {
		@Override
		public IJasoParser getParser() {
			return new JamoParser();
		}
	},
	CHOSUNG {
		@Override
		public IJasoParser getParser() {
			return new ChosungParser();
		}
	};

	private static Map<String, JamoParserType> stringToEnumMap = new HashMap<>(JamoParserType.values().length);
	static {
		for (JamoParserType type : JamoParserType.values()) {
			stringToEnumMap.put(type.toString(), type);
		}
	}

	public static JamoParserType getParserTypeByString(String parserType) {
		if (stringToEnumMap.containsKey(parserType)) {
			return stringToEnumMap.get(parserType);
		}

		throw new IllegalArgumentException("[" + parserType + "] does not support.");
	}

	public abstract IJasoParser getParser();

}
