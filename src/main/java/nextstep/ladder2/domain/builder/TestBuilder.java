package nextstep.ladder2.domain.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import nextstep.ladder2.domain.NxLine;

public class TestBuilder implements LadderBuilder {

    @Override
    public List<NxLine> build(int height, int countOfPerson) {
        List<NxLine> lines = new ArrayList<>();

        lines.add(new NxLine(Arrays.asList(true, false, true)));
        lines.add(new NxLine(Arrays.asList(false, true, false)));
        lines.add(new NxLine(Arrays.asList(true, false, false)));
        lines.add(new NxLine(Arrays.asList(false, true, false)));
        lines.add(new NxLine(Arrays.asList(true, false, true)));

        return lines;
    }
}
