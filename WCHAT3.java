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
//class MyFrame extends JFrame implements ActionListener
 class MyFrame implements ActionListener

{
	JFrame f;
    JButton btn;
    String fp;       
    
    MyFrame()
        {
		f=new JFrame("Watsapp Chat Viewer-SCAM");
		f.setSize(500,500);
	  	f.setLocation(400,200);
		btn=new JButton("Upload File");
		btn.setBounds(200,180,120,80);
		btn.addActionListener(this);
		f.setLayout(null);
		f.add(btn);
		f.setVisible(true);
            
			
            /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.setTitle("Chat Viewer");
            this.setLocationRelativeTo(null);
	    this.setSize(500,500);
	    this.setLocation(400,200);
            this.setLayout(new FlowLayout());
            btn=new JButton("Upload File");
	    btn.setBounds(200,300,60,60);
	    btn.setFocusable(false);
	    btn.addActionListener(this);
            this.add(btn);
            this.pack();
            this.setVisible(true);*/
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
		
		/*	try{



			
		FileReader fr=new FileReader(f.getPath());
		BufferedReader br = new BufferedReader(fr);
		String l,t;
		l=br.readLine();
		int i1=0;
		int i2=0;
		String[]a=l.split(",", 2);
		String[]b=a[1].split("-",2);
		String[]c=b[1].split(":", 2);
		String user1=c[0];
		String user2=c[0];
		String[]d=new String[1200];
		String[]e=new String[1200];
		String[]f1=new String[1200];
		t=br.readLine();
		while(t!=null){
			d=t.split(",", 2);
			e=d[1].split("-",2);
			f1=e[1].split(":", 2);
			if(user1!=f1[0]){
				user2=f1[0];
			}
			t=br.readLine();
                }
		System.out.println(" " + user2);
		System.out.println("" + user1);
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
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
	Scanner sc =new Scanner(System.in);
	System.out.println("give a file name");
	String fname=sc.nextLine();
	FileWriter fw=new FileWriter(fname,true);
	while ((strLine = br.readLine()) != null) {
		if(i==0){
			i++;
			continue;
			}
		//System.out.println(strLine);
		String[] a=strLine.split(",",2);
		String[] b=a[1].split("-",2);

		String[] c=b[1].split(":",2);
		String user=c[0].trim();
		
		if(user1==null)
			user1=user;
		if(user.compareTo(user1)==0){
			//System.out.println(user +":"+c[1]);
			fw.write("\n"+user + ":" + c[1]);
			i++;
		}
		else{
			if(user2==null)
				user2=user;
			if(user.compareTo(user2)==0){
				//System.out.println("\t\t\t\t\t\t\t" + ":"+c[1]);
				//System.out.println("\t\t\t\t\t\t\t\t" + user + ":" + c[1]);
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
public class WCHAT3
{
    public static void main(String [] args)
 {
        MyFrame obj=new MyFrame();
        
    }
}
