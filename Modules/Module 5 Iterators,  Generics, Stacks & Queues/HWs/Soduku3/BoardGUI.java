// This is a variation of the 8 queens board class that provides an animation
// of the recursive backtracking.
// This is modified from a version created by Stuart Reges at UW-Seattle

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class BoardGUI {
    private JButton[][] myButtons;
    private int myDelay;
    private JFrame f;

    public BoardGUI(int size) {
        f = new JFrame();
        f.setSize(60 * size + 50, 60 * size + 80);
        f.setTitle("SUDOKU SOLVER");
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        Container contentPane = f.getContentPane();

        // initialize delay and add slider to control it at bottom
        final int maxPause = 1000; // milliseconds
        final JSlider slider = new JSlider(0, maxPause - 20);
        myDelay = slider.getValue();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                myDelay = maxPause - slider.getValue();
            }
        });
        JPanel p = new JPanel();
        p.add(new JLabel("slow"));
        p.add(slider);
        p.add(new JLabel("fast"));
        contentPane.add(p, "South");

        // add buttons in the middle for the chess squares
        p = new JPanel(new GridLayout(size, size, 1, 1));
        contentPane.add(p, "Center");
        p.setBackground(Color.black);
        myButtons = new JButton[size][size];
        Font f24 = new Font("Serif", Font.BOLD, 24);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                JButton b = new JButton();
                b.setFont(f24);
                p.add(b);
                myButtons[i][j] = b;
            }

        // bring it on...
        f.setVisible(true);
        f.toFront();
    }

    public void update(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                myButtons[r][c].setText(""+board[r][c]);
            }
         }
         pause();
    }

    // pause using slider setting
    private void pause() {
        pause(myDelay);
    }

    private void pause(int delay) {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {
            throw new InternalError();
        }
    }
}
