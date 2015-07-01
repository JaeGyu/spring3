package ex.chap02.s2_2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

	private SimpleJdbcInsert insertPlayer;

	@Override
	protected void initDao() throws Exception {
		this.insertPlayer = new SimpleJdbcInsert(getDataSource())
				.withTableName("player").usingGeneratedKeyColumns("player_id");
	}

	@Override
	public void insertPlayer(Player player) throws DataAccessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("name", player.getName());
		parameters.put("team_id", player.getTeam().getId());

		Number newId = this.insertPlayer.executeAndReturnKey(parameters);
		player.setId(newId.intValue());
	}

}
