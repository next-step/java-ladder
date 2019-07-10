package nextstep.ladder.view.formatter;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

import java.util.stream.Collectors;

public class LadderFormatter implements Formatter<Ladder> {
    private static final String DELIMITER_LINE = "\n";

    private final Formatter<Line> lineFormatter;

    public LadderFormatter(final Formatter<Line> lineFormatter) {
        this.lineFormatter = lineFormatter;
    }

    @Override
    public String format(final Ladder ladder) {
        return ladder.stream()
                .map(lineFormatter::format)
                .collect(Collectors.joining(DELIMITER_LINE));
    }
}
