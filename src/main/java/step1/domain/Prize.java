package step1.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Prize {

    private final String prize;


    public Prize(String prize) {
        validatePrize(prize);
        this.prize = prize;
    }

    public static List<Prize> from(List<String> prizes) {
        return prizes.stream()
            .map(Prize::new)
            .collect(Collectors.toList());
    }

    public String getPrize() {
        return prize;
    }

    private void validatePrize(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new IllegalArgumentException("prize 이름은 비어있을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Prize)) {
            return false;
        }

        Prize that = (Prize) o;

        return Objects.equals(prize, that.prize);
    }

    @Override
    public int hashCode() {
        return prize != null ? prize.hashCode() : 0;
    }
}
