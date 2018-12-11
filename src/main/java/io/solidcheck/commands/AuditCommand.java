package io.solidcheck.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import java.util.concurrent.Callable;

@Command(name = "audit", description = "Runs audit and linting engines",
        version = "audit 1.0", mixinStandardHelpOptions = true)
public class AuditCommand implements Callable<String> {

    @Option(names = {"-engine"},
            paramLabel = "engine",
            description = "\nSolidity audit/lint engine to run. \n" +
                    "Available options: \n" +
                    "- auditAll -- runs all installed audit engines, will take a LONG while\n" +
                    "- mythril \n" +
                    "- slither \n" +
                    "- oyente \n" +
                    "- securify \n"+
                    "- smartCheck \n" +
                    "" +
                    "- lintingAll \n" +
                    "- surya \n" +
                    " OR \n"+
                    "- mythril, securify - comma separated values \n"
    )
    private String enginesToRun = "";

    @Option(names = {"-pathToSolidityFile"},
            paramLabel = "pathToSolidityFile",
            description="The absolute path to the solidity file you need audited.")
    private String pathToSolidityFile = "";

    @Option(names = {"-options"},
            paramLabel = "options",
            description = "Options to be passed to the engines. See example file.")
    private String options = "";

    @Option(names = {"-outputFolder"},
            paramLabel = "outputFolder",
            description = "Absolute path to the folder where the results are stored.")
    private String outputFolder = "";

    @Option(names = {"-sendToRemix"},
            paramLabel = "sendToRemix",
            description = "")
    private boolean sendToRemix = false;

    public AuditCommand() {

    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("\uD83D\uDCC2 Loading solidity file from "+pathToSolidityFile);
        Thread.sleep(123);
        System.out.println("Making sure requested engines are installed...");
        Thread.sleep(50);
        System.out.println("Checking the output folder at " + outputFolder + " is usable");
        System.out.println("Running "+enginesToRun+" using options at "+ options +"...");
        System.out.println("⛺ - set up a small camp here, this might take a while..." );
        Thread.sleep(3900);
        System.out.println("Writing results...");
        Thread.sleep(800);
        System.out.println("All done, well done! \uD83D\uDC4F ✅");
        return "";
    }

    private void validateEngines() {

    }

    private void validatePathToSolidity() {

    }

    private void validateOutputFolder() {

    }

}
