//Small images are 175 x 250px

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

public class HangmanGUI extends JFrame implements ActionListener
{
    private Container window;
   // private Image[] hangingThing = new Image[7]; //[didn't end up using this array, hard coded the images instead]
    private ImageIcon image;
    
    private JTextArea gameBox;
    private JLabel label;
    private JButton abcButton;
    private JButton aButton,bButton,cButton,dButton,eButton,fButton,gButton,hButton,iButton,jButton,kButton,lButton,mButton,nButton,oButton,pButton,qButton,rButton,sButton,tButton,uButton,vButton,wButton,xButton,yButton,zButton;
    private JButton restart;
    private JButton quit;
    private char pushedButton = '_'; // translate a button to a char
    
    String[] guessWords = {"Can it be Winter break already?","Bananas are awesome!","Congratulations Einstein!","Computer science is so epic!","Are you coming to the tree?"}; //our array of phrases that the code could randomly choose from
    String dashedPhrase;
    int rndIndex;
    String pickedPhrase;
    String dashes = "";
    //stores what letters the user has pressed to be used to fill in dashes 
    private char guessedLetter;
    private int numOfGuesses;
    
    private boolean mistake = false; 
    private int mistakesDone = 0;
    private boolean gameOver; 
    
    public HangmanGUI() //creates the game
    {
        createWindow();
        getPhrase();
        
        dashedWord();
        componentsToWindow();
    }
    
    private void createWindow()//creates the GUI display window
    {
        window = getContentPane();
        window.setLayout(null);
        window.setBackground(Color.LIGHT_GRAY);
        setSize(710, 360);
        setTitle("HangmanGUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } 
    
    public void getPhrase() //chooses a random phrase in our 5-phrase array
    {
        rndIndex = new Random().nextInt(guessWords.length); //chooses a random index within our guessWords array
        pickedPhrase = guessWords[rndIndex]; //index value of the chosen phrase
    }

    public String dashedWord()// translates the chosen phrase from getPhrase() to dashes 
    {
        StringBuilder hiddenString = new StringBuilder();// allowed for string manipulation and string search
        String alphabet = "abcdefghijklmnopqrstuvwxyz"; //the letters that would be turned into dashes as the code creates a new string 
        for(int i = 0; i < pickedPhrase.length(); i++)// makes it so it translate to the marks and dashes 
        {
           
           if((pickedPhrase.charAt(i) == '!') ||(pickedPhrase.charAt(i) == '?')  || (pickedPhrase.charAt(i) == '.') || (pickedPhrase.charAt(i) == ',')|| (pickedPhrase.charAt(i) == '\'')){
               hiddenString.append(pickedPhrase.charAt(i)); //tells code to print out punctuation automatically
           }
           else{
             hiddenString.append("_ "); // tells a code to print a dash
           }
           
           dashes = hiddenString.toString();
           
        }
    
        return dashes;
    }
    
    public void checkInput() //check user input (if the letter exists)
    {   
        int characterNotFound = 0;
        StringBuilder newString = new StringBuilder(dashes);//allow for string manipulation
            for (int i = 0; i < pickedPhrase.length(); i++)
        {
            char currentChar = pickedPhrase.charAt(i);// we assign the clicked button to be the currecnt character

           if(Character.toLowerCase(currentChar) == pushedButton)// if the pusheded button equals the curent 
            {
                    newString.setCharAt(i,currentChar);// assign character at the position to be the new letter
                    characterNotFound = 1;
                }
            } 
            
        if(characterNotFound !=1) //if the letter isn't found in the phrase, don't print anything and adds a mistakeDone
        {
            mistakesDone++;
        }
        
        if  (dashes.equals(pickedPhrase) || mistakesDone == 6) //checks to see if the dashed phrase is equal to the picked phrase from the array
        {
            didWeWin();
        }
        
        dashes = newString.toString();// recreates the dashes string.
    }
    
    private void componentsToWindow()
    {
        if(mistakesDone == 0)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall0.png"));
            label = new JLabel(image);
            label.setBounds(510, 10, 175, 250);
            window.add(label);
            repaint();
        }

        //creates the textarea that the random phrase will be displyed on
        gameBox = new JTextArea(dashes);
        gameBox.setVisible(true);
        gameBox.setBounds(10, 100, 450, 225);
        gameBox.setEditable(false);
        gameBox.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 20));
        gameBox.setLineWrap(true);
        gameBox.setText(dashes);
        window.add(gameBox);
        
