package PlayerManager.service;

import PlayerManager.dao.PlayerDao;
import PlayerManager.model.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerDao playerDao;

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Transactional
    public void addPlayer(Player player) {
        playerDao.addPlayer(player);
    }

    @Transactional
    public void updatePlayer(Player player) {
        playerDao.updatePlayer(player);
    }

    @Transactional
    public void deletePlayer(int id) {
        playerDao.deletePlayer(id);
    }

    @Transactional
    public Player getPlayerById(int id) {
        return playerDao.getPlayerById(id);
    }

    @Transactional
    public List<Player> listOfPlayers() {
        return playerDao.listOfPlayers();
    }
}
