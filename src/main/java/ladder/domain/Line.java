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
        boolean state = false;
        Random random = new Random();
        for (int i = 0; i < countOfPlayer - 1; i++) {
            if (state) {
                state = false;
            } else {
                state = random.nextBoolean();
            }
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
