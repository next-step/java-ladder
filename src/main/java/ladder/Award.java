package ladder;

import java.util.Objects;

public class Award {

    private final String award;

    private Award(String award) {
        valid(award);
        this.award = award;
    }

    public static Award from(String award) {
        return new Award(award);
    }

    private void valid(String award) {
        if (award.isBlank()) {
            throw new IllegalArgumentException("유효하지 않은 결과 값입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Award award1 = (Award) o;
        return Objects.equals(award, award1.award);
    }

    @Override
    public int hashCode() {
        return Objects.hash(award);
    }

    @Override
    public String toString() {
        return "Award{" +
            "award='" + award + '\'' +
            '}';
    }
}