        //creates letter buttons the user will use to input their letter guesses 
        aButton = new JButton("a");
        aButton.setBounds(10, 20, 30, 30);
        aButton.addActionListener(this);
        aButton.setMargin (new Insets (0,0,0,0));
        window.add(aButton);
        
        bButton = new JButton("b");
        bButton.setBounds(45, 20, 30, 30);
        bButton.addActionListener(this);
        bButton.setMargin (new Insets (0,0,0,0));
        window.add(bButton);
        
        cButton = new JButton("c");
        cButton.setBounds(80, 20, 30, 30);
        cButton.addActionListener(this);
        cButton.setMargin (new Insets (0,0,0,0));
        window.add(cButton);
        
        dButton = new JButton("d");
        dButton.setBounds(115, 20, 30, 30);
        dButton.addActionListener(this);
        dButton.setMargin (new Insets (0,0,0,0));
        window.add(dButton);
        
        eButton = new JButton("e");
        eButton.setBounds(150, 20, 30, 30);
        eButton.addActionListener(this);
        eButton.setMargin (new Insets (0,0,0,0));
        window.add(eButton);
        
        fButton = new JButton("f");
        fButton.setBounds(185, 20, 30, 30);
        fButton.addActionListener(this);
        fButton.setMargin (new Insets (0,0,0,0));
        window.add(fButton);
        
        gButton = new JButton("g");
        gButton.setBounds(220, 20, 30, 30);
        gButton.addActionListener(this);
        gButton.setMargin (new Insets (0,0,0,0));
        window.add(gButton);
        
        hButton = new JButton("h");
        hButton.setBounds(255, 20, 30, 30);
        hButton.addActionListener(this);
        hButton.setMargin (new Insets (0,0,0,0));
        window.add(hButton);
        
        iButton = new JButton("i");
        iButton.setBounds(290, 20, 30, 30);
        iButton.addActionListener(this);
        iButton.setMargin (new Insets (0,0,0,0));
        window.add(iButton);
        
        jButton = new JButton("j");
        jButton.setBounds(325, 20, 30, 30);
        jButton.addActionListener(this);
        jButton.setMargin (new Insets (0,0,0,0));
        window.add(jButton);
        
        kButton = new JButton("k");
        kButton.setBounds(360, 20, 30, 30);
        kButton.addActionListener(this);
        kButton.setMargin (new Insets (0,0,0,0));
        window.add(kButton);
        
        lButton = new JButton("l");
        lButton.setBounds(395, 20, 30, 30);
        lButton.addActionListener(this);
        lButton.setMargin (new Insets (0,0,0,0));
        window.add(lButton);
        
        mButton = new JButton("m");
        mButton.setBounds(430, 20, 30, 30);
        mButton.addActionListener(this);
        mButton.setMargin (new Insets (0,0,0,0));
        window.add(mButton);
        
        nButton = new JButton("n");
        nButton.setBounds(10, 55, 30, 30);
        nButton.addActionListener(this);
        nButton.setMargin (new Insets (0,0,0,0));
        window.add(nButton);
        
        oButton = new JButton("o");
        oButton.setBounds(45, 55, 30, 30);
        oButton.addActionListener(this);
        oButton.setMargin (new Insets (0,0,0,0));
        window.add(oButton);
        
        pButton = new JButton("p");
        pButton.setBounds(80, 55, 30, 30);
        pButton.addActionListener(this);
        pButton.setMargin (new Insets (0,0,0,0));
        window.add(pButton);
        
        qButton = new JButton("q");
        qButton.setBounds(115, 55, 30, 30);
        qButton.addActionListener(this);
        qButton.setMargin (new Insets (0,0,0,0));
        window.add(qButton);
        
        rButton = new JButton("r");
        rButton.setBounds(150, 55, 30, 30);
        rButton.addActionListener(this);
        rButton.setMargin (new Insets (0,0,0,0));
        window.add(rButton);
        
        sButton = new JButton("s");
        sButton.setBounds(185, 55, 30, 30);
        sButton.addActionListener(this);
        sButton.setMargin (new Insets (0,0,0,0));
        window.add(sButton);
        
        tButton = new JButton("t");
        tButton.setBounds(220, 55, 30, 30);
        tButton.addActionListener(this);
        tButton.setMargin (new Insets (0,0,0,0));
        window.add(tButton);
        
        uButton = new JButton("u");
        uButton.setBounds(255, 55, 30, 30);
        uButton.addActionListener(this);
        uButton.setMargin (new Insets (0,0,0,0));
        window.add(uButton);
        
        vButton = new JButton("v");
        vButton.setBounds(290, 55, 30, 30);
        vButton.addActionListener(this);
        vButton.setMargin (new Insets (0,0,0,0));
        window.add(vButton);
        
