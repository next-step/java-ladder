package ladder.domain;

import ladder.util.RandomPoint;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> line;
    private int columnSize;

    public Line(int countOfPerson){
        this.columnSize = countOfPerson;
        this.line = generateLine(RandomPoint.generateRandomPoint());
    }

    protected List<Boolean> generateLine(Boolean randomPoint){
        int ladderColumn = columnSize - 2;
        List<Boolean> newPoint = new ArrayList<>();
        Boolean initPoint = randomPoint;
        newPoint.add(initPoint);
        for(int i = 0; i < ladderColumn ; i++) {
            Boolean nextBoolean = RandomPoint.nextPoint(initPoint);
            newPoint.add(nextBoolean);
            initPoint = nextBoolean;
        }
        return newPoint;
    }

    public List<Boolean> resultLine(){
        return new ArrayList<>(this.line);
    }

}