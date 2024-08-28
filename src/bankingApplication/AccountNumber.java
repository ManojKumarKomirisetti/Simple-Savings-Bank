package bankingApplication;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AccountNumber {
    private static final int ACCOUNT_NUMBER_LENGTH = 11;
    
    public static String uniqueAccountNumber = null;
    
    public static String generateUniqueAccountNumber() {
        Set<String> usedAccountNumbers = new HashSet<String>();
        Random random = new Random();

        while (true) {
            StringBuilder accountNumberBuilder = new StringBuilder();
            for (int i = 0; i < ACCOUNT_NUMBER_LENGTH; i++) {
                accountNumberBuilder.append(random.nextInt(10)); // Generate a random digit (0-9)
            }
            String accountNumber = accountNumberBuilder.toString();

            if (!usedAccountNumbers.contains(accountNumber)) {
                usedAccountNumbers.add(accountNumber);
                return accountNumber;
            }
        }
    }
    
    
    public static String NumberAcc() {
    	uniqueAccountNumber = generateUniqueAccountNumber();
        return uniqueAccountNumber;
    }
    

    public static void main(String[] args) {
    	//System.out.println(accountNumberVal());
        //System.out.println("Generated Account Number: " + uniqueAccountNumber);
    }

    
}

