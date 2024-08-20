import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main implements ActionListener {
    private String expression = "";
    private JTextField tf;
    private JButton[] b = new JButton[10];
    private JButton addition, sub, mul, div, eq, cl;

    public Main() {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(300, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        tf = new JTextField();
        tf.setBounds(0, 0, 200, 30);
        tf.setHorizontalAlignment(JTextField.LEFT);

        frame.add(tf);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 5, 5, 5));
        p.setBounds(0, 30, 200, 200);

        for (int i = 0; i < 10; i++) {
            b[i] = new JButton("" + i);
            b[i].addActionListener(this);
            p.add(b[i]);
        }

        addition = new JButton("+");
        addition.addActionListener(this);
        sub = new JButton("-");
        sub.addActionListener(this);
        mul = new JButton("*");
        mul.addActionListener(this);
        div = new JButton("/");
        div.addActionListener(this);
        eq = new JButton("=");
        eq.addActionListener(this);
        cl = new JButton("C");
        cl.addActionListener(this);

        p.add(addition);
        p.add(sub);
        p.add(mul);
        p.add(div);
        p.add(eq);
        p.add(cl);
        frame.add(p);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String res = e.getActionCommand();

        if (res.matches("\\d")) {
            expression += res;
            tf.setText(expression);
        } else if (res.equals("C")) {
            expression = "";
            tf.setText("");
        } else if (res.equals("=")) {
            try {
                String result = eval(expression);
                tf.setText(result);
                expression = result;
            } catch (Exception ex) {
                tf.setText("Error");
                expression = "";
            }
        } else {
            expression += res;
            tf.setText(expression);
        }
    }

    private String eval(String expr) {

            expr = expr.replace(" ", "");
            double result = 0;
            char operator = '+';
            int len = expr.length();
            int i = 0;

            while (i < len) {
                StringBuilder numBuffer = new StringBuilder();
                while (i < len && (Character.isDigit(expr.charAt(i)) || expr.charAt(i) == '.')) {
                    numBuffer.append(expr.charAt(i++));
                }
                double number = Double.parseDouble(numBuffer.toString());
                switch (operator) {
                    case '+':
                        result += number;
                        break;
                    case '-':
                        result -= number;
                        break;
                    case '*':
                        result *= number;
                        break;
                    case '/':
                        if (number == 0) {
                            return "Error: Division by zero";
                        }
                        result /= number;
                        break;
                }
                if (i < len) {
                    operator = expr.charAt(i++);
                }
            }

            return String.valueOf(result);

    }

    public static void main(String[] args) {
        new Main();
    }
}