        wButton = new JButton("w");
        wButton.setBounds(325, 55, 30, 30);
        wButton.addActionListener(this);
        wButton.setMargin (new Insets (0,0,0,0));
        window.add(wButton);
        
        xButton = new JButton("x");
        xButton.setBounds(360, 55, 30, 30);
        xButton.addActionListener(this);
        xButton.setMargin (new Insets (0,0,0,0));
        window.add(xButton);
        
        yButton = new JButton("y");
        yButton.setBounds(395, 55, 30, 30);
        yButton.addActionListener(this);
        yButton.setMargin (new Insets (0,0,0,0));
        window.add(yButton);
        
        zButton = new JButton("z");
        zButton.setBounds(430, 55, 30, 30);
        zButton.addActionListener(this);
        zButton.setMargin (new Insets (0,0,0,0));
        window.add(zButton);
        
        //runs reset() class and clears the textfield
        restart = new JButton("Ressurect");
        restart.setBounds(475, 270, 100, 25);
        restart.addActionListener(this);
        restart.setMargin (new Insets (0,0,0,0));
        window.add(restart);
        restart.setEnabled(false);
        
        //runs the endGame() class and turns off the program
        quit = new JButton("End Game");
        quit.setBounds(590, 270, 100, 25);
        quit.addActionListener(this);
        quit.setMargin (new Insets (0,0,0,0));
        window.add(quit);
        quit.setEnabled(false);
    }

    public void drawHangMan() //updates the image based on how many mistakes the user has made
    {
        if(mistakesDone == 0)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall0.png"));
        }
        
        if(mistakesDone == 1)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall1.png"));
        }
 
        else if(mistakesDone == 2)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall2.png"));
        }

        else if(mistakesDone == 3)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall3.png"));
        }
        
        else if(mistakesDone == 4)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall4.png"));

        }
        
        else if(mistakesDone == 5)
        {
            image = new ImageIcon(getClass().getResource("hangmanSmall5.png"));

        }
        
        else if(mistakesDone == 6)
        {
            window.setBackground(Color.RED);// turns background red to signify DEATH
            image = new ImageIcon(getClass().getResource("hangmanSmall6.png"));
            gameOver = true;
        }
        
        label = new JLabel(image);
        label.setBounds(510, 10, 175, 250);
        window.add(label);
        repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)// tells what happens when the buttons are clicked and what will continue on
    {
        JButton clicked = (JButton) e.getSource();
        
        if (e.getSource() instanceof JButton)
        {
            //when each letter button is clicked, sets their enable to false and stores that data in pushedButton to help fill in dashes later on
            if (clicked.equals(aButton))
            {
                aButton.setEnabled(false);
                pushedButton = 'a';
            }
            
            if (clicked.equals(bButton))
            {
                bButton.setEnabled(false);
                pushedButton = 'b';
            }
            
            if (clicked.equals(cButton))
            {
                cButton.setEnabled(false);
                pushedButton = 'c';
            }
            
            if (clicked.equals(dButton))
            {
                dButton.setEnabled(false);
                pushedButton = 'd';
            }
            
            if (clicked.equals(eButton))
            {
                eButton.setEnabled(false);
                pushedButton = 'e';
            }
            
            if (clicked.equals(fButton))
            {
                fButton.setEnabled(false);
                pushedButton = 'f';
            }
            
            if (clicked.equals(gButton))
            {
                gButton.setEnabled(false);
                pushedButton = 'g';
            } 
            
            if (clicked.equals(hButton))
            {
                hButton.setEnabled(false);
                pushedButton = 'h';
            }
            
            if (clicked.equals(iButton))
            {
                iButton.setEnabled(false);
                pushedButton = 'i';
            }
            
            if (clicked.equals(jButton))
            {
                jButton.setEnabled(false);
                pushedButton = 'j';
            }  
            
            if (clicked.equals(kButton))
            {
                kButton.setEnabled(false);
                pushedButton = 'k';
            } 
            
            if (clicked.equals(lButton))
            {
                lButton.setEnabled(false);
                pushedButton = 'l';
            }
            
            if (clicked.equals(mButton))
            {
                mButton.setEnabled(false);
                pushedButton = 'm';
            }
            
            if (clicked.equals(nButton))
            {
                nButton.setEnabled(false);
                pushedButton = 'n';
            }
            
            if (clicked.equals(oButton))
            {
                oButton.setEnabled(false);
                pushedButton = 'o';
            } 
            
            if (clicked.equals(pButton))
            {
                pButton.setEnabled(false);
                pushedButton = 'p';
            }
            
            if (clicked.equals(qButton))
            {
                qButton.setEnabled(false);
                pushedButton = 'q';
            }
            
            if (clicked.equals(rButton))
            {
                rButton.setEnabled(false);
                pushedButton = 'r';
            }
            
            if (clicked.equals(sButton))
            {
                sButton.setEnabled(false);
                pushedButton = 's';
            }
            
            if (clicked.equals(tButton))
            {
                tButton.setEnabled(false);
                pushedButton = 't';
            }
            
            if (clicked.equals(uButton))
            {
                uButton.setEnabled(false);
                pushedButton = 'u';
            }
            
            if (clicked.equals(vButton))
            {
                vButton.setEnabled(false);
                pushedButton = 'v';
            }
            
            if (clicked.equals(wButton))
            {
                wButton.setEnabled(false);
                pushedButton = 'w';
            }
            
            if (clicked.equals(xButton))
            {
                xButton.setEnabled(false);
                pushedButton = 'x';
            }
            
            if (clicked.equals(yButton))
            {
                yButton.setEnabled(false);
                pushedButton = 'y';
            }
            
            if (clicked.equals(zButton))
            {
                zButton.setEnabled(false);
                pushedButton = 'z';
            }

            if(clicked.equals(restart))
            {
                reset();
            }
            
            if(clicked.equals(quit))
            {
                endGame();
            }
            
            // only want to do this if we are not restarting or ending the game
            if(!clicked.equals(restart)){

               if(mistakesDone < 6)
               {
                   checkInput();
                   

             if(gameBox != null){
                 
                int stringLength = gameBox.getText().length();
                gameBox.replaceRange(dashes, 0, (stringLength));//repalces and updates the text
      
                repaint();
             }
                drawHangMan();
             }
            }  
        }
    }
    
    public void didWeWin()// tell if you lost or not
    {
        if(gameOver = true && mistakesDone < 6) //[didn't have time to finish this section of the code, didn't fix extra dashes problem, and can't compare to the original phrase to check if user is correct]
        {
            window.setBackground(Color.GREEN);
            restart.setEnabled(true); 
            quit.setEnabled(true);
        }
        
        else if (gameOver = true && mistakesDone == 6)
        {
            window.setBackground(Color.RED);
            restart.setEnabled(true); 
            quit.setEnabled(true);
        }
    }
    // when ressurect button is pushed, resets so you can play annother round [everything resets but the hanging man to remind you of what you have done]
    public void reset()
    {
        mistakesDone = 0; 
        
        //need to update the jlabel's icon, now that you have updated image.  use jlabels setIcon method [we weren't able to make this method work, and decided not to go through with it]
        
        repaint();
         //enables all buttons (because they were disabled as they were pressed)
        aButton.setEnabled(true);
        bButton.setEnabled(true);
        cButton.setEnabled(true);
        dButton.setEnabled(true);
        eButton.setEnabled(true);
        fButton.setEnabled(true);
        gButton.setEnabled(true);
        hButton.setEnabled(true);
        iButton.setEnabled(true);
        jButton.setEnabled(true);
        kButton.setEnabled(true);
        lButton.setEnabled(true);
        mButton.setEnabled(true);
        nButton.setEnabled(true);
        oButton.setEnabled(true);
        pButton.setEnabled(true);
        qButton.setEnabled(true);
        rButton.setEnabled(true);
        sButton.setEnabled(true);
        tButton.setEnabled(true);
        uButton.setEnabled(true);
        vButton.setEnabled(true);
        wButton.setEnabled(true);
        xButton.setEnabled(true);
        yButton.setEnabled(true);
        zButton.setEnabled(true);
        
        window.setBackground(Color.LIGHT_GRAY);//sets background back to the original color 
        
        restart.setEnabled(false); 
        quit.setEnabled(false);
        
        // takes the old dashes/word and takes the new and replaces it so we can get the next phrase must type a letter to replay the new phrase. 
            
            int stringLength = gameBox.getText().length(); 
            gameBox.replaceRange("", 0, (stringLength));
            getPhrase();
           
            dashedWord();
            gameBox.replaceRange(dashes, 0, (dashes.length() -1 ));

            ImageIcon currentImage = (ImageIcon) label.getIcon();
           currentImage = new ImageIcon(getClass().getResource("hangmanSmall0.png"));
            label.setIcon(currentImage);
            repaint();
    }
    
    public void endGame()
    {
        System.exit(0); //closes the system
    }
    
    public static void main(String[] args)
    {
        HangmanGUI program = new HangmanGUI();
        program.setVisible(true);

    }
}