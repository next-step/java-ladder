package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

public class LadderResultTest {

    @Test
    @DisplayName("맵에서 결과를 반환해준다.")
    void 결과_반환() {
        LinkedHashMap<Member, Reword> rewordMap = new LinkedHashMap<>();
        rewordMap.put(new Member("hee"), new Reword("5000"));
        Assertions.assertThat(new LadderResult(rewordMap).getReword(new Member("hee"))).isEqualTo(new Reword("5000"));
    }

}
