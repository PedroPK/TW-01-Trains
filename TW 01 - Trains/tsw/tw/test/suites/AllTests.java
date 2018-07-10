package tw.test.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tw.graph.GraphTest;
import tw.io.InputProcessorTest;
import tw.regexp.RegExpProcessorTest;

@RunWith(Suite.class)
@SuiteClasses({
	InputProcessorTest.class,
	RegExpProcessorTest.class,
	GraphTest.class
})
public class AllTests {

}
