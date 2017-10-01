package PlayerManager.service;


import PlayerManager.model.Player;

import java.util.List;

public interface PlayerService {
    public void addPlayer(Player player);
    public void updatePlayer(Player player);
    public void deletePlayer(int id);
    public Player getPlayerById(int id);
    public List<Player> listOfPlayers();
}
