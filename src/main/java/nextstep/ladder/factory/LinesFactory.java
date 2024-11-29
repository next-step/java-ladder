package nextstep.ladder.factory;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.LinesImpl;

public class LinesFactory {
    public static LinesImpl lines(List<Boolean> lines) {
        return new LinesImpl(LinesDataConverter.convert(lines));
    }

    public static LinesImpl lines(Boolean... lines) {
        return lines(toList(lines));
    }

    private static List<Boolean> toList(Boolean[] lines) {
        return Arrays.asList(lines);
    }

}
