package ladder.domain;


import ladder.ladderexceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {

    @Test
    @DisplayName("게임 생성 테스트")
    void testGenerateLadderWithConnection() {
        int numUser = 5;
        int numHeight = 0;
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> new Ladder(numHeight, numUser, new SampleShufflePattern()));
    }

    @ParameterizedTest
    @CsvSource({"a,3등", "b,1등", "c,2등", "d,4등"})
    @DisplayName("게임 동작 테스트")
    void testGame(String input, String expected) {
        Line layer1 = Line.ofPoints(Arrays.asList(
                Point.custom(0, PointStatus.custom(false, true)),
                Point.custom(1, PointStatus.custom(true, false)),
                Point.custom(2, PointStatus.custom(false, true)),
                Point.custom(3, PointStatus.custom(true, false))
        ));
        Line layer2 = Line.ofPoints(Arrays.asList(
                Point.custom(0, PointStatus.custom(false, false)),
                Point.custom(1, PointStatus.custom(false, false)),
                Point.custom(2, PointStatus.custom(false, true)),
                Point.custom(3, PointStatus.custom(true, false))
        ));
        Line layer3 = Line.ofPoints(Arrays.asList(
                Point.custom(0, PointStatus.custom(false, false)),
                Point.custom(1, PointStatus.custom(false, true)),
                Point.custom(2, PointStatus.custom(true, false)),
                Point.custom(3, PointStatus.custom(false, false))
        ));

        Ladder sampleLadder = new Ladder(Arrays.asList(layer1, layer2, layer3));

        Users inputUsers = new Users(Arrays.asList("a", "b", "c", "d"));
        Rewards inputRewards = new Rewards(Arrays.asList("1등", "2등", "3등", "4등"));

        Result result = sampleLadder.generateResult(inputUsers, inputRewards);

        assertThat(result.responseForOne(input)).isEqualTo(expected);
    }
}
