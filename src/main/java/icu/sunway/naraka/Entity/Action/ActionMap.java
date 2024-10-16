package icu.sunway.naraka.Entity.Action;

import icu.sunway.naraka.Entity.Action.ActionImpl.ActionFlick;
import lombok.Getter;

@Getter
public enum ActionMap {
    flick(ActionFlick.getInstance());

    private final AbstractAction action;

    ActionMap(AbstractAction action) {
        this.action = action;
    }

    public static ActionMap fromString(String name) {
        try {
            return Enum.valueOf(ActionMap.class, name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
