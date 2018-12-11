package io.solidtest.commands;

import io.solidcheck.AuditMaster;
import org.junit.Test;

public class AuditCommandTest {

    @Test
    public void integrationTest() {
        AuditMaster.callCommand( AuditMaster.parseCommand("audit -engine=auditAll") );
        //AuditMaster.callCommand( AuditMaster.parseCommand("audit -h") );
        //AuditMaster.callCommand( AuditMaster.parseCommand("install -V") );
    }

}
