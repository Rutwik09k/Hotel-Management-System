package com.coding.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

	
    private int statusCode;
	
    private String message;
	
	private String token;
	
	private String role;
	
	private String expirationTime;
	
	private String bookingConfirmationCode;
	
	private UserDTO user;

	private RoomDTO room;
	
	private BookingDTO booking;
	
	private List<UserDTO> userList;
	
	private List<RoomDTO> roomList;
	
	private List<BookingDTO> bookingList;

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the expirationTime
	 */
	public String getExpirationTime() {
		return expirationTime;
	}

	/**
	 * @param expirationTime the expirationTime to set
	 */
	public void setExpirationTime(String expirationTime) {
		this.expirationTime = expirationTime;
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

	/**
	 * @return the booking
	 */
	public BookingDTO getBooking() {
		return booking;
	}

	/**
	 * @param booking the booking to set
	 */
	public void setBooking(BookingDTO booking) {
		this.booking = booking;
	}

	/**
	 * @return the userList
	 */
	public List<UserDTO> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<UserDTO> userList) {
		this.userList = userList;
	}

	/**
	 * @return the roomList
	 */
	public List<RoomDTO> getRoomList() {
		return roomList;
	}

	/**
	 * @param roomList the roomList to set
	 */
	public void setRoomList(List<RoomDTO> roomList) {
		this.roomList = roomList;
	}

	/**
	 * @return the bookingList
	 */
	public List<BookingDTO> getBookingList() {
		return bookingList;
	}

	/**
	 * @param bookingList the bookingList to set
	 */
	public void setBookingList(List<BookingDTO> bookingList) {
		this.bookingList = bookingList;
	}

	public Response(int statusCode, String message, String token, String role, String expirationTime,
			String bookingConfirmationCode, UserDTO user, RoomDTO room, BookingDTO booking, List<UserDTO> userList,
			List<RoomDTO> roomList, List<BookingDTO> bookingList) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.token = token;
		this.role = role;
		this.expirationTime = expirationTime;
		this.bookingConfirmationCode = bookingConfirmationCode;
		this.user = user;
		this.room = room;
		this.booking = booking;
		this.userList = userList;
		this.roomList = roomList;
		this.bookingList = bookingList;
	}

	public Response() {
		super();
	}

	
	
}
