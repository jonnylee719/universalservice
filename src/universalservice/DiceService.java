import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class DiceService implements Service {
  JPanel panel;
  Box diceBox;
  
  JComboBox numOfDice;
  
  public JPanel getGuiPanel() {
    panel = new JPanel();

    JButton button = new JButton("Roll 'em!");
    
    String[] choices = {"1", "2", "3", "4", "5"};
    numOfDice = new JComboBox(choices);
    
    panel.add(numOfDice);
    panel.add(button);
    
    return panel;
  }
  
  public class RollEmListener implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
      //roll the dice
      String selection = (String) numOfDice.getSelectedItem();
      int numOfDiceToRoll = Integer.parseInt(selection);
      for (int i = 0; i < numOfDiceToRoll; i++) {
        panel.add(new DicePanel());
      }
      panel.validate();
      panel.repaint();
    }
  }
  
  public class DicePanel extends JPanel {
    public void paintComponent(Graphics g) {
      g.setColor(Color.BLACK);
      g.drawRect(0,0,50,50);
      setSize(60, 60);
    }
  }
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("dice servic test");
    DiceService ds = new DiceService();    

    frame.getContentPane().add(BorderLayout.CENTER, ds.getGuiPanel());
    frame.setSize(500, 500);
    frame.setVisible(true);

  }
  
}