package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ladders {

    List<Ladder> ladders;

    public Ladders(List<Ladder> ladders){
        this.ladders = ladders;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int climb(int index) {

        AtomicInteger moveIndex = new AtomicInteger(index);

        ladders.forEach(ladder -> moveIndex.set(ladder.move(moveIndex.get())));

        return moveIndex.get();

    }

}

