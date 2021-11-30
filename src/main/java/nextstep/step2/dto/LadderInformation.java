package nextstep.step2.dto;

import nextstep.step2.vo.Height;
import nextstep.step2.vo.Names;
import nextstep.step2.vo.Width;

public class LadderInformation {

    private final Width width;
    private final Height height;

    private LadderInformation(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public static LadderInformation of(Width width, Height height) {
        return new LadderInformation(width, height);
    }

    public static LadderInformation of(String namesString, String heightValue) {
        Names names = Names.of(namesString);
        return of(Width.of(names.size()), Height.of(heightValue));
    }

    public Width getWidth() {
        return width;
    }

    public Height getHeight() {
        return height;
    }
}
