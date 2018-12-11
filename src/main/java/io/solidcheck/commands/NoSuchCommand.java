package io.solidcheck.commands;

import java.util.concurrent.Callable;

public class NoSuchCommand implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("No such command. Type help for hints.");
        return "";
    }
}
