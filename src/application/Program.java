package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.execptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Criando um try-catch para tratar as exceções
		try {
			System.out.print("Número do quarto: ");
			int roomNumber = sc.nextInt();
	
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
	
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			// Instanciar a reserva
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reserva: " + reservation);
	
			System.out.println();
			System.out.println("Entre com as datas para atualização da reserva: ");
	
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
	
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			// Chamar método para a atualização das datas
			reservation.updateDates(checkIn, checkOut);
		}
		
		catch(ParseException e) {
			System.out.println("Formato de data inválida");
		}
		
		catch (DomainException e) {
			System.out.println(""
					+ "Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		
		sc.close();

	}

}
	

