package ladder.domain;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
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

    private Players players;
    private Players singlePlayer;

    private Prizes prizes;

    private Height minHeight;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = new ArrayList<>();
        names.add("pobi");
        names.add("honux");
        this.players = Players.of(names);

        List<String> singlePlayerName = new ArrayList<>();
        singlePlayerName.add("heee");
        this.singlePlayer = Players.of(singlePlayerName);

        List<String> prizeNames = new ArrayList<>();
        prizeNames.add("3000");
        prizeNames.add("꽝");
        this.prizes = Prizes.of(prizeNames);

        this.minHeight = Height.of(Height.MIN_HEIGHT);
        this.height = Height.of(Height.MIN_HEIGHT * 5);
    }

    @DisplayName("LadderGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderGame.of(LadderShapeInfo.valueOf(players, prizes, height)))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderGame 생성 실패 : 게임 참여자가 null")
    @NullSource
    @ParameterizedTest
    void playerIsNull(final Players players) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(LadderShapeInfo.valueOf(players, prizes, minHeight)));
    }

    @DisplayName("LadderGame 생성 실패 : 게임 실행 결과 null")
    @NullSource
    @ParameterizedTest
    void prizesIsNull(final Prizes prizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(LadderShapeInfo.valueOf(players, prizes, minHeight)));
    }

    @DisplayName("LadderGame 생성 실패 : LadderShapeInfo 가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final LadderShapeInfo ladderShapeInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(ladderShapeInfo));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void play() {
        assertThatCode(() -> LadderGame.of(LadderShapeInfo.valueOf(players, prizes, height)).ready())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자가 1명 일 때, LadderGame 실행 가능")
    @Test
    void createWithSinglePlayer() {
        assertThatCode(() -> LadderGame.of(LadderShapeInfo.valueOf(singlePlayer, prizes, height)).ready())
                .doesNotThrowAnyException();
    }

    // TODO 게임 참여자가 1명이고 사다리의 높이가 N이면, N개의 Pillar 를 출력한다.
}
