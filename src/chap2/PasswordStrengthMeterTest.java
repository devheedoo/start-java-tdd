package chap2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
	private PasswordStrengthMeter meter = new PasswordStrengthMeter();
	
	private void assertStrength(String password, PasswordStrength strength) {
		PasswordStrength result = meter.meter(password);
		assertEquals(strength, result);
	}

	@Test
	void meetsAllCriteria_Then_Strong() {
		assertStrength("ab12!@AB", PasswordStrength.STRONG);
		assertStrength("abc1!Add", PasswordStrength.STRONG);
	}
	
	@Test
	void meetsOtherCriteria_except_for_Legnth_Then_Normal() {
		assertStrength("ab12!@A", PasswordStrength.NORMAL);
	}
	
	@Test
	void meetsOtherCriteria_except_for_number_Then_Normal() {
		assertStrength("ab!@Aqwer", PasswordStrength.NORMAL);
	}

	@Test
	void meetsOtherCriteria_except_for_Uppercase_Then_Normal() {
		assertStrength("ab12!@df", PasswordStrength.NORMAL);
	}
	
	@Test
	void meetsOnlyLengthCriteria_Then_Weak() {
		assertStrength("abdefghi", PasswordStrength.WEAK);
	}

	@Test
	void meetsOnlyNumberCriteria_Then_Weak() {
		assertStrength("12345", PasswordStrength.WEAK);
	}

	@Test
	void meetsOnlyUppercaseCriteria_Then_Weak() {
		assertStrength("ABCDE", PasswordStrength.WEAK);
	}

	@Test
	void meetsNoCriteria_Then_Weak() {
		assertStrength("abc", PasswordStrength.WEAK);
	}

	@Test
	void nullInput_Then_Invalid() {
		assertStrength(null, PasswordStrength.INVALID);
	}
	
	@Test
	void emptyInput_Then_Invalid() {
		assertStrength("", PasswordStrength.INVALID);
	}
}
