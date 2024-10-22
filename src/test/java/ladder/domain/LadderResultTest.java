package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;

import static ladder.domain.MemberTest.m1;
import static ladder.domain.RewordTest.r1;

public class LadderResultTest {

    @Test
    @DisplayName("맵에서 결과를 반환해준다.")
    void 결과_반환() {
        LinkedHashMap<Member, Reword> rewordMap = new LinkedHashMap<>();
        rewordMap.put(m1, r1);
        Assertions.assertThat(new LadderResult(rewordMap).getReword(m1)).isEqualTo(r1);
    }

}
