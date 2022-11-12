package nextstep.ladder.view.dto;

import nextstep.ladder.exception.ErrorMessage;
import nextstep.ladder.exception.InvalidHeightOfLadderException;

public class AskHeightOfLadderDto {
    private final int height;

    public AskHeightOfLadderDto(int height) {
        if (!isValidHeight(height)) {
            throw new InvalidHeightOfLadderException(ErrorMessage.INVALID_HEIGHT_OF_LADDER);
        }
        this.height = height;
    }

    public static AskHeightOfLadderDto of(int height) {
        return new AskHeightOfLadderDto(height);
    }

    private boolean isValidHeight(int height) {
        return height > 0;
    }

    public int getHeight() {
        return height;
    }
}
