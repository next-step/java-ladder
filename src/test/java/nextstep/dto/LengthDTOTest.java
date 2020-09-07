package nextstep.dto;

import nextstep.entity.Length;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LengthDTOTest {

    @Test
    void of() {
        int length = 1;
        then(LengthDTO.of(new LengthDTO(length))).isEqualTo(new Length(length));
    }
}
