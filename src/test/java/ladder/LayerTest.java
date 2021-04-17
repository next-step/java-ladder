package ladder;

import ladder.domain.Layer;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LayerTest {
    @Test
    @DisplayName("복도 생성 확률 100프로, |-------|         |-------|         |-------| 형태")
    public void Layer() {
        // given 
        List<Boolean> expectAisles = Arrays.asList(true, false, true, false, true);
        RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
            @Override
            public boolean randomBoolean() {
                return true;
            }
        };
        Layer expectLayer = new Layer(expectAisles);

        // when 
        Layer resultLayer = new Layer(6, randomTrueBoolean);

        // then
        Assertions.assertThat(resultLayer).isEqualToComparingFieldByField(expectLayer);
    }
}
