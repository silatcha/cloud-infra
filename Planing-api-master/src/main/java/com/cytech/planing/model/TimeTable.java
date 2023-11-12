package com.cytech.planing.model;


import java.util.List;

import com.cytech.planing.model.school.Disponibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

@PlanningSolution
public class TimeTable  {

    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    private List<Disponibility> timeslotList;
    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    private List<Room> roomList;
    @PlanningEntityCollectionProperty
    private List<Exam> lessonList;
    @ValueRangeProvider(id = "teacherRange")
    @ProblemFactCollectionProperty
    private List<Teacher> teachersList;
    @PlanningScore
    private HardSoftScore score;

    public TimeTable() {
    }

    public TimeTable(List<Disponibility> timeslotList, List<Room> roomList,List<Teacher> teachersList, List<Exam> lessonList) {
        this.timeslotList = timeslotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
        this.teachersList = teachersList;
    }

    public List<Disponibility> getTimeslotList() {
        return timeslotList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Exam> getLessonList() {
        return lessonList;
    }
    // @JsonProperty("teachersList")
    public List<Teacher> getTeacherList() {
        return teachersList;
    }
    // @JsonProperty("teachersList")
    public void setTeachersList(List<Teacher> teachersList) {
        this.teachersList = teachersList;
    }

    public HardSoftScore getScore() {
        return score;
    }

}
