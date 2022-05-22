package nextstep.ladder.dto;

import nextstep.ladder.domain.Height;

public class LadderStandardDto {
    private final Height height;
    private final int width;

    public LadderStandardDto(Height height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height.getValue();
    }

    public int getWidth() {
        return width;
    }
}
