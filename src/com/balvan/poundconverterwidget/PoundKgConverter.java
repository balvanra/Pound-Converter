package com.balvan.poundconverterwidget;

public class PoundKgConverter {

	static double koef = 2.20462;

	static String convertPound2Kg(CharSequence poundStr) {
		if (poundStr == null || poundStr.length() == 0)
			return null;
		Double in = null;
		try {
			in = Double.valueOf(poundStr.toString());
		} catch (NumberFormatException e) {
			return null;
		}
		Double out = ((double) Math.round((in / koef) * 100)) / 100;

		return out.toString();
	}

	static String convertKg2Pound(CharSequence kgStr) {
		if (kgStr == null || kgStr.length() == 0)
			return null;
		Double in = null;
		try {
			in = Double.valueOf(kgStr.toString());
		} catch (NumberFormatException e) {
			return null;
		}
		Double out = ((double) Math.round((in * koef) * 100)) / 100;

		return out.toString();
	}
}
