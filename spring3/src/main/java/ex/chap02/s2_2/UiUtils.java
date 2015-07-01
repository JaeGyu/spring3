package ex.chap02.s2_2;

import org.apache.commons.lang.StringUtils;

public class UiUtils {

	public static boolean isSmallLength(String name, String playerName,
			int length) {

		if (name == null) {
			return true;
		}

		if (length < name.length()) {
			System.out.printf("%s는 %s문자 이하로 입력해 주세요. \n", playerName, length);
			return false;
		}

		return true;
	}

	public static boolean isNumeric(String id, String teamId) {

		if (!StringUtils.isNumeric(id)) {
			System.out.printf("%s는 숫자로 입력해 주세요. \n", teamId);
			return false;
		}

		return true;
	}

}
