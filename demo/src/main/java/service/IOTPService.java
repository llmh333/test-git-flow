package service;

import respone.OTPCodeRespone;

public interface IOTPService {
    public OTPCodeRespone genarateOTP();

    public boolean checkOTP(OTPCodeRespone otpcr, String otp);
}
