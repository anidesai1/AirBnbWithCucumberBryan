package com.airbnb.util;

import com.airbnb.model.Room;
import com.airbnb.model.User;
import com.airbnb.repository.RoomRepository;
import com.airbnb.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Populator {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public Populator(RoomRepository roomRepository, UserRepository userRepository) {
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct //run this block of code one time when you start the application
    public void init(){
        //saves 2 rooms
        Room room1 = new Room();
        room1.setName("Cliffhanger");
        room1.setRate(100);
        roomRepository.save(room1);

        Room room2 = new Room();
        room2.setName("Slickrock");
        room2.setRate(125);
        roomRepository.save(room2);

        User user1 = new User();
        user1.setName("Ani");
        user1.setId(1L);
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("Dhwani");
        user2.setId(2L);
        userRepository.save(user2);
    }
}
