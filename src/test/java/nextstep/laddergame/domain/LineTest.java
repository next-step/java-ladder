package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void create() {
        int people = 5;
        Line line = new Line(people);

        for (Point ppoint : line.getPoints()) {

            if (ppoint.getDirection().isNotMove()) {
                System.out.print("|     ");
            } else if (ppoint.getDirection().isRight()){
                System.out.print("|-----");
            } else {
                System.out.print("|     ");
            }


        }
    }
}