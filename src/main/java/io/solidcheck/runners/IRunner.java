package io.solidcheck.runners;

public interface IRunner {

    IRunResult run(String engine, IRunOptions options);

}
