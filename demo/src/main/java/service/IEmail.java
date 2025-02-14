package service;

import respone.OTPCodeRespone;

public interface IEmail {

    public OTPCodeRespone sendMail(String receivedEmail);
}
