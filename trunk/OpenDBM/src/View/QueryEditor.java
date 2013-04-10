package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class QueryEditor extends JPanel {
	JTextPane editeur = new JTextPane();
	JScrollPane scroll = new JScrollPane(editeur);

	public QueryEditor() {
		this.setLayout(new BorderLayout());
		Font font = new Font("Arial", 0, 14);
		editeur.setFont(font);
		this.setBorder(BorderFactory.createTitledBorder("Editeur de requête:"));
		this.add(scroll, BorderLayout.CENTER);

		editeur.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				SQLHighlight s = new SQLHighlight(editeur);

			}
		});
	}

	class SQLHighlight {
		private String[] strsToHighlight = { "SELECT", "UPDATE", "DELETE",
				"FROM", "WHERE", "AND", "OR", "SET", "USE", "SHOW", "DROP",
				"CREATE", "TABLE", "FUNCTION", "INSERT", "VALUES", "GRANT",
				"JOIN", "LIKE" };

		public SQLHighlight(JTextPane c) {
			String text = c.getText().toUpperCase().replaceAll("\n", "");
			final StyledDocument doc = c.getStyledDocument();

			final MutableAttributeSet normal = new SimpleAttributeSet();
			StyleConstants.setForeground(normal, Color.black);
			StyleConstants.setBold(normal, false);

			SwingUtilities.invokeLater(new Runnable() {

				public void run() {
					doc.setCharacterAttributes(0, doc.getLength(), normal, true);
				}
			});

			for (String strToHL : strsToHighlight) {
				Pattern p = Pattern
						.compile("(^|\\s+)(" + strToHL + ")(\\s+|$)");
				Matcher m = p.matcher(text);
				while (m.find() == true) {
					System.out.println("Found    '" + m.group(2)
							+ "'  at position  " + m.start(2) + "-" + m.end(2)
							+ "   +++\n");
					MutableAttributeSet attri = new SimpleAttributeSet();
					StyleConstants.setForeground(attri, Color.blue);
					StyleConstants.setBold(attri, true);

					// 2 = 2eme paranthèse capturante
					final int start = m.start(2);
					final int end = m.end(2);
					final int length = end - start;
					final MutableAttributeSet style = attri;

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							doc.setCharacterAttributes(start, length, style,
									true);
						}
					});
				}
			}
		}
	}

}
