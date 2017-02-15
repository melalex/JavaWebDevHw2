package com.room414.homework2.transcript;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Alexander Melashchenko
 * @version 1.0 16 Feb 2017
 */
class SessionTest {
    @Test
    void set() {
        Transcript.Session session = new Transcript.Session();

        session.set("Calculus", 70);

        assert session.getGrade("Calculus") == 70;

        assertThrows(IllegalArgumentException.class, () -> session.set("Calculus", -1));
        assertThrows(IllegalArgumentException.class, () -> session.set("Calculus", 101));
    }

    @Test
    void getEctsGrade() {
        Transcript.Session session = new Transcript.Session();

        session.set("Calculus", 1);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.F;

        session.set("Calculus", 50);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.Fx;

        session.set("Calculus", 60);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.E;

        session.set("Calculus", 70);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.D;

        session.set("Calculus", 80);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.C;

        session.set("Calculus", 89);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.B;

        session.set("Calculus", 100);
        assert session.getEctsGrade("Calculus") == Transcript.Ects.A;
    }

}