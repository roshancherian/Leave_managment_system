package com.leave.management.service;

import com.leave.management.entity.LeaveRequest;
import com.leave.management.entity.User;
import com.leave.management.repository.LeaveRepository;
import com.leave.management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepo;

    @Autowired
    private UserRepository userRepo;

    public LeaveRequest applyLeave(Integer userId, LeaveRequest leave) {

        User user = userRepo.findById(userId).orElseThrow();

        leave.setEmployeeId(userId);
        leave.setStatus("PENDING");
        leave.setCurrentApproverId(user.getManagerId());

        return leaveRepo.save(leave);
    }

    public List<LeaveRequest> getMyLeaves(Integer userId) {
        return leaveRepo.findByEmployeeId(userId);
    }

    public List<LeaveRequest> getPending(Integer managerId) {
        return leaveRepo.findByCurrentApproverId(managerId);
    }

    public LeaveRequest approveLeave(Integer leaveId) {

        LeaveRequest leave = leaveRepo.findById(leaveId).orElseThrow();

        Integer currentManager = leave.getCurrentApproverId();
        User manager = userRepo.findById(currentManager).orElseThrow();

        if (manager.getManagerId() == null) {
            leave.setStatus("APPROVED");
        } else {
            leave.setCurrentApproverId(manager.getManagerId());
        }

        return leaveRepo.save(leave);
    }

    public LeaveRequest rejectLeave(Integer leaveId) {
        LeaveRequest leave = leaveRepo.findById(leaveId).orElseThrow();
        leave.setStatus("REJECTED");
        return leaveRepo.save(leave);
    }
}