package bank;
import java.util.*;


class Account
{
	private int accountNumber;
	private String accountType;
	private String serviceBranchIFSC;
	private float minimumBalance;
	private float availableBalance;
	private int customerId;
	private String customerName;
	private static int totalAccountCreated;
	
	Account()
	{
		accountNumber =0;
		accountType= "";
		serviceBranchIFSC = "";
		minimumBalance = 0;
		availableBalance = 0;
		customerId = 0;
		customerName = "";
		totalAccountCreated++;
	}
	
	public void setDetails()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("a) Enter the account no.: ");
		accountNumber = sc.nextInt();
	
		
		String s = sc.nextLine();
		System.out.println("b) Enter the account type: ");
		accountType = sc.nextLine();
		
		System.out.println("c) Enter the Service branch IFSC: ");
		serviceBranchIFSC = sc.nextLine();
		
		System.out.println("d) Enter minimum balance: ");
		minimumBalance = sc.nextFloat();
		s = sc.nextLine();
		
		System.out.println("e) Enter available balance: ");
		availableBalance = sc.nextFloat();
		s = sc.nextLine();
		
		System.out.println("f) Enter the customer id: ");
		customerId = sc.nextInt();
		s = sc.nextLine();
		
		System.out.println("g) Enter the customers name: ");
		customerName= sc.nextLine();
		
	}
	
	public void setDetails(int accnumber, String Type, String branch, float minBalance, float availbalance, int Id, String Name)
	{
		accountNumber =accnumber;
		accountType= Type;
		serviceBranchIFSC = branch;
		minimumBalance = minBalance;
		availableBalance =  availbalance;
		customerId = Id;
		customerName = Name;
	}
	public String getDetails(int accountNo)
	{
		String s = "a) The account no. is: "+accountNumber+"\nb) The account type is: "+accountType+"\nc) The service branch IFSC is: "+serviceBranchIFSC+"\nd) The available balance is: "+availableBalance+"\ne) The customer id is: "+customerId+"\nf) The customer name is: "+customerName;
		return s;
	}
	
	public void updatedetails(int accountNo)
	{
		int b;
		Scanner sc = new Scanner(System.in);
		
			
			System.out.println("Enter the no. for what you want to update:\n 1.Account type\n 2.Service branch IFSC\n 3.Customer id\n 4.customer name\n 5.Exit\n");
			b = sc.nextInt();
			switch(b) { 
			
			case 1:
				System.out.println("Enter the new account type");
				accountType = sc.nextLine();
				break;
			case 2:
				System.out.println("Enter the new service branch IFSC");
				serviceBranchIFSC = sc.nextLine();
				break;
			case 3:
				System.out.println("Enter the new customer id");
				customerId = sc.nextInt();
				
				break;
			case 4:
				String s1= sc.nextLine();
				System.out.println("Enter the new customer name");
				customerName = sc.nextLine();
				break;
			case 5:
				return;
			default:
				System.out.println("Wrong no. entered please enter again");
				break;
			
			}
			
	}
	
	public float getBalance(int accountNo)
	{
		return availableBalance;
	}
	
	
	public void deposit(int accountNo,float amount)
	{
		availableBalance = availableBalance + amount;
		System.out.printf("Amount deposited Successfully. The current balance is %f \n",availableBalance);
		
	}
	
	public void withDraw(int accountNo,float amount)
	{
		float current = (availableBalance - amount);
		if(current<minimumBalance)
		{
			System.out.println("Sorry, can't withdraw as there is no enough balance\n");
		}
		else
		{
			availableBalance = availableBalance - amount;
			System.out.printf("Amount withdrawl Successfully. The current balance is %f .\n",availableBalance);
			
		}
		
	}
	public static int totalAccount()
	{
		return totalAccountCreated;
	}
	public void compare( Account account1, Account account2){
     String s;
     if(account1.availableBalance<account2.availableBalance){
         s=account2.getDetails(account2.accountNumber);
         System.out.println(s);
     }
     else{
         s=account1.getDetails(account1.accountNumber);
         System.out.println(s);
     }
 }
	
	
	
}
public class BankingSystem {
public static void main(String args[])
{
	  int choice;
	  int accnumber;
	  float amount;
		
		Scanner sc = new Scanner(System.in);
		
		Account[] account= new Account[50];
		account[0]= new Account();
		account[0].setDetails(0,"SAVING","ASD",10000,250000,1,"Heena Matlani");
		account[1]= new Account();
		account[1].setDetails(1,"CURRENT","FGH",5000,10000,1,"Aaruhi");
		account[2]= new Account();
		account[2].setDetails(2,"SAVING","THU",11000,300000,1,"Amritjot");
		account[3]= new Account();
		account[3].setDetails(3,"CURRENT","UIO",5000,60000,1,"Ritu");
		account[4]= new Account();
		account[4].setDetails(4,"SAVING","OPI",11000,44000,1,"Yogita");
		int i=5;
		
		while(true) {
		System.out.println("---------------------------------------------------------");
		System.out.println("          WELCOME TO THE BANK");
		System.out.println("---------------------------------------------------------");
		System.out.println("Choose from the following what you wanna do from the options:");
		System.out.println("1. Update details");
		System.out.println("2. Get details");
		System.out.println("3. Deposit");
		System.out.println("4. Withdraw");
		System.out.println("5. Set details");
		System.out.println("6. Total numbers of accounts");
		System.out.println("7. Compare accounts");
		System.out.println("8. Exit");
		
				
				
		choice= sc.nextInt();
		switch(choice) { 
		
		case 1:

			System.out.println("- Enter the account no.");
			accnumber = sc.nextInt();
			account[accnumber].updatedetails(accnumber);
			break;
		case 2:
			System.out.println("- Enter the account no.");
			accnumber = sc.nextInt();
			String s =account[accnumber].getDetails(accnumber);
			System.out.printf("%s\n",s);
			break;
		case 3:
			System.out.println("- Enter the account no.");
			accnumber= sc.nextInt();
			System.out.println("- Enter the amount");
			amount = sc.nextInt();
			account[accnumber].deposit(accnumber,amount);
			break;
		case 4:
			System.out.println("- Enter the account no.");
			accnumber = sc.nextInt();
			System.out.println("- Enter the amount");
			amount = sc.nextInt();
			account[accnumber].withDraw(accnumber,amount);
			break;
		case 5:
			account[i] = new Account();
			account[i].setDetails();
			i++;
			break;
		case 6:
			int accounts = account[i].totalAccount();
			System.out.printf("The total numbers of account created is %d\n",accounts);
			break;
		case 7:
			System.out.println("- Enter the first account no.");
			accnumber = sc.nextInt();
			System.out.println("- Enter the second account no.");
			int acc1 = sc.nextInt();
			
			account[accnumber].compare(account[accnumber], account[acc1]);
			
			
			break;
		case 8:
			return;
		default:
			System.out.println("Wrong no. entered please enter again\n");
			break;
		
		}
		}
}
}