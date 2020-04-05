package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLinkTest {

    @DisplayName("Link는 중복 연결 될 수 없다.")
    @Test
    void nonDuplicateConnect() {
        LadderLink connectLink = LadderLink.CONNECT;
        LadderLink newLink = LadderLink.of(connectLink);

        assertThat(newLink).isEqualTo(LadderLink.DIS_CONNECT);
    }
}
