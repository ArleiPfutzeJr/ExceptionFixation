package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter account data");
			System.out.print("Number:");
			int number = sc.nextInt();
			System.out.print("Holder:");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial Balance:");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw Limit:");
			Double withDrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withDrawLimit);
			
			System.out.println();
			System.out.println("Enter amount for withdraw:");
			double amount = sc.nextDouble();
			
			
		try {
			acc.withDraw(amount);
			System.out.printf("New Balance: "+ String.format("%.2f", acc.getBalance()));
		}
		catch (DomainException e ) {
			System.out.println(e.getMessage());
			
		}
		
		sc.close();

	}

}
