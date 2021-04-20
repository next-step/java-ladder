package ladder;

import ladder.domain.Ladder;
import ladder.domain.Layer;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LadderTest {
    public final RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };

    @Test
    public void Ladder() {
        // given
        final int line = 6;
        final int height = 3;
        Layer trueLayer = Layer.valueOf(line, randomTrueBoolean);
        Ladder expectLadder = new Ladder(Arrays.asList(trueLayer, trueLayer, trueLayer));

        // when
        Ladder resultLadder = Ladder.valueOf(line, height, randomTrueBoolean);

        // then
        Assertions.assertThat(resultLadder).isEqualTo(expectLadder);
    }

    private static Stream<Arguments> finalLineTestParameters() {
        return Stream.of(
                arguments(0, 1),
                arguments(1, 0),
                arguments(2, 3),
                arguments(3, 2),
                arguments(4, 5),
                arguments(5, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("finalLineTestParameters")
    public void finalLineTest(int startLine, int expectFinalLine) {
        // given
        final int line = 6;
        final int height = 3;
        Ladder ladder = Ladder.valueOf(line, height, randomTrueBoolean);

        //when
        int resultFinalLine = ladder.finalLine(startLine);

        // then
        Assertions.assertThat(resultFinalLine).isEqualTo(expectFinalLine);
    }

    @Test
    public void printLadder() {
        //given
        //given
        Layer layer1 = new Layer(Arrays.asList(true, false, true, false, true));
        String printLayer1 = "|-------|       |-------|       |-------|";
        Layer layer2 = new Layer(Arrays.asList(true, false, true, false, false));
        String printLayer2 = "|-------|       |-------|       |       |";
        Ladder ladder = new Ladder(Arrays.asList(layer1, layer2, layer1));
        StringBuilder expectLadder = new StringBuilder();
        expectLadder.append(printLayer1).append(System.lineSeparator())
                .append(printLayer2).append(System.lineSeparator())
                .append(printLayer1).append(System.lineSeparator());

        //when
        String resultLadder = ladder.printLadder();

        //then
        assertThat(resultLadder).isEqualTo(expectLadder.toString());
    }

}
