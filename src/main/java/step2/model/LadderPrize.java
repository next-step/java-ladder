package step2.model;

import step2.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class LadderPrize {

    private final static String NOT_CORRECT_SIZE_MESSAGE = "입력하신 인원 수와 보상 개수는 같아야합니다.";
    private final List<Prize> prizes = new ArrayList<>();

    private LadderPrize(Person person, String[] ladderPrize) {
        confirmLadderPrizeSize(person, ladderPrize);
        for(String prize : ladderPrize) {
            prizes.add(Prize.createPrize(prize));
        }
    }

    //사다리보상을 생성한다.
    public static LadderPrize createLadderPrize(Person person, String prizeStr) {
        return new LadderPrize(person, StringUtil.divideComma(prizeStr));
    }

    //해당 인덱스에 저장되어있는 사다리보상을 가져온다 .
    public Prize choosePrize(int index) {
        return prizes.get(index);
    }

    public List<Prize> getPrizes() {
        return prizes;
    }

    //입력받은 사다리보상이 인원수와 맞는지 체크한다.
    private void confirmLadderPrizeSize(Person person, String[] prizeArr) {
        if(person.nameSize() != prizeArr.length) {
            throw new IllegalArgumentException(NOT_CORRECT_SIZE_MESSAGE);
        }
    }
}
