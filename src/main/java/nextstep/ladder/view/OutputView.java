package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerGroup;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private static final String SEPARATOR = "|";
    private static final String LINE = getMark("-");
    private static final String BLANK = getMark(" ");

    private static String getMark(String mark) {
        return IntStream.range(0, Player.NAME_LIMIT)
                .mapToObj(i -> mark).collect(Collectors.joining());
    }

    public void viewResult(PlayerGroup playerGroup, Collection<Collection<Boolean>> ladder) {
        System.out.println();
        System.out.println("실행결과물");
        System.out.println();

        viewPlayerGroup(playerGroup);
        viewLadder(ladder);
    }

    public void viewPlayerGroup(PlayerGroup playerGroup) {
        System.out.println(playerGroup.playerNames().stream()
                .map(name -> getWhiteSpace(name) + name)
                .collect(Collectors.joining(" ")));
    }

    private String getWhiteSpace(String name) {
        return IntStream.range(0, Player.NAME_LIMIT - name.length())
                .mapToObj(i -> " ")
                .collect(Collectors.joining());
    }

    public void viewLadder(Collection<Collection<Boolean>> ladder) {
        System.out.println(ladder.stream()
                .map(this::getLines)
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private String getLines(Collection<Boolean> lines) {
        return lines.stream()
                .map(isLine -> isLine ? LINE : BLANK)
                .collect(Collectors.joining(SEPARATOR, BLANK + SEPARATOR, SEPARATOR));
    }
}
