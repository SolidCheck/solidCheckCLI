package io.solidcheck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "generateSamples", description = "Generates sample solidity or option files for the audit/linting engines",
        version = "audit 1.0", mixinStandardHelpOptions = true)
public class GenerateSampleFiles implements Callable<String> {

    @Option(names = {"-sampleType"},
            paramLabel = "sampleType",
            description = "Possible values: file/folder names in github repo under examples")
    private String sampleType;

    @Override
    public String call() {
        System.out.println("Generating samples in /Users/mihai/smartAudit/samples");
        return "";
    }



}
