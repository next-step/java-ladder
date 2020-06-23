package ladder.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderPoles {

    private final List<LadderPole> ladderPoles;

    private LadderPoles(final List<LadderPole> ladderPoles) {
        validate(ladderPoles);
        this.ladderPoles = Collections.unmodifiableList(ladderPoles);
    }

    public static LadderPoles create(final List<LadderPole> poles) {
        return new LadderPoles(poles);
    }

    public static LadderPoles create(final int... poles) {
        List<LadderPole> ladderPoles = Arrays.stream(poles)
            .mapToObj(LadderPole::create)
            .collect(Collectors.toList());

        return new LadderPoles(ladderPoles);
    }

    private void validate(final List<LadderPole> ladderPoles) {
        if (Objects.isNull(ladderPoles) || ladderPoles.isEmpty()) {
            throw new IllegalArgumentException("사다리 세로 기둥은 반드시 존재해야 합니다.");
        }
    }

    public LadderGameRewords convertToGameRewords(final LadderGameRewords ladderGameRewords) {
        if (ladderPoles.size() != ladderGameRewords.count()) {
            throw new IllegalArgumentException(
                "세로 기둥의 크기와 결과값으 갯수는 동일해야 합니다.");
        }

        List<LadderGameReword> mappedLadderGameRewords = ladderPoles.stream()
            .map(pole -> ladderGameRewords.getLadderGameReword(pole.getPolePosition()))
            .collect(Collectors.toList());

        return LadderGameRewords.create(mappedLadderGameRewords);
    }
}
