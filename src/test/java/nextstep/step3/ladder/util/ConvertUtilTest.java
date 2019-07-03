package nextstep.step3.ladder.util;

import nextstep.step3.ladder.domain.Name;
import nextstep.step3.ladder.domain.Participant;
import nextstep.step3.ladder.domain.Prize;
import nextstep.step3.ladder.domain.PrizeInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 18:59
 */
class ConvertUtilTest {

    @DisplayName("두개의 리스트를 Map으로 변환하기")
    @Test
    void convertToMap() {
        Participant participant = Participant.of(
                Arrays.asList(
                        "kwon",
                        "byeon",
                        "yun"));

        PrizeInfo prizeInfo = PrizeInfo.of(
                Arrays.asList(
                        Prize.of(1000),
                        Prize.of(1000),
                        Prize.of(1000)), participant.count());

        List<Name> names = participant.stream()
                .collect(Collectors.toList());

        assertThat(ConvertUtil.convertToMap(participant, prizeInfo).containsKey(names.get(1))).isTrue();
    }
}