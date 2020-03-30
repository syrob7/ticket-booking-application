package com.ticketbooking;

import com.ticketbooking.model.*;
import com.ticketbooking.model.enums.TicketType;
import com.ticketbooking.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.Month;

//@Component
public class Main {

    @Autowired
    public Main(MovieRepo movieRepo, RoomRepo roomRepo, SeatRepo seatRepo,
                ReservationRepo reservationRepo, TicketRepo ticketRepo, ScreeningRepo screeningRepo) {

        Movie movie = new Movie("Obcy");
        movieRepo.save(movie);

        Room room = new Room("Room 1");
        roomRepo.save(room);

        Seat seat11 = new Seat(1, 1);
        seat11.setRoom(room);
        Seat seat12 = new Seat(1, 2);
        seat12.setRoom(room);
        Seat seat13 = new Seat(1, 3);
        seat13.setRoom(room);
        Seat seat21 = new Seat(2, 1);
        seat21.setRoom(room);
        Seat seat22 = new Seat(2, 2);
        seat22.setRoom(room);
        Seat seat23 = new Seat(2, 3);
        seat23.setRoom(room);
        Seat seat31 = new Seat(3, 1);
        seat31.setRoom(room);
        Seat seat32 = new Seat(3, 2);
        seat32.setRoom(room);
        Seat seat33 = new Seat(3, 3);
        seat33.setRoom(room);

        seatRepo.save(seat11);
        seatRepo.save(seat12);
        seatRepo.save(seat13);
        seatRepo.save(seat21);
        seatRepo.save(seat22);
        seatRepo.save(seat23);
        seatRepo.save(seat31);
        seatRepo.save(seat32);
        seatRepo.save(seat33);

        Screening screening = new Screening(LocalDateTime.of(2015, Month.JULY, 29, 19, 30));
        screening.setMovie(movie);
        screening.setRoom(room);
        screeningRepo.save(screening);

        Reservation reservation = new Reservation("Jan", "Kowalski");
        reservation.setScreening(screening);

        Reservation reservation2 = new Reservation("Mariam", "Nowak");
        reservation2.setScreening(screening);

        reservationRepo.save(reservation);
        reservationRepo.save(reservation2);

        Ticket ticket11 = new Ticket(TicketType.ADULT);
        Ticket ticket12 = new Ticket(TicketType.CHILD);
        Ticket ticket13 = new Ticket(TicketType.STUDENT);

        Ticket ticket21 = new Ticket(TicketType.ADULT);
        Ticket ticket22 = new Ticket(TicketType.STUDENT);

        ticket11.setReservation(reservation);
        ticket11.setScreening(screening);
        ticket11.setSeat(seat31);
        ticket12.setReservation(reservation);
        ticket12.setScreening(screening);
        ticket12.setSeat(seat32);
        ticket13.setReservation(reservation);
        ticket13.setScreening(screening);
        ticket13.setSeat(seat33);

        ticket21.setReservation(reservation2);
        ticket21.setScreening(screening);
        ticket21.setSeat(seat21);
        ticket22.setReservation(reservation2);
        ticket22.setScreening(screening);
        ticket22.setSeat(seat22);

        ticketRepo.save(ticket11);
        ticketRepo.save(ticket12);
        ticketRepo.save(ticket13);

        ticketRepo.save(ticket21);
        ticketRepo.save(ticket22);
    }
}
