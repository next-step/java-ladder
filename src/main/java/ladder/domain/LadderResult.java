package ladder.domain;

import java.util.List;

public class LadderResult {

    public static Players result(Players players, Ladder ladder) {
        int nameIndex;
        for (Name name : players.getPlayers().keySet()) {
            nameIndex = 0;
            int resultIndex = nameIndex;
            for (HorizontalLines horizontalLines : ladder.getVerticalLines()) {
                if (resultIndex == 0 && horizontalLines.getHorizontalLines().get(resultIndex)) {
                    resultIndex++;
                } else if (horizontalLines.getHorizontalLines().get(resultIndex -1)) {
                    resultIndex--;
                } else if (horizontalLines.getHorizontalLines().get(resultIndex)) {
                    resultIndex++;
                }
            }
            nameIndex++;
            // FIXME 여기서 에러
            players.getPlayers().put(name, String.valueOf(resultIndex));
        }
        return players;



















//        Ladder ladder = new Ladder(5, 5, new SequentialConnectionStratrgy());
//
//        int nameIndex;
//        // 이름을 기준으로 반복하고
//        for (Name name : players.getPlayers().keySet()) {
//            nameIndex = 0;
//            int resultIndex = nameIndex;
//
//            // 세로로 for
//            for (HorizontalLines horizontalLine : ladder.getVerticalLines()) {
//
//                // 가로로 for
//                for (int i = 0; i < horizontalLine.getHorizontalLines().size(); i++) {
//
//                    // 첫번째이면 true 만 비교, 그게 아니면 오른쪽에 있으면 오른쪽으로, 왼쪽에 있으면 왼쪽으로 결과 이동
//                    if (i == 0 && horizontalLine.getHorizontalLines().get(i)) {
//                        resultIndex++;
//                    } else if (horizontalLine.getHorizontalLines().get(i - 1)) {
//                        resultIndex--;
//                    } else if (horizontalLine.getHorizontalLines().get(i)) {
//                        resultIndex++;
//                    }
//                }
//            }
//
//            // 이동을 완료하였으면, map 에 순서 입력 // result index를 출력하는 것이 아니라 결과 list에서 get 하는 메서드로 출력
//            players.getPlayers().put(name, String.valueOf(resultIndex));
//
//            nameIndex++;
//        }
//
//        for (HorizontalLines horizontalLine : ladder.getVerticalLines()) {
//            for (int i = 0; i < horizontalLine.getHorizontalLines().size(); i++) {
//                if (i == 0 && horizontalLine.getHorizontalLines().get(0)) {
//
//                }
//            }
//        }
//
//        return null;
    }
}
