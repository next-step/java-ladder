package nextstep.ladder.ladder;

import nextstep.ladder.util.StringUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Prizes {

    private final List<String> prizeNames;

    private Prizes(List<String> prizeNames) {
        this.prizeNames = prizeNames;
    }

    public static Prizes of(String prizes) {
        String[] split = StringUtil.split(prizes);
        List<String> collect = Arrays.stream(split)
                .collect(Collectors.toList());
        return new Prizes(collect);
    }

    public String findPrize(int index) {
        indexValidate(index);
        return prizeNames.get(index);
    }

    public List<String> getPrizeNames() {
        return Collections.unmodifiableList(prizeNames);
    }

    private void indexValidate(int index) {
        int length = prizeNames.size() - 1;
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("상품 정보는 0부터 " + length + "까지 조회 가능합니다.");
        }
    }
}

