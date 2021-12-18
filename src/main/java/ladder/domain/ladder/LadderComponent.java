package ladder.domain.ladder;

import java.util.Objects;

public class LadderComponent {

    private final LadderWidth width;
    private final LadderHeight height;

    public LadderComponent(int width, LadderHeight height) {
        this.width = new LadderWidth(width);
        this.height = height;
    }

    public static LadderComponent of(int width, int height) {
        return new LadderComponent(width, new LadderHeight(height));
    }

    public int getWidth() {
        return width.getWidth();
    }

    public int getHeight() {
        return height.getHeight();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderComponent that = (LadderComponent) o;
        return Objects.equals(width, that.width) && Objects.equals(height, that.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    @Override
    public String toString() {
        return "LadderComponent{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

}
