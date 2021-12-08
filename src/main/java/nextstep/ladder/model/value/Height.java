package nextstep.ladder.model.value;

import java.util.Objects;

public class Height {

    private final int MAX_HEIGHT = 10;
    private final String HEIGHT_ERROR_MSG = "사다리 높이는 10을 넘을 수 없습니다!!!";

    private final int ladderHeight;

    public Height(int inputData) {

        if(inputData > 10) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MSG);
        }

        this.ladderHeight = inputData;
    }

    public int getHeight() {
        return ladderHeight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Height height = (Height) o;
        return ladderHeight == height.ladderHeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeight);
    }

}
