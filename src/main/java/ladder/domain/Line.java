package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<Boolean> points;

    Line(int countOfPerson) {

        Random random = new Random();
        points = new ArrayList<>();
        points.add(new Boolean(false)); //  첫번째 좌표값은 FALSE 값으로

        IntStream.range(1, countOfPerson).forEach(i -> {
            Boolean element = random.nextBoolean();
            if (i > 1) {
                element = checkElement(points.get(i - 1), element); // 세번째 값부터 인접 좌표와 중복이 되지 않도록 체크
            }
            points.add(element);
        });

    }

    public List<Boolean> getPoints() {
        return points;
    }

    public Boolean checkElement(Boolean prev, Boolean addElement) {
        if (prev == Boolean.TRUE && prev.equals(addElement))
            return Boolean.FALSE;
        return addElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return true;
    }

}
