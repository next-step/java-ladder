package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        boolean lastBoolean = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currBoolean = randomBoolean();
            if(currBoolean && lastBoolean) {
                currBoolean = false;
            }
            line.add(currBoolean);
            lastBoolean = currBoolean;
        }
    }

    private boolean randomBoolean() {
        return Math.random() < 0.5;
    }

    public int size() {
        return line.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean b : line) {
            sb.append(b ? "|-----" : "|     ");
        }
        sb.append("|");
        return sb.toString();
    }
}
