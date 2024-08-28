import java.util.*;
class Student
{
	double OS;
	double DBMS;
	double Maths;
	double OOPS;
	double Networking;
	
	public Student(double OS, double DBMS, double Maths, double OOPS, double Networking)
	{
		this.OS = OS;
		this.DBMS = DBMS;
		this.Maths = Maths;
		this.OOPS = OOPS;
		this.Networking = Networking;
	}

	double sum()
	{
		double sum=0.0;
		sum = OS + DBMS + Maths + OOPS + Networking;
		return sum;
	}
	double percentage()
	{
		double percentage = sum()/5;
		return percentage;
	}
	char grade()
	{
		if(percentage() >= 90)
		{
			return 'O';
		}
		else if(percentage() >= 80)
		{
			return 'E';
		}
		else if(percentage() >= 70)
		{
			return 'A';
		}
		else if(percentage() >= 60)
		{
			return 'B';
		}
		else if(percentage() >= 50)
		{
			return 	'C';
		}
		else if(percentage() >= 40)
		{
			return 'D';
		}
		return 'F';
	}
}
	

class Organize extends Student
{
	Organize(double OS, double DBMS, double Maths, double OOPS, double Networking)
	{
		super(OS, DBMS, Maths, OOPS, Networking);
	}
	void organize()
	{
		System.out.println("\033c");

		Scanner sc = new Scanner(System.in);

		System.out.println("Calculate the following :-\n");

		double sum = sum();
		double percentage = percentage();
		char grade = grade();

		System.out.println("1. SUM : " + sum);  
		System.out.println("3. PERCENTAGE : " + percentage);
		System.out.println("4. GRADE : "+ grade);
				
		
		
	}		
}
class Input
{
	void input()
	{
		System.out.println("\033c");

		Scanner sc = new Scanner(System.in);

		System.out.println("ENTER DETAILS OF THE STUDENT\n");
		System.out.print("1. Name : ");
		String name = sc.nextLine();
		System.out.print("2. Roll No. : ");
		Long roll = sc.nextLong();
		System.out.println("3. Marks: ");

		System.out.print(" i) Operating System : ");
		double OS = sc.nextDouble();

		System.out.print(" ii) Database Management System : ");
		double DBMS = sc.nextDouble();

		System.out.print(" iii) Maths : ");
		double Maths = sc.nextDouble();

		System.out.print(" iv) Object Oriented Programming : ");
		double OOP = sc.nextDouble();

		System.out.print(" v) Networking : ");
		double Network = sc.nextDouble();

		Organize O1 = new Organize(OS,DBMS,Maths,OOP,Network); O1.organize();
	}
}

class Start
{
	public static void main(String s[])
	{
		System.out.println("\033c");
		Scanner sc = new Scanner(System.in);

		System.out.println("\n---STUDENT GRADE CALCULATOR---\n");
		System.out.println("1. Calculate grade for a Student");
		System.out.println("2.Exit");
		System.out.print("\nEnter your choice: ");
		int ch = sc.nextInt();
		switch(ch)
		{
			case 1 -> { Input I1 = new Input(); I1.input();}
			case 2 -> {End.end();}		
			default ->{System.out.println("\nOopss!!! Inavlid Input");main(s);}
		}
		System.out.println("Do you want to continue?? (1 for Yes/ 0 for No)");
		int c = sc.nextInt();
		if(c==1)
			main(s);
		else
			End.end();
		
	}
}

class End
{
	 static void end()
	{
		System.out.println("\033c");
		System.out.println("\t\tTHANK YOU !!!");
		System.exit(1);
	}
}