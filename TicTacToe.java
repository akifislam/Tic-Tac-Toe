//package Akif;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TicTacToe implements WindowListener {
    int count = 0;
    JFrame GameResult;
    Frame frame;
    int checkWin = 0;
    int checkDraw = 0;
    Label[] label = new Label[9];
    Button[] buttons = new Button[9];
    Font fonts = new Font("Times New Roman", Font.BOLD, 50);


    // Constructor
    TicTacToe() {
        prepareBackground();
        Play();
        frame.addWindowListener(this);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
    TicTacToe Game = new TicTacToe();
    }




    void prepareBackground() {
        frame = new Frame("3rd Try ! The Akif Game");
        frame.setLayout(new GridLayout(3, 3));
        frame.setSize(500, 390);
        frame.setLocation(400, 220);
        frame.setResizable(false);
        frame.setBackground(Color.darkGray);
        frame.setForeground(Color.WHITE);

    }

    void Play() {
        for (int i = 0; i < 9; i++) {

            final int II = i;
            buttons[i] = new Button("-");
            buttons[i].setBackground(Color.darkGray);
            buttons[i].setForeground(Color.white);
            buttons[i].setFont(fonts);
            frame.add(buttons[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    System.out.println("COUNT VALUE : " + count);
                    if (buttons[II].getLabel().contains("-") && (count % 2 == 0) && (e.getSource() == buttons[II]))
                        buttons[II].setLabel("X");
                    else if ((buttons[II].getLabel().contains("-"))) buttons[II].setLabel("O");
                    count++;

                    // ------------------------------------------------------

                    // Winning Condition 01 - ALL ROWS :
                    for (int j = 0; j < 9; j = j + 3) {
                        System.out.println(j);
                        if ((buttons[j].getLabel() != "-") &&
                                (buttons[j].getLabel() == buttons[j + 1].getLabel()) &&
                                (buttons[j + 1].getLabel() == buttons[j + 2].getLabel())) {
                            checkWin = 1;
                            System.out.println("Row Winner !");
                        }

                    }
                    // Winning Condition : 02 - All Columns
                    for (int j = 0; j < 3; j++) {
                        if ((buttons[j].getLabel() != "-") &&
                                (buttons[j].getLabel() == buttons[j + 3].getLabel()) &&
                                (buttons[j + 3].getLabel() == buttons[j + 6].getLabel())) {
                            checkWin = 1;
                            System.out.println("Column Winner !");
                        }

                    }
                    // Winning Condition : 03 - Left Diagonal
                    if ((buttons[0].getLabel() != "-") &&
                            (buttons[0].getLabel() == buttons[4].getLabel()) &&
                            (buttons[4].getLabel() == buttons[8].getLabel())) {
                        checkWin = 1;
                        System.out.println("Left Diagonal Winner !");
                    }

                    // Winning Condition : 04 - Right Diagonal
                    if ((buttons[2].getLabel() != "-") &&
                            (buttons[2].getLabel() == buttons[4].getLabel()) &&
                            (buttons[4].getLabel() == buttons[6].getLabel())) {
                        checkWin = 1;
                        System.out.println(" Right Diagonal Winner !");
                    }
                    if (checkWin == 1) {
                        String OX = buttons[II].getLabel();
                        JOptionPane.showMessageDialog(frame, "Winner : " + OX);

                    }

                    // Check Draw
                    for (int p = 0; p < 9; p++) {
                        if ((count == 9) && (checkWin != 1))
                            JOptionPane.showMessageDialog(frame, "DRAW !");
                    }
                }


            });

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

