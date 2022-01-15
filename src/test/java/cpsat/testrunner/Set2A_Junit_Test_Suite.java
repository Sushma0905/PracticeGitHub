package cpsat.testrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import cpsat.mock.scenario.Set2A_Question3_HomeTown;
import cpsat.mock.scenario.Set2A_Question5_PremierLeague;
import cpsat.mock.scenario.Set2A_Question6_OnlineRegistration;

@RunWith(Suite.class)
@Suite.SuiteClasses({cpsat.mock.scenario.Set2A_Question3_HomeTown.class,cpsat.mock.scenario.Set2A_Question5_PremierLeague.class,
	cpsat.mock.scenario.Set2A_Question6_OnlineRegistration.class,cpsat.mock.scenario.Set2A_Question1_meripustak.class,
	cpsat.mock.scenario.Set2A_Question4_WoodLands.class,cpsat.mock.scenario.Set2B_Question2_OnlineRegistration.class})


public class Set2A_Junit_Test_Suite {

}
