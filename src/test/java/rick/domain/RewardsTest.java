package rick.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class RewardsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null, empty 리스트")
    void nullAndEmptyName(final List<String> names) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Rewards(names));
    }
}
