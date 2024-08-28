package bankingApplication;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CustomerId {

	    private static final int CUSTOMER_ID_LENGTH = 5;
	    static String uniqueAccountNumber=null;
	    
	    public static String generateUniqueAccountNumber() {
	        Set<String> usedAccountNumbers = new HashSet<String>();
	        Random random = new Random();

	        while (true) {
	            StringBuilder accountNumberBuilder = new StringBuilder();
	            for (int i = 0; i < CUSTOMER_ID_LENGTH; i++) {
	                accountNumberBuilder.append(random.nextInt(10)); // Generate a random digit (0-9)
	            }
	            String accountNumber = accountNumberBuilder.toString();

	            if (!usedAccountNumbers.contains(accountNumber)) {
	                usedAccountNumbers.add(accountNumber);
	                return accountNumber;
	            }
	        }
	    }
	    public static int customerIdVal() {
	    	uniqueAccountNumber = generateUniqueAccountNumber();
	        int CustId = Integer.parseInt(uniqueAccountNumber);
	        return CustId;
	    }
	    public static void main(String[] args) {
	  
	        System.out.println("Generated Account Number: " + uniqueAccountNumber);
	    }

	    
	}


