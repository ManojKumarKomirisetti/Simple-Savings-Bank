package bankingApplication;
import java.security.SecureRandom;
import java.util.Base64;
public class PasswordGenerator {

	static String generatedPassword = null;
	    private static final int PASSWORD_LENGTH = 12;

	    public static String generatePassword() {
	    	
	        SecureRandom secureRandom = new SecureRandom();
	        byte[] randomBytes = new byte[PASSWORD_LENGTH];
	        secureRandom.nextBytes(randomBytes);

	        return Base64.getEncoder().encodeToString(randomBytes);
	    }
	    public static String pass()
	    {
	    	generatedPassword = generatePassword();
	    	return generatedPassword;
	    }
	    
	    public static void main(String[] args) {
//	        pass();
//	        System.out.println("Generated Password: " + generatedPassword);
	    }
	}

