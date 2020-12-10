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

    public int climb(int index) {

        AtomicInteger moveIndex = new AtomicInteger(index);

        ladders.forEach(ladder -> moveIndex.set(changeMoveIndex(ladder, moveIndex.get())));

        return moveIndex.get();

    }

    private int changeMoveIndex(Ladder ladder, int currentMoveIndex) {
        return currentMoveIndex + ladder.move(currentMoveIndex);
    }

}

