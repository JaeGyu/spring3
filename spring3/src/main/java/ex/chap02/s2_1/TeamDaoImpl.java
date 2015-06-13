package ex.chap02.s2_1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws DataAccessException {

		RowMapper<Team> mapper = new TeamRowMapper();

		return getJdbcTemplate()
				.query("select team_id, name from team", mapper);
	}

	protected class TeamRowMapper implements RowMapper<Team> {
		private List<Team> teamList = new ArrayList<Team>();

		public List<Team> getList() {
			return teamList;
		}

		@Override
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException {

			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));

			return team;
		}

	}

}
