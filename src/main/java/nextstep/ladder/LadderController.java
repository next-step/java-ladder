package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.RandomPointCreationRule;
import nextstep.ladder.view.Input;
import nextstep.ladder.view.Output;

import java.util.List;

public class LadderController {

    public void start(){
        List<Name> nameList =  Input.readUserNameList();
        int maxLadderLength = Input.readMaxLadderLength();
        Ladder ladder = Ladder.of(maxLadderLength, nameList.size()-1, new RandomPointCreationRule());

        Output.printNameList(nameList);
        Output.printLadder(ladder);
    }


}
