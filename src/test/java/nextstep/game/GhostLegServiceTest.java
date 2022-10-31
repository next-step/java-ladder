package nextstep.game;

import game.domain.FixedWithLadderCaseNumberStrategy;
import game.domain.FixedWithoutLadderCaseNumberStrategy;
import game.domain.GhostLegService;
import game.dto.LineDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class GhostLegServiceTest {

    private GhostLegService ghostLegService;
    private LineDto validLineDto;

    @BeforeEach
    public void 사다리_가로줄_생성() {
        ghostLegService = new GhostLegService();
        validLineDto = new LineDto(ghostLegService.generateRandomLines(5));
    }

    @Test
    @Order(1)
    public void 사다리_가로줄_생성_확인() {
        List<Boolean> lines = validLineDto.getLines();
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
                () -> assertThat(secondFilteredLines).isEqualTo(List.of(true, false, true))
        );
    }
}
