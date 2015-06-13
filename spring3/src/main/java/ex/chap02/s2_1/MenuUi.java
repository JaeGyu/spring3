package ex.chap02.s2_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {

	private SelectTeamUi selectTeamUi;

	public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
		this.selectTeamUi = selectTeamUi;
	}

	@Override
	protected void showMenu() {
		System.out.println("--------------------");
		System.out.println("『선수 명단』「메뉴」");
		System.out.println("");
		System.out.println("1.종료");
		System.out.println("2.팀 목록");
		System.out.println("");
		System.out.println("번호를 입력한 후 Enter 키를 눌러 주세요.");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 2;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch (number) {
		case 1:
			// 1.종료
			System.out.println("종료되었습니다");
			System.exit(0);
		case 2:
			// 2.팀 목록
			this.selectTeamUi.show();
			break;
		}
	}

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext(
				"bean2_1.xml");

		MenuUi menuUi = context.getBean(MenuUi.class);
		while (true) {
			System.out.println("호호");
			menuUi.show();
		}
	}

}
