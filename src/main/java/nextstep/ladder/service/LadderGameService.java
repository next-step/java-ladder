package nextstep.ladder.service;

import nextstep.ladder.domain.gamer.Gamers;
import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.result.Results;

public class LadderGameService {
    private static final String INITIATE_ERROR_MSG = "create LadderGamerService fail." +
            "gamers's size and results's size and ladder's sizeOfPersons are must be same size " +
            "gamers's size=%d, " +
            "results's size=%d, " +
            "ladder's sizeOfPerson=%d";

    private final Gamers gamers;
    private final Results results;
    private final Ladder ladder;

    public LadderGameService(Gamers gamers, Results results, Ladder ladder) {
        this.gamers = gamers;
        this.results = results;
        this.ladder = ladder;
    }

    public static LadderGameService of(Gamers gamers, Results results, Ladder ladder) {
        if (isInvalid(gamers, results, ladder)) {
            throw new IllegalArgumentException(String.format(INITIATE_ERROR_MSG, gamers.size(), results.size(), ladder.sizeOfPerson()));
        }
        return new LadderGameService(gamers, results, ladder);
    }

    private static boolean isInvalid(Gamers gamers, Results results, Ladder ladder) {
        return gamers.size() != results.size() || results.size() != ladder.sizeOfPerson();
    }

    public String getResult(String gamer) {
        int startNumber = gamers.getLadderNumber(gamer);
        int resultNumber = ladder.getResultNumber(startNumber);
        return results.getResult(resultNumber);
    }

    @Override
    public String toString() {
        return "LadderGameService{" +
                "gamers=" + gamers +
                ", results=" + results +
                ", ladder=" + ladder +
                '}';
    }
}
