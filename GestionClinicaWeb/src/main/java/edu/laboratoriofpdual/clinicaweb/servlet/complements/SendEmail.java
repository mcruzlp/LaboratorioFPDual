package edu.laboratoriofpdual.clinicaweb.servlet.complements;

import java.util.*;  
import javax.mail.*;
import javax.mail.internet.*;  
  
public class SendEmail  
{  
 public static void main(String [] args){  
      String to = "mcruzlp@gmail.com";
      String from = "mcruzlp@gmail.com";
      String host = "localhost";
  
     //Get the session object  
      Properties properties = System.getProperties();  
      properties.setProperty("mail.smtp.host", host);  
      Session session = Session.getDefaultInstance(properties);  
  
     //compose the message  
      try{  
         MimeMessage message = new MimeMessage(session);  
         message.setFrom(new InternetAddress(from));  
         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
         message.setSubject("Restaurar contraseña");  
         message.setText("Haz click en el siguiente enlace para restablecer tu contraseña: https://restablecercontrasena.com");  
  
         // Send message  
         Transport.send(message);  
         System.out.println("message sent successfully....");  
  
      }catch (MessagingException mex) {mex.printStackTrace();}  
   }  
}  
