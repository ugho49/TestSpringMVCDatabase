package fr.nantes.ustephan.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by ughostephan on 28/12/2016.
 */
@Configuration
public class MailConfig {

    @Autowired
    Environment env;

    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(env.getProperty("mail.host"));
        javaMailSender.setPort(Integer.valueOf(env.getProperty("mail.port")));

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", env.getProperty("mail.transport.protocol"));
        properties.setProperty("mail.smtp.auth", env.getProperty("mail.smtp.auth"));
        properties.setProperty("mail.smtp.starttls.enable", env.getProperty("mail.smtp.starttls.enable"));
        properties.setProperty("mail.debug", env.getProperty("mail.debug"));
        return properties;
    }
}
