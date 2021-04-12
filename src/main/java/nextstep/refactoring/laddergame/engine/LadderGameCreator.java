package nextstep.refactoring.laddergame.engine;

public interface LadderGameCreator<I, O> {

    LadderGame<I, O> createLadderGame(int ladderWidth, int ladderHeight);

}
