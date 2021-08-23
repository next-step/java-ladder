package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int MIN_PLAYERS = 2;
    private final List<Boolean> points = new ArrayList<>();

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
        Random random = new Random();
        for (int i = 0; i < countOfPlayer - 1; i++) {
            if (state) {
                points.add(false);
                continue;
            }
            state = random.nextBoolean();
            points.add(state);
        }
        return points;
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
