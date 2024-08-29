package com.coding.service.interfac;

import com.coding.dto.Response;
import com.coding.entity.Booking;

public interface IBookingService {

	Response saveBooking(Long roomId,Long userId,Booking bookingRequest);
	
	Response findBookingByConfirmationCode(String confirmationCode);
	
	Response getAllBookings();
	
	Response cancelBooking(Long bookingId);
}
