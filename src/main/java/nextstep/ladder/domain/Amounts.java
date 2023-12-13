package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Amounts implements Iterable<Amount> {
    private final List<Amount> amounts;

    public Amounts(String[] inputAmounts) {
        validate(inputAmounts);

        List<Amount> amountList = new ArrayList<>();
        for (String input : inputAmounts) {
            amountList.add(new Amount(input.trim()));
        }

        this.amounts = amountList;
    }

    private void validate(String[] amounts) {
        checkAmountsSizeIsValid(amounts);
    }

    private void checkAmountsSizeIsValid(String[] amounts) {
        if (amounts == null || amounts.length == 0) {
            throw new IllegalArgumentException("실행 결과의 갯수는 최소 1개 이상이어야 합니다.");
        }
    }

    public Amount find(Position position) {
        return this.amounts.get(position.current());
    }

    public int size() {
        return this.amounts.size();
    }

    @Override
    public Iterator<Amount> iterator() {
        return this.amounts.iterator();
    }
}
