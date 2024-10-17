package icu.sunway.naraka.Controller;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Action.ActionMap;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import icu.sunway.naraka.Entity.Result;
import icu.sunway.naraka.Message.UniversalMessage;
import icu.sunway.naraka.Service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    PlayerService playerService;
    UniversalMessage universalMessage = UniversalMessage.getInstance();

    PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PutMapping("/update_action")
    public Result<String> updatePlayerAction(@RequestParam String playerId,
                                             @RequestParam String actionName) {
        try {
            ActionMap actionMap = ActionMap.fromString(actionName);
            if (actionMap == null) {
                throw new IllegalArgumentException("Custom Exception: Invalid action name");
            }
            playerService.updatePlayerAction(playerId, actionMap.getAction());
        } catch (Exception e) {
            return new Result<>(500, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), null);
    }

    @PostMapping("/create")
    public Result<String> createPlayer(@RequestParam String nickName) {
        String playerId;
        try {
            playerId = playerService.createPlayer(nickName);
        } catch (Exception e) {
            return new Result<>(500, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), playerId);
    }

    @GetMapping("/get")
    public Result<AbstractPlayer> getPlayer(@RequestParam String playerId) {
        AbstractPlayer player;
        try {
            player = playerService.getPlayer(playerId);
        } catch (Exception e) {
            return new Result<>(500, universalMessage.fail() + e.getMessage(), null);
        }
        return new Result<>(200, universalMessage.success(), player);
    }

    @PutMapping("/update_add_card_random")
    public Result<String> updatePlayerAddCardRandom(@RequestParam String playerId) {
        try {
            playerService.updatePlayerCardAddCardRandom(playerId);
        } catch (Exception e) {
            return new Result<>(500, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), null);
    }

}
