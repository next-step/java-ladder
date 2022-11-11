package nextstep.game;

import game.domain.ladder.LadderResult;
import game.domain.ladder.Ladders;
import game.domain.ladder.Line;
import game.service.FixedWithLadderCaseNumberStrategy;
import game.service.FixedWithoutLadderCaseNumberStrategy;
import game.service.GhostLegService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GhostLegServiceTest {

    private GhostLegService ghostLegService;
    private Line validLine;
    private Ladders ladders;
    private List<String> people;
    private List<String> results;

    @BeforeEach
    public void 사다리_가로줄_생성() {
        ghostLegService = new GhostLegService();
        validLine = new Line(ghostLegService.generateRandomLines(5));
        ladders = new Ladders(List.of(new Line(List.of(true, false, true)), new Line(List.of(false, true, false))));
        people = List.of("test1", "test2", "test3", "test4");
        results = List.of("꽝", "꽝", "당첨", "꽝");
    }

    @Test
    @Order(1)
    public void 사다리_가로줄_생성_확인() {
        List<Boolean> lines = validLine.points();
        assertThat(lines).containsAnyOf(true, false);
    }

    @Test
    @Order(2)
    public void 유효한_사다리_가로줄_WithLadderCase_확인() {
        List<Boolean> firstUnfilteredLines = Arrays.asList(true, true, true);
        List<Boolean> secondUnfilteredLines = Arrays.asList(true, true, false);
        List<Boolean> firstFilteredLines = ghostLegService.filterLines(firstUnfilteredLines, new FixedWithLadderCaseNumberStrategy());
        List<Boolean> secondFilteredLines = ghostLegService.filterLines(secondUnfilteredLines, new FixedWithLadderCaseNumberStrategy());

        assertAll(
                () -> assertThat(firstFilteredLines).isEqualTo(List.of(true, false, true)),
                () -> assertThat(secondFilteredLines).isEqualTo(List.of(true, false, true))
        );
    }

    @Test
    @Order(3)
    public void 유효한_사다리_가로줄_WithoutLadderCase_확인() {
        List<Boolean> firstUnfilteredLines = Arrays.asList(false, false, true);
        List<Boolean> secondUnfilteredLines = Arrays.asList(false, false, false);
        List<Boolean> firstFilteredLines = ghostLegService.filterLines(firstUnfilteredLines, new FixedWithoutLadderCaseNumberStrategy());
        List<Boolean> secondFilteredLines = ghostLegService.filterLines(secondUnfilteredLines, new FixedWithoutLadderCaseNumberStrategy());

        assertAll(
                () -> assertThat(firstFilteredLines).isEqualTo(List.of(true, false, true)),
                () -> assertThat(secondFilteredLines).isEqualTo(List.of(true, false, false))
        );
    }

    @Test
    @Order(4)
    public void 사다리타기_결과확인_all() {
        List<LadderResult> expect =
                List.of(new LadderResult("test1", "당첨"), new LadderResult("test2", "꽝"),
                        new LadderResult("test3", "꽝"), new LadderResult("test4", "꽝"));

        assertAll(
                () -> assertThat(ghostLegService.findLadderResults(people, "all", results, ladders).get(0).person()).isEqualTo(expect.get(0).person()),
                () -> assertThat(ghostLegService.findLadderResults(people, "all", results, ladders).get(1).person()).isEqualTo(expect.get(1).person()),
                () -> assertThat(ghostLegService.findLadderResults(people, "all", results, ladders).get(2).person()).isEqualTo(expect.get(2).person()),
                () -> assertThat(ghostLegService.findLadderResults(people, "all", results, ladders).get(3).person()).isEqualTo(expect.get(3).person())
        );
    }

    @Test
    @Order(5)
    public void 사다리타기_결과확인_1명() {
        List<LadderResult> expect = List.of(new LadderResult("test1", "당첨"));
        assertThat(ghostLegService.findLadderResults(people, "test1", results, ladders).get(0).person()).isEqualTo(expect.get(0).person());
    }
}
