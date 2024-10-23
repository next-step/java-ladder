package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.MatchResult;
import nextstep.ladder.domain.Player;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderView implements Visible {

    private static final String SEPARATOR = "|";
    private static final String LINE = getMark("-");
    private static final String BLANK = getMark(" ");

    private static String getMark(String mark) {
        return Stream.of(new String[Player.NAME_LIMIT])
                .map(i -> mark)
                .collect(Collectors.joining());
    }

    @Override
    public void view(MatchResult matchResult, Ladder ladder) {
        System.out.println(ladder.ladderLines().stream()
                .map(this::getLines)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private String getLines(Collection<Boolean> lines) {
        return lines.stream()
                .map(isLine -> isLine ? LINE : BLANK)
                .collect(Collectors.joining(SEPARATOR, BLANK + SEPARATOR, SEPARATOR));
    }
}
