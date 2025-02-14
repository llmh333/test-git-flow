package service.iplm;

import common.MailConfig;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import respone.OTPCodeRespone;
import service.IEmail;
import service.IOTPService;

import java.util.Properties;

public class EmailServiceIplm implements IEmail {
    @Override
    public OTPCodeRespone sendMail(String receivedEmail) {
        // Get properties object
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.host", MailConfig.HOST_NAME);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.port", MailConfig.TSL_PORT);

            // get Session
            Session session = Session.getDefaultInstance(props, new jakarta.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD);
                }
            });
            // compose message
            MimeMessage message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receivedEmail));
            message.setSubject("Mã OTP");
            IOTPService otpService = new OTPServiceIplm();
            OTPCodeRespone otpcr = otpService.genarateOTP();
            message.setText("Mã OTP của bạn là: " + otpcr.getOtpCode());

            // send message
            Transport.send(message);

            return otpcr;
        } catch (MessagingException e) {
            e.printStackTrace();
            return null;

        }
    }

}