package laddergame.controller;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.Size;
import laddergame.domain.player.Name;
import laddergame.domain.player.Player;
import laddergame.domain.player.Players;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {
    private LadderFactory factory;

    @Test
    void 참여자한명생성() {
        String name = "참여이름";
        Player player = LadderFactory.enrollOne("참여이름");

        assertThat(player).isEqualTo(new Player(new Name(name)));
    }

    @Test
    void 참여자여러명생성() {
        List<String> names = Arrays.asList("참여1", "참여2", "참여3", "참여4");
        List<Player> playerList = names.stream()
                .map(LadderFactory::enrollOne)
                .collect(Collectors.toList());

        Players players = LadderFactory.enroll(names);

        assertThat(players).isEqualTo(new Players(playerList));
    }

    @Test
    void 사다리생성() {
        Size size = new Size(5, 6);
        Ladder ladder = LadderFactory.makeLadder(size);

    }


}
