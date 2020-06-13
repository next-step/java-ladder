package ladder.domain;

import ladder.domain.dto.LadderMatchResult;
import ladder.domain.ladder.Position;
import ladder.domain.ladder.shape.Height;
import ladder.domain.ladder.shape.LadderShapeInfo;
import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import ladder.domain.player.Player;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.fixture.LadderFixtures;
import ladder.fixture.PlayerAndPrizeFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LadderGameTest {

    private PlayersAndPrizes multiplePlayersAndPrizes;
    private PlayersAndPrizes singlePlayersAndPrizes;

    private Height minHeight;
    private Height height;

    @BeforeEach
    void setUp() {
        multiplePlayersAndPrizes = PlayerAndPrizeFixtures.of().getMultiplePlayersAndPrizes();
        singlePlayersAndPrizes = PlayerAndPrizeFixtures.of().getSinglePlayersAndPrizes();

        this.minHeight = Height.of(Height.MIN_HEIGHT);
        this.height = Height.of(Height.MIN_HEIGHT * 5);
    }

    @DisplayName("LadderGame 생성")
    @Test
    void create() {
        assertThatCode(() -> LadderGame.of(
                    LadderShapeInfo.valueOf(singlePlayersAndPrizes, height), new RandomStairGenerationStrategy())
        ).doesNotThrowAnyException();
    }

    @DisplayName("LadderGame 생성 실패 : PlayersAndPrizes 가 null")
    @NullSource
    @ParameterizedTest
    void playersAndPrizesIsNull(final PlayersAndPrizes playersAndPrizes) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(
                        LadderShapeInfo.valueOf(playersAndPrizes, minHeight), new RandomStairGenerationStrategy()));
    }

    @DisplayName("LadderGame 생성 실패 : ladderShapeInfo 가 null")
    @NullSource
    @ParameterizedTest
    void heightIsNull(final LadderShapeInfo ladderShapeInfo) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.of(ladderShapeInfo, new RandomStairGenerationStrategy()));
    }

    @DisplayName("게임 참여자 이름과 사다리 판의 정보를 가진 LadderShapeResult 를 반환")
    @Test
    void ready() {
        assertThatCode(() -> LadderGame.of(
                LadderShapeInfo.valueOf(multiplePlayersAndPrizes, height), new RandomStairGenerationStrategy())
                .ready())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 참여자가 1명 일 때, LadderGame 실행 가능")
    @Test
    void createWithSinglePlayer() {
        assertThatCode(() -> LadderGame.of(
                LadderShapeInfo.valueOf(singlePlayersAndPrizes, height), new RandomStairGenerationStrategy())
                .ready())
                .doesNotThrowAnyException();
    }

    @DisplayName("게임 실행 후 참여자의 모든 이름을 반환")
    @Test
    void playAndReturnPlayerNames() {
        LadderMatchResult ladderMatchResult =
                LadderGame.of(
                        LadderShapeInfo.valueOf(multiplePlayersAndPrizes, height),
                        new RandomStairGenerationStrategy()
                ).play();

        assertThat(ladderMatchResult.getPlayers().stream().map(Player::getName))
                .isEqualTo(multiplePlayersAndPrizes.getPlayerNames());
    }

    @DisplayName("게임 참여자가 1명 일 때, match 되는 prize 하나를 반환")
    @Test
    void playWithSinglePlayer() {
        final int singleIndex = 0;
        LadderMatchResult ladderMatchResult =
                LadderGame.of(
                        LadderShapeInfo.valueOf(singlePlayersAndPrizes, height),
                        new RandomStairGenerationStrategy()
                ).play();

        assertThat(ladderMatchResult.match(singlePlayersAndPrizes.getPlayerNames().get(singleIndex)))
                .isEqualTo(Prize.of(singlePlayersAndPrizes.getPrizeNames().get(singleIndex)));
    }

    @DisplayName("게임 참여자가 여러 명일 때, match 되는 Prize 확인")
    @Test
    void playWithMultiplePlayers() {
        LadderMatchResult ladderMatchResult = LadderFixtures.of().getLadderGame().play();

        Prizes expectedPrizes = Prizes.of(Arrays.asList("5000", "꽝", "1000", "3000", "꽝"));

        List<String> playerNames = PlayerAndPrizeFixtures.playerNames;
        IntStream.range(0, playerNames.size())
                .forEach(index ->
                    assertThat(ladderMatchResult.match(playerNames.get(index)).getName())
                            .isEqualTo(expectedPrizes.indexOf(Position.of(index)).getName())
                );
    }
}
