package com.coding.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="rooms")
public class Room {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	private String roomType;
	private BigDecimal roomPrice;
	private String roomPhotoUrl;
	private String roomDescription;
	
	@OneToMany(mappedBy = "room",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();
	
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", roomType=" + roomType + ", roomPrice=" + roomPrice + ", roomPhotoUrl="
				+ roomPhotoUrl + ", roomDescription=" + roomDescription + "]";
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
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}


	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	/**
	 * @return the roomPrice
	 */
	public BigDecimal getRoomPrice() {
		return roomPrice;
	}


	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}


	/**
	 * @return the roomPhotoUrl
	 */
	public String getRoomPhotoUrl() {
		return roomPhotoUrl;
	}


	/**
	 * @param roomPhotoUrl the roomPhotoUrl to set
	 */
	public void setRoomPhotoUrl(String roomPhotoUrl) {
		this.roomPhotoUrl = roomPhotoUrl;
	}


	/**
	 * @return the roomDescription
	 */
	public String getRoomDescription() {
		return roomDescription;
	}


	/**
	 * @param roomDescription the roomDescription to set
	 */
	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}


	/**
	 * @return the bookings
	 */
	public List<Booking> getBookings() {
		return bookings;
	}


	/**
	 * @param bookings the bookings to set
	 */
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}


	public Room(Long id, String roomType, BigDecimal roomPrice, String roomPhotoUrl, String roomDescription,
			List<Booking> bookings) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomPhotoUrl = roomPhotoUrl;
		this.roomDescription = roomDescription;
		this.bookings = bookings;
	}


	public Room() {
		super();
	}
	
	





}
