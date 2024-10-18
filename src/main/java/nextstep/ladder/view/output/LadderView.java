package nextstep.ladder.view.output;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.Visible;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderView implements Visible {

    private static final String SEPARATOR = "|";
    private static final String LINE = getMark("-");
    private static final String BLANK = getMark(" ");

    private static String getMark(String mark) {
        return IntStream.range(0, Player.NAME_LIMIT)
                .mapToObj(i -> mark).collect(Collectors.joining());
    }

    @Override
    public void view(final PlayerGroup playerGroup, final Ladder ladder) {
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
