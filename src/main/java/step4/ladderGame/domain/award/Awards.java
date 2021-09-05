package step4.ladderGame.domain.award;

import step4.ladderGame.domain.exception.DifferentCountOfPlayerAndResultException;
import step4.ladderGame.domain.exception.NotFoundIndexException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Awards {

    private static final String SEPARATOR = ",";

    private final List<Award> awards;

    public Awards(final String awardNames, final int playerCount) {
        List<String> splitAwardName = Arrays.asList(awardNames.split(SEPARATOR));
        validate(splitAwardName.size(), playerCount);

        AtomicInteger index = new AtomicInteger();

        awards = splitAwardName.stream()
                .map(name -> new Award(name, index.getAndIncrement()))
                .collect(Collectors.toList());
    }

    private void validate(final int awardCount, final int playerCount) {
        if (awardCount != playerCount) {
            throw new DifferentCountOfPlayerAndResultException();
        }
    }

    public String findResult(final int index) {
        return awards.stream()
                .filter(award -> index == award.getIndex())
                .findFirst()
                .map(Award::getName)
                .orElseThrow(NotFoundIndexException::new);
    }

    public List<Award> getAwards() {
        return Collections.unmodifiableList(awards);
    }

}
