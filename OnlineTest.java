import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
    JButton btnNext, btnBookmark;
    JLabel label;
    ButtonGroup bg;
    int m[] = new int[15];
    JRadioButton radioButton[] = new JRadioButton[5];
    int current = 0,count = 0, x = 1, y = 1, now = 0;
    OnlineTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButton[i] = new JRadioButton();
            add(radioButton[i]);
            bg.add(radioButton[i]);
        }

        btnNext = new JButton("Next Question");
        btnBookmark = new JButton("Bookmark Question");
        btnNext.addActionListener(this);
        btnBookmark.addActionListener(this);
        add(btnNext);
        add(btnBookmark);
        set();
        label.setBounds(30, 40, 450, 20);
        radioButton[0].setBounds(50, 80, 450, 20);
        radioButton[1].setBounds(50, 110, 200, 20);
        radioButton[2].setBounds(50, 140, 200, 20);
        radioButton[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 150, 30);
        btnBookmark.setBounds(270, 240, 200, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(700,600);
        Color c = new Color(149, 0, 255);
        getContentPane().setBackground(c);
    }


    /* handle all event */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNext) {
            if (qcheck())
                count = count + 1;
            current++;
            set();
            if (current == 14) {
                btnNext.setEnabled(false);
                btnBookmark.setText("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark Question")) {
            JButton bk = new JButton("Bookmark " + x);
            bk.setBounds(480, 20 + 30 * x, 150, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 14)
                btnBookmark.setText("Score");
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (qcheck())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (qcheck())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this,"You have answered " + count + " Questions correctly" );
            System.exit(0);
        }
    }


    /* SET Questions with options */
    void set() {
        radioButton[4].setSelected(true);
        if (current == 0) {
            label.setText("Que1:  Number of primitive data types in java?");
            radioButton[0].setText("6");
            radioButton[1].setText("7");
            radioButton[2].setText("8");
            radioButton[3].setText("9");
        }
        if (current == 1) {
            label.setText("Que2:  What is the size of float and double in java?");
            radioButton[0].setText("32 and 64");
            radioButton[1].setText("32 and 32");
            radioButton[2].setText("64 and 64");
            radioButton[3].setText("64 and 32");
        }
        if (current == 2) {
            label.setText("Que3: Automatic type conversion is possible in which of he possible cases?");
            radioButton[0].setText("byte to int");
            radioButton[1].setText("int to long");
            radioButton[2].setText("long to int");
            radioButton[3].setText(" short to int");
        }
        if (current == 3) {
            label.setText("Que4: When an array  is passed to a method,what does the method receive?");
            radioButton[0].setText("the reference of the array");
            radioButton[1].setText("a copy of the array");
            radioButton[2].setText("Length of the array");
            radioButton[3].setText("copy of first element");
        }
        if (current == 4) {
            label.setText("Que5: Select the valid statement to declare and initialize an array");
            radioButton[0].setText("int[] A = {}");
            radioButton[1].setText("int[] A = {1,2,3}");
            radioButton[2].setText("int[] A = (1,2,3)");
            radioButton[3].setText("int arrayA");
        }
        if (current == 5) {
            label.setText("Que6: Arrays in java are");
            radioButton[0].setText("object reference");
            radioButton[1].setText("objects");
            radioButton[2].setText("primitive data types");
            radioButton[3].setText("none");
        }
        if (current == 6) {
            label.setText("Que7:  When the object is created in java?");
            radioButton[0].setText("at run time");
            radioButton[1].setText("at compile time");
            radioButton[2].setText("depends on the code");
            radioButton[3].setText("none");
        }
        if (current == 7) {
            label.setText("Que8:  Which one of the following is not a Java feature?");
            radioButton[0].setText("Object-oriented");
            radioButton[1].setText("Use of pointers");
            radioButton[2].setText("Portable");
            radioButton[3].setText("Dynamic and Extensible");
        }
        if (current == 8) {
            label.setText("Que9: Which of these cannot be used for a variable name in Java?");
            radioButton[0].setText("identifier & keyword");
            radioButton[1].setText("identifier");
            radioButton[2].setText("keyword");
            radioButton[3].setText("none of the mentioned");
        }
        if (current == 9) {
            label.setText("Que10: What is the extension of java code files?");
            radioButton[0].setText(".js");
            radioButton[1].setText(".txt");
            radioButton[2].setText(".class");
            radioButton[3].setText(".java");
        }
        label.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            radioButton[j].setBounds(50, 80 + i, 200, 20);
    }

    /* declare right answers. */
    boolean qcheck() {
        if (current == 0)
            return (radioButton[2].isSelected());
        if (current == 1)
            return (radioButton[0].isSelected());
        if (current == 2)
            return (radioButton[1].isSelected());
        if (current == 3)
            return (radioButton[0].isSelected());
        if (current == 4)
            return (radioButton[1].isSelected());
        if (current == 5)
            return (radioButton[1].isSelected());
        if (current == 6)
            return (radioButton[0].isSelected());
        if (current == 7)
            return (radioButton[1].isSelected());
        if (current == 8)
            return (radioButton[2].isSelected());
        if (current == 9)
            return (radioButton[3].isSelected());
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Exam Portal");
}
}
