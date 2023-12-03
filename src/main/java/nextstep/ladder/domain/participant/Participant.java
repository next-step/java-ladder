package nextstep.ladder.domain.participant;


public class Participant {
    private String name;
    private int currentIndex;
    private String result;

    public Participant(String name, int currentIndex) {
        this.name = name;
        this.currentIndex = currentIndex;
    }

    public void moveLeft() {
        currentIndex -= 1;
    }

    public void moveRight() {
        currentIndex += 1;
    }

    public void insertResult(String[] results) {
        result = results[currentIndex];
    }

    public String getName() {
        return name;
    }

    public final int getCurrentIndex() {
        return currentIndex;
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "{name:" + name + "}" + "{currentPosition:" + currentIndex + "}" + "|";
    }
}
