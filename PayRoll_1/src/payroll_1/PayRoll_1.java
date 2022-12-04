
package payroll_1;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import static javafx.util.Duration.hours;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.*;

class Pay extends JFrame implements ActionListener {
    ///public static void main (String args[]) {
    // initialize the lbl with caption name Employee Details
    
    JLabel lbl = new JLabel("PayRoll System New Version");

    Font f = new Font("Times New Roman", Font.BOLD, 36);
    Font f1 = new Font("Times New Roman", Font.BOLD, 20);
    Font f2 = new Font("Times New Roman", Font.BOLD, 18);
     
    JLabel lblcompanyname, lblpaydate, lblstartdate, lblenddate, lblid, lblemployeename, lbldepartment, lbldays,
            lblrate, lblsubmit, lblsalary;
    JTextField companyName, payDate, startDate, endDate, iD, empName, deptName, numDays,
            payRate, salary;
    JRadioButton rbmale, rbfemale;
    JButton btnadd, btnsave, btnupdate, btndelete, btnexit;
    JButton btnfirst, btnlast, btnnext, btnprev;
    JButton btncalculate;
    String gen;
    ResultSet rs = null;
    Connection conn = null;
    Statement stmt = null;

    float numOfDays, rate, empsalary; 
    private Object txthours;

