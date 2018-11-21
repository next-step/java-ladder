package ui;

import device.InputDevice;
import device.OutputDevice;
import domain.Difficult;
import domain.NameTag;
import domain.NameTagGroup;
import domain.ResultTagGroup;
import utils.StringUtils;

import java.util.List;

public class ConsoleUI {

    public static void main(String[] args) {
        List<NameTag> nameTags = StringUtils.makeNameTag(InputDevice.inputNames());
        ResultTagGroup resultTagGroup = ResultTagGroup.of(StringUtils.makeNameTag(InputDevice.inputResults()));

        Difficult difficult = Difficult.valueOf(InputDevice.inputDifficult());

        NameTagGroup nameTagGroup = NameTagGroup.ofDifficult(nameTags, difficult);

        OutputDevice.ladderResult();
        OutputDevice.viewInputValues(nameTagGroup);

        OutputDevice.ladderView(nameTagGroup);
        OutputDevice.viewResultValues(resultTagGroup);
        OutputDevice.viewResultOneAndAll(nameTagGroup, resultTagGroup);
    }


}
