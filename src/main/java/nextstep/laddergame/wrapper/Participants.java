package nextstep.laddergame.wrapper;

import nextstep.laddergame.domain.Gamer;

import java.util.List;

public class Participants {
    private final List<Gamer> gamers;

    public Participants(List<Gamer> gamers) {
        this.gamers = gamers;
    }


    public List<Gamer> getGamers() {
        return gamers;
    }

    public int getNumberOfPerson() {
        return this.gamers.size();
    }

    public Gamer getGamer(String name) {
        return this.gamers
                .stream()
                .filter(vo -> vo.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public Gamer getGamer(int index) {
        return this.gamers.get(index);
    }
}
