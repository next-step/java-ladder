package ladder.core.controller;

public interface ILadderController extends Controller {
    void inputGamers(String gamerNames);
    void inputReward(String reward);
    void inputLadderSize(int ladderSize);
    void inputGamerName(String gamerName);
    void callAfterLadderResult();
}
