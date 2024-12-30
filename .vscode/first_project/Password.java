import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Random;

public class Password implements Printable {
    private String password;
    private static final String key = "Bar12345Bar12345";
    private static final Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    private static final int strongPasswordLenght = 12;

    public Password() {
        this.password = encryptPassword(generateStrongPassword());
    }

    public Password(String password) {
        this.password = encryptPassword(password);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    private String encryptPassword(String toEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(toEncrypt.getBytes());
            String encryptedPassword = new String(encrypted);
            return encryptedPassword;
        } catch (Exception e) {
            return "Encryption failed";
        }
    }

    private String decryptPassword(String toDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] decrypted = cipher.doFinal(toDecrypt.getBytes());
            String decryptedPassword = new String(decrypted);
            return decryptedPassword;
        } catch (Exception ex) {
            return "Decryption failed";
        }
    }

    private String generateStrongPassword() {
        String alphabet = "AQWERTYUFHVJX12345678901234678480801@@@CNSJWQPGTMKahsrtyriopsaxbnskdlx[]><!!%^$#&*)(++==)";
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        Random random = new Random();
        StringBuilder generatedString = new StringBuilder();
        while (true) {
            for (int i = 0; i < strongPasswordLenght; i++) {
                int index = random.nextInt(alphabet.length());
                generatedString.append(alphabet.charAt(index));
            }
            if (generatedString.toString().matches(regex)) {
                return generatedString.toString();
            } else {
                generatedString.setLength(0);
            }
        }
    }

    private String getOriginalPassword() {
        return decryptPassword(this.password);
    }

    public String getEncryptedPassword() {
        return this.password;
    }

    public int getPasswordLength() {
        return this.decryptPassword(this.password).length();
    }

    @Override
    public void listData() {
        System.out.println("Password: " + getOriginalPassword());
    }
}
