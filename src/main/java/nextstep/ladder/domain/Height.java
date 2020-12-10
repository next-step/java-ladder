package nextstep.ladder.domain;

public class Height {
    private int height;

    private Height(int height) {
        checkHeightValidate(height);
        this.height = height;
    }

    public static Height from(int height) {
        return new Height(height);
    }

    private void checkHeightValidate(int height) {
        if(height < 1) {
            throw new IllegalArgumentException("높이는 1이상 입력해주세요");
        }
    }

    public int getHeight() {
        return height;
    }


}
