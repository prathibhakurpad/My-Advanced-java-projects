package mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.PopupList;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
 
public class MailManager {

public void SendMail(){
	

	Display d1 = new Display();
	Shell s1 = new Shell(d1);
	s1.setSize(500, 500);
	Text text1 = new Text(s1, SWT.WRAP | SWT.BORDER);
    text1.setBounds(200, 170, 100, 20);
    text1.setTextLimit(30);
    text1.setSize(200, 20);
    //text1.setText("12345");
    Text text2 = new Text(s1, SWT.SINGLE | SWT.BORDER);
    text2.setBounds(200, 200, 100, 20);
    text2.setTextLimit(30);
    text2.setSize(200, 20);
    Text text3 = new Text(s1, SWT.SINGLE | SWT.BORDER);
    text3.setBounds(200, 230, 100, 20);
    text3.setTextLimit(30);
    text3.setSize(200, 20);
   /* Text text4 = new Text(s1, SWT.SINGLE | SWT.BORDER);
    text4.setBounds(200, 200, 100, 20);
    text4.setTextLimit(30);
    text4.setSize(200, 20);*/
    //text2.setText("ABC");
    Label l1 = new Label(s1, SWT.BORDER);
    l1.setText("Enter user name");
    l1.setBounds(100, 170, 100, 20);
    Label l2 = new Label(s1, SWT.BOLD);
    l2.setText("Password");
    l2.setBounds(100, 200, 100, 20);
    Label l3 = new Label(s1, SWT.BORDER);
    l3.setText("Enter to address");
    l3.setBounds(100, 230, 100, 20);
    Button b1 = new Button(s1, SWT.PUSH);
    b1.setText("Submit");
    b1.setBounds(130, 290, 100, 20);
    Button b2 = new Button(s1, SWT.PUSH);
    b2.setText("Reset");
    b2.setBounds(250, 290, 100, 20);
    
    
    
    s1.open();
    
	
 b1.addSelectionListener(new SelectionAdapter() {
	 public void widgetSelected(SelectionEvent e){
		 
		    String username = text1.getText();
		    String password = text2.getText();
		    String toadd = text3.getText();
		 Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
		 props.put("mail.smtp.starttls.enable", "true");
		 props.put("mail.smtp.host", "smtp.gmail.com");
		 props.put("mail.smtp.port", "587");
		 Session session = Session.getInstance(props,
		 new javax.mail.Authenticator() {
		 protected PasswordAuthentication getPasswordAuthentication() {
		 return new PasswordAuthentication(username, password);
		 }
		 });
		 try {
		 Message message = new MimeMessage(session);
		 message.setFrom(new InternetAddress(username));
		 message.setRecipients(Message.RecipientType.TO,
		 InternetAddress.parse(toadd));
		 message.setSubject("Test Mail");
		 message.setText("This mail is sent from Java Program !!");
		 Transport.send(message);
		 
		 
		// Dialog d2 = new Dialog(s1) ;
		 
		 
		 MessageBox messageBox = new MessageBox(s1, SWT.OK );
	        
	        messageBox.setText("Sucess");
	        messageBox.setMessage("Your mail sent Sucessfully");
	        
	        messageBox.open();
	        
	        //Button b3 = new 
		 
		 
		 
		 
		 } catch (MessagingException e1) {
		 throw new RuntimeException(e1);
		 }

		 
	 }
}); 
   b2.addSelectionListener(new SelectionAdapter() {
	   
	   public void widgetSelected(SelectionEvent e){
		    
		   text1.setText(" ");
		   text2.setText(" ");
		   text3.setText(" ");
	   }
	   
	   
});
 
//final String username = "prathibhakurpad4@gmail.com";
 
//final String password = "{*nagesh*}";
 
 while(!s1.isDisposed()){
 	
 	if(d1.readAndDispatch()) d1.sleep();
 	
 }
 d1.dispose();


}
}
