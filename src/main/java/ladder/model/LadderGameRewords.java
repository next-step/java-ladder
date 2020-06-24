package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGameRewords {

    private static final String COMMA_DELIMITER = ",";

    private final List<LadderGameReword> ladderGameRewords;

    private LadderGameRewords(final List<LadderGameReword> ladderGameRewords) {
        validate(ladderGameRewords);
        this.ladderGameRewords = Collections.unmodifiableList(ladderGameRewords);
    }

    private void validate(final List<LadderGameReword> ladderGameRewords) {
        if (Objects.isNull(ladderGameRewords) || ladderGameRewords.isEmpty()) {
            throw new IllegalArgumentException("결과값은 NULL 이 될 수 없습니다.");
        }
    }

    public static LadderGameRewords create(final String rewords) {
        return create(rewords.split(COMMA_DELIMITER));
    }

    public static LadderGameRewords create(final String[] rewordArray) {
        List<LadderGameReword> rewords = Arrays.stream(rewordArray)
            .map(LadderGameReword::create)
            .collect(Collectors.toList());

        return create(rewords);
    }

    public static LadderGameRewords create(final List<LadderGameReword> rewords) {
        return new LadderGameRewords(rewords);
    }

    public int count() {
        return ladderGameRewords.size();
    }

    public LadderGameReword get(int index) {
        return ladderGameRewords.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderGameRewords)) {
            return false;
        }
        LadderGameRewords that = (LadderGameRewords) o;
        return Objects.equals(ladderGameRewords, that.ladderGameRewords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderGameRewords);
    }
}
