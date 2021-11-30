package nextstep.step2.dto;

import nextstep.step2.vo.Height;
import nextstep.step2.vo.Names;
import nextstep.step2.vo.Width;

public class LadderInformationDto {

    private final Width width;
    private final Height height;

    private LadderInformationDto(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public static LadderInformationDto of(Width width, Height height) {
        return new LadderInformationDto(width, height);
    }

    public static LadderInformationDto of(String namesString, String heightValue) {
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
