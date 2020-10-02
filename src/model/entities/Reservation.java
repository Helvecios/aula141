package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	// Atributos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Construtor com atributos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	// Getters and Setters
	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// Metodos
	// Metodo - Conta dias entre checkin e checkout
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// TimeUnit converte diferença em milissegundos em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// Método - Atualização da reserva
	public String  updateDates(Date checkIn, Date checkOut) {
		Date now = new Date(); // Criando a data atual
		// Verificando se a data do check-n ou check-out é posterior a data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Erro nas reservas. As datas das reservas para atualização devem ser posteriores a data atual";
		}

		if (!checkOut.after(checkIn)) {
			return "A data do check-out deve ser posterior a de check-in";

		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null; //Se retornar nulo é porque não deu nenum erro
	}

	@Override
	// Implementar String toString
	public String toString() {
		return "Room " 
	+ roomNumber 
	+ ", check-in: " 
	+ sdf.format(checkIn) 
	+ ", check-out: " 
	+ sdf.format(checkOut)
	+ ", " + duration() 
	+ " nights";

	}

}
