package newladder.model;


public class MyLadderGame {

    private final MyLadder ladder = new MyLadder();

    public MyLadderGame(int participantsSize, int ladderHeight) {
        ladder.createLadder(participantsSize, ladderHeight);
        ladder.downLadder(0);
        ladder.downLadder(1);
        ladder.downLadder(2);
    }


}
