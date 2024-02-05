package number.guessing.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Game extends JFrame implements ActionListener {
    JTextField text,t1;
    JButton check;
    int number,i,trials=5;;
    Game(){
        setLayout(null);

        JLabel l1 = new JLabel("A number chosen between 1 to 100");
        l1.setBounds(80,20,400,20);
        l1.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        add(l1);

        JLabel l2 = new JLabel("You have only 5 trials");
        l2.setBounds(140,50,250,20);
        l2.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        add(l2);

        JLabel guess = new JLabel("GUESS THE NUMBER...?");
        guess.setBounds(120,100,400,20);
        guess.setFont(new Font("SAN_SERIF",Font.BOLD,24));
        guess.setForeground(Color.yellow);
        add(guess);

        text = new JTextField();
        text.setBounds(200,140,100,60);
        text.setHorizontalAlignment(JTextField.CENTER);
        text.setFont(new Font("SAN_SERIF",Font.BOLD,28));
        add(text);

        check = new JButton("CHECK");
        check.setBounds(210,210,80,25);
        check.setFont(new Font("SAN_SERIF",Font.BOLD,12));
        check.addActionListener(this);
        add(check);

        t1 = new JTextField("");
        t1.setBounds(50,270,410,80);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        t1.setBackground(new Color(136,136,136));
        t1.setBorder(BorderFactory.createLineBorder(new Color(136,136,136)));
        add(t1);


        Scanner sc = new Scanner(System.in);
        number = 1 + (int)(100 * Math.random());


        setSize(500,400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(136,136,136));
        setUndecorated(true);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if (e.getSource() == check && i!= trials) {
                i++;
                int guessno = Integer.parseInt(text.getText());
                if (number == guessno) {
                    t1.setText("Congratulations! You guessed the number");
                    t1.setForeground(Color.green);
                    switch (i) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Your score is 100 ");
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null, "Your score is 80 ");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null, "Your score is 60 ");
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null, "Your score is 40 ");
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Your score is 20 ");
                            break;
                    }
                } else if (number > guessno) {
                    t1.setText("The number is greater than " + guessno);
                    t1.setForeground(Color.orange);
                } else if (number < guessno) {
                    t1.setText("The number is less than " + guessno);
                    t1.setForeground(Color.orange);
                }
            }
           else if (i >= trials) {
                t1.setText("OOPS!\n"+"You trials are over\n"+"The number was " + number);
                t1.setForeground(Color.red);
                }
        }catch (Exception ae){
            System.out.println(ae);
        }
    }
    public static void main(String[] args) {
        new  Game();
    }
}