import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import ApiService from '../../service/ApiService'; // Assuming your service is in a file called ApiService.js

const EditBookingPage = () => {
    const navigate = useNavigate();
    const { bookingCode } = useParams();
    const [bookingDetails, setBookingDetails] = useState(null); // State variable for booking details
    const [error, setError] = useState(null); // Track any errors
    const [success, setSuccessMessage] = useState(null); // Track success message

    useEffect(() => {
        const fetchBookingDetails = async () => {
            try {
                const response = await ApiService.getBookingByConfirmationCode(bookingCode);
                if (response && response.booking) {
                    setBookingDetails(response.booking);
                } else {
                    setError('Booking details not found.');
                }
            } catch (error) {
                setError(error.message);
            }
        };

        fetchBookingDetails();
    }, [bookingCode]);

    const acheiveBooking = async (bookingId) => {
        if (!window.confirm('Are you sure you want to achieve this booking?')) {
            return; // Do nothing if the user cancels
        }

        try {
            const response = await ApiService.cancelBooking(bookingId);
            if (response && response.statusCode === 200) {
                setSuccessMessage('The booking was successfully achieved.');
                setTimeout(() => {
                    setSuccessMessage('');
                    navigate('/admin/manage-bookings');
                }, 3000);
            } else {
                setError('Failed to achieve the booking.');
                setTimeout(() => setError(''), 5000);
            }
        } catch (error) {
            setError(error.response?.data?.message || error.message);
            setTimeout(() => setError(''), 5000);
        }
    };

    return (
        <div className="edit-booking-page">
            <h2>Booking Detail</h2>
            {error && <p className='error-message'>{error}</p>}
            {success && <p className='success-message'>{success}</p>}
            {bookingDetails ? (
                <div className="booking-details">
                    <h3>Booking Details</h3>
                    <p><strong>Confirmation Code:</strong> {bookingDetails.bookingConfirmationCode}</p>
                    <p><strong>Check-in Date:</strong> {new Date(bookingDetails.checkInDate).toLocaleDateString()}</p>
                    <p><strong>Check-out Date:</strong> {new Date(bookingDetails.checkOutDate).toLocaleDateString()}</p>
                    <p><strong>Num Of Adults:</strong> {bookingDetails.numOfAdults}</p>
                    <p><strong>Num Of Children:</strong> {bookingDetails.numOfChildren}</p>
                    <p><strong>Guest Email:</strong> {bookingDetails.guestEmail}</p>

                    <br />
                    <hr />
                    <br />
                    <h3>Booker Details</h3>
                    {bookingDetails.user ? (
                        <div>
                            <p><strong>Name:</strong> {bookingDetails.user.name}</p>
                            <p><strong>Email:</strong> {bookingDetails.user.email}</p>
                            <p><strong>Phone Number:</strong> {bookingDetails.user.phoneNumber}</p>
                        </div>
                    ) : (
                        <p>User details not available.</p>
                    )}

                    <br />
                    <hr />
                    <br />
                    <h3>Room Details</h3>
                    {bookingDetails.room ? (
                        <div>
                            <p><strong>Room Type:</strong> {bookingDetails.room.roomType}</p>
                            <p><strong>Room Price:</strong> ${bookingDetails.room.roomPrice}</p>
                            <p><strong>Room Description:</strong> {bookingDetails.room.roomDescription}</p>
                            <img src={bookingDetails.room.roomPhotoUrl} alt="Room" />
                        </div>
                    ) : (
                        <p>Room details not available.</p>
                    )}
                    
                    <button
                        className="acheive-booking"
                        onClick={() => acheiveBooking(bookingDetails.id)}
                    >Achieve Booking
                    </button>
                </div>
            ) : (
                <p>Loading booking details...</p>
            )}
        </div>
    );
};

export default EditBookingPage;
