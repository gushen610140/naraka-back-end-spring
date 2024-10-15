package icu.sunway.naraka.Entity.Action;

import icu.sunway.naraka.Entity.Action.ActionImpl.ActionFlick;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class ActionMap {
    @Getter
    private static final Map<String, AbstractAction> actionMap = new HashMap<>() {{
        put("flick", ActionFlick.getInstance());
    }};
}
