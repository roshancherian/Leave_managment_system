package com.leave.management.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer employeeId;

    private LocalDate startDate;
    private LocalDate endDate;

    private String reason;
    private String status;

    private Integer currentApproverId;

    @Column(name = "leave_apply", insertable = false, updatable = false)
    private LocalDateTime leaveApply;

    // GETTERS & SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getEmployeeId() { return employeeId; }
    public void setEmployeeId(Integer employeeId) { this.employeeId = employeeId; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getCurrentApproverId() { return currentApproverId; }
    public void setCurrentApproverId(Integer currentApproverId) { this.currentApproverId = currentApproverId; }

    public LocalDateTime getLeaveApply() { return leaveApply; }
}