package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Line> ladder = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    private int height;
    private int line;

    public Ladder(int line, int height) {
        this.height = height;
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(line));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public List<Integer> play() {
        int max_location = line - 1;
        for (int i = 0; i < line; i++) {
            int location = i;
            for (int j = 0; j < height; j++) {
                if (ladder.get(j).getList().get(location))
                    location--;
                if (location < max_location && ladder.get(j).getList().get(location + 1))
                    location++;
            }
            result.add(location);
        }
        return result;
    }
}
