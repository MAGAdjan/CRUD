package PlayerManager.dao;

import PlayerManager.model.Player;

import java.util.List;

public interface PlayerDao {
    public void addPlayer(Player player);

    public void updatePlayer(Player player);

    public void deletePlayer(int id);

    public Player getPlayerById(int id);

    public List<Player> listOfPlayers();
}
