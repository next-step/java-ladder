package ladder;

import ladder.domain.Layer;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}
