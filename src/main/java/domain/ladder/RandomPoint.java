package domain.ladder;

import java.util.ArrayList;
import java.util.Random;

public class RandomPoint {

    private ArrayList<Boolean> points = new ArrayList<>();

    public ArrayList<Boolean> getRandomPoint(int playerCount){
        points.add(getRamdonLine());
        for (int location = 1; location < playerCount - 1; location++) {
            points.add(getPoint(location));
        }
        return points;
    }

    public boolean getPoint(int countOfPerson) {
        return points.get(countOfPerson-1) == true ? false : getRamdonLine();
    }

    public boolean getRamdonLine() {
        return new Random().nextBoolean();
    }

}
