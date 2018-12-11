package io.solidtest.commands;

import io.solidcheck.AuditMaster;
import org.junit.Test;

public class InstallCommandTest {

    @Test
    public void integrationTest() {
        AuditMaster.callCommand( AuditMaster.parseCommand("install -engine=mythril") );
        //AuditMaster.callCommand( AuditMaster.parseCommand("install -h") );
        //AuditMaster.callCommand( AuditMaster.parseCommand("install -V") );
    }

}
