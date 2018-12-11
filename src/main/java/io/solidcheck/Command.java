package io.solidcheck;

public class Command {

    public String commandMain;
    public String[] commandArgs = new String[0];

    public Command() {

    }

    public Command(String commandMain, String[] commandArgs) {
        this.commandMain = commandMain;
        this.commandArgs = commandArgs;
    }

}
