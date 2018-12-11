package io.solidtest.dockerStuff;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class DockerTest {

    @Test
    public void simpleTest() throws IOException, InterruptedException {
        //DefaultDockerClientConfig clientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        //DockerClient dockerClient = DockerClientBuilder.getInstance(clientConfig).build();
        //System.out.println(dockerClient.infoCmd().exec().toString());
        Runtime rt = Runtime.getRuntime();
        //String command = "docker run -v /Users/mihai/Desktop/tmp/examples:/tmp mythril/myth -x /tmp/contract.sol";
        String command = "docker run -v /Users/mihai/Desktop/tmp/examples:/tmp trailofbits/slither /tmp/contract.sol";
        //String command = "docker run -v /Users/mihai/Desktop/tmp/examples:/oyente/oyente/tmp luongnguyen/oyente python /oyente/oyente/oyente.py -s /oyente/oyente/tmp/contract.sol";

        CrunchifyRunCommand commandRunner = new CrunchifyRunCommand();
        commandRunner.run(command);

        //runFromTerminal();
    }

    private void runFromTerminal(String commandToRun) throws IOException, InterruptedException {
        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");
        String homeDirectory = System.getProperty("user.home");
        Process process;
        if (isWindows) {
            process = Runtime.getRuntime()
                    .exec(String.format("cmd.exe "+commandToRun, homeDirectory));
        } else {
            process = Runtime.getRuntime()
                    .exec(String.format(commandToRun, homeDirectory));
        }
        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        int exitCode = process.waitFor();
        assert exitCode == 0;
    }

    private void getImageFromDockerHub() {

    }

    private void executeCommandAgainstImage() {

    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

    public class CrunchifyRunCommand {

        public void run(String command) {
            String s = null;

            try {

                Process p = Runtime.getRuntime().exec(command);

                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

                // read the output from the command
                System.out.println("Here is the standard output of the command:\n");
                while ((s = stdInput.readLine()) != null) {
                    System.out.println(s);
                }

                // read any errors from the attempted command
                System.out.println("Here is the standard error of the command (if any):\n");
                while ((s = stdError.readLine()) != null) {
                    System.out.println(s);
                }

                System.exit(0);
            } catch (IOException e) {
                System.out.println("exception happened - here's what I know: ");
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

}
