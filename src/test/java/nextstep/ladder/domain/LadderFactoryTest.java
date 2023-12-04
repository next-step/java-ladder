package nextstep.ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LadderFactoryTest {
    @Test
    void 참여인원_테스트() throws Exception {
        LadderFactory ladderFactory = new LadderFactory("a,b,c");

        assertThat(ladderFactory.people().count()).isEqualTo(3);
    }

    @Test
    void 사다리_생성_테스트() throws Exception {
        int height = 5;
        LadderFactory ladderFactory = new LadderFactory("a,b,c");

        Ladder ladder = ladderFactory.ladder(height);

        assertThat(ladder.lines().size()).isEqualTo(height);
    }
}
