package nextstep.ladders.domain;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParticipantsTest {

    @Test
    void 정상_생성() {
        final List<String> names = List.of("pobi", "honux", "crong", "jk");
        assertDoesNotThrow(() -> {
            Participants participants = new Participants(names);
            assertEquals(names.size(), participants.count());
        });
    }
}