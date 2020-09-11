package step04.controller;

public class LadderApplication {

    public static void main(String[] args) {
        LadderConsoleSimulator ladderConsoleSimulator = new LadderConsoleSimulator();

        ladderConsoleSimulator.recruitParticipants();
        ladderConsoleSimulator.setRewards();
        ladderConsoleSimulator.createLadder();
        ladderConsoleSimulator.printInitStatus();
        ladderConsoleSimulator.simulate();
        ladderConsoleSimulator.checkResult();
    }
}
