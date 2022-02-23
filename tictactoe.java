import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class tictactoe implements ActionListener{

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];

    boolean player1_turn;
    
    tictactoe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Arial", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBackground(new Color(150,150,150));

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));

        for(int i=0; i<9; i++){
            button[i] = new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("Arial", Font.BOLD, 120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
        }

        title_panel.add(textfield, BorderLayout.CENTER);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel, BorderLayout.CENTER);

        player1_turn();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++){
            if(e.getSource() == button[i]){
                if(player1_turn){
                    button[i].setText("X");
                    button[i].setForeground(new Color(255,0,0));
                    button[i].setEnabled(false);
                    player1_turn = false;
                    textfield.setText("Player 2's turn");
                }
                else{
                    button[i].setText("O");
                    button[i].setForeground(new Color(0,0,255));
                    button[i].setEnabled(false);
                    player1_turn = true;
                    textfield.setText("Player 1's turn");
                    check();
                }
            }
        }
    }

    public void player1_turn(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1_turn = true;
            textfield.setText("Player 1's turn");
        }
        else{
            player1_turn = false;
            textfield.setText("Player 2's turn");
        }
    }

    //fix
    public void check(){
        if( (button[0].getText()=="X") && (button[1].getText()=="X") && (button[2].getText()=="X") ){
            button[0].setForeground(new Color(255,0,0));
            button[1].setForeground(new Color(255,0,0));
            button[2].setForeground(new Color(255,0,0));
            button[0].setEnabled(false);
            button[1].setEnabled(false);
            button[2].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[0].getText()=="O") && (button[1].getText()=="O") && (button[2].getText()=="O") ){
            button[0].setForeground(new Color(0,0,255));
            button[1].setForeground(new Color(0,0,255));
            button[2].setForeground(new Color(0,0,255));
            button[0].setEnabled(false);
            button[1].setEnabled(false);
            button[2].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[3].getText()=="X") && (button[4].getText()=="X") && (button[5].getText()=="X") ){
            button[3].setForeground(new Color(255,0,0));
            button[4].setForeground(new Color(255,0,0));
            button[5].setForeground(new Color(255,0,0));
            button[3].setEnabled(false);
            button[4].setEnabled(false);
            button[5].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[3].getText()=="O") && (button[4].getText()=="O") && (button[5].getText()=="O") ){
            button[3].setForeground(new Color(0,0,255));
            button[4].setForeground(new Color(0,0,255));
            button[5].setForeground(new Color(0,0,255));
            button[3].setEnabled(false);
            button[4].setEnabled(false);
            button[5].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[6].getText()=="X") && (button[7].getText()=="X") && (button[8].getText()=="X") ){
            button[6].setForeground(new Color(255,0,0));
            button[7].setForeground(new Color(255,0,0));
            button[8].setForeground(new Color(255,0,0));
            button[6].setEnabled(false);
            button[7].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[6].getText()=="O") && (button[7].getText()=="O") && (button[8].getText()=="O") ){
            button[6].setForeground(new Color(0,0,255));
            button[7].setForeground(new Color(0,0,255));
            button[8].setForeground(new Color(0,0,255));
            button[6].setEnabled(false);
            button[7].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[0].getText()=="X") && (button[3].getText()=="X") && (button[6].getText()=="X") ){
            button[0].setForeground(new Color(255,0,0));
            button[3].setForeground(new Color(255,0,0));
            button[6].setForeground(new Color(255,0,0));
            button[0].setEnabled(false);
            button[3].setEnabled(false);
            button[6].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[0].getText()=="O") && (button[3].getText()=="O") && (button[6].getText()=="O") ){
            button[0].setForeground(new Color(0,0,255));
            button[3].setForeground(new Color(0,0,255));
            button[6].setForeground(new Color(0,0,255));
            button[0].setEnabled(false);
            button[3].setEnabled(false);
            button[6].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[1].getText()=="X") && (button[4].getText()=="X") && (button[7].getText()=="X") ){
            button[1].setForeground(new Color(255,0,0));
            button[4].setForeground(new Color(255,0,0));
            button[7].setForeground(new Color(255,0,0));
            button[1].setEnabled(false);
            button[4].setEnabled(false);
            button[7].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[1].getText()=="O") && (button[4].getText()=="O") && (button[7].getText()=="O") ){
            button[1].setForeground(new Color(0,0,255));
            button[4].setForeground(new Color(0,0,255));
            button[7].setForeground(new Color(0,0,255));
            button[1].setEnabled(false);
            button[4].setEnabled(false);
            button[7].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[2].getText()=="X") && (button[5].getText()=="X") && (button[8].getText()=="X") ){
            button[2].setForeground(new Color(255,0,0));
            button[5].setForeground(new Color(255,0,0));
            button[8].setForeground(new Color(255,0,0));
            button[2].setEnabled(false);
            button[5].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[2].getText()=="O") && (button[5].getText()=="O") && (button[8].getText()=="O") ){
            button[2].setForeground(new Color(0,0,255));
            button[5].setForeground(new Color(0,0,255));
            button[8].setForeground(new Color(0,0,255));
            button[2].setEnabled(false);
            button[5].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[0].getText()=="X") && (button[4].getText()=="X") && (button[8].getText()=="X") ){
            button[0].setForeground(new Color(255,0,0));
            button[4].setForeground(new Color(255,0,0));
            button[8].setForeground(new Color(255,0,0));
            button[0].setEnabled(false);
            button[4].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[0].getText()=="O") && (button[4].getText()=="O") && (button[8].getText()=="O") ){
            button[0].setForeground(new Color(0,0,255));
            button[4].setForeground(new Color(0,0,255));
            button[8].setForeground(new Color(0,0,255));
            button[0].setEnabled(false);
            button[4].setEnabled(false);
            button[8].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[2].getText()=="X") && (button[4].getText()=="X") && (button[6].getText()=="X") ){
            button[2].setForeground(new Color(255,0,0));
            button[4].setForeground(new Color(255,0,0));
            button[6].setForeground(new Color(255,0,0));
            button[2].setEnabled(false);
            button[4].setEnabled(false);
            button[6].setEnabled(false);
            textfield.setText("Player 1 wins!");
        }
        else if( (button[2].getText()=="O") && (button[4].getText()=="O") && (button[6].getText()=="O") ){
            button[2].setForeground(new Color(0,0,255));
            button[4].setForeground(new Color(0,0,255));
            button[6].setForeground(new Color(0,0,255));
            button[2].setEnabled(false);
            button[4].setEnabled(false);
            button[6].setEnabled(false);
            textfield.setText("Player 2 wins!");
        }
        else if( (button[0].getText()!="") && (button[1].getText()!="") && (button[2].getText()!="") && (button[3].getText()!="") && (button[4].getText()!="") && (button[5].getText()!="") && (button[6].getText()!="") && (button[7].getText()!="") && (button[8].getText()!="") ){
            textfield.setText("Draw!");
        }
    }

    public static void main(String[] args) {
        tictactoe tic = new tictactoe();
    }
}
