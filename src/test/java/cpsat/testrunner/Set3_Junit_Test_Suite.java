package cpsat.testrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({cpsat.mock.scenario.Set3_Question1_jQuery.class,cpsat.mock.scenario.Set3_Question2_makery.class,
	cpsat.mock.scenario.Set3_Question3_cii.class,cpsat.mock.scenario.Set3_Question4_mptourism.class,
	cpsat.mock.scenario.Set4_Question1_cii_Pagefactory.class})

public class Set3_Junit_Test_Suite {

}
