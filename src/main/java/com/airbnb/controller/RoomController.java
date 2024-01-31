package com.airbnb.controller;

import com.airbnb.model.Room;
import com.airbnb.model.User;
import com.airbnb.service.RoomService;
import com.airbnb.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {
    private final RoomService roomService;
    private final UserService userService;

    public RoomController(RoomService roomService, UserService userService) {
        this.roomService = roomService;
        this.userService = userService;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
        return roomService.findAll();
    }

    @GetMapping("/room")
    public Room findByName(@RequestParam String name){
        return roomService.findByName(name);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.findAll();}
}
