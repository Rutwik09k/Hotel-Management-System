package com.coding.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="bookings")
public class Booking {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="check in date is required")
	private LocalDate checkInDate;
	
	@Future(message="check out date must be in future")
	private LocalDate checkOutDate;
	
	@Min(value=1,message="Number of Adults must not be less than 1")
	private int numOfAdults;
	
	@Min(value=0,message="Number of children must not be less than 0")
	private int numOfChildren;
	
	private int totalNumOfGuest;
	
	private String bookingConfirmationCode;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;

	
	public void calculateTotalNumberOfGuest() {
		this.totalNumOfGuest=this.numOfAdults+this.numOfChildren;
	}


	

	
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
		calculateTotalNumberOfGuest();
	}



	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
		calculateTotalNumberOfGuest();
	}





	@Override
	public String toString() {
		return "Booking [id=" + id + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", numOfAdults=" + numOfAdults + ", numOfChildren=" + numOfChildren + ", totalNumOfGuest="
				+ totalNumOfGuest + ", bookingConfirmationCode=" + bookingConfirmationCode + "]";
	}





	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}





	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}





	/**
	 * @return the checkInDate
	 */
	public LocalDate getCheckInDate() {
		return checkInDate;
	}





	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}





	/**
	 * @return the checkOutDate
	 */
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}





	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}





	/**
	 * @return the totalNumOfGuest
	 */
	public int getTotalNumOfGuest() {
		return totalNumOfGuest;
	}





	/**
	 * @param totalNumOfGuest the totalNumOfGuest to set
	 */
	public void setTotalNumOfGuest(int totalNumOfGuest) {
		this.totalNumOfGuest = totalNumOfGuest;
	}





	/**
	 * @return the bookingConfirmationCode
	 */
	public String getBookingConfirmationCode() {
		return bookingConfirmationCode;
	}





	/**
	 * @param bookingConfirmationCode the bookingConfirmationCode to set
	 */
	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}





	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}





	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}





	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}





	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}





	/**
	 * @return the numOfAdults
	 */
	public int getNumOfAdults() {
		return numOfAdults;
	}





	/**
	 * @return the numOfChildren
	 */
	public int getNumOfChildren() {
		return numOfChildren;
	}





	public Booking(Long id, @NotNull(message = "check in date is required") LocalDate checkInDate,
			@Future(message = "check out date must be in future") LocalDate checkOutDate,
			@Min(value = 1, message = "Number of Adults must not be less than 1") int numOfAdults,
			@Min(value = 0, message = "Number of children must not be less than 0") int numOfChildren,
			int totalNumOfGuest, String bookingConfirmationCode, User user, Room room) {
		super();
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numOfAdults = numOfAdults;
		this.numOfChildren = numOfChildren;
		this.totalNumOfGuest = totalNumOfGuest;
		this.bookingConfirmationCode = bookingConfirmationCode;
		this.user = user;
		this.room = room;
	}





	public Booking() {
		super();
	}







	

	
	
	
}
