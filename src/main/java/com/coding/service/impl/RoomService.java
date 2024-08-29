package com.coding.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Files;
import com.coding.dto.Response;
import com.coding.dto.RoomDTO;
import com.coding.entity.Room;
import com.coding.exception.OurException;
import com.coding.repo.BookingRepository;
import com.coding.repo.RoomRepository;
import com.coding.service.interfac.IRoomService;
import com.coding.utils.Utils;

@Service
public class RoomService implements IRoomService{

	
	@Autowired
	private RoomRepository rommRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	private static final String IMAGE_DIR = System.getProperty("user.dir") + "/src/main/resources/static/image";

    @Override
    public Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description) {
        Response response = new Response();
        try {
            String imageUUID = null;
            if (photo != null && !photo.isEmpty()) {
                // Validate file type and size if needed
                imageUUID = UUID.randomUUID().toString() + "_" + photo.getOriginalFilename();
                Path fileNameAndPath = Paths.get(IMAGE_DIR, imageUUID);
                Files.write(fileNameAndPath, photo.getBytes());
            }

            Room room = new Room();
            room.setRoomPhotoUrl(imageUUID);
            room.setRoomType(roomType);
            room.setRoomPrice(roomPrice);
            room.setRoomDescription(description);
            Room savedRoom = roomRepository.save(room);
            RoomDTO roomDTO = Utils.mapRoomEntityToRoomDTO(savedRoom);
            response.setStatusCode(200);
            response.setMessage("Successful");
            response.setRoom(roomDTO);
        } catch (Exception e) {
            // Log the exception (e.g., using a logger)
            response.setStatusCode(500);
            response.setMessage("Error adding room: " + e.getMessage());
        }
        return response;
    }

	@Override
	public List<String> getAllRoomTypes() {
		List<String> roomTypeList = roomRepository.findDistinctRoomTypes();
		return roomTypeList;
	}

	 @Override
	    public Response getAllRooms() {
	        Response response = new Response();
	        try {
	            List<Room> rooms = roomRepository.findAll();
	            List<RoomDTO> roomDTOs = rooms.stream()
	                                          .map(Utils::mapRoomEntityToRoomDTO)
	                                          .collect(Collectors.toList());
	            response.setStatusCode(200);
	            response.setMessage("Successful");
	            response.setRoomList(roomDTOs);
	        } catch (Exception e) {
	            response.setStatusCode(500);
	            response.setMessage("Error fetching rooms: " + e.getMessage());
	        }
	        return response;
	    }
	

	@Override
	public Response deleteRoom(Long roomId) {
Response response =new Response();
		
		try {
			
			roomRepository.findById(roomId).orElseThrow(()->new OurException("Room not Found"));
			roomRepository.deleteById(roomId);
			response.setStatusCode(200);
			response.setMessage("successful");
			
			
		}
		catch(OurException e) {
			response.setStatusCode(404);
			response.setMessage(e.getMessage());
		}
		catch (Exception e) {
			 response.setStatusCode(500);
				response.setMessage("Error adding a room" + e.getMessage());
		}
		
		 return response;
	}

	@Override
	public Response updateRoom(Long roomId, String description, String roomType, BigDecimal roomPrice, MultipartFile photo) {
         Response response =new Response();
		
		try {
			
			
			String imageUUID=null;
	        if(!photo.isEmpty())
	        {
	            imageUUID= photo.getOriginalFilename();
	            Path faleNameAndPath = Paths.get(IMAGE_DIR, imageUUID);
	            Files.write(faleNameAndPath,photo.getBytes());
	        }
//	        else
//	        {
//            imageUUID=photo;
//             }
//
//	        response.setImageName(imageUUID);
			
			
		
			Room room = roomRepository.findById(roomId).orElseThrow(()->new OurException("room not found"));
			if(roomType !=null ) room.setRoomType(roomType);
			if(roomPrice !=null ) room.setRoomPrice(roomPrice);
			if(description !=null ) room.setRoomDescription(description);
			if( imageUUID!=null ) room.setRoomPhotoUrl(imageUUID);

			Room updatedRoom = roomRepository.save(room);
			RoomDTO roomDTO = Utils.mapRoomEntityToRoomDTO(updatedRoom);
			
			response.setStatusCode(200);
			response.setMessage("successful");
			response.setRoom(roomDTO);
			
		}
		catch(OurException e) {
			response.setStatusCode(404);
			response.setMessage(e.getMessage());
		}
		catch (Exception e) {
			 response.setStatusCode(500);
				response.setMessage("Error adding a room" + e.getMessage());
		}
		
		 return response;
	}


	@Override
	public Response getRoomById(Long roomId) {
		
	    Response response =new Response();
			
			try {
				
				Room room = roomRepository.findById(roomId).orElseThrow(()->new OurException("Room not Found"));
				RoomDTO roomDTO=Utils.mapRoomEntityToRoomDTOPlusBookings(room);
				response.setStatusCode(200);
				response.setMessage("successful");
				response.setRoom(roomDTO);
				
			}
			catch(OurException e) {
				response.setStatusCode(404);
				response.setMessage(e.getMessage());
			}
			catch (Exception e) {
				 response.setStatusCode(500);
					response.setMessage("Error adding a room" + e.getMessage());
			}
			
			 return response;
		}
	

	@Override
	public Response getAvailableRoomsByDataAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
	    Response response =new Response();
		
				try {
					
					List<Room> availableRooms =roomRepository.findAvailableRoomsByDatesAndTypes(checkInDate, checkOutDate, roomType);
					List<RoomDTO> roomDTOList = Utils.mapRoomListEntityToRoomListDTO(availableRooms);
					response.setStatusCode(200);
					response.setMessage("successful");
					response.setRoomList(roomDTOList);
					
				}
			
				catch (Exception e) {
					 response.setStatusCode(500);
						response.setMessage("Error adding a room" + e.getMessage());
				}
				
				 return response;
			}
		

	@Override
	public Response getAllAvailableRooms() {
		   Response response =new Response();
			
					try {
						
						List<Room> roomList = roomRepository.getAllAvailableRooms();
						List<RoomDTO> roomDTOList = Utils.mapRoomListEntityToRoomListDTO(roomList);
						response.setStatusCode(200);
						response.setMessage("successful");
						response.setRoomList(roomDTOList);
						
					}
					catch(OurException e) {
						response.setStatusCode(404);
						response.setMessage(e.getMessage());
					}
					catch (Exception e) {
						 response.setStatusCode(500);
							response.setMessage("Error adding a room" + e.getMessage());
					}
					
					 return response;
				}

}


