package io.solidcheck.commands;

import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "generateTests", description = "Based on found or selected vulnerabilities in the smart contracts, generates unit tests that highlight the problem.",
        version = "generateTests 1.0", mixinStandardHelpOptions = true)
public class GenerateTestsCommand implements Callable<String> {

        @Override
        public String call() {
            System.out.println("See you soon! \uD83E\uDD23");
            return "";
        }

}


