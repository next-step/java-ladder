package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameEntitiesTest {


    @Test
    void 이름으로_참가자_인덱스_찾기() {
        GameEntities gameEntities = GameEntities.from(
                List.of("p0", "p1", "p2"),
                List.of("r0", "r1", "r2")
        );

        assertThat(gameEntities.findParticipantIndexByParticipantName("p0")).isEqualTo(0);
    }

    @Test
    void 없는_참가자_찾으면_에러() {
        GameEntities gameEntities = GameEntities.from(
                List.of("p0", "p1", "p2"),
                List.of("r0", "r1", "r2")
        );

        assertThatThrownBy(() -> gameEntities.findParticipantIndexByParticipantName("p3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 인덱스로_보상_찾기() {
        GameEntities gameEntities = GameEntities.from(
                List.of("p0", "p1", "p2"),
                List.of("r0", "r1", "r2")
        );

        assertThat(gameEntities.findRewardByIndex(0)).isEqualTo(new Reward("r0"));
    }
}