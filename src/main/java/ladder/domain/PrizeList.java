package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrizeList {

    private final List<Prize> prizeList;

    public PrizeList(List<Prize> prizeList) {
        this.prizeList = prizeList;
    }

    public static PrizeList of(String[] prizeListInOrder) {
        List<Prize> list = Arrays.stream(prizeListInOrder)
                .map(Prize::new)
                .collect(Collectors.toList());
        return new PrizeList(list);
    }

    public Prize prize(Position position) {
        int index = position.number();
        validateIndexRange(index);
        return prizeList.get(index);
    }

    public List<Prize> prizeList() {
        return prizeList;
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index > prizeList.size() - 1) {
            throw new IllegalArgumentException("유효하지 않는 position 값입니다.");
        }
    }
}
