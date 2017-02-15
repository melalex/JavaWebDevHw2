package com.room414.homework2.transcript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Melashchenko
 * @version 1.0 15 Feb 2017
 */
public class Transcript {
    public enum Ects { A, B, C, D, E, Fx, F, NaG}

    public static class Session {
        Map<String, Integer> subjects = new HashMap<>();

        public void set(String subjectName, int subjectGrade) {
            if (subjectGrade < 0 || subjectGrade > 100){
                throw new IllegalArgumentException();
            }

            subjects.put(subjectName, subjectGrade);
        }

        public Integer getGrade(String subjectName) {
            return subjects.get(subjectName);
        }

        public Ects getEctsGrade(String subjectName) {
            Integer grade = subjects.get(subjectName);

            if (grade != null) {
                int unpackedGrade = grade;
                if (unpackedGrade < 35) {
                    return Ects.F;
                } else if (unpackedGrade < 60) {
                    return Ects.Fx;
                } else if (unpackedGrade < 67) {
                    return Ects.E;
                } else if (unpackedGrade < 75) {
                    return Ects.D;
                } else if (unpackedGrade < 82) {
                    return Ects.C;
                } else if (unpackedGrade < 90) {
                    return Ects.B;
                } else {
                    return Ects.A;
                }
            }

            return Ects.NaG;
        }
    }

    private List<Session> sessions = new ArrayList<>();

    public Session getSession(int number) {
        return sessions.get(number - 1);
    }

    public void setSession(Session session, int number) {
        sessions.set(number, session);
    }

    public void addSession(Session session) {
        sessions.add(session);
    }
}
