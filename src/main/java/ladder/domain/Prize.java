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
    public static final String DELIMITER = ",";
    private final String[] prizes;

    private Prize(String[] prizes, int countOfPerson) {
        if (prizes.length != countOfPerson) {
            throw new IllegalArgumentException("입력한 상품의 개수가 참여자 수와 맞지 않습니다.");
        }

        this.prizes = prizes;
    }

    public static Prize of(String prizes, int countOfPerson) {
        if (prizes == null || prizes.trim().isEmpty()) {
            throw new IllegalArgumentException("상품이 입력되지 않았습니다.");
        }

        return new Prize(prizes.split(DELIMITER), countOfPerson);
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
