package ladder.domain;

import ladder.domain.ladder.Height;
import ladder.domain.player.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderGameTest {

    private List<String> names;
    private List<String> singlePlayerName;

    @BeforeEach
    void setUp() {
        this.names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");

        this.singlePlayerName = new ArrayList<>();
        singlePlayerName.add("heee");
    }

    @DisplayName("LadderGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderGame.of(Players.of(names), Height.of(Height.MIN_HEIGHT * 5)))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderGame 생성 실패 : 게임 참여자가 null")
    @NullSource
    @ParameterizedTest
    void playerIsNull(final Players players) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(players, Height.of(Height.MIN_HEIGHT)));
    }

    @DisplayName("LadderGame 생성 실패 : 사다리 높이가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final Height height) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(Players.of(names), height));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void play() {
        assertThatCode(() -> LadderGame.of(Players.of(names), Height.of(Height.MIN_HEIGHT * 5)).play())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자가 1명 일 때, LadderGame 실행 가능")
    @Test
    void createWithSinglePlayer() {
        assertThatCode(() -> LadderGame.of(Players.of(singlePlayerName), Height.of(Height.MIN_HEIGHT * 5)).play())
                .doesNotThrowAnyException();
    }
}
