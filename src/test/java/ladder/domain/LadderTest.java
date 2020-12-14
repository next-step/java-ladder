package ladder.domain;


import ladder.ladderexceptions.InvalidLadderHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LadderTest {

    @Test
    @DisplayName("게임 생성 테스트")
    void testGenerateLadderWithConnection() {
        int numUser = 5;
        int numHeight = 0;
        assertThatExceptionOfType(InvalidLadderHeightException.class)
                .isThrownBy(() -> new Ladder.Builder(numUser).height(numHeight).connectionMode(new SampleShufflePattern()).build());
    }

    @ParameterizedTest
    @CsvSource({"a,3등", "b,1등", "c,2등", "d,4등"})
    @DisplayName("게임 동작 테스트")
    void testGame(String input, String expected) {

        Ladder sampleLadder = new Ladder.Builder(4)
                .height(3)
                .connectionMode(new ConnectionMode() {
                    private int idx = 0;
                    // 아래 입력에 따른 사다리 레이아웃은 다음과 같다.
                    // true, false, true, false
                    // false, false, true, false
                    // false, true, false, false
                    private final List<Boolean> layout = Arrays.asList(
                            true, false, true,
                            false, false, true,
                            false, true, false);

                    @Override
                    public boolean generateConnection() {
                        boolean status = layout.get(idx);
                        idx += 1;
                        return status;
                    }
                })
                .build();

        Users inputUsers = new Users(Arrays.asList("a", "b", "c", "d"));
        Rewards inputRewards = new Rewards(Arrays.asList("1등", "2등", "3등", "4등"));

        Result result = sampleLadder.generateResult(inputUsers, inputRewards);

        assertThat(result.responseForOne(input)).isEqualTo(expected);
    }
}
