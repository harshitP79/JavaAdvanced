package Main.com.tyss;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LoanServiceTest {
	LoanService L = new LoanService();
	
	@Test
	public void testEligibikity() {
		assertTrue(L.isEligible(30,30000));
	}
	
	@Test
	public void testInvalidAge() {
		assertTrue(L.isEligible(25, 25000));
	}
	
	@Test
	public void testInvalidSalary() {
		assertFalse(L.isEligible(28, 2000));
	}
	
	@Test
    void testBoundaryAge() {
        assertAll(
                () -> assertTrue(L.isEligible(21, 25000)),
                () -> assertTrue(L.isEligible(60, 40000))
        );
    }
	
	@Test
	public void testvalidLoanAmount() {
		assertThrows(IllegalArgumentException.class,()->{
			L.calculateEMI(0, 5);
		});
	}
	
	@Test
	public void testValidTenure() {
		assertThrows(IllegalArgumentException.class,()->{
			L.calculateEMI(0, 0);
		});
	}
	@Test
	public void testValidEMICalc() {
		assertEquals(500,L.calculateEMI(60000.0, 10));
	}
	
	@Test
	public void testPremiumCategory() {
		assertEquals("Premium",L.getLoanCategory(751));
	}
	@Test
	public void testStandardCategory() {
		assertEquals("Standard",L.getLoanCategory(611));
	}
	@Test
	public void testHighRiskCategory() {
		assertEquals("High Risk",L.getLoanCategory(200));
	}
}
	