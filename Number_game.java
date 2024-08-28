import java.util.*;
class Start
{
	public static void main(String s[])
	{

		System.out.println("\nNUMBER GAME\n");
		System.out.println("1.Start a New Game");
		System.out.println("2.Exit");

		System.out.print("Your Choice : ");
		Scanner sc = new Scanner(System.in);
		int c= sc.nextInt();
		switch(c)
		{
			case 1: System.out.print("\033c");Terms(); break;
			case 2: ThankYou.printt();
		}		
	}

	static void Terms()
	{
		int flag=0;;
		
		System.out.println("TERMS AND CONDITIONS: \n\n");
		System.out.println("1.The player has to guess a number between 1 to 100\n");
		System.out.println("2.Player will be provided with 6 attempts.\n");
		System.out.println("3. If he/she guesses the correct number in the \n");
		System.out.println(" i) 1st attempt, 100 points will be awarded.");
		System.out.println(" ii) 2nd attempt, 80 points will be awarded.");
		System.out.println(" iii) 3rd attempt, 60 points will be awarded.");
		System.out.println(" iv) 4th attempt, 40 points will be awarded.");
		System.out.println(" v) 5th attempt, 20 points will be awarded.");
		System.out.println(" vi) 6th attempt, 10 points will be awarded.");

		
		int c= Continue_Game.continue1();
		
		switch(c)
		{
			case 1 : Game.play();
			case 0 : ThankYou.printt();
		}
		
	}
}

class Game
{
	
	static void play()
	{
		
		int a=(int)(Math.random()*100);
		
		Scanner sc = new Scanner(System.in);

		System.out.print("\033c");
		System.out.println("THE GAME BEGINS........\n");
		System.out.println(a);
		int i=1;
		int score=100;

		//int continue1=1;
		while(i<7)
		{
			
			System.out.println("\nChance No. : "+ i);
			System.out.println("\nEnter a number between 0 to 100: ");
			int n = sc.nextInt();
			if(a==n)
			{
				System.out.print("\033c");
				System.out.println("\nHURRAAYYY... YOU OWN THE GAME\n");
				System.out.println("The Actual number was "+n);
				System.out.println("YOUR SCORE IS "+Score.score(i)); 							
				NewG.newG();
				return;
			}
			if(Math.abs(a-n)<5)
				System.out.println("You are very close to the actual Number!!!");
			else if(n>a && n-a>40)
				System.out.println("The ENTERED number is MUCH LARGER than the ACTUAL number");

			else if(n>a)
				System.out.println("The ENTERED number is QUITE LARGER than the ACTUAL number");

			else if(a<n && n-a>40)
				System.out.println("The ENTERED number is MUCH SMALLER than the ACTUAL number");

			else 
				System.out.println("The ENTERED number is QUITE SMALLER than the ENTERED number");
			
			/*int c= Continue_Game.continue1();
			System.out.print("\033c");
			switch(c)
			{
				case 1 : break;
				case 0 : ThankYou.printt();
			}*/
			i++;
				
		}
		if(i==7)
		{
			System.out.print("\033c");
			System.out.println("\nYou lost your 6 chances..\nThe Actual Number was "+a);
			NewG.newG();
		}
	}
}


class Continue_Game
{
	static int continue1()
	{

		System.out.println("\n\nDO YOU WANT TO CONTINUE??(1 for Yes / 0 for No)");
		int c=-1;

		while(c!=0 && c!=1)
		{
		System.out.print("Your Choice : ");
		Scanner sc = new Scanner(System.in);
		c= sc.nextInt();
		switch(c)
		{
			case 'Y','y',1 : return 1;
			case 'N','n',0 : return 0;
			default : System.out.println("Invalid Choice");
		}
		}
		return 9;		
	}
}


class NewG
{
	static void newG()
	{
		System.out.println("\n\nDO YOU WANT TO START A NEW GAME ??(1 for Yes / 0 for No)");
		int c=-1;

		while(c!=0 && c!=1)
		{
		System.out.print("Your Choice : ");
		Scanner sc = new Scanner(System.in);
		c= sc.nextInt();
		switch(c)
		{
			case 'Y','y',1 : System.out.print("\033c");
					String[] newArgs = {"a", "b"};
            				Start.main(newArgs);break;

			case 'N','n',0 : ThankYou.printt();
			default : System.out.println("Invalid Choice");
		}
		}
		return;		

	}
}


class Score
{
	static int score(int s)
	{
		int y=switch(s)
		{
			case 1 -> {yield 100;}
			case 2 -> {yield 80;}
			case 3 -> {yield 60;}
			case 4 -> {yield 40;}
			case 5 -> {yield 20;}	
			case 6 -> {yield 10;}
			default -> {yield 0;}
		};
		return y;	
	}
}

class ThankYou
{
	static void printt()
	{
		
		System.out.println("\nYOUR GAME ENDS HERE... THANK YOU !!!");
		System.exit(1);
		return;
	}
}


