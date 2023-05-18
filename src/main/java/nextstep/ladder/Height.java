package nextstep.ladder;

public class Height {

    private int height;

    public Height(int height){
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < 2) {
            throw new IllegalArgumentException("사다리 높이는 2 이상이어야 합니다.");
        }
    }

    public int height(){
        return height;
    }
}
