package ladder;

import java.util.Objects;

public class Prize {
    private String prize;

    private Prize(String prize) {
        this.prize = prize;
    }

    public static Prize of(String prize) {
        return new Prize(prize);
    }

    public String getPrize() {
        return prize;
    }

    public String getPrizePad() {
        String prizeAddEmpty = this.prize + " ".repeat(5);
        return prizeAddEmpty.substring(0, 6);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prize prize1 = (Prize) o;
        return Objects.equals(prize, prize1.prize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prize);
    }
}
