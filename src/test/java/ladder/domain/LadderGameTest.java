package ladder.domain;

import ladder.domain.ladder.Height;
import ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderGameTest {

    private List<String> names;

    @BeforeEach
    void setUp() {
        this.names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
    }

    @DisplayName("LadderGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderGame.of(Players.of(names), Height.of(Height.MIN_HEIGHT * 5)))
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void play() {
        assertThatCode(() -> LadderGame.of(Players.of(names), Height.of(Height.MIN_HEIGHT * 5)).play())
                .doesNotThrowAnyException();
    }
}
