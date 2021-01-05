package chap2;

public class PasswordStrengthMeter {
	public PasswordStrength meter(String s) {
		if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
		int strengthsCount = getStrengthsCount(s);
		if (strengthsCount <= 1) return PasswordStrength.WEAK;
		if (strengthsCount == 2) return PasswordStrength.NORMAL;
		return PasswordStrength.STRONG;
	}
	
	private boolean meetsContainingNumberCriteria(String s) {
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				return true;
			}
		}
		return false;
	}

	private boolean meetsContainingUppercaseCriteria(String s) {
		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		return false;
	}

	private int getStrengthsCount(String s) {
		int strengthsCount = 0;
		if (s.length() >= 8) strengthsCount++;
		if (meetsContainingNumberCriteria(s)) strengthsCount++;
		if (meetsContainingUppercaseCriteria(s)) strengthsCount++;
		return strengthsCount;
	}
}
