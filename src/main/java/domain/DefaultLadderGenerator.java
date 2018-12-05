package domain;

public class DefaultLadderGenerator implements LadderGenerator {

    @Override
    public Ladder generate(int participantCount, int height) {
        return Ladder.of(participantCount, height);
    }
}
