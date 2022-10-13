package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Bridge;

import static org.assertj.core.api.BDDAssertions.then;

class BridgeTest {

    @Test
    @DisplayName("closed()로 생성시 False로 생성되는지 테스트")
    void closed() {
        then(Bridge.closed()).isEqualTo(new Bridge(false));
    }

    @Test
    @DisplayName("from()으로 전달받은 bridge가 열려있을 때 생성된 Bridge는 닫혀있는채로 생성됨.")
    void from() {
        then(Bridge.from(new Bridge(true))).isEqualTo(Bridge.closed());
    }

    @Test
    @DisplayName("createClosed()로 넘긴 count 개수 만큼 닫힌 Bridge가 생성되는지 테스트.")
    void createClosed() {
        then(Bridge.createClosedBridges(2)).isEqualTo(List.of(Bridge.closed(), Bridge.closed()));
    }
}
