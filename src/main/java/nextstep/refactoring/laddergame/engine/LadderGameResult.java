package nextstep.refactoring.laddergame.engine;

public interface LadderGameResult<I, O> {

    I getInput();
    O getOutput();

}
