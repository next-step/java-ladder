package nextstep.ladder.domain.ladder;

import static nextstep.ladder.utils.Validator.checkNotNull;

public class LadderSize {

    private final Positive width;
    private final Positive height;

    public LadderSize(Positive width, Positive height) {
        checkNotNull(width, height);
        this.width = width;
        this.height = height;
    }

    public Positive getWidth() {
        return width;
    }

    public int height() {
        return height.getValue();
    }
}
