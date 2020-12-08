package ladder.domain.game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-12-04.
 */
public class BridgeTest {


    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 사다리는_연결되어_있나(boolean connection) {
        assertThat(Bridge.of(connection)).isEqualTo(Bridge.of(connection));
    }



}
