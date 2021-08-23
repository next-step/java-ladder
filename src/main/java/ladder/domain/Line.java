package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int MIN_PLAYERS = 2;
    private final List<Boolean> points = new ArrayList<>();
    private static Random random = new Random();

    public static Line create(int countOfPlayer) {
        if (countOfPlayer < MIN_PLAYERS) {
            throw new IllegalArgumentException("최소 2인 이상 플레이 가능합니다.");
        }
        return new Line(points(countOfPlayer));
    }

    Line(List<Boolean> points) {
        this.points.addAll(points);
    }

    private static List<Boolean> points(int countOfPlayer) {
        List<Boolean> points = new ArrayList<>();
        boolean state = false;
        for (int i = 0; i < countOfPlayer - 1; i++) {
            state = randomState(state);
            points.add(state);
        }
        return points;
    }

    private static boolean randomState(boolean beforeState){
        if (beforeState) {
            return false;
        }
        return random.nextBoolean();
    }

    public boolean point(int index){
        return points.get(index);
    }

    public int size(){
        return points.size();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
