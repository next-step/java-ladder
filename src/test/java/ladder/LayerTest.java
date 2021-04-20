package ladder;

import ladder.domain.Layer;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LayerTest {
    @Test
    @DisplayName("복도 생성 확률 100프로, |-------|         |-------|         |-------| 형태")
    public void Layer() {
        // given
        final int line = 6;
        List<Boolean> expectAisles = Arrays.asList(true, false, true, false, true);
        RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
            @Override
            public boolean randomBoolean() {
                return true;
            }
        };
        Layer expectLayer = new Layer(expectAisles);

        // when 
        Layer resultLayer = Layer.valueOf(line, randomTrueBoolean);

        // then
        assertThat(resultLayer).isEqualToComparingFieldByField(expectLayer);
    }

    @Test
    public void hasAisle() {
        // given
        List<Boolean> expectAisles = Arrays.asList(true, false, true, false, true);
        Layer expectLayer = new Layer(expectAisles);
        // when

        // then
        assertThat(expectLayer.hasAisle(0)).isTrue();
        assertThat(expectLayer.hasAisle(1)).isFalse();
        assertThat(expectLayer.hasAisle(2)).isTrue();
        assertThat(expectLayer.hasAisle(3)).isFalse();
        assertThat(expectLayer.hasAisle(4)).isTrue();
    }

    private static Stream<Arguments> nextLineTestParameters() {
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
    @MethodSource("nextLineTestParameters")
    public void nextLine(int previousLine, int expectNextLine) {
        // given
        List<Boolean> aisles = Arrays.asList(true, false, true, false, true);
        Layer layer = new Layer(aisles);

        // when
        int resultNextLine = layer.nextLine(previousLine);

        // then
        assertThat(resultNextLine).isEqualTo(expectNextLine);
    }

}
