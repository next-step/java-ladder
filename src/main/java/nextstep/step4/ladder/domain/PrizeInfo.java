package nextstep.step4.ladder.domain;

import nextstep.step4.ladder.util.StringUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-01 21:44
 */
public class PrizeInfo {
    private static final String NULL_EMPTY_EXCEPTION_MESSAGE = "실행 결과 값이 없습니다.";
    private static final String INFO_RESULT_SIZE_EXCEPTION_MESSAGE = "결과값이 참여자와 다릅니다.";

    private List<Prize> prizeInfo;

    public PrizeInfo(List<Prize> prizeInfo) {
        this.prizeInfo = prizeInfo;
    }

    public static PrizeInfo of(String prizeInfo, int participantCount) {
        if ("".equals(prizeInfo) || prizeInfo == null) {
            throw new IllegalArgumentException(NULL_EMPTY_EXCEPTION_MESSAGE);
        }

        if (StringUtil.split(prizeInfo).size() != participantCount) {
            throw new IllegalArgumentException(INFO_RESULT_SIZE_EXCEPTION_MESSAGE);
        }

        return new PrizeInfo(StringUtil.split(prizeInfo).stream()
                .map(prize -> Prize.of(prize))
                .collect(Collectors.toList()));
    }

    public Stream<Prize> stream() {
        return this.prizeInfo.stream();
    }

    public Prize findPrizeByIndex(int findIndex) {
        return prizeInfo.stream()
                .filter(prize -> prizeInfo.get(findIndex).equals(prize))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
