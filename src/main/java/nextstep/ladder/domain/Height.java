package nextstep.ladder.domain;

public class Height {

    private static final String MIN_VALUE_EXCEPTION_MESSAGE = "사다리의 최소값은 2이상이여야 합니다.";
    private int height;

    public Height(int height) {
        validHeightCount(height);
        this.height = height;
    }

    private void validHeightCount(int height) {
        if(height < 2){
            throw new IllegalArgumentException(MIN_VALUE_EXCEPTION_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
