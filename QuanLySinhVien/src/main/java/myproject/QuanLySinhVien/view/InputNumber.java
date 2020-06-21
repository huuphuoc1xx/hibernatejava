package myproject.QuanLySinhVien.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class InputNumber extends JTextField {
	public InputNumber() {
		addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      if (!((c >= '0') && (c <= '9') ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE)||c=='.')) {
			        getToolkit().beep();
			        e.consume();
			      }
			    }
		});
	}
}
