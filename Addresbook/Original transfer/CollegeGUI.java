import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.*;
import java.text.*;
//import CollegeBook();

public class CollegeGUI extends JFrame implements ActionListener
{ 
        
        private Container window;
        private int pageNumber = 0;
        
        private JMenuBar menuBar; //contains all the components of the menu
        private JMenu fileMenu; //a menu in the menuBar
        private JMenu editMenu;
        private JButton next, back, add, delete, save;
       // private JMenu addMenu;
       // private JMenu removeMenu;
         private ArrayList<JMenuItem> fileMenuItems; 
        private ArrayList<JMenuItem> editMenuItems;
        private JTextField names, price, accept, grad, city, state,zip, year;
        private JLabel currentDate, displayPage, displayDate;
        //private JComboBox<Integer> year ;
         private JComboBox<String> type, size ;
         
         private CollegeBook cd;
        
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() instanceof JMenuItem)
                    {
                    JMenuItem clicked = (JMenuItem) e.getSource();
                    if (clicked.getText().equals("Exit")) // kills the code and completly closes it
                        System.exit(0);
                    else if (clicked.getText().equals("Change Background Color"))
                    // can change the backgrounnd to a color of you preferance. though when save is clicked it returns to gray 
                        window.setBackground(new Color(
                            (int)(Math.random() * 256),
                            (int)(Math.random() * 256),
                            (int)(Math.random() * 256))
                        );
                    else if (clicked.getText().equals("Add")) 
                    // adds another set of data based of previous info that can be changed
                    { // make it so you can add at current and at end- not complete yet
                        CollegeData info = new CollegeData();
                        int currentPage = cd.getCurrentIndex();
                        int addressBookSize = cd.getAddressBookSize();
            
                    
                        info.setName(names.getText());//this is pulled from fields in the gui
                        info.setFound(Integer.parseInt(year.getText()));
                        info.setPrice(Integer.parseInt(price.getText()));
                        info.setAccept(Double.parseDouble(accept.getText()));
                        info.setGrad(Double.parseDouble(grad.getText()));
                        info.setCity(city.getText());
                        info.setState(state.getText());
                        info.setZip(Integer.parseInt(zip.getText()));
                        info.setSelectedItemSize(size.getSelectedItem().toString());
                        info.setSelectedItemType(type.getSelectedItem().toString());
                        window.setBackground(Color.GREEN);// changes color to symbolize editing with change back once saved
                        if(currentPage == ( addressBookSize - 1))
                        {
                            cd.addEntry(info);
                        }
                        else if(currentPage < (addressBookSize - 1))
                        {
                           cd.addAtIndexEntry(currentPage,info);
                        }
                    }
                    else if (clicked.getText().equals("Delete")){
                    
                  if (cd.deleteEntry() != null) // if conditions are met  it will delete and move to the page before it
                    {
                    CollegeData  cp = new CollegeData();
                     cp = cd.getPrePage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                    // System.out.println("Page#:" + pageNumber);
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));

                    }
                }
                    else if(clicked.getText().equals("Next"))// moves the data thru
                    {
                        CollegeData  cp = new CollegeData();
                        cp = cd.getNextPage();
                        names.setText(cp.getName());
                        year.setText(Integer.toString(cp.getFound()));
                        price.setText(Integer.toString(cp.getPrice()));
                        accept.setText(Double.toString(cp.getAccept()));
                        grad.setText(Double.toString(cp.getGrad()));
                        city.setText(cp.getCity());
                        state.setText(cp.getState());
                        zip.setText(Integer.toString(cp.getZip()));
                        size.setSelectedItem(cp.getSelectedItemSize());
                        type.setSelectedItem(cp.getSelectedItemType());
                        pageNumber = cd.getCurrentIndex();
                        displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                    }
                    else if(clicked.getText().equals("Previous")){// move data backwards
                        
                    CollegeData  cp = new CollegeData();
                     cp = cd.getPrePage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                    }
                     else if (clicked.getText().equals("Beginning")){ // jumps to beginning of data
                        // pg = 0;
                    CollegeData  cp = new CollegeData();
                     cp = cd.getFirstPage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                     }
                     else if (clicked.getText().equals("End")){ // jumps to end of data
                        
                     CollegeData  cp = new CollegeData();
                     cp = cd.getLastPage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                     }
                    else if(clicked.getText().equals("Save")){ 
                        // updates edits made so it is keeps changes made as it goes back and forth thru the data
                    cd.getPG().setName(names.getText());
                    cd.getPG().setFound(Integer.parseInt(year.getText()));
                    cd.getPG().setPrice(Integer.parseInt( price.getText()));
                    cd.getPG().setAccept(Double.parseDouble( accept.getText()));
                    cd.getPG().setGrad(Double.parseDouble(grad.getText()));
                    cd.getPG().setCity(city.getText());
                    cd.getPG().setState(state.getText());
                    cd.getPG().setZip(Integer.parseInt( zip.getText()));
                    cd.getPG().setSelectedItemSize(size.getSelectedItem().toString());
                    cd.getPG().setSelectedItemType(type.getSelectedItem().toString());
                    window.setBackground(Color.LIGHT_GRAY);
                    }
                     else if (clicked.getText().equals("Sort")){}// sorts the data by price
                       cd.mySort();
                    }
    
            if(e.getSource() instanceof JButton)
            {
                JButton clicked = (JButton) e.getSource();
                
                if(clicked.equals(next)){// move thru data updating what we can see
                     CollegeData  cp = new CollegeData();
                     cp = cd.getNextPage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                     
                     pageNumber = cd.getCurrentIndex();
                    // System.out.println("Page#:" + pageNumber);
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                 
                }
                if(clicked.equals(back))// move it back ad update what we can see
                {
                    CollegeData  cp = new CollegeData();
                     cp = cd.getPrePage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                    // System.out.println("Page#:" + pageNumber);
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));

                }
               if(clicked.equals(add)){// same as last time just in button form 
                   // make it so you can add at current and at end
                    //you need to create a new College Data 
                    //Then copy the values from the gui into the college data class
                    //then add the class to the collegebook
                         CollegeData info = new CollegeData();
                        int currentPage = cd.getCurrentIndex();
                        int addressBookSize = cd.getAddressBookSize();
            
                    
                        info.setName(names.getText());//this is pulled from fields in the gui
                        info.setFound(Integer.parseInt(year.getText()));
                        info.setPrice(Integer.parseInt(price.getText()));
                        info.setAccept(Double.parseDouble(accept.getText()));
                        info.setGrad(Double.parseDouble(grad.getText()));
                        info.setCity(city.getText());
                        info.setState(state.getText());
                        info.setZip(Integer.parseInt(zip.getText()));
                        info.setSelectedItemSize(size.getSelectedItem().toString());
                        info.setSelectedItemType(type.getSelectedItem().toString());
                        window.setBackground(Color.GREEN);// changes color to symbolize editing with change back once saved
                        if(currentPage == ( addressBookSize - 1))
                        {
                            cd.addEntry(info);
                        }
                        else if(currentPage < (addressBookSize - 1))
                        {
                           cd.addAtIndexEntry(currentPage,info);
                        } 
                } 
                if(clicked.equals(delete)){// same as last time but in button form 
                    //call the delete method and save the return value
                    //if the the return value is null do nothing
                    //else just update the screen
                    if (cd.deleteEntry() != null)
                    {
                    CollegeData  cp = new CollegeData();
                     cp = cd.getPrePage();
                     names.setText(cp.getName());
                     year.setText(Integer.toString(cp.getFound()));
                     price.setText(Integer.toString(cp.getPrice()));
                     accept.setText(Double.toString(cp.getAccept()));
                     grad.setText(Double.toString(cp.getGrad()));
                     city.setText(cp.getCity());
                     state.setText(cp.getState());
                     zip.setText(Integer.toString(cp.getZip()));
                     size.setSelectedItem(cp.getSelectedItemSize());
                     type.setSelectedItem(cp.getSelectedItemType());
                    pageNumber = cd.getCurrentIndex();
                    // System.out.println("Page#:" + pageNumber);
                     displayPage.setText("Current Page: "+ Integer.toString(pageNumber+1));
                    }
                }
                if(clicked.equals(save)){// saves data
                    cd.getPG().setName(names.getText());
                    cd.getPG().setFound(Integer.parseInt(year.getText()));
                    cd.getPG().setPrice(Integer.parseInt( price.getText()));
                    cd.getPG().setAccept(Double.parseDouble( accept.getText()));
                    cd.getPG().setGrad(Double.parseDouble(grad.getText()));
                    cd.getPG().setCity(city.getText());
                    cd.getPG().setState(state.getText());
                    cd.getPG().setZip(Integer.parseInt( zip.getText()));
                    cd.getPG().setSelectedItemSize(size.getSelectedItem().toString());
                    cd.getPG().setSelectedItemType(type.getSelectedItem().toString());
                    window.setBackground(Color.LIGHT_GRAY);
                    
                }
            }
        }
        public CollegeGUI()// presents our code
        {
            cd = new CollegeBook();
            cd.printAllUniversities();// shows if it is working orionally 
            windowPage();
            buttons();
            textBox();
            PvP();// drop downs
            menu();// webpage file and edit
        }
       
            
        
        public void windowPage()//creates the GUI display window
     {
        window = getContentPane();
        window.setLayout(null);
        window.setBackground(Color.LIGHT_GRAY);
        setSize(700, 800);
        setTitle("CollegeGUI");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } 
        public void menu()// creates windows to move, add, save and do what the butttons do and more
        {
            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            editMenu = new JMenu("Edit"); 
         
        //add the menu times to each of the menus
            setupFileMenu();
            setupEditMenu();
          
        //add the menus to the menubar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //tell the class(JFrame)to use your menu instead of null
        setJMenuBar(menuBar);
        }
        
        public void setupFileMenu()
        {
            fileMenuItems = new ArrayList<>();
            fileMenuItems.add(new JMenuItem("Beginning"));
            fileMenuItems.add(new JMenuItem("End"));
            fileMenuItems.add(new JMenuItem("Save"));
            fileMenuItems.add(new JMenuItem("Exit"));
            fileMenuItems.add(new JMenuItem("Sort"));
            fileMenuItems.add(new JMenuItem("Change Background Color"));
    
        for (JMenuItem menuItem: fileMenuItems)
        {
            menuItem.addActionListener(this);
            fileMenu.add(menuItem);
        }

        }
        public void setupEditMenu()
        {
        editMenuItems = new ArrayList<>();
        editMenuItems.add(new JMenuItem("Add"));
        editMenuItems.add(new JMenuItem("Delete"));
        editMenuItems.add(new JMenuItem("Next"));
        editMenuItems.add(new JMenuItem("Previous"));
        for (JMenuItem menuItem: editMenuItems)
        {
            menuItem.addActionListener(this);
            editMenu.add(menuItem);
        }
        }
        
        public void buttons()
        {
            next = new JButton("Next");
            next.setBounds(10, 550, 102, 32);
            next.addActionListener(this);
            next.setMargin (new Insets (0,0,0,0));
            window.add(next);
            
            back = new JButton("Back");
             
            back.setBounds(140, 550, 102, 32);
            back.addActionListener(this);
            back.setMargin (new Insets (0,0,0,0));
            window.add(back);
            
            add = new JButton("Add");
             
            add.setBounds(350, 550, 102, 32);
            add.addActionListener(this);
            add.setMargin (new Insets (0,0,0,0));
            window.add( add);
            
            delete = new JButton("Delete");
            delete.setBounds(475, 550, 102, 32);
            delete.addActionListener(this);
            delete.setMargin (new Insets (0,0,0,0));
            window.add( delete );
            
            save = new JButton("Save");
             
            save.setBounds(585, 550, 102, 32);
            save.addActionListener(this);
            save.setMargin (new Insets (0,0,0,0));
            window.add(save);  
        }
        
            public void textBox()
            {
                names = new JTextField();
                names.setBorder(BorderFactory.createTitledBorder("Name"));
                names.setBounds(50, 50, 600, 50);
               // name.setText(update);
                window.add(names);
                
                year = new JTextField();
                year.setBorder(BorderFactory.createTitledBorder("Founding year"));
                year.setBounds(50, 125, 200, 50);
                //year.setText(update);
                window.add(year);
                
                price = new JTextField();
                price.setBorder(BorderFactory.createTitledBorder("$Price$"));
                price.setBounds(50, 200, 300, 50);
                //price.setText(update);
                window.add(price);
                
                accept = new JTextField();
                accept.setBorder(BorderFactory.createTitledBorder("Acceptance Rate %"));
                accept.setBounds(50, 275, 150, 50);
                //accept.setText(update);
                window.add(accept);
                
                grad = new JTextField();
                grad.setBorder(BorderFactory.createTitledBorder("Graduation Rate %"));
                grad.setBounds(400, 275, 150, 50);
                //grad.setText(update);
                window.add(grad);
                
                city = new JTextField();
                city.setBorder(BorderFactory.createTitledBorder("City"));
                city.setBounds(50, 350, 300, 50);
                //city.setText(update);
                window.add(city);
                
                state = new JTextField();
                state.setBorder(BorderFactory.createTitledBorder("State (initials)"));
                state.setBounds(400, 350, 75, 50);
                //state.setText(update);
                window.add(state);
                
                zip = new JTextField();
                zip.setBorder(BorderFactory.createTitledBorder("ZipCode"));
                zip.setBounds(50, 425, 150, 50);
                //zip.setText(update);
                window.add(zip);
            
                displayPage  = new JLabel("Current Page: "+ Integer.toString(pageNumber));
             
                displayDate = new JLabel("Current Date: ");
               // int totalPage = ab.size();

                //displayPage.setBorder(BorderFactory.createTitledBorder("ZipCode"));
                
                displayPage.setBounds(50, 475, 150, 50);
             //   currentPage.setBounds(150, 475, 150, 50);
                
                displayDate = new JLabel("Current Date: ");
                String pattern = "MM/dd/yyyy";
                DateFormat df = new SimpleDateFormat(pattern);
                Date today = Calendar.getInstance().getTime();
                String todayAsString = df.format(today);
                currentDate = new JLabel (todayAsString);

                displayDate.setBounds(50, 500, 150, 50);
                currentDate.setBounds(150, 500, 150, 50);               
                window.add(displayPage);
         //       window.add(currentPage);
                window.add(displayDate);
                window.add(currentDate);
            //    window.add(currentPage);
                
                
                
                
            }
            
            public void PvP()// the drop downs
            {
                size = new JComboBox<>();
                ArrayList<String> sizes = new ArrayList<>(Arrays.asList("Large", "Medium", "Small"));
                for (String n : sizes)
                    size.addItem(n);
                    size.setBorder(BorderFactory.createTitledBorder("Size"));
                    size.setBounds(400,125, 100, 50);
                    window.add(size);
                    
                type = new JComboBox<>();
                ArrayList<String> types= new ArrayList<>(Arrays.asList("Public", "Private"));
                for (String pick : types)
                    type.addItem(pick);
                    type.setBorder(BorderFactory.createTitledBorder("Type"));
                    type.setBounds(380, 425, 200, 50);
                    window.add(type);
            }
            

        
    public static void main(String[] args)
    {
        
        
        
        CollegeGUI program = new CollegeGUI();
        program.setVisible(true);
    }
}