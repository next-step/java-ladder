package game;

import game.domain.ladder.FixedNumberOneAndTrueValueStrategy;
import game.domain.ladder.LadderResult;
import game.domain.ladder.Ladders;
import game.domain.ladder.Line;
import game.service.GhostLegService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GhostLegServiceTest {

    private GhostLegService ghostLegService;
    private List<String> participants;
    private List<String> results;
    private Ladders ladders;

    @BeforeEach
    public void init() {
        ghostLegService = new GhostLegService();

        participants = List.of("test1", "test2");
        results = List.of("당첨", "꽝");
        ladders = new Ladders(List.of(Line.of(2, new FixedNumberOneAndTrueValueStrategy())));
    }

    @Test
    public void 랜덤사다리_생성() {
        assertAll(
                () -> assertThat(ghostLegService.generateRandomLines(1, 2, new FixedNumberOneAndTrueValueStrategy())).hasSize(1),
                () -> assertThat(ghostLegService.generateRandomLines(2, 2, new FixedNumberOneAndTrueValueStrategy())).hasSize(2)
        );
    }

    @Test
    public void 사다리결과_전체() {
        List<LadderResult> expected = List.of(new LadderResult("test1", "꽝"), new LadderResult("test2", "당첨"));
        List<LadderResult> actual = ghostLegService.findLadderResults(participants, "all", results, ladders);

        assertAll(
                () -> assertThat(actual.get(0).person()).isEqualTo(expected.get(0).person()),
                () -> assertThat(actual.get(0).result()).isEqualTo(expected.get(0).result()),
                () -> assertThat(actual.get(1).person()).isEqualTo(expected.get(1).person()),
                () -> assertThat(actual.get(1).result()).isEqualTo(expected.get(1).result())
        );
    }

    @Test
    public void 사다리결과_일부() {
        List<LadderResult> actual = ghostLegService.findLadderResults(participants, "test1", results, ladders);

        assertAll(
                () -> assertThat(actual).hasSize(1),
                () -> assertThat(actual.get(0).person()).isEqualTo("test1"),
                () -> assertThat(actual.get(0).result()).isEqualTo("꽝")
        );
    }
}
