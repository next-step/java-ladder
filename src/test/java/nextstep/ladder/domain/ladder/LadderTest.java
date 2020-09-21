package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    @DisplayName("사다리 생성")
    void create() {
        LineMaterial lineMaterial = LineMaterial.of(2, () -> true);
        LadderMaterial ladderMaterial = LadderMaterial.of(3, lineMaterial);
        Ladder ladder = Ladder.from(ladderMaterial);

        System.out.println(ladder);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,3,0,1","2,3,1,0","3,4,0,0"})
    @DisplayName("사다리 실행")
    void play(int sizeOfPoint, int height, int startLocation, int expectedLocation) {
        LineMaterial lineMaterial = LineMaterial.of(sizeOfPoint, () -> true);
        LadderMaterial ladderMaterial = LadderMaterial.of(height, lineMaterial);
        Ladder ladder = Ladder.from(ladderMaterial);
        LadderResult ladderResult = ladder.play();

        assertThat(ladderResult.getFinalLocation(Location.from(startLocation))).isEqualTo(Location.from(expectedLocation));
    }

}
