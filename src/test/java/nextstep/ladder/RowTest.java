package nextstep.ladder;

import nextstep.ladder.domain.Row;
import nextstep.ladder.dto.PointDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RowTest {
    @Test
    void Row_생성_테스트() {
        List<PointDto> pointDtos = Row.of(() -> true, 5)
                .toPointDtos();

        assertAll("Row create Test",
                () -> assertEquals(true, pointDtos.get(0).isRight()),
                () -> assertEquals(false, pointDtos.get(1).isRight()),
                () -> assertEquals(true, pointDtos.get(2).isRight()),
                () -> assertEquals(false, pointDtos.get(3).isRight()),
                () -> assertEquals(false, pointDtos.get(4).isRight())
        );

    }
}



