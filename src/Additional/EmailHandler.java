package Additional;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailHandler {
    private String username;
    private String password;
    private String receiver;
    private Message message;
    private String Subject;
    private String Text;

    public EmailHandler(String to) {
        this.receiver = to;
        this.prepareEmail();
    }

    public EmailHandler(String to,String subject,String text) {
        this.prepareEmail();
        this.receiver = to;
        this.Subject = subject;
        this.Text = text;
    }

    // Getters
    public String getFromAddress() {
        return this.username;
    }

    public  String getToAddress() {
        return this.receiver;
    }

    public String getSubject() {
        return this.Subject;
    }

    public String getText() {
        return this.Text;
    }

    // Setters
    public void setToAddress(String to) {
        this.receiver = to;
    }

    public void setSubject(String sub) {
        this.Subject = sub;
    }

    public void setMessage(String message) {
        this.Text = message;
    }

    // Utility Functions
    private void prepareEmail() {
        this.username = "bootcampvisa@gmail.com";
        this.password = "bootcamp_2019";
        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }

        });

        this.message = new MimeMessage(session);
    }

    public boolean checkPresence() {
        return ((receiver != null) && (Subject != null)  && (Text != null));
    }

    public void sendMessage() {
        if(checkPresence()) {
            try {
                this.message.setFrom(new InternetAddress(this.username));
                this.message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.receiver));
                this.message.setSubject(Subject);
                this.message.setText(Text);
            }
            catch(Exception ex) {
                System.out.println("Email Handler: "+ex);
            }
        }
    }

}
