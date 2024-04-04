package ladder.model;

import java.util.stream.IntStream;

public class GameResult {
    private final NameList nameList;
    private final GameResultList gameResultList;

    public GameResult(NameList nameList, GameResultList gameResultList) {
        this.nameList = nameList;
        this.gameResultList = gameResultList;
    }

    public void ladderGame(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            IntStream.range(0, line.getPoints().size())
                    .forEach(index -> {
                        boolean point = line.getPoints().get(index);
                        if (point) {
                            this.nameList.swapPoints(index);
                        }
                    });
        }

    }

    public String makeResult(String name) {
        if (name.equals("all")) {
            return makeAllResult();
        }

        if(this.nameList.getNameList().contains(name)){
            int index = this.nameList.getNameList().indexOf(name);
            return this.gameResultList.getResultList().get(index);
        }

        throw new IllegalArgumentException("입력한 사람은 게임 참여자가 아님");
    }

    private String makeAllResult(){
        String result = "";
        for (int i = 0; i < gameResultList.getResultList().size(); i++) {
            result = result + nameList.getNameList().get(i) + " : " + gameResultList.getResultList().get(i) + "\n";
        }
        return result;
    }

}
