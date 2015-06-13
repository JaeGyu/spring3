package ex.chap02.s2_1;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface TeamDao {
	
	List<Team> getTeamList() throws DataAccessException;

}
