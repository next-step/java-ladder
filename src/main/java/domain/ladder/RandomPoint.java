package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPoint {

    private List<Boolean> points = new ArrayList<>();

    List<Boolean> getRandomPoint(int playerCount){
        points.add(getRamdonLine());
        for (int location = 1; location < playerCount - 1; location++) {
            points.add(getPoint(location));
        }
        return points;
    }

    private boolean getPoint(int countOfPerson) {
        return points.get(countOfPerson-1) == false && new Random().nextBoolean();
    }

    private boolean getRamdonLine() {
        return new Random().nextBoolean();
    }

}
