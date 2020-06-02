package nextstep.ladder.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderRequestDto {
    private final int MIN_USER_SIZE = 2;
    private final int MIN_HEIGHT = 2;

    private final List<String> names;
    private final int height;

    public LadderRequestDto(List<String> names, int height) {
        this.validateHeight(height);
        this.validateNames(names);
        this.names = Collections.unmodifiableList(names);
        this.height = height;
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getHeight() {
        return this.height;
    }


    private void validateNames(List<String> names) {
        if (Objects.isNull(names) || names.size() < MIN_USER_SIZE) {
            throw new IllegalArgumentException(String.format("name is at least %d", MIN_USER_SIZE));
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(String.format("height is at least %d", MIN_HEIGHT));
        }
    }
}
