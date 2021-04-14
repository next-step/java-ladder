package step4.domain;

import java.util.Objects;

import step4.exception.MinimumNameLengthException;

public class Prize {
    private final Position position;
    private final String prize;

    public Prize(int position, String prize) {
        this.position = Position.valueOf(position);
        this.prize = validate(prize.trim());
    }

    private String validate(String prize) {
        if (prize == null || prize.isEmpty()) {
            throw new MinimumNameLengthException("유효하지 않은 상품입니다.");
        }
        return prize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Prize prize1 = (Prize)o;
        return Objects.equals(position, prize1.position) && Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, prize);
    }
}
