package ladder.domain;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Ladders {

    private List<Ladder> ladders;

    public Ladders(List<Ladder> ladders){
        this.ladders = ladders;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }


    public int climb(int startIndex) {

        AtomicInteger moveIndex = new AtomicInteger(startIndex);

        ladders.forEach(ladder -> moveIndex.set(ladder.move(moveIndex.get())));

        return moveIndex.get();

    }

}

