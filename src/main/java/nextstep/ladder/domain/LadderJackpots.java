package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderJackpots {
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String TRANSFER_STRING = "";
    List<LadderJackpot> jackpots;

    private LadderJackpots(List<LadderJackpot> jackpots) {
        this.jackpots = jackpots;
    }

    public static LadderJackpots of(String excutionResults, String initPerson) {
        String[] results = excutionResults.split(",");

        if(results.length != initPerson.split(",").length) {
            throw new IllegalArgumentException("사람과 당첨 결과의 수는 같아야 합니다.");
        }

        return new LadderJackpots(Arrays.stream(results)
                                        .map(LadderJackpot::of)
                                        .collect(Collectors.toList()));
    }

    public String findJackpot(int index) {
        return jackpots.get(index).findJackpot();
    }

    public int result(int moveIndex, List<Lines> list) {
        Position position = Position.of(moveIndex);
        MoveStrategy moveStrategy;

        // 당첨상품 처리 로직
        for (int i = 0; i < list.size(); i++) {
            //만약 사다리 + 1이 선이 있는 다리라면?
            if (moveIndex == 1) {
                moveStrategy = new RightMoveStrategy(list, moveIndex);
                if (moveStrategy.move(i)) {
                    position.rightMove();
                    continue;
                }
                continue;
            }

            if (moveIndex > 1 && moveIndex < list.get(0).size() - 1) {
                if(list.get(i).findLines(moveIndex - 1).isExist()) {
                    position.leftMove();
                    continue;
                }

                if(list.get(i).findLines(moveIndex + 1).isExist()) {
                    position.rightMove();
                    continue;
                }
                continue;
            }

            if(moveIndex == list.get(0).size() - 1) {
                if(list.get(i).findLines(moveIndex - 1).isExist()) {
                    position.leftMove();
                }
            }
        }

        return position.ceil();
    }

    @Override
    public String toString() {
        return jackpots.toString().replaceAll(REPLACE_STRING, TRANSFER_STRING);
    }
}
