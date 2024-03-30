package nextstep.ladder.domain;

public class Height {
    private final int height;

    public Height(int height) {
        if(height <= 1){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }
}
