import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tictactoe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel texttfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    Tictactoe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,450);
        frame.getContentPane().setBackground(Color.decode("#000000"));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        texttfield.setBackground(Color.decode("#343434"));
        texttfield.setForeground(Color.decode("#FF0000"));
        texttfield.setFont(new Font("Rowdies",Font.BOLD,50));
        texttfield.setHorizontalAlignment(JLabel.CENTER);
        texttfield.setText("Tic-Tac-Toe");
        texttfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(Color.LIGHT_GRAY);

        title_panel.add(texttfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);

        for(int i=0;i<9;i++)
        {
            buttons[i] = new JButton();
            buttons[i].setBackground(Color.decode("#353935"));
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Rowdies",Font.BOLD,80));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setEnabled(false);
        }

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(player1_turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setBackground(Color.decode("#343434"));
                        buttons[i].setForeground(Color.decode("#0047AB"));
                        buttons[i].setText("X");
                        player1_turn=false;
                        texttfield.setForeground(Color.decode("#FF0000"));
                        texttfield.setText("O turn");

                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setBackground(Color.decode("#343434"));
                        buttons[i].setForeground(Color.decode("#FF0000"));
                        buttons[i].setText("O");
                        player1_turn=true;
                        texttfield.setForeground(Color.decode("#0047AB"));
                        texttfield.setText("X turn");

                        check();
                    }
                }
            }
        }
    }

    public void firstTurn(){

        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(true);
        }
        if(random.nextInt(2)==0)
        {
            player1_turn=true;
            texttfield.setForeground(Color.decode("#0047AB"));
            texttfield.setText("X turn");

        }
        else
        {
            player1_turn=false;
            texttfield.setForeground(Color.decode("#FF0000"));
            texttfield.setText("O turn");

        }
    }

    public void check(){

        //check X win conditions
        if((buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X"))
        {
            xWins(0,1,2);
        }

        if((buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X"))
        {
            xWins(3,4,5);
        }

        if((buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(6,7,8);
        }

        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(0,3,6);
        }

        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X"))
        {
            xWins(1,4,7);
        }

        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(2,5,8);
        }

        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X"))
        {
            xWins(0,4,8);
        }

        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X"))
        {
            xWins(2,4,6);
        }

        //check O win conditions
        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O"))
        {
            oWins(0,1,2);
        }

        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O"))
        {
            oWins(3,4,5);
        }

        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(6,7,8);
        }

        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O"))
        {
            oWins(0,3,6);
        }

        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O"))
        {
            oWins(1,4,7);
        }

        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(2,5,8);
        }

        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O"))
        {
            oWins(0,4,8);
        }

        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a,int b,int c){

        buttons[a].setBackground(Color.decode("#4CBB17"));
        buttons[b].setBackground(Color.decode("#4CBB17"));
        buttons[c].setBackground(Color.decode("#4CBB17"));

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }

        texttfield.setForeground(Color.decode("#0047AB"));
        texttfield.setText("X wins");
    }

    public void oWins(int a,int b,int c){

        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }

        texttfield.setForeground(Color.decode("#FF0000"));
        texttfield.setText("O wins");
    }
}
