package ladder.domain.ladder;

import ladder.exception.OverlapLineException;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private static final Random random = new Random();
    private List<Boolean> spotList;

    public Line(int countOfPerson) {
        this(createSpot(countOfPerson - 1));
    }

    public Line(List<Boolean> spot) {
        validate(spot);
        this.spotList = spot;
    }

    private void validate(List<Boolean> spot) {
        int bound = spot.size() - 1;
        for (int i = 0; i < bound; i++) {
            overlapValidate(spot, i);
        }
    }

    private void overlapValidate(List<Boolean> spot, int i) {
        if (spot.get(i) == true && spot.get(i + 1) == true) {
            throw new OverlapLineException("Line이 겹치는 부분이 있습니다.");
        }
    }

    private static List<Boolean> createSpot(int person){
        List<Boolean> tmpSpotList = new ArrayList<>();

        IntStream.range(0, person).forEach(i -> {
            checkContent(tmpSpotList);
        });

        return tmpSpotList ;
    }

    private static void checkContent(List<Boolean> tmpSpotList) {
        if (tmpSpotList.isEmpty()) {
            tmpSpotList.add(randomBoolean());
            return;
        }

        Boolean prevLine = tmpSpotList.get(tmpSpotList.size() - 1);
        if (!prevLine) {
            tmpSpotList.add(randomBoolean());
            return;
        }
        tmpSpotList.add(false);
    }

    private static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public int move(int nowPosition) {
        // 현재 사다리 맨 왼쪽에 위치해있을때
        if(nowPosition == 0) {
            return rightMove(nowPosition);
        }

        // 현재 사다리 맨 오른쪽에 위치해있을때
        if(nowPosition == getSpotList().size()) {
            return leftMove(nowPosition);
        }

        // 현재 사다리 중간에 위치해있을때
        return middlePositionCase(nowPosition);
    }

    private int middlePositionCase(int nowPosition) {
        if(isRightMove(nowPosition)) {
            return rightMove(nowPosition);
        }

        if(!isRightMove(nowPosition)) {
            return leftMove(nowPosition);
        }

        return nowPosition;
    }

    public int rightMove(int widthPos) {
        if(spotList.get(widthPos)) {
            widthPos += 1;
        }
        return widthPos;
    }

    public int leftMove(int widthPos) {
        if(spotList.get(widthPos - 1)) {
            widthPos -= 1;
        }
        return widthPos;
    }

    public boolean isRightMove(int widthPos) {
        return spotList.get(widthPos);
    }

    public List<Boolean> getSpotList() {
        return spotList;
    }
}
