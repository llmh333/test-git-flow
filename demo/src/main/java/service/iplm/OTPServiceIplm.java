package service.iplm;

import lombok.Getter;
import lombok.Setter;
import respone.OTPCodeRespone;
import service.IOTPService;

import java.security.SecureRandom;
import java.time.LocalDateTime;

@Getter
@Setter

public class OTPServiceIplm implements IOTPService {
    private String otp;
    private LocalDateTime expiryOTP;
    private final SecureRandom random = new SecureRandom();

    public OTPServiceIplm() {

    }

    public String getOTP() {
        return otp;
    }

    public OTPCodeRespone genarateOTP() {
        this.otp = String.format("%06d", random.nextInt(100000));
        this.expiryOTP = LocalDateTime.now().plusMinutes(1);
        return new OTPCodeRespone().builder().otpCode(otp).expiryOTPCode(expiryOTP).build();
    }

    public boolean checkOTP(OTPCodeRespone otpcr, String otp) {
        if (otpcr.getOtpCode() == null) return false;
        if (otpcr.getOtpCode().equals(otp)) {
            if (!LocalDateTime.now().isAfter(otpcr.getExpiryOTPCode())) {
                resetOTP(otpcr);
                return true;
            }
            else {
                resetOTP(otpcr);
                return false;
            }
        } else return false;
    }

    public void resetOTP(OTPCodeRespone otpCodeRespone) {
        otpCodeRespone.setOtpCode(null);
        otpCodeRespone.setExpiryOTPCode(null);
    }

}
