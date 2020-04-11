package nextstep.ladder.domain.gamer;

import java.util.List;

public class Gamers {
    private final List<String> gamers;

    private Gamers(List<String> gamers) {
        this.gamers = gamers;
    }

    public static Gamers of(List<String> gamers){
        //TODO validation
        return new Gamers(gamers);
    }

    public int getLadderNumber(String gamer){
        return 0;
    }
}
