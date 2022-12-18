import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.awt.Color;
 class MyFrame implements ActionListener

{
    JFrame f;
    JButton btn,jb;
    String fp;       
    JLabel t1,t2,t3,t4,t5;
    
    MyFrame()
        {
		f=new JFrame("Whatsapp Chat Viewer-SCAM");
		f.setSize(500,500);
	  	f.setLocation(800,200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn=new JButton("Upload");
		btn.setBounds(210,250,90,50);
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		btn.setFocusable(false);
		btn.addActionListener(this);
		t5=new JLabel("Upload and go check your alligned chat from your directory!!");
		t5.setBounds(0,403,500,25);
		t5.setFont(new Font("Papyrus",Font.ROMAN_BASELINE,15));
		t5.setOpaque(true);
		t5.setBackground(Color.white);
		t5.setHorizontalAlignment(SwingConstants.CENTER);	
		t5.setForeground(Color.black);
		f.add(t5);
		t1=new JLabel("CHAT ALIGNER");
		t1.setBounds(10,20,460,80);
		t1.setFont(new Font("Papyrus",Font.ITALIC,40));
		t1.setOpaque(true);
		t1.setBackground(Color.black);
		t1.setHorizontalAlignment(SwingConstants.CENTER);	
		t1.setForeground(Color.white);
		f.add(t1);
		t3=new JLabel("");
		t3.setBounds(0,400,500,2);
		t4=new JLabel("");
		t4.setBounds(0,430,500,2);
		t3.setOpaque(true);
		t3.setBackground(Color.black);
		t4.setOpaque(true);
		t4.setBackground(Color.black);
		f.add(t3);
		f.add(t4);
		t2=new JLabel("Please upload your exported whatsapp chat here!!");
		t2.setBounds(10,140,460,40);
		t2.setFont(new Font("Verdana",Font.PLAIN,15));
		t2.setOpaque(true);
		t2.setBackground(Color.black);
		t2.setHorizontalAlignment(SwingConstants.CENTER);	
		t2.setForeground(Color.white);
		f.add(t2);
		f.setLayout(null);
		f.add(btn);
		f.setVisible(true); 
        }
	public void actionPerformed (ActionEvent evt)  {
            if(evt.getSource()==btn)
            {
                JFileChooser file_upload=new JFileChooser();
              //file_upload.showOpenDialog(null);
              int res=file_upload.showOpenDialog(null);
              if(res==JFileChooser.APPROVE_OPTION)
              {
              	java.io.File f=file_upload.getSelectedFile();
			 System.err.println(f.getPath());
			fp=f.getPath();
	      }
	      try {
		    
	             FileInputStream fstream = new FileInputStream(fp);
               	     DataInputStream in = new DataInputStream(fstream);
	             BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    
               	     String strLine;
	             // Read File Line By Line
	              String user1=null;
	              String user2=null;
	              int i=0;
		      String fn1=user1+"_"+user2+".txt";
	              FileWriter fw=new FileWriter(fn1,true);
	              while ((strLine = br.readLine()) != null) {
		      if(i==0){
			i++;
			continue;
		      }
		      String[] a=strLine.split(",",2);
		      String[] b=a[1].split("-",2);
                      String[] c=b[1].split(":",2);
		      String user=c[0].trim();
		      if(user1==null)
			 user1=user;
		      if(user.compareTo(user1)==0){
			fw.write("\n"+user + ":" + c[1]);
			i++;
		      }
		      else{
			   if(user2==null)
			       	user2=user;
			   if(user.compareTo(user2)==0){
				fw.write("\n\t\t\t\t\t\t\t\t\t" + user + ":" + c[1]);
				i++;
			}
		}
	}
	 
	
	br.close();
	in.close();
	fw.close();
	} catch (Exception e) {// Catch exception if any
		System.err.println("Error: " + e.getMessage());
	}

              }
            }
            
        
}
public class ChatAligner
{
    public static void main(String [] args)
 {
        MyFrame obj=new MyFrame();
        
    }
}
