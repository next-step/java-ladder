package nextstep.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    @Test
    public void 사다리생성_테스트() {
        int sizeOfPerson = 5;
        assertThat(LadderLine.init(sizeOfPerson).getPoints()).hasSize(sizeOfPerson);
    }

    @Test
    public void 사다리_한_라인_moves_결과() {
        LadderLine line = new LadderLine(Arrays.asList(new Point(0,Direction.first(TRUE))
                , new Point(1,Direction.first(TRUE).last())),Arrays.asList(false,false));

        assertThat(line.moves(0)).isEqualTo(1);
    }
}