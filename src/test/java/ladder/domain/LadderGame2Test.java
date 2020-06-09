package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo2;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
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

public class LadderGame2Test {

    private PlayersAndPrizes multiplePlayersAndPrizes;
    private PlayersAndPrizes singlePlayersAndPrizes;

    private Height minHeight;
    private Height height;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("pobi", "honux");
        List<String> prizeNames = Arrays.asList("3000", "꽝");

        multiplePlayersAndPrizes = PlayersAndPrizes.valueOf(
                Players.of(names), Prizes.of(prizeNames));

        List<String> singlePlayerName = Collections.singletonList("heee");
        List<String> singlePrizeName = Collections.singletonList("win");

        singlePlayersAndPrizes = PlayersAndPrizes.valueOf(
                Players.of(singlePlayerName), Prizes.of(singlePrizeName));

        this.minHeight = Height.of(Height.MIN_HEIGHT);
        this.height = Height.of(Height.MIN_HEIGHT * 5);
    }

    @DisplayName("LadderGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderGame2.of(LadderShapeInfo2.valueOf(singlePlayersAndPrizes, height)))
                .doesNotThrowAnyException();
    }

    @DisplayName("LadderGame 생성 실패 : PlayersAndPrizes 가 null")
    @NullSource
    @ParameterizedTest
    void playersAndPrizesIsNull(final PlayersAndPrizes playersAndPrizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame2.of(LadderShapeInfo2.valueOf(playersAndPrizes, minHeight)));
    }

    @DisplayName("LadderGame 생성 실패 : ladderShapeInfo 가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final LadderShapeInfo2 ladderShapeInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame2.of(ladderShapeInfo));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void ready() {
        assertThatCode(() -> LadderGame2.of(
                LadderShapeInfo2.valueOf(multiplePlayersAndPrizes, height))
                .ready())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자가 1명 일 때, LadderGame 실행 가능")
    @Test
    void createWithSinglePlayer() {
        assertThatCode(() -> LadderGame2.of(
                LadderShapeInfo2.valueOf(singlePlayersAndPrizes, height))
                .ready())
                .doesNotThrowAnyException();
    }

    // TODO 게임 참여자가 1명이고 사다리의 높이가 N이면, N개의 Pillar 를 출력한다.

    @DisplayName("게임 실행 후 참여자의 모든 이름을 반환")
    @Test
    void playAndReturnPlayerNames() {
        LadderMatchResult ladderMatchResult =
                LadderGame2.of(LadderShapeInfo2.valueOf(multiplePlayersAndPrizes, height)).play();

        assertThat(ladderMatchResult.getPlayers().stream().map(Player::getName))
                .isEqualTo(multiplePlayersAndPrizes.getPlayerNames());
    }

    @DisplayName("게임 참여자가 1명 일 때, match 되는 prize 하나를 반환")
    @Test
    void playWithSinglePlayer() {
        final int singleIndex = 0;
        LadderMatchResult ladderMatchResult =
                LadderGame2.of(LadderShapeInfo2.valueOf(singlePlayersAndPrizes, height)).play();

        assertThat(ladderMatchResult.match(singlePlayersAndPrizes.getPlayerNames().get(singleIndex)))
                .isEqualTo(Prize.of(singlePlayersAndPrizes.getPrizeNames().get(singleIndex)));
    }

    // TODO 게임 참여자가 여러 명일 때, 임의로 결과값을 정해서 match 되는 값이 맞는지 확인
}
