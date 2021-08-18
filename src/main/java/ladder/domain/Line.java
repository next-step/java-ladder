package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line(List<Player> players){
        this(players.size());
    }

    Line(int countOfPlayer) {
        if (countOfPlayer < 2) {
            throw new IllegalArgumentException("최소 2인 이상 플레이 가능합니다.");
        }
        boolean state = false;
        Random random = new Random();
        for (int i = 0; i < countOfPlayer - 1; i++) {
            if (state) {
                this.points.add(false);
                continue;
            }
            state = random.nextBoolean();
            this.points.add(state);
        }
    }

    public boolean point(int index){
        return points.get(index);
    }

    public int size(){
        return this.points.size();
    }

    @Override
    public String toString() {
        return points.toString();
    }
}
