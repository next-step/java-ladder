package ladder;

import ladder.model.Bridge;
import ladder.model.LadderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BridgeTest {
    private Bridge movableBridge = Bridge.createMovableBridge(0);
    private Bridge nonMovableBridge = Bridge.createNonMovableBridge(0);

    @Test
    public void 정상_다리_생성(){
        assertThat(movableBridge.equals(Bridge.of(0, LadderItem.HORIZONTAL))).isTrue();
        assertThat(nonMovableBridge.equals(Bridge.of(0, LadderItem.BLANK_HORIZONTAL))).isTrue();

        assertThat(movableBridge.equals(Bridge.of(0, LadderItem.BLANK_HORIZONTAL))).isFalse();
        assertThat(nonMovableBridge.equals(Bridge.of(0, LadderItem.HORIZONTAL))).isFalse();
    }

    @Test
    public void 다리를_통한_이동(){
        assertThat(movableBridge.move(0)).isEqualTo(1);
        assertThat(movableBridge.move(1)).isEqualTo(0);
        assertThat(nonMovableBridge.move(0)).isEqualTo(0);
        assertThat(nonMovableBridge.move(1)).isEqualTo(1);
    }

    @Test
    public void 이동하지_못하는_경우(){
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> movableBridge.move(2))
                .withMessageMatching("해당 다리에서는 이동할 수 없는 위치에 있습니다.");

    }
}
