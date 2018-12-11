package io.solidcheck.commands;

import picocli.CommandLine.Command;

@Command(description = "Prints the current installable audit engines",
        name = "list", mixinStandardHelpOptions = true, version = "list 1.0")
public class ListCommand implements java.util.concurrent.Callable<Void> {

    @Override
    public Void call() {
        System.out.println("");
        System.out.println("--- Audit tools ----");
        System.out.println("Mythril");
        System.out.println("Slither");
        System.out.println("Oyente");
        System.out.println("Securify");
        System.out.println("Smartcheck");
        System.out.println("");
        System.out.println("--- Linting ----");
        System.out.println("Surya");
        System.out.println("");
        System.out.println("--- Other ----");
        System.out.println("Surya");
        System.out.println("Solgraph");
        System.out.println("");
        return null;
    }

}
