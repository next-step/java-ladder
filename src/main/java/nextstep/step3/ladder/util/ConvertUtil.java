package nextstep.step3.ladder.util;

import nextstep.step3.ladder.domain.Name;
import nextstep.step3.ladder.domain.Participant;
import nextstep.step3.ladder.domain.Prize;
import nextstep.step3.ladder.domain.PrizeInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 18:50
 */
public class ConvertUtil {
    public static Map<Name, Prize> convertToMap(Participant participant, PrizeInfo prizeInfo) {

        List<Name> keyStore = participant.stream()
                .collect(Collectors.toList());
        List<Prize> valueStore = prizeInfo.stream()
                .collect(Collectors.toList());

        convertTargetSizeCheck(keyStore, valueStore);

        Map<Name, Prize> convert = new HashMap<>();
        for (int i = 0; i < keyStore.size(); i++) {
            convert.put(keyStore.get(i), valueStore.get(i));
        }

        return convert;
    }

    private static void convertTargetSizeCheck(List<Name> key, List<Prize> value) {
        if(!(key.size() == value.size())) {
            throw new IllegalArgumentException("참여자와 상금정보의 개수가 다릅니다.");
        }
    }
}
