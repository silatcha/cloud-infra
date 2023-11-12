package com.cytech.planing.model;

import com.cytech.planing.model.school.Disponibility;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Exam {

    @PlanningId
    private Long id;

    private Matter subject;
    private Speciality speciality;
    @PlanningVariable(valueRangeProviderRefs = "teacherRange")
    private Teacher teacher;

    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    private Disponibility timeslot;
    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    private Room room;

    public Exam() {
    }

    public Exam(Long id,Teacher teacher, Matter subject, Speciality speciality) {
        this.id = id;
        this.subject = subject;
        this.speciality = speciality;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }


    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher t) {
        this.teacher = t;
    }
    public Long getTeacherId() {return this.teacher.getTeacherId();}

    public Disponibility getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Disponibility timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }
    public int getRoomSize() {
        return this.room.getCapacity();
    }
    public void setRoom(Room room) {
        this.room = room;
    }

    public Matter getSubject() {
        return subject;
    }

    public void setSubject(Matter subject) {
        this.subject = subject;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return subject + "(" + id + ")";
    }

}