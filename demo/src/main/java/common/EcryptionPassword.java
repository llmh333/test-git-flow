package common;


import org.mindrot.jbcrypt.BCrypt;

public class EcryptionPassword {

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String hashPassword) {
        return BCrypt.checkpw(password,hashPassword);
    }


}
