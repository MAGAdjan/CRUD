package PlayerManager.controller;

import PlayerManager.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import PlayerManager.service.PlayerService;

@Controller
public class PlayerController {
    PlayerService playerService;

    @Autowired
    public void setPlayerService(PlayerService playerService) {
        this.playerService = playerService;
    }

    @RequestMapping(value = "players", method = RequestMethod.GET)
    public String listOfPlayers(Model model){
        model.addAttribute("player", new Player());
        model.addAttribute("listOfPlayers", playerService.listOfPlayers());
        return "players";
    }

    @RequestMapping(value = "/players/add", method = RequestMethod.POST)
    public String addPlayer(@ModelAttribute Player player){
        if(player.getId() == 0) {
            playerService.addPlayer(player);
        }else{
            playerService.updatePlayer(player);
        }

        return "redirect:/players";
    }

    @RequestMapping(value = "/update/{id}")
    public String updatePlayer(@PathVariable int id, Model model){
        model.addAttribute("player", playerService.getPlayerById(id));
        model.addAttribute("listOfPlayers", playerService.listOfPlayers());

        playerService.updatePlayer(playerService.getPlayerById(id));

        return "players";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePlayer(@PathVariable int id){
        playerService.deletePlayer(id);

        return "redirect:/players";
    }

    @RequestMapping(value = "/playerdata/{id}")
    public String playerData(@PathVariable int id, Model model) {
        model.addAttribute("player", playerService.getPlayerById(id));

        return "playerdata";
    }
}
