package nextstep.refactoring.ladder.engine.dto;

import nextstep.refactoring.view.interfaces.Dto;

import java.util.List;

public interface LineDto extends Dto {

    List<Boolean> connectionList();

}
