package nextstep.dto;

import nextstep.entity.Entry;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class EntryDTOTest {

    @Test
    void of() {
        String name = "pobi";
        then(EntryDTO.of(new EntryDTO(name))).isEqualTo(new Entry(name));
    }
}
