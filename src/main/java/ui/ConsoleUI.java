package ui;

import device.InputDevice;
import domain.NameTag;
import domain.NameTagGroup;
import utils.StringUtils;

public class ConsoleUI {

    public static void main(String[] args){
        String names = InputDevice.inputNames();
        NameTagGroup nameTagGroup = NameTagGroup.of(StringUtils.makeNameTag(names));

    }
}
