package io.solidcheck.commands;

import picocli.CommandLine.Command;

import java.util.Scanner;
import java.util.concurrent.Callable;

@Command(name = "interactive", description = "Prompts and explains each parameter along the way",
        version = "interactive 1.0", mixinStandardHelpOptions = true)
public class InteractiveModeCommand implements Callable<String> {

    @Override
    public String call() {
        System.out.println("Auditing in interactive mode :D ");
        promptForStuff("Engine to use(auditAll, mythril, oyente, etc):");
        promptForStuff("Absolute path to options file(you can generate sample options, see generateSamples command)");
        promptForStuff("Absolute path to output folder(this is where we store the reports):");
        promptForStuff("Path to solidity file or solidity folder(multiple contract scan):");
        return "";
    }

    private String promptForStuff(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private boolean validate(String command, int lifecyclePhase, String answer) {
        return true;
    }

}
