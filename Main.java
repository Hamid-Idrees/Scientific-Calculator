import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    static JFrame frame; // declaring variables
    static JTextField textField;
    static JButton[] numberButtons = new JButton[10]; // dynamic button array
    static JButton[] functionButtons = new JButton[18];
    static JButton addBtn, subBtn, mulBtn, divBtn, eqBtn, decBtn, clrBtn, delBtn;
    static JButton sinBtn, cosBtn, tanBtn, lnBtn, logBtn, sqrtBtn, powBtn, invBtn;
    static JPanel panel;
    static double num1=0, num2=0, res=0;
    static char operator;

    public static void main(String[] args) {

        // create frame
        frame = new JFrame("Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 100, 400, 600);
        frame.setLayout(null);

        // our font
        Font myFont = new Font("Arial", Font.BOLD, 18);

        // create textfield
        textField = new JTextField();
        textField.setBounds(44, 50, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // create buttons
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        divBtn = new JButton("/");
        mulBtn = new JButton("*");
        eqBtn = new JButton("=");
        clrBtn = new JButton("Clear");
        delBtn = new JButton("Delete");
        decBtn = new JButton(".");

        sinBtn = new JButton("sin");
        cosBtn = new JButton("cos");
        tanBtn = new JButton("tan");
        lnBtn = new JButton("ln");
        logBtn = new JButton("log");
        sqrtBtn = new JButton("√");
        powBtn = new JButton("^");
        invBtn = new JButton("1/x");

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = clrBtn;
        functionButtons[7] = delBtn;
        functionButtons[8] = sinBtn;
        functionButtons[9] = cosBtn;
        functionButtons[10] = tanBtn;
        functionButtons[11] = lnBtn;
        functionButtons[12] = logBtn;
        functionButtons[13] = sqrtBtn;
        functionButtons[14] = powBtn;
        functionButtons[15] = invBtn;

        for(int i = 0; i<16; i++){
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delBtn.setBounds(40,500,145,50);
        clrBtn.setBounds(205,500,145,50);

        // crate panel
        panel = new JPanel();
        panel.setBounds(45,150,300,300);
        panel.setLayout(new GridLayout(6,4,5,5));
        panel.setBackground(Color.GRAY);

        // adding buttons on panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(eqBtn);
        panel.add(divBtn);
        panel.add(sinBtn);
        panel.add(cosBtn);
        panel.add(tanBtn);
        panel.add(sqrtBtn);
        panel.add(logBtn);
        panel.add(lnBtn);
        panel.add(powBtn);
        panel.add(invBtn);

        // adding components on panel
        frame.setVisible(true);
        frame.add(textField);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(panel);

        /////////////////////////////////// EVENT HANDLING ///////////////////////////////////////////

        for (int i = 0; i < 10; i++) { // loop starts
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText() + numberButtons[finalI].getText());
                }
            });
        } // loop ends

        //////////////////////////////////////////////////////////////////////////////////////////////
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + ".");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+':
                        res = num1 + num2;
                        break;
                    case '-':
                        res = num1 - num2;
                        break;
                    case '*':
                        res = num1 * num2;
                        break;
                    case '/':
                        res = num1 / num2;
                        break;
                    case '^':
                        res = Math.pow(num1, num2);
                        break;
                }

                textField.setText(String.valueOf(res));
                num1 = res;
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()) {
                    String txt = textField.getText();
                    textField.setText(txt.substring(0, txt.length() - 1));
                }
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.sin(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.cos(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.tan(Math.toRadians(Double.parseDouble(textField.getText())))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.sqrt(Double.parseDouble(textField.getText()))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.log10(Double.parseDouble(textField.getText()))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        lnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(Math.log(Double.parseDouble(textField.getText()))));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText("");
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////
        invBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(String.valueOf(1 / Double.parseDouble(textField.getText())));
            }
        });

        //////////////////////////////////////////////////////////////////////////////////////////////

    }
}