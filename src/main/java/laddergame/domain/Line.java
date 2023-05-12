package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> points;

    public Line(final List<Boolean> points) {
        this.points = points;
    }


    public Line(int countOfPeople) {
        validate(countOfPeople);

        this.points = new ArrayList<>(countOfPeople - 1);
        Random random = new Random();
        if (random.nextInt(2) == 1) {
            points.add(true);
        }
        points.add(false);
    }

    private void validate(final int countOfPeople) {
        if (countOfPeople < 1){
            throw new IllegalArgumentException("참여 인원은 두 명 이상이어야 합니다.");
        }
    }
}
