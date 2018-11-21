package ui;

import device.InputDevice;
import device.outputDevice;
import domain.NameTag;
import domain.NameTagGroup;
import domain.ResultTagGroup;
import utils.StringUtils;

import java.util.List;

public class ConsoleUI {

    public static void main(String[] args) {
        List<NameTag> nameTags = StringUtils.makeNameTag(InputDevice.inputNames());
        ResultTagGroup resultTagGroup = ResultTagGroup.of(StringUtils.makeNameTag(InputDevice.inputResults()));

        NameTagGroup nameTagGroup = NameTagGroup.of(nameTags, InputDevice.inputHeight());

        outputDevice.ladderResult();
        outputDevice.viewInputValues(nameTagGroup);

        outputDevice.ladderView(nameTagGroup);
        outputDevice.viewResultValues(resultTagGroup);
        outputDevice.viewResultOneAndAll(nameTagGroup, resultTagGroup);
    }


}
