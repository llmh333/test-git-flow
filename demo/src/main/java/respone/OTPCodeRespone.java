package respone;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OTPCodeRespone {
    private String otpCode;
    private LocalDateTime expiryOTPCode;
}
