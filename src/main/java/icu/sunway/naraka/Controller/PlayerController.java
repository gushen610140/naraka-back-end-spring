package icu.sunway.naraka.Controller;

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

    @PostMapping("/update_action")
    public Result<String> updatePlayerAction(@RequestParam String playerId,
                                             @RequestParam String action) {
        try {
            playerService.updatePlayerAction(playerId, Objects.requireNonNull(ActionMap.fromString(action)).getAction());
        } catch (Exception e) {
            return new Result<>(400, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), null);
    }

    @PostMapping("/create")
    public Result<String> createPlayer(@RequestParam String nickName) {
        try {
            playerService.createPlayer(nickName);
        } catch (Exception e) {
            return new Result<>(400, universalMessage.fail(), e.getMessage());
        }
        return new Result<>(200, universalMessage.success(), null);
    }

    @GetMapping("/get")
    public Result<AbstractPlayer> getPlayer(@RequestParam String playerId) {
        AbstractPlayer player;
        try {
            player = playerService.getPlayer(playerId);
        } catch (Exception e) {
            return new Result<>(400, universalMessage.fail() + e.getMessage(), null);
        }
        return new Result<>(200, universalMessage.success(), player);
    }

}
