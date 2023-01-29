package view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DynamicListDemo {

    private String[] defaultValues =  {
        "a", "ab", "abc", "abcd", "abcde", "abcdef", "absdefg", "abcdefgh",
        "abcdefghi", "abcdefghij", "abcdefghijk", "abcdefghijkl", "abcdefghijklm",
    };
    private JList<String> jList = createJList();

    public DynamicListDemo() {
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(jList));
        frame.add(createTextField(), BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JTextField createTextField() {
        final JTextField field = new JTextField(15);
        field.getDocument().addDocumentListener(new DocumentListener(){
            @Override public void insertUpdate(DocumentEvent e) { filter(); }
            @Override public void removeUpdate(DocumentEvent e) { filter(); }
            @Override public void changedUpdate(DocumentEvent e) {}
			private void filter() {
                String filter = field.getText();
                filterModel((DefaultListModel<String>)jList.getModel(), filter);
            }
        });
        return field;
    }

    private JList<String> createJList() {
        JList<String> list = new JList<String>(createDefaultListModel());
        list.setVisibleRowCount(6);
        return list;
    }

    private ListModel<String> createDefaultListModel() {
        DefaultListModel<String> model = new DefaultListModel<>();
        for (String s : defaultValues) {
            model.addElement(s);
        }
        return model;
    }

    public void filterModel(DefaultListModel<String> model, String filter) {
        for (String s : defaultValues) {
            if (!s.startsWith(filter)) {
                if (model.contains(s)) {
                    model.removeElement(s);
                }
            } else {
                if (!model.contains(s)) {
                    model.addElement(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new DynamicListDemo();
            }
        });
    }
}
