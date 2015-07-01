package ex.chap02.s2_2;

import org.apache.commons.lang.StringUtils;

public class InsertPlayerUi extends AbstractUi {

	private TeamDao teamDao;
	private PlayerDao playerDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	@Override
	public void show() {
		final String playerName = "선수명";
		showMenu(playerName);

		String name = getInputedString();

		if (StringUtils.isEmpty(name)) {
			return;
		} else if (UiUtils.isSmallLength(name, playerName, 128)) {
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		} else {
			show();
		}
	}

	protected void showTeamField(Player player) {
		final String teamId = "팀ID";

		showMenu(teamId);

		String id = getInputedString();

		if (StringUtils.isEmpty(id)) {
			return;
		} else if (UiUtils.isNumeric(id, teamId)) {
			Team team = this.teamDao.getTeam(Integer.valueOf(id));

			if (team == null) {
				System.out.printf("입력하신 팀 아이디가 '%s'인 팀은 존재하지 않습니다.\n", id);
				showTeamField(player);
			} else {
				player.setTeam(team);
				playerDao.insertPlayer(player);
				System.out.printf("팀 %s에 %s 선수를 추가했습니다.\n", team.getName(),
						player.getName());
			}
		}
	}

	protected void showMenu(String wanted) {
		System.out.println("......................................");
		System.out.println(" [선수 명단]  [선수 추가]");
		System.out.println("");
		System.out.printf("%s를 입력하고 Enter 키를 눌러주세요.\n", wanted);
		System.out.println("아무것도 입력하지 않고 Enter 키를 누르면 메뉴로 돌아갑니다.");
	}

}
