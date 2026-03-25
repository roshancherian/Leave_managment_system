package com.leave.management.controller;

import com.leave.management.entity.LeaveRequest;
import com.leave.management.service.LeaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService service;

    @PostMapping("/apply")
    public LeaveRequest apply(@RequestParam Integer userId,
                              @RequestBody LeaveRequest leave) {
        return service.applyLeave(userId, leave);
    }

    @GetMapping("/my")
    public List<LeaveRequest> myLeaves(@RequestParam Integer userId) {
        return service.getMyLeaves(userId);
    }

    @GetMapping("/pending")
    public List<LeaveRequest> pending(@RequestParam Integer managerId) {
        return service.getPending(managerId);
    }

    @PostMapping("/approve/{id}")
    public LeaveRequest approve(@PathVariable Integer id) {
        return service.approveLeave(id);
    }

    @PostMapping("/reject/{id}")
    public LeaveRequest reject(@PathVariable Integer id) {
        return service.rejectLeave(id);
    }
}