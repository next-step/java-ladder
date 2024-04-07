package ladder.domain.participants;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void validate_name_length() {
        String invalidName = "over_five";
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(invalidName));
    }
}