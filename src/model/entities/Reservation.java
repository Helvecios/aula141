package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.execptions.DomainException;

public class Reservation {

	// Atributos
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// Construtor com atributos
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		// Verificando se a data do check-n ou check-out � posterior a data atual
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data do check-out deve ser posterior a de check-in");
		}
		
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
		// TimeUnit converte diferen�a em milissegundos em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	// M�todo - Atualiza��o da reserva
	//Throws lan�a uma exce��o para "DomainException"
	public void  updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date(); // Criando a data atual
		// Verificando se a data do check-n ou check-out � posterior a data atual
		if (checkIn.before(now) || checkOut.before(now)) {
			//Temos que lan�ar uma exce��o "throw"
			throw new DomainException("As datas das reservas para atualiza��o devem ser posteriores a data atual");
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data do check-out deve ser posterior a de check-in");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
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
