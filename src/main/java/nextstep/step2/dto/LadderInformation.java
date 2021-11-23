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

    public static LadderInformation create(Width width, Height height) {
        return new LadderInformation(width, height);
    }

    public static LadderInformation createWithString(String namesString, String heightValue) {
        Names names = Names.createWithString(namesString);
        return create(Width.create(names.size()), Height.createWithString(heightValue));
    }

    public Width getWidth() {
        return width;
    }

    public Height getHeight() {
        return height;
    }
}
