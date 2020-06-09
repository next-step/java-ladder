package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    private Players players;
    private Players singlePlayer;

    private Prizes prizes;
    private Prizes singlePrize;

    private Height minHeight;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("pobi", "honux");
        this.players = Players.of(names);

        List<String> singlePlayerName = Collections.singletonList("heee");
        this.singlePlayer = Players.of(singlePlayerName);

        List<String> prizeNames = Arrays.asList("3000", "꽝");
        this.prizes = Prizes.of(prizeNames);

        List<String> singlePrizeName = Collections.singletonList("win");
        this.singlePrize = Prizes.of(singlePrizeName);

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
    void ready() {
        assertThatCode(() -> LadderGame.of(LadderShapeInfo.valueOf(players, prizes, height)).ready())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자의 수와 게임 실행 결과의 수가 맞지 않으면 예외가 발생")
    @Test
    void createFailure() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(LadderShapeInfo.valueOf(singlePlayer, prizes, height)).ready());
    }

    @DisplayName("게임 참여자가 1명 일 때, LadderGame 실행 가능")
    @Test
    void createWithSinglePlayer() {
        assertThatCode(() -> LadderGame.of(LadderShapeInfo.valueOf(singlePlayer, singlePrize, height)).ready())
                .doesNotThrowAnyException();
    }

    // TODO 게임 참여자가 1명이고 사다리의 높이가 N이면, N개의 Pillar 를 출력한다.

    @DisplayName("게임 실행 후 참여자의 모든 이름을 반환")
    @Test
    void playAndReturnPlayerNames() {
        LadderMatchResult ladderMatchResult =
                LadderGame.of(LadderShapeInfo.valueOf(players, prizes, height)).play();

        assertThat(ladderMatchResult.getPlayers().stream().map(Player::getName))
                .isEqualTo(players.getNames());
    }

    @DisplayName("게임 참여자가 1명 일 때, match 되는 prize 하나를 반환")
    @Test
    void playWithSinglePlayer() {
        final int singleIndex = 0;
        LadderMatchResult ladderMatchResult =
                LadderGame.of(LadderShapeInfo.valueOf(singlePlayer, singlePrize, height)).play();

        assertThat(ladderMatchResult.match(singlePlayer.getNames().get(singleIndex)))
                .isEqualTo(singlePrize.indexOf(singleIndex));
    }

    // TODO 게임 참여자가 여러 명일 때, 임의로 결과값을 정해서 match 되는 값이 맞는지 확인
}
