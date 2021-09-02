package step3.ladderGame.domain.award;

import step3.ladderGame.domain.exception.DifferentCountOfPlayerAndResultException;
import step3.ladderGame.domain.exception.NotFoundIndexException;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public final class Awards {

    private final List<Award> awards;

    public Awards(final List<String> awardNames, final int playerCount) {
        validate(awardNames.size(), playerCount);
        AtomicInteger index = new AtomicInteger();

        awards = awardNames.stream()
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

}
