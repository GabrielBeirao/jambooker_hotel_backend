package com.beiras.jambookerhotel.repository;

import com.beiras.jambookerhotel.model.BookedRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;



// public interface BookingRepository extends JpaRepository<BookedRoom, Long> {

//     List<BookedRoom> findByRoomId(Long roomId);

//  Optional<BookedRoom> findByBookingConfirmationCode(String confirmationCode, Long userId);

//     List<BookedRoom> findByGuestEmail(String email);
// }

public interface BookingRepository extends JpaRepository<BookedRoom, Long> {
    List<BookedRoom> findByGuestEmail(String email);
    List<BookedRoom> findByRoomId(Long roomId);
    
    @Query("SELECT br FROM BookedRoom br WHERE br.bookingConfirmationCode = :confirmationCode AND br.userId = :userId")
    Optional<BookedRoom> findByBookingConfirmationCode(@Param("confirmationCode") String confirmationCode, @Param("userId") Long userId);
}
