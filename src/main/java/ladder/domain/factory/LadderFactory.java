package ladder.domain.factory;

import ladder.domain.Destinations;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.vo.LadderBody;

public class LadderFactory {

    private LadderFactory() {
    }

    private static final int MIN_PLAYERS = 2;

    public static Ladder create(Players players,
                                Destinations destinations,
                                int height){
        validateDestinations(players, destinations);

        return new Ladder(players, destinations, createLadderBody(players, height));
    }

    private static void validateDestinations(Players players, Destinations destinations){
        if (players.count() != destinations.count()){
            throw new IllegalArgumentException("사다리 생성할 때는 참가자 수와 실행 결과 수는 같아야 합니다.");
        }
    }

    private static LadderBody createLadderBody(Players players, int height){
        return new LadderBody(players.count() - 1, height);
    }

}
