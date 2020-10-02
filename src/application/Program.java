package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Número do quarto: ");
		int roomNumber = sc.nextInt();

		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Data do check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		// Verificar se a data de check-out é posterior a de check-in
		if (!checkOut.after(checkIn)) {
			System.out.println("A data do check-out deve ser posterior a de check-in");

			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
		} else {
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
			//Melhoria colocando o tratamento dos erros na classe Reservation
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Erro na reserva: " + error);
				
			}
			else {
				System.out.println("Reserva: " + reservation);
			}
		}

		sc.close();

	}

}
