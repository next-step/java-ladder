package nextstep.ladder.domain.endpoint;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EndpointTest {
    @Test
    void name() {
        String charSequence = "point";
        Endpoint point = Endpoint.from(charSequence);
        Assertions.assertThat(point.name()).isEqualTo(charSequence);
    }
}
