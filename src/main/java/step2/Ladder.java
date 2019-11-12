package step2;

public class Ladder {
    private int height;

    public Ladder(int height) {
        this.height = height;
    }

    public Ladder(String heightInput) {
        try {
            height = Integer.parseInt(heightInput);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다. " + e);
        }
    }

    public int getHeight() {
        return height;
    }
}
