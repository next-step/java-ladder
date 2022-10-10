package nextstep.ladder.domain;

import nextstep.ladder.dto.LineDto;
import nextstep.ladder.dto.PointDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class ResultTest {

    @DisplayName("index 결과가 오름차순으로 정렬되어 있다.")
    @Test
    void result() {

        final LadderCreator ladderCreator = LadderCreator.of(5, "4");
        final List<LineDto> linesDto = Result.show(ladderCreator.start());

        final List<PointDto> pointsDto = linesDto.get(0).getPointsDto();
        assertAll(
                () -> assertThat(linesDto).hasSize(4),
                () -> assertThat(pointsDto.get(0).getIndex()).isEqualTo(0),
                () -> assertThat(pointsDto.get(1).getIndex()).isEqualTo(1),
                () -> assertThat(pointsDto.get(2).getIndex()).isEqualTo(2),
                () -> assertThat(pointsDto.get(3).getIndex()).isEqualTo(3)
        );
    }
}