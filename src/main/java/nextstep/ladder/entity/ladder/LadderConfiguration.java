package nextstep.ladder.entity.ladder;

public class LadderConfiguration {

    private int countOfFloors;
    private int countOfLines;

    public LadderConfiguration(int countOfFloors, int countOfLines) {
        this.countOfFloors = countOfFloors;
        this.countOfLines = countOfLines;

        throwIfFloorsLessThanOne();
        throwIfLinesLessThanTwo();
    }

    private void throwIfFloorsLessThanOne() {
        if (countOfFloors < 1) {
            throw new IllegalArgumentException("사다리 높이는 1 이상으로 입력해주세요.");
        }
    }

    private void throwIfLinesLessThanTwo() {
        if (countOfLines < 2) {
            throw new IllegalArgumentException("최소한 2명 이상의 참가자가 필요합니다.");
        }
    }


    public int getCountOfFloors() {
        return countOfFloors;
    }

    public int getCountOfLines() {
        return countOfLines;
    }
}