    Pay() {
        super("Employees Details");
        addWindowListener(new WindowAdapter() {
           
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setLayout(null);

        lblsubmit = new JLabel("Developed By Tausifa Saeed");
        add(lblsubmit);

        lblsubmit.setHorizontalAlignment(lblsubmit.CENTER);
        lblsubmit.setBounds(240, 770, 450, 20);
        lblsubmit.setFont(f1);

        add(lbl);

        lbl.setBounds(200, 50, 500, 100);
        lbl.setHorizontalAlignment(lbl.CENTER);

        lbl.setFont(f);

        lblcompanyname = new JLabel("Company Name");
        lblpaydate = new JLabel("Pay Date");
        lblstartdate = new JLabel("Start Date");
        lblenddate = new JLabel("End Date");
        lblid = new JLabel("ID");
        lblemployeename = new JLabel("Employee Name");
        lbldepartment = new JLabel("Department");
        lbldays = new JLabel("Total Days Worked");
        lblrate = new JLabel("Rate Per Day");
        lblsalary = new JLabel("Salary");
        lblcompanyname.setBounds(260, 140, 200, 30);
        lblpaydate.setBounds(260, 180, 100, 30);
        lblstartdate.setBounds(260,220, 100, 30);
        lblenddate.setBounds(260, 260, 100, 30);
        lblid.setBounds(260, 300, 100, 30);
        lblemployeename.setBounds(260, 340, 160, 30);
        lbldepartment.setBounds(260, 380, 100, 30);
        lbldays.setBounds(260, 420, 160, 30);
        lblrate.setBounds(260, 460, 160, 30);
        lblsalary.setBounds(260, 500, 100, 30); 
       
        add(lblcompanyname);
        add(lblpaydate);
        add(lblstartdate);
        add(lblenddate);
        add(lblid);
        add(lblemployeename);
        add(lbldepartment);
        add(lbldays);
        add(lblrate);
        add(lblsalary);

        lblcompanyname.setFont(f2);
        lblpaydate.setFont(f2);
        lblstartdate.setFont(f2);
        lblenddate.setFont(f2);
        lblid.setFont(f2);
        lblemployeename.setFont(f2);
        lbldepartment.setFont(f2);
        lbldays.setFont(f2);
        lblrate.setFont(f2);
        lblsalary.setFont(f2);

        companyName = new JTextField(20);
        payDate = new JTextField(20);
        startDate = new JTextField(20);
        endDate = new JTextField(20);
        iD = new JTextField(20);
        empName = new JTextField(20);
        deptName = new JTextField(20);
        numDays = new JTextField(20);
        payRate = new JTextField(20);
        salary = new JTextField(20);

        companyName.setBounds(430, 140, 100, 30);
        payDate.setBounds(430, 180, 100, 30);
        startDate.setBounds(430, 220, 100, 30);
        endDate.setBounds(430, 260, 100, 30);
        iD.setBounds(430, 300, 100, 30);
        empName.setBounds(430, 340, 100, 30);
        deptName.setBounds(430, 380, 100, 30);
        numDays.setBounds(430, 420, 100, 30);
        payRate.setBounds(430, 460, 100, 30);
        salary.setBounds(430,500, 100, 30);

        add(companyName);
        add(payDate);
        add(startDate);
        add(endDate);
        add(iD);
        add(empName);
        add(deptName);
        add(numDays);
        add(payRate);
        add(salary);
        btnadd = new JButton("Add");
        btnsave = new JButton("Save");
        btnupdate = new JButton("Update");
        btndelete = new JButton("Delete");

        btnadd.setToolTipText("Click this button to Add record in the Database.");
        btnsave.setToolTipText("Click this button to Save record in the Database.");
        btnupdate.setToolTipText("Click this button to Update record in the Database.");
        btndelete.setToolTipText("Click this button to Delete record in the Database.");

        btnadd.setBounds(250, 600, 100, 30);
        btnsave.setBounds(360, 600, 100, 30);
        btnupdate.setBounds(470, 600, 100, 30);
        btndelete.setBounds(580, 600, 100, 30);
        btnadd.setFont(f1);
        btnsave.setFont(f1);
        btnupdate.setFont(f1);
        btndelete.setFont(f1);
        
        btnadd.setForeground(Color.WHITE);
        btnsave.setForeground(Color.white);
        btnupdate.setForeground(Color.white);
        btndelete.setForeground(Color.white);
        
        btnadd.setBackground(Color.black);
        btnsave.setBackground(Color.black);
        btnupdate.setBackground(Color.black);
        btndelete.setBackground(Color.black);

        add(btnadd);
        add(btnsave);
        add(btndelete);
        add(btnupdate);

        btnadd.addActionListener(this);
        btnsave.addActionListener(this);
        btnupdate.addActionListener(this);
        btndelete.addActionListener(this);
       
       btnfirst=new JButton("First");
       btnnext=new JButton("Next");
       btnprev=new JButton("Previous");
       btnlast=new JButton("Last");
       
       btnfirst.setToolTipText("Click this button to move to the First Record.");
       btnnext.setToolTipText("Click this button to move to the Next Record.");
       btnprev.setToolTipText("Click this button to move to the Previous Record.");
       btnlast.setToolTipText("Click this button to move to the Last Record.");
       
       btnfirst.setBounds(250,650,100,30);
       btnnext.setBounds(360,650,100,30);
       btnprev.setBounds(470,650,107,30);
       btnlast.setBounds(587,650,95,30);

       add(btnfirst);
       add(btnnext);
       add(btnprev);
       add(btnlast);  

       btnfirst.addActionListener(this);
       btnnext.addActionListener(this);
       btnprev.addActionListener(this);
       btnlast.addActionListener(this);
       
       btnfirst.setFont(f1);
       btnnext.setFont(f1);
       btnprev.setFont(f1);
       btnlast.setFont(f1);
       
       btnfirst.setBackground(Color.BLACK);
       btnnext.setBackground(Color.black);
       btnprev.setBackground(Color.black);
       btnlast.setBackground(Color.BLACK);
       
       btnfirst.setForeground(Color.white);
       btnnext.setForeground(Color.white);
       btnprev.setForeground(Color.white);
       btnlast.setForeground(Color.white);
       
       btnexit=new JButton("Exit");
       btnexit.setToolTipText("Click this button to Quit Program.");
       btnexit.setBounds(410,700,135,30);
       add(btnexit);
       btnexit.addActionListener(this);
       btnexit.setFont(f1);
       btnexit.setBackground(Color.black);
       btnexit.setForeground(Color.white);
 
       btncalculate=new JButton("Calculate");
       btncalculate.setToolTipText("Click this button to compute the salary of the employee.");
       btncalculate.setBounds(410,550,135,30);
       add(btncalculate);
       btncalculate.addActionListener(this);
       btncalculate.setFont(f1);
       btncalculate.setBackground(Color.BLACK);
       btncalculate.setForeground(Color.white); 
       
       //open database connection
       dbOpen();
       
    }
    
       public void actionPerformed(ActionEvent ae)  
      
     {
      try
       {
   
    if(ae.getActionCommand()=="Add")
   {
     
    companyName.setText("");
    payDate.setText("");
    startDate.setText("");
    endDate.setText("");
    iD.setText("");
    empName.setText("");
    deptName.setText("");
    numDays.setText("");
    payRate.setText("");
    salary.setText("");
    
  }
    
   if(ae.getActionCommand()=="Update") 
   {
     
       try{
      
    stmt.executeUpdate("UPDATE `pay_roll` SET companyName='" + companyName.getText() + "' ,payDate='" + payDate.getText()
                         + "',startDate='" + startDate.getText() + "',endDate='" + endDate.getText() + "',iD= '" + iD.getText() 
                         + "',empName='" + empName.getText()+ "',deptName='" + deptName.getText() 
                         +  "',numDays= '" + numDays.getText() + "',payRate='" + payRate.getText() + "',salary='" + salary.getText()
                         + "'WHERE iD=" +iD.getText() + " ");
      
    JOptionPane.showMessageDialog(this, "Updated Successfully"); 
   
    } catch (SQLException ex){ 
        JOptionPane.showMessageDialog(this, "could not update");
         dbClose();
         dbOpen();
  }
       
}
  
  if(ae.getActionCommand()=="Delete")
   {
      
       try{
       
    stmt.executeUpdate("DELETE FROM pay_roll WHERE id =" + iD.getText() + "");  
       
      JOptionPane.showMessageDialog(this, "Deleted succussfully");
      dbClose();

   }catch(SQLException ex){
      JOptionPane.showMessageDialog(this, "could not delete");
     
      // db open
      dbOpen();
   }
  }
    if(ae.getActionCommand()=="Save")
   {
     
    try{
     
    
  stmt.executeUpdate ("INSERT INTO pay_roll VALUES('" + companyName.getText() + "','"+ payDate.getText() + "','" + startDate.getText() + "','" + endDate.getText() + "','" + iD.getText()+ "','" 
  + empName.getText()  + "','" + deptName.getText() + "','" + numDays.getText()+ "','" + payRate.getText() + "','" + salary.getText() +"')");
  
     
  JOptionPane.showMessageDialog(this, "Saved Successfully"); 
  
  // db close
  dbClose();  
  companyName.setText("");
    payDate.setText("");
    startDate.setText("");
    endDate.setText("");
    iD.setText("");
    empName.setText("");
    deptName.setText("");
    numDays.setText("");
    payRate.setText("");
    salary.setText("");  
   
   }catch(SQLException ex){
       JOptionPane.showMessageDialog(this, "could not save");
     
         }
   }
       
   if (ae.getActionCommand()=="Next")  
   {
    if(rs.next())
    {
     setText();      
    }else
    {
     JOptionPane.showMessageDialog(null, "You are At Already Last Record", "Message", JOptionPane.ERROR_MESSAGE); 
     }
     
   if(ae.getActionCommand()=="Previous")
   {
      
   
    if(rs.previous())
    {
     setText();
    }
    else
    {
     JOptionPane.showMessageDialog(null, "You Are At Already First Record", "Message", JOptionPane.ERROR_MESSAGE);
     }
   
   }
   if (ae.getActionCommand()=="First")
   {
    
    if(rs.first())
    {
     setText();
    }
  
   }
   if (ae.getActionCommand()=="Last")
   {
     
   
    if(rs.last())
    {
     setText();
    }
   
   }
   if(ae.getActionCommand()=="Calculate")
   {
       
          numOfDays=Float.parseFloat(numDays.getText());
                        rate=Float.parseFloat(payRate.getText());
                        empsalary=(numOfDays*rate);
                         float round = Round(empsalary,2);
                         salary.setText(Float.toString(round));
                         salary.setEditable(false);        
   
   }
   if(ae.getActionCommand()=="Exit")
   {
       
   System.exit(0);  
   }
   }
   }catch(SQLException e)
  {
   e.printStackTrace();
  }
 } 
    

// Method to round off decimal values  

  public static float Round(float Rval, int Rpl) {
  float p = (float)Math.pow(10,Rpl);
  Rval = Rval * p;
  float tmp = Math.round(Rval);
  return (float)tmp/p;
    }  
 
 public void dbOpen() 
 {
  try
      
  { 
     String url = "jdbc:mysql://localhost:3307/payroll_1";
             
     //properties for creating connection to Oracle database 
 
       Properties props = new Properties();
       props.setProperty("user", "root");
       props.setProperty("Password","");
       //creating connection to Oracle database using JDBC
       
      conn = DriverManager.getConnection(url,props);
       
       conn = DriverManager.getConnection(url);
          
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

// here in this statement mydata is a DSN name which u have to create before run this program
// step to create dsn
// open control panel-> open administrativr tools-> open data source(ODBC)-> press add
//->select microsoft access driver(*.mdb) then finish->give data source name-> select database and press ok
// again press ok.
//conn=DriverManager.getConnection("jdbc:odbc:mydata");
   stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   rs = stmt.executeQuery("Select * from pay_roll");
   if(rs.next())
    setText();
    rs.next();
  }catch(SQLException e){
      System.out.print(e);
  }
 }
 public void dbClose()
 {
  try{
     stmt.close();
     rs.close();
     conn.close();
  }catch(SQLException e)
  {
   System.out.print(e);
}
 }
 public void setText(){
  try{
   companyName.setText(rs.getString(1));
   payDate.setText(rs.getString(2));
   startDate.setText(rs.getString(3));
   endDate.setText(rs.getString(4));
   iD.setText(rs.getString(5));
   empName.setText(rs.getString(6));
   deptName.setText(rs.getString(7));
   numDays.setText(rs.getString(8));
   payRate.setText(rs.getString(9));
   salary.setText(rs.getString(10));
   
      }catch(SQLException e){ 
       System.out.print(e);
      }
      }
}
 public class PayRoll_1{
     
 public static void main(String [] args) 
        {
  
        // create a object of Frame class in main method
            
         
         JFrame jf = new JFrame();
 
         Pay fr1=new Pay();
         
        fr1.getContentPane().setBackground(Color.white);
        
        // set frame size
         fr1.setSize(800,1600);
        
        // set frame visible true
        fr1.setVisible(true);
        
        }
 }


   



















































































































































































































































































































































































































































































































































































































































































































      
       
       

      
      
          
          

          
          
     
       
          
          
          
          
          
       
          
     
    
 

    



