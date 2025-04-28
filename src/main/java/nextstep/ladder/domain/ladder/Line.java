package nextstep.ladder.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Line {
    List<Boolean> line = new ArrayList<>();

    public Line(int countOfPerson) {
        boolean lastBoolean = false;
        for (int i = 0; i < countOfPerson - 1; i++) {
            boolean currBoolean = randomBoolean();
            if(isConsecutiveLine(currBoolean, lastBoolean)) {
                currBoolean = false;
            }
            line.add(currBoolean);
            lastBoolean = currBoolean;
        }
    }
    private boolean isConsecutiveLine(boolean curr, boolean last) {
        return curr && last;
    }

    private boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
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
