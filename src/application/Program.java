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

			// Criando a data atual
			Date now = new Date();
			// Verificando se a data do check-n ou check-out é posterior a data atual
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Erro nas reservas. As datas das reservas para atualização devem ser posteriores a data atual");
			}

			else if (!checkOut.after(checkIn)) {
				System.out.println("A data do check-out deve ser posterior a de check-in");

			}

			else {
				// Chamar método para a atualização das datas
				reservation.updateDates(checkIn, checkOut);

				System.out.println("Reserva: " + reservation);
			}
		}

		sc.close();

	}

}
