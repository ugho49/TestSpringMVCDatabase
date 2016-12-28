package fr.nantes.ustephan.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * Created by ughostephan on 29/12/2016.
 */
@Component
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${mail.default.from}")
    private String defaultFrom;

    /**
     * Send mail with default "from" value.
     *
     * @param to      the to
     * @param subject the subject
     * @param message the message
     */
    public void sendMail(String to, String subject, String message) {
        send(defaultFrom, to, subject, message);
    }

    /**
     * Send mail with custom "from" value.
     *
     * @param from    the from
     * @param to      the to
     * @param subject the subject
     * @param message the message
     */
    public void sendMail(String from, String to, String subject, String message) {
        send(from, to, subject, message);
    }


    private void send(String from, String to, String subject, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(message);
        mailSender.send(mail);
    }
}
