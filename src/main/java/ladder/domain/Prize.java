package ladder.domain;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Prize {
    private final String[] prizes;

    public Prize(String prizes) {
        this.prizes = prizes.split(",");
    }

    public String getPrize(int position) {
        if (position > prizes.length) {
            throw new IndexOutOfBoundsException("입력된 수가 상품의 개수보다 큽니다.");
        }

        if (position < 0) {
            throw new IndexOutOfBoundsException("입력된 수는 0 이상이어야 합니다.");
        }

        return prizes[position];
    }
}
