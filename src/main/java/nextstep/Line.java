package nextstep;

import java.util.ArrayList;
import java.util.List;

import static nextstep.constant.Constant.PER_DOT;

public class Line {
    private List<Boolean> points = new ArrayList<>();


    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson * PER_DOT; i++) {
            points.add(false);
        }
    }

    public void mark(int target) {
        points.stream()
                .skip(target)
                .limit(target + PER_DOT)
                .forEach(System.out::println);
    }

}
