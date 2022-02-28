/*
    Name: George Jose P. Montano
    Subject: ITCC 11.1
    Section: B
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    // Array to hold numbers 0-9
    JButton[] numberButtons = new JButton[10];
    // Array for operators
    JButton[] operatorButtons = new JButton[9];
    JButton addButton, subtractButton, multiplyButton, deleteButton,
    divideButton, equalsButton, clearButton, decimalButton, negativeButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 20);

    double firstNumber, secondNumber, result;
    char operator;
    
    public calculator(){
        
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.red);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.gray);
        
        // new textfield for display
        textfield = new JTextField();
        textfield.setBounds(25, 10, 230, 30);
        textfield.setFont(myFont);
        // set to false so that the textfield is not editable
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setBackground(Color.WHITE);

        // create buttons for operators with their respective symbols
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("x");
        divideButton = new JButton("÷");
        equalsButton = new JButton("=");
        decimalButton = new JButton(".");
        negativeButton = new JButton("(-)");
        clearButton = new JButton("C");
        deleteButton = new JButton("Del");

        // place operators in array
        operatorButtons[0] = addButton;
        operatorButtons[1] = subtractButton;
        operatorButtons[2] = multiplyButton;
        operatorButtons[3] = divideButton;
        operatorButtons[4] = decimalButton;
        operatorButtons[5] = equalsButton;
        operatorButtons[6] = deleteButton;
        operatorButtons[7] = clearButton;
        operatorButtons[8] = negativeButton;

        // add action listener to all operator buttons
        for(int i = 0; i < 9; i++){
            // "this" is the object that is calling the method
            operatorButtons[i].addActionListener(this);
            operatorButtons[i].setFont(myFont);
            // removes active button outline
            operatorButtons[i].setFocusable(false);
        }
        // add action listener to all number buttons
        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // set size of negative, delete, and clear buttons which are placed outside of the grid
        negativeButton.setBounds(25, 320, 70, 30);
        deleteButton.setBounds(102, 320, 70, 30);
        clearButton.setBounds(180, 320, 70, 30);

        // create a new panel that houses the grid of buttons for numbers and operators
        panel = new JPanel();
        panel.setBounds(25, 50, 230, 250);
        panel.setLayout(new GridLayout(4,4,0,0));

        // add all buttons to the panel
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divideButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiplyButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subtractButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(addButton);

        // add everything else
        frame.add(panel);
        frame.add(negativeButton);
        frame.add(deleteButton);   
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        for(int i = 0; i<10; i++){
            if(event.getSource()==numberButtons[i]){
                // if the textfield is empty, add the number to the textfield
                if(textfield.getText().equals("")){
                    textfield.setText(String.valueOf(i));
                }
                // otherwise, add the number to the end of the textfield
                else{
                    textfield.setText(textfield.getText()+String.valueOf(i));
                }
            }
        }

        if(event.getSource() == decimalButton){
           textfield.setText(textfield.getText().concat("."));
        }
        // if the operator button is pressed, set the operator to the button pressed
        else if(event.getSource() == addButton){
            firstNumber = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        else if(event.getSource() == subtractButton){
            firstNumber = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        else if(event.getSource() == multiplyButton){
            firstNumber = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        else if(event.getSource() == divideButton){
            firstNumber = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        else if(event.getSource() == equalsButton){
            secondNumber = Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                    result = firstNumber + secondNumber;
                    textfield.setText(String.valueOf(result));
                    break;
                case '-':
                    result = firstNumber - secondNumber;
                    textfield.setText(String.valueOf(result));
                    break;
                case '*':
                    result = firstNumber * secondNumber;
                    textfield.setText(String.valueOf(result));
                    break;
                case '/':
                    result = firstNumber / secondNumber;
                    textfield.setText(String.valueOf(result));
                    break;
            }
        }
        else if(event.getSource() == clearButton){
            textfield.setText("");
        }
        else if(event.getSource() == deleteButton){
            // if the textfield is empty, do nothing
            if(textfield.getText().equals("")){
                textfield.setText("");
            }
            // otherwise, remove the last character from the textfield
            else{
                String temp = textfield.getText();
                temp = temp.substring(0, temp.length()-1);
                textfield.setText(temp);
            }
        }
        else if(event.getSource() == negativeButton){
            // if the textfield is empty, add a negative sign to the textfield
            if(textfield.getText().equals("")){
                textfield.setText("-");
            }
            // otherwise, add a negative sign to the end of the textfield
            else{
                textfield.setText(textfield.getText()+"-");
            }
        } 
    }

    public static void main(String[] args) {
        calculator calc = new calculator();
    }
}