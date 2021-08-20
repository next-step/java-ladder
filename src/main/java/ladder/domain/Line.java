package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    public static final int MIN_PLAYERS = 2;
    private List<Boolean> points = new ArrayList<>();

    public Line(List<Player> players){
        this(players.size());
    }

    Line(int countOfPlayer) {
        if (countOfPlayer < MIN_PLAYERS) {
            throw new IllegalArgumentException("최소 2인 이상 플레이 가능합니다.");
        }
        add(countOfPlayer);
    }

    private void add(int countOfPlayer) {
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
