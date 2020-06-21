package myproject.QuanLySinhVien.view;

import java.text.NumberFormat;

import javax.swing.text.NumberFormatter;

public class InputNumberFormat extends NumberFormatter {
	public InputNumberFormat(NumberFormat format) {
		super(format);
		setValueClass(Float.class);
		setMinimum(0);
		setMaximum(Float.MAX_VALUE);
		setAllowsInvalid(false);
	}
}
