package SuperShopBillingSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame {

    private Container c;
    private Font f;
    private JLabel username, userphone, sp, sq, total;
    private JTextField tf_1, tf_2;
    private JButton bt_1, bt_2;
    private Cursor cursor;
    private JTextArea ta_1;
    private JComboBox cb_1, cb_2;
    private JTable table;
    private DefaultTableModel defaulttable;
    private JScrollPane scroll;

    private String[] products = {"Rice", "Oil", "Chicken", "Apple", "Egg"};
    private String[] quantity = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private String[] column = {"Product", "Quantity", "Price", "Total"};
    private String[] row = new String[4];
    private int totalprice = 0;

    MainFrame() {
        initcomponents();
    }

    public void initcomponents() {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);

        f = new Font("Arial", Font.BOLD, 18);
        cursor = new Cursor(Cursor.HAND_CURSOR);

        username = new JLabel();
        username.setText("Enter Customer Name :");
        username.setBounds(50, 20, 220, 50);
        username.setFont(f);
        username.setForeground(Color.BLUE);
        c.add(username);

        tf_1 = new JTextField();
        tf_1.setBounds(280, 20, 300, 50);
        tf_1.setFont(f);
        c.add(tf_1);

        userphone = new JLabel();
        userphone.setText("Enter Phone Number :");
        userphone.setBounds(600, 20, 220, 50);
        userphone.setFont(f);
        userphone.setForeground(Color.BLUE);
        c.add(userphone);

        tf_2 = new JTextField();
        tf_2.setBounds(830, 20, 300, 50);
        tf_2.setFont(f);
        c.add(tf_2);

        bt_1 = new JButton("Save");
        bt_1.setBounds(1180, 20, 150, 50);
        bt_1.setFont(f);
        bt_1.setBackground(Color.CYAN);
        bt_1.setCursor(cursor);
        c.add(bt_1);

        sp = new JLabel();
        sp.setText("Select Product :");
        sp.setBounds(50, 100, 200, 50);
        sp.setFont(f);
        sp.setForeground(Color.BLUE);
        c.add(sp);

        sq = new JLabel("Select Quantity :");
        sq.setText("Select Quantity :");
        sq.setBounds(50, 180, 200, 50);
        sq.setFont(f);
        sq.setForeground(Color.BLUE);
        c.add(sq);

        cb_1 = new JComboBox(products);
        cb_1.setBounds(300, 100, 200, 50);
        cb_1.setEditable(true);
        c.add(cb_1);

        cb_2 = new JComboBox(quantity);
        cb_2.setBounds(300, 180, 200, 50);
        cb_2.setEditable(true);
        c.add(cb_2);

        bt_2 = new JButton("Add");
        bt_2.setBounds(350, 260, 150, 50);
        bt_2.setFont(f);
        bt_2.setBackground(Color.CYAN);
        bt_2.setCursor(cursor);
        c.add(bt_2);

        table = new JTable();
        defaulttable = new DefaultTableModel();
        defaulttable.setColumnIdentifiers(column);
        table.setModel(defaulttable);
        table.setFont(f);
        table.setRowHeight(30);
        scroll = new JScrollPane(table);
        scroll.setBounds(830, 150, 600, 400);
        c.add(scroll);

        total = new JLabel("Total : 0");
        total.setBounds(1230, 550, 200, 50);
        total.setFont(f);
        total.setForeground(Color.BLUE);
        c.add(total);

        bt_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a = tf_1.getText();
                String b = tf_2.getText();
                ta_1 = new JTextArea();
                ta_1.setBounds(830, 100, 600, 50);
                ta_1.setFont(f);
                c.add(ta_1);
                ta_1.setText("  Name:  " + a + "\n" + "  Phone:  " + b);
                tf_1.setText("");
                tf_2.setText("");
            }
        });

        bt_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String c = (String) (cb_1.getSelectedItem());
                int d = Integer.parseInt(cb_2.getSelectedItem().toString());
                if (c == "Rice") {
                    row[0] = c;
                    row[1] = String.valueOf(d);
                    row[2] = String.valueOf(70);
                    row[3] = String.valueOf(d * 70);
                    defaulttable.addRow(row);
                    totalprice = totalprice + (d * 70);
                } else if (c == "Oil") {
                    row[0] = c;
                    row[1] = String.valueOf(d);
                    row[2] = String.valueOf(140);
                    row[3] = String.valueOf(d * 140);
                    defaulttable.addRow(row);
                    totalprice = totalprice + (d * 140);
                } else if (c == "Chicken") {
                    row[0] = c;
                    row[1] = String.valueOf(d);
                    row[2] = String.valueOf(170);
                    row[3] = String.valueOf(d * 170);
                    defaulttable.addRow(row);
                    totalprice = totalprice + (d * 170);
                } else if (c == "Apple") {
                    row[0] = c;
                    row[1] = String.valueOf(d);
                    row[2] = String.valueOf(150);
                    row[3] = String.valueOf(d * 150);
                    defaulttable.addRow(row);
                    totalprice = totalprice + (d * 150);
                } else if (c == "Egg") {
                    row[0] = c;
                    row[1] = String.valueOf(d);
                    row[2] = String.valueOf(9);
                    row[3] = String.valueOf(d * 9);
                    defaulttable.addRow(row);
                    totalprice = totalprice + (d * 9);
                }

                total.setText("Total : " + totalprice);
            }
        });
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(50, 100, 1500, 800);
        frame.setTitle("Super Shop Billing System");
    }
}
