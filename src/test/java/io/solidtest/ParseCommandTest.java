package io.solidtest;

import io.solidcheck.AuditMaster;
import io.solidcheck.Command;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;

public class ParseCommandTest {

    @Test
    public void testParseSimple() {
        String commandMain = "list";
        test("list", new Command("list", new String[0]));

        String[] expectedString = {"-hV"};
        test("list -hV", new Command("list", expectedString));

        String[] expectedString2 = {"-hV","audit","all"};
        test("list -hV audit all", new Command("list", expectedString2));
    }

    private void test(String commandString, Command expectedCommandResult) {
        Command command = AuditMaster.parseCommand(commandString);
        assertTrue( command.commandMain.equals(expectedCommandResult.commandMain) );
        assertTrue(Arrays.equals(command.commandArgs, expectedCommandResult.commandArgs) );
    }

}
