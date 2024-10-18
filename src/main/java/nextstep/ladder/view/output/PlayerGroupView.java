package nextstep.ladder.view.output;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerGroup;
import nextstep.ladder.Visible;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerGroupView implements Visible {

    @Override
    public void view(final PlayerGroup playerGroup, final Ladder ladder) {
        System.out.println(playerGroup.playerNames().stream()
                .map(name -> getWhiteSpace(name) + name)
                .collect(Collectors.joining(" ")));
    }

    private String getWhiteSpace(String name) {
        return IntStream.range(0, Player.NAME_LIMIT - name.length())
                .mapToObj(i -> " ")
                .collect(Collectors.joining());
    }
}
