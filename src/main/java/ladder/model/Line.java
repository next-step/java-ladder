package ladder.model;

import ladder.util.RandomUtil;
import ladder.util.ViewUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    public static final String SPACE_BAR = " ";
    public static final String DASH = "-";
    public static final String PIPE = "|";

    private List<Boolean> points = new ArrayList<Boolean>();

    public Line(int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            if (randomValueCase(countOfPerson, i)) continue;

            if (trueCase()) continue;

            points.add(false);
        }
    }

    private boolean trueCase() {
        if (points.stream().allMatch(Boolean.FALSE::equals)) {
            points.add(true);
            return true;
        }
        return false;
    }

    private boolean randomValueCase(int countOfPerson, int i) {
        if (i == 0 || (!points.get(i - 1) && i < countOfPerson - 2)) {
            points.add(RandomUtil.getRandomBoolean());
            return true;
        }
        return false;
    }

    public int next(int current){

        for (int i = 0; i < points.size(); i++) {
            if(i == current && points.get(i)){
                return current+1;
            }
        }

        for (int i = 0; i < points.size(); i++) {
            if( i == current -1 && points.get(i)){
                return current-1;
            }
        }

        return current;
    }

    @Override
    public String toString() {
        return pointsToString();
    }

    private String pointsToString() {
        return ViewUtil.concatInput(ViewUtil.setPrefix(6), String.format("|%s|", convertToString()));

    }

    private String convertToString() {
        return points.stream()
                .map(Line::visualize)
                .collect(Collectors.joining(Line.PIPE));
    }

    private static String visualize(Boolean value) {
        return value ? Line.DASH.repeat(5) : Line.SPACE_BAR.repeat(5);
    }
}
