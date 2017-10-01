package PlayerManager.dao;

import PlayerManager.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(player);
    }

    public void updatePlayer(Player player) {
        Session session = sessionFactory.getCurrentSession();
        session.update(player);
    }

    public void deletePlayer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Player player = session.load(Player.class, new Integer(id));
        if(player != null){
            session.delete(player);
        }
    }

    public Player getPlayerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Player player = session.load(Player.class, new Integer(id));

        return player;
    }

    @SuppressWarnings("unchecked")
    public List<Player> listOfPlayers() {
        Session session = sessionFactory.getCurrentSession();
        List<Player> listOfPlayers = session.createQuery("from Player").list();

        return listOfPlayers;
    }
}
