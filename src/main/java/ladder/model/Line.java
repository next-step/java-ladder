package ladder.model;

import ladder.common.Constants;
import ladder.util.RandomUtil;
import ladder.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    private List<Boolean> points = new ArrayList<Boolean>();

    public Line(int countOfPerson) {
        IntStream.range(0, countOfPerson)
                .forEach(i -> {
                        points.add(RandomUtil.getRandomBoolean());
                });
    }

    @Override
    public String toString() {
        return String.format("|%s|",convertToString());
    }

    private String convertToString() {
        return points.stream()
                .map(Line::visualize)
                .collect(Collectors.joining(Constants.PIPE));
    }

    private static String visualize(Boolean value) {
        return value ? Constants.DASH.repeat(6) : Constants.SPACE_BAR.repeat(6);
    }
}
