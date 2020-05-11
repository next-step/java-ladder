package ladder;

public class Height {

    private int height;

    public Height(int height) {
        this.height = height;
    }

    public Height(String height) {
        int tempHeight = 0;
        try {
            tempHeight = Integer.parseInt(height);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자만 입력하셔야 합니다.");
        }

        this.height = tempHeight;
    }

    public int getHeight() {
        return height;
    }
}
