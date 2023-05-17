package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @ParameterizedTest
    @CsvSource(value = {
            "5, 4",
            "4, 5",
            "10, 10"
    })
    void 사다리_확인(int height, int people) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(people);
            List<Boolean> bridges = line.getBridges();
            assertThat(bridges).hasSize(people - 1);

            for (Boolean point : bridges) {
                System.out.print("|");
                System.out.print(point ? "-----" : "     ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
    }
}