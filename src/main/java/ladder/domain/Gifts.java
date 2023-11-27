package ladder.domain;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

public class Gifts {
    private final List<Gift> values;

    public Gifts(List<String> giftList, People people) {
        this.values = valueOf(giftList, people);
    }

    private static List<Gift> valueOf(List<String> giftList, People people) {
        validate(giftList, people);
        return giftList.stream().map(Gift::new).collect(Collectors.toList());
    }

    private static void validate(List<String> giftList, People people) {
        if (giftList.size() != people.count()) {
            throw new InputMismatchException("참여자 수와 실행결과 갯수는 동일하여야 합니다.");
        }
    }

    public Gift find(int i) {
        return values.get(i);
    }

    public List<Gift> values() {
        return Collections.unmodifiableList(values);
    }
}
