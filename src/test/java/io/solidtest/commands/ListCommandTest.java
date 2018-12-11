package io.solidtest.commands;

import io.solidcheck.AuditMaster;
import org.junit.Test;

public class ListCommandTest {

    @Test
    public void integrationTest() {
        //AuditMaster.callCommand( AuditMaster.parseCommand("list") );
        AuditMaster.callCommand( AuditMaster.parseCommand("list --help") );
        //AuditMaster.callCommand( AuditMaster.parseCommand("list -V") );
    }

}
