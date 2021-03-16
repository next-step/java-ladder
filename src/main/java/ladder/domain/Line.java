package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> pointList = new ArrayList<>();

    private final Random random = new Random();

    public Line (int countOfPerson) {
        int verticalLineCount = countOfPerson;
        int horizontalLineCount = countOfPerson - 1;
        int totalPointCount = verticalLineCount + horizontalLineCount;

        for (int i = 0; i < totalPointCount ; i++) {
            pointList.add(getNextLinePoint(i));
        }
    }

    private boolean getNextLinePoint(int index) {
        if(isVerticalLine(index)) {
            return true;
        }
       return getNextHorizontalLinePoint(index);
    }

    private boolean isVerticalLine(int index) {
        return index % 2 == 0;
    }

    private boolean getNextHorizontalLinePoint(int index) {
        boolean previousHorizontalLinePoint = false;
        int previousHorizontalLinePointIdx = index - 2;
        if(previousHorizontalLinePointIdx > 0){
            previousHorizontalLinePoint = pointList.get(previousHorizontalLinePointIdx);
        }
        if(previousHorizontalLinePoint){
           return false;
        }
        return random.nextBoolean();
    }

    public List<Boolean> getPointList() {
        return pointList;
    }
}
