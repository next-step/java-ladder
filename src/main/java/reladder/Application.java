package reladder;

public class Application {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        LadderResponse ladderResponse = new LadderResponse();
        ladderResponse.printLadderGame();
        ladderResponse.printResult();
        ladderResponse.printResultAll();
    }
}
