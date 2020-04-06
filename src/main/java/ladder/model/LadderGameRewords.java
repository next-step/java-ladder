package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static ladder.utils.LadderUtil.separateLineWithComma;

public class LadderGameRewords {

    private final List<LadderGameReword> ladderGameRewords;

    private LadderGameRewords(List<LadderGameReword> ladderGameRewords) {
        validate(ladderGameRewords);
        this.ladderGameRewords = Collections.unmodifiableList(ladderGameRewords);
    }

    private void validate(List<LadderGameReword> ladderGameRewords) {
        if (Objects.isNull(ladderGameRewords) || ladderGameRewords.isEmpty()) {
            throw new IllegalArgumentException("LadderGameRewords is empty");
        }
    }

    public static LadderGameRewords newInstance(String rewords) {
        return newInstance(separateLineWithComma(rewords));
    }

    private static LadderGameRewords newInstance(String[] rewordArray) {
        List<LadderGameReword> rewords = Arrays.stream(rewordArray)
                .map(LadderGameReword::of)
                .collect(Collectors.toList());

        return newInstance(rewords);
    }

    public static LadderGameRewords newInstance(List<LadderGameReword> rewords) {
        return new LadderGameRewords(rewords);
    }
}
