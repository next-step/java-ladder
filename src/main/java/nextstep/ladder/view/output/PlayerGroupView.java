package nextstep.ladder.view.output;

import nextstep.ladder.Visible;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.PlayerGroup;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerGroupView implements Visible {

    @Override
    public void view(final PlayerGroup playerGroup, final Ladder ladder) {
        System.out.println(playerGroup.playerNames().stream()
                .map(name -> getWhiteSpace(name) + name)
                .collect(Collectors.joining(" ")));
    }

    private String getWhiteSpace(String name) {
        return Stream.of(new String[Player.NAME_LIMIT - name.length()])
                .map(i -> " ")
                .collect(Collectors.joining());
    }
}
