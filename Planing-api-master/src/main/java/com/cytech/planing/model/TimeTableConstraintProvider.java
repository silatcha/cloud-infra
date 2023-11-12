package com.cytech.planing.model;

import com.cytech.planing.model.Exam;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;
import org.optaplanner.core.api.score.stream.bi.BiJoiner;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                roomConflict(constraintFactory),
                teacherConflict(constraintFactory),
                studentGroupConflict(constraintFactory),
                studentsizeRoomsizeConflict(constraintFactory),
                teacherDisponibylityConflict(constraintFactory),
                //  teacherSubjectConflict(constraintFactory),
                // Soft constraints are only implemented in the optaplanner-quickstarts code
        };
    }

    private Constraint roomConflict(ConstraintFactory constraintFactory) {
        // A room can accommodate at most one lesson at the same time.

        // Select a lesson ...
        return constraintFactory
                .forEach(Exam.class)
                // ... and pair it with another lesson ...
                .join(Exam.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Exam::getTimeslot),
                        // ... in the same room ...
                        Joiners.equal(Exam::getRoom),
                        // ... and the pair is unique (different id, no reverse pairs) ...
                        Joiners.lessThan(Exam::getId)
                )
                // ... then penalize each pair with a hard weight.
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Room conflict");
    }

    private Constraint teacherConflict(ConstraintFactory constraintFactory) {
        // A teacher can teach at most one lesson at the same time.
        return constraintFactory.forEach(Exam.class)
                .join(Exam.class,
                        Joiners.equal(Exam::getTimeslot),
                        Joiners.equal(Exam::getTeacher),
                        Joiners.lessThan(Exam::getId))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Teacher conflict");
    }

    private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
        // A student can attend at most one lesson at the same time.
        return constraintFactory.forEach(Exam.class)
                .join(Exam.class,
                        Joiners.equal(Exam::getTimeslot),
                        Joiners.equal(Exam::getSpeciality),
                        Joiners.lessThan(Exam::getId))
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Student group conflict");
    }
    private Constraint studentsizeRoomsizeConflict(ConstraintFactory constraintFactory) {
        // A student can attend at most one lesson at the same time.
        return constraintFactory.forEach(Exam.class)
                .filter((lesson) -> lesson.getRoom().getCapacity() < lesson.getSpeciality().getGroupSize())
                .penalize(HardSoftScore.ONE_HARD)
                .asConstraint("Student group size conflict");
    }
    private Constraint teacherDisponibylityConflict(ConstraintFactory constraintFactory){
        return constraintFactory.forEach(Exam.class)
                .filter((lesson) ->  !lesson.getTeacher().isAvailable(lesson.getTimeslot()))
                .penalize(HardSoftScore.ONE_HARD).asConstraint("Teacher not available");
    }
    private Constraint teacherSubjectConflict(ConstraintFactory constraintFactory){
        return constraintFactory.forEach(Exam.class)
                .filter((lesson) -> lesson.getTeacher().getMatter() == lesson.getSubject())
                .reward(HardSoftScore.ONE_SOFT).asConstraint("Good Boy");
    }
}
