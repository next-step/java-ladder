package nextstep.ladder.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

@Getter
public class Ladder {
    private List<Line> lines = new ArrayList<>();


    public Ladder(int countOfUsers, int height) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(countOfUsers);
            lines.add(line);
        }
    }

    public String status() {
        String result = "";
        int height = lines.size();
        for (int i = 0; i < height; i++) {
            Line line = lines.get(i);
            List<Boolean> points = line.getBridges();
            for (Boolean point : points) {
                result += "|";
                result += point ? "-----" : "     ";
            }
            result += "|\n";
        }
        return result;
    }
}
