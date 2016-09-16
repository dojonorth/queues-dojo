package com.rentalcars.dojos.tdd.queues;

public interface IOrderedJobs {

    void register(char dependentJob, char independentJob);
    void register(char job);
    String sort();
}
