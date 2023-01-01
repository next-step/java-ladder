package nextstep.ladder.domain;

public class Height {
    private int height;

    public Height(int height) {
        validHeightCount(height);
        this.height = height;
    }

    private void validHeightCount(int height) {
        if(height < 2){
            throw new IllegalArgumentException("사다리의 최소값은 2이상이여야 합니다.");
        }
    }
}
