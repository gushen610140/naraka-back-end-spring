package icu.sunway.naraka.Entity.Action.ActionImpl;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import lombok.Getter;

public class ActionFlick extends AbstractAction {

    private final static int flickValue = 300;
    private final static String name = "flick";
    @Getter
    private final static ActionFlick instance = new ActionFlick(flickValue);

    ActionFlick(int value) {
        super(value);
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return name;
    }
}
