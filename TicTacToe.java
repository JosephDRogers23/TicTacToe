import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class TicTacToe
{




  JFrame _frame = new JFrame("Tic-Tac-Toe");
  JButton[] _buttons = new JButton[9];
  boolean turn = false; //X

  public TicTacToe()
  {

    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    _frame.setSize(400, 400);

    JPanel _ttt = new JPanel();
    JPanel _newPanel = new JPanel();
    _ttt.setLayout(new GridLayout(3, 3));
    _newPanel.setLayout(new FlowLayout());
    for(int j=0; j<9; j++)
    {
      _buttons[j] = new JButton("_");
      ActionListener buttonListener = new ButtonListener();
      _buttons[j].addActionListener(buttonListener);
      _buttons[j].setFont(new Font("Comic Sans", Font.PLAIN, 48));
      _ttt.add(_buttons[j]);
    }
    JButton newButton = new JButton("New Game");
    ActionListener newListener = new NewGameButtonListener();
    newButton.addActionListener(newListener);
    newButton.setFont(new Font("Comic Sans", Font.PLAIN, 48));
    _newPanel.add(newButton);

    _frame.add(_ttt, BorderLayout.NORTH);
    _frame.add(_newPanel, BorderLayout.SOUTH);

    _frame.setVisible(true);

  }

  public static void main(String[] args)
  {
    new TicTacToe();
  }

  class ButtonListener implements ActionListener
  {
      public void actionPerformed(ActionEvent e)
      {
        JButton source = (JButton) e.getSource();
        String currentText = source.getText();
        if(currentText.equals("X") || currentText.equals("O"))
        {
          //Ignore
        }
        else if(turn){
          source.setText("X");
          turn = !turn;
        }
        else
        {
          source.setText("O");
          turn = !turn;
        }

      }
  }
  class NewGameButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0; i<9; i++)
        {
          JButton source = _buttons[i];
          source.setText("_");
        }
    }
  }



}
