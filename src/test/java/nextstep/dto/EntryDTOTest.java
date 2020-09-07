package nextstep.dto;

import nextstep.entity.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class EntryDTOTest {

    @Test
    @DisplayName("팩토리 메소드 검증")
    void of() {
        String name = "pobi";
        then(EntryDTO.of(new EntryDTO(name))).isEqualTo(new Entry(name));
    }
}
