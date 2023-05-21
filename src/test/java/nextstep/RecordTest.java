package nextstep;

import nextstep.domain.Participant;
import nextstep.domain.Record;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RecordTest {
    
    @Test
    void 참가자에_따른_결과_반환() {

        // given
        Record record = new Record();
        record.add(Participant.of("abc"), "1000");
        record.add(Participant.of("def"), "2000");

        // when
        Map<Participant, String> result1 = record.value("abc");
        Map<Participant, String> result2 = record.value("def");

        // then
        assertThat(result1).containsValue("1000");
        assertThat(result2).containsValue("2000");
    }

    @Test
    void all_입력_시_전체_record_반환() {

        // given
        Record record = new Record();
        record.add(Participant.of("abc"), "1000");
        record.add(Participant.of("def"), "2000");

        // when
        Map<Participant, String> result = record.value("all");

        // then
        assertThat(result).containsValues("1000", "2000");
    }
}
