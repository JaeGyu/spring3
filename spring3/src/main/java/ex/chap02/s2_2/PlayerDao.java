package ex.chap02.s2_2;

import org.springframework.dao.DataAccessException;

public interface PlayerDao {
	
	void insertPlayer(Player player) throws DataAccessException;
}
