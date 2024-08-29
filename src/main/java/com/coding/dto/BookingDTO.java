package com.coding.dto;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonInclude;


import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Long id;
    private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int numOfAdults;
	private int numOfChildren;
	private int totalNumOfGuest;
	private String bookingConfirmationCode;
	private UserDTO user;
	private RoomDTO room;
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
	 * @return the numOfAdults
	 */
	public int getNumOfAdults() {
		return numOfAdults;
	}
	/**
	 * @param numOfAdults the numOfAdults to set
	 */
	public void setNumOfAdults(int numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	/**
	 * @return the numOfChildren
	 */
	public int getNumOfChildren() {
		return numOfChildren;
	}
	/**
	 * @param numOfChildren the numOfChildren to set
	 */
	public void setNumOfChildren(int numOfChildren) {
		this.numOfChildren = numOfChildren;
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
	public UserDTO getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/**
	 * @return the room
	 */
	public RoomDTO getRoom() {
		return room;
	}
	/**
	 * @param room the room to set
	 */
	public void setRoom(RoomDTO room) {
		this.room = room;
	}
	public BookingDTO(Long id, LocalDate checkInDate, LocalDate checkOutDate, int numOfAdults, int numOfChildren,
			int totalNumOfGuest, String bookingConfirmationCode, UserDTO user, RoomDTO room) {
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
	public BookingDTO() {
		super();
	}
	
	
}
