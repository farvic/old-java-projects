package com.victoraraujo.lil.learningspring.util;

import com.victoraraujo.lil.learningspring.data.Guest;
import com.victoraraujo.lil.learningspring.data.GuestRepository;
import com.victoraraujo.lil.learningspring.data.Reservation;
import com.victoraraujo.lil.learningspring.data.ReservationRepository;
import com.victoraraujo.lil.learningspring.data.Room;
import com.victoraraujo.lil.learningspring.data.RoomRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    public AppStartupEvent(RoomRepository roomRepository, GuestRepository guestRepository,
            ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        rooms.forEach(System.out::println);
        Iterable<Guest> guests = this.guestRepository.findAll();
        guests.forEach(System.out::println);
        Iterable<Reservation> reservations = this.reservationRepository.findAll();
        reservations.forEach(System.out::println);
    }
}
