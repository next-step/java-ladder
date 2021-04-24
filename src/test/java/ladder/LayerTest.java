package ladder;

import ladder.domain.Handle;
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
        List<Handle> expectHandles = Arrays.asList(Handle.EXIST, Handle.NON_EXIST, Handle.EXIST, Handle.NON_EXIST, Handle.EXIST);
        RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
            @Override
            public boolean randomBoolean() {
                return true;
            }
        };
        Layer expectLayer = Layer.valueOf(expectHandles);

        // when 
        Layer resultLayer = Layer.valueOf(line, randomTrueBoolean);

        // then
        assertThat(resultLayer).isEqualToComparingFieldByField(expectLayer);
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
        List<Handle> handles = Arrays.asList(Handle.EXIST, Handle.NON_EXIST, Handle.EXIST, Handle.NON_EXIST, Handle.EXIST);
        Layer layer = Layer.valueOf(handles);

        // when
        int resultNextLine = layer.nextLine(previousLine);

        // then
        assertThat(resultNextLine).isEqualTo(expectNextLine);
    }

    @Test
    public void printLayer() {
        //given
        List<Handle> handles = Arrays.asList(Handle.EXIST, Handle.NON_EXIST, Handle.EXIST, Handle.NON_EXIST, Handle.EXIST);
        Layer layer = Layer.valueOf(handles);
        String expectLayer = "|-------|       |-------|       |-------|";
        //when
        String resultLayer = layer.printLayer();
        //then
        assertThat(resultLayer).isEqualTo(expectLayer);
    }
}
