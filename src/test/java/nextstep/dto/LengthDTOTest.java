package nextstep.dto;

import nextstep.entity.Length;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class LengthDTOTest {

    @Test
    @DisplayName("팩토리 메소드 검증")
    void of() {
        int length = 1;
        then(LengthDTO.of(new LengthDTO(length))).isEqualTo(new Length(length));
    }
}
