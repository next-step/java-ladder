package nextstep.game;

import game.domain.GhostLegService;
import game.dto.LineDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void 사다리_가로줄_생성_확인() {
        List<Boolean> lines = validLineDto.getLines();
        assertThat(lines).containsAnyOf(true, false);
    }

    @Test
    public void 유효한_사다리_가로줄_확인() {
        validLineDto.filter(ghostLegService.filterLines(List.of(true, false, true)));
//        LineDto invalidLineDto = new LineDto(List.of(true, true, true));
//        invalidLineDto.filter(ghostLegService.filterLines(invalidLineDto.getLines()));
        assertAll(
                () -> assertThat(validLineDto.getLines()).isEqualTo(List.of(true, false, true))
//                () -> assertThat(invalidLineDto.getLines()).isEqualTo(List.of(true, false, true))
        );
    }
}
