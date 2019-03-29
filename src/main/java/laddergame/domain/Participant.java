package laddergame.domain;

import static laddergame.ApplicationLauncher.ALL;

public class Participant extends EndPoint {
    public Participant(String name, int index) {
        super(name, index);
    }

    @Override
    public boolean isValid(String target) {
        return super.isValid(target) && !ALL.equals(target);
    }
}