import java.util.*;

class Account
{	
	long Pan_No;
	long Acc_name;
	String Name;
	int Age;
	String Address;
	long PhoneNo;
	double Balance;

	
	Account(long Pan_No)
	{		
		this.Pan_No = Pan_No;
	}
	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name : ");
		Name = sc.nextLine();
		System.out.print("Enter your age : ");
		Age = sc.nextInt();
		sc.nextLine(); 
		System.out.print("Enter your address : ");
		Address = sc.nextLine();
		System.out.print("Enter your Phone No. : ");
		PhoneNo = sc.nextLong();
		System.out.print("Enter the amount you want to deposit initially : ");
		Balance = sc.nextDouble();
		Acc_name = (long)Math.random()*1000000;
		
	}
	void display()
	{
		System.out.println("\033c");

		System.out.println("DETAILS : \n");
		System.out.println("Name : " + Name);
		System.out.println("Account Number : " + Acc_name);
		System.out.println("Age : " + Age);
		System.out.println("Address : " + Address);
		System.out.println("Phone No. : " + PhoneNo);
		System.out.println("Current Balance : " + Balance);
	}
}

class CreateAccount
{
	void createAccount(Account A[], int c)
	{
		System.out.println("\033c");
		System.out.println("Enter Details for Account Creation \n");
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter The Pan Number \n");
		long pan_no = sc.nextLong();
		A[c] = new Account(pan_no) ;
		A[c].input();
		//A[c].display();
	}
}

class UpdateDetails
{
	void updateDetails(Account A[], int n)
	{

		System.out.println("\033c");
		//System.out.println("Enter Details for Account Creation \n");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Pan Number to Upadate Details : ");
		long pan_no = sc.nextLong();
		int flag=0;
		for(int i=0;i<n;i++)
		{
			if(A[i].Pan_No == pan_no)
			{
				A[i].input();
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("\nThe Account doesn't exist with the given Pan No. ");
		}
		return ;
	}
}

class CheckBalance
{	

		void checkBalance(Account A[], int n)
		{
		System.out.println("\033c");
		//System.out.println("Enter Details for Account Creation \n");

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Pan Number to Check Balance : ");
		long pan_no = sc.nextLong();
		int flag=0;
		for(int i=0;i<n;i++)
		{
			if(A[i].Pan_No == pan_no)
			{
				System.out.println("Cuurent Balance: " + A[i].Balance);
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("\nThe Account doesn't exist with the given Pan No. ");
		}
		return ;
		}
}

class WithdrawDeposit
{
	void withdraw(Account A[] , int n)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Pan Number to Withdraw Amount : ");
		long pan_no = sc.nextLong();
		int flag=0;
		for(int i=0;i<n;i++)
		{
			if(A[i].Pan_No == pan_no)
			{
				System.out.print("Enter Amount to withdraw (Limit is 50000) : ");
				double amount = sc.nextDouble();
				if(amount > 50000)
				{
					System.out.println("The amount withdraw limit is 50000");
					return;
				}
				if(amount > A[i].Balance)
				{
					System.out.println("Insuffient Balance ");
					return ;
				}
				else
				{
					A[i].Balance = A[i].Balance - amount;
					System.out.println("Your current Balance is " + A[i].Balance);
					
				}
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("\nThe Account doesn't exist with the given Pan No. ");
		}
		return ;		
	}
	
	void deposit(Account A[], int n)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Pan Number to Deposit Amount : ");
		long pan_no = sc.nextLong();
		int flag=0;
		for(int i=0;i<n;i++)
		{
			if(A[i].Pan_No == pan_no)
			{
				System.out.print("Enter Amount to Deposit : ");
				double amount = sc.nextDouble();
				A[i].Balance = A[i].Balance + amount;
				System.out.println("Your current Balance is " + A[i].Balance);	
				flag=1;
				break;
			}
		}
		if(flag==0)
		{
			System.out.println("\nThe Account doesn't exist with the given Pan No. ");
		}
		return ;
	}
}

class ATM
{
	public static void main(String s[])
	{
		
		Scanner sc = new Scanner(System.in);
		Account A[] = new Account[10];
		int i=0;
		int q=1;
		while(q!=0)
		{
		System.out.println("\033c");
		System.out.println("-------------- ATM MANAGEMENT SYSTEM -------------- ");

		System.out.println("1. Create a account");
		System.out.println("2. Update details ");
		System.out.println("3. Check Balance ");
		System.out.println("4. Withdraw Amount");
		System.out.println("5. Deposit Amount");
		System.out.println("6. Exit");
		
		
		System.out.print("\nEnter your choice: ");
		int ch = sc.nextInt();
		
		switch(ch)
		{
			case 1 -> {CreateAccount CA = new CreateAccount();
				CA.createAccount(A, i); i++; break;}
			
			case 2 -> {UpdateDetails UD = new UpdateDetails();
				UD.updateDetails(A, i); break; }
			
			case 3 -> { CheckBalance CB = new CheckBalance();
				CB.checkBalance(A, i); break; }

			case 4 -> { WithdrawDeposit WD = new WithdrawDeposit(); 
				WD.withdraw(A, i); break; }

			case 6 -> { System.out.println("THANK YOUUU"); System.exit(0);}
				
		}
		System.out.println("\n\nDo you want to continue???(1 for Yes/ 0 for No) ");
		q= sc.nextInt();
		}
		System.out.println("THANK YOUUU");
	}
}