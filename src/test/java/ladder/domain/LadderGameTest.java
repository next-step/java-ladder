package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    private LineBuildStrategy lineBuildStrategy;

    @BeforeEach
    public void init(){
        lineBuildStrategy = new RandomLineBuildStrategy();
    }


    @DisplayName("사다리가 최대 높이까지 생성되는지 테스트")
    @Test
    void ladderBuildTest(){
        // given
        int ladderMaxHeight = 5;

        // when
        Players players = new Players(new String[]{"AAA", "BBB", "CCC"});

        Ladders ladders = new Ladders(IntStream.range(0, ladderMaxHeight)
                .mapToObj(ladder -> new Ladder(lineBuildStrategy.build(players.getPlayers().size())))
                .collect(Collectors.toList()));

        // then
        assertThat(ladders.getLadders().size()).isEqualTo(ladderMaxHeight);
    }


}
