package icu.sunway.naraka.Controller;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Action.ActionMap;
import icu.sunway.naraka.Entity.Result;
import icu.sunway.naraka.Message.UniversalMessage;
import icu.sunway.naraka.Service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    PlayerService playerService;
    UniversalMessage universalMessage = UniversalMessage.getInstance();
    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Result<String> updatePlayerAction(@RequestParam String playerId,
                                           @RequestParam String action) {
        try {
            playerService.updatePlayerAction(playerId, Objects.requireNonNull(ActionMap.fromString(action)).getAction());
        } catch (Exception e) {
            return new Result<>(400, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), null);
    }
}
