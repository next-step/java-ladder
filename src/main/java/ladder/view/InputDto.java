package ladder.view;

import ladder.domain.Names;

public class InputDto {
    private final Names names;
    private final Integer height;

    public InputDto(Names names, Integer height) {
        this.names = names;
        this.height = height;
    }

    public Names getNames() {
        return names;
    }

    public Integer getHeight() {
        return height;
    }
}
