package com.rentalcars.dojos.tdd.queues;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderedJobsTest {

    private OrderedJobs orderedJobs;

    @Before
    public void setup() {
        orderedJobs = new OrderedJobs();
    }

    @Test
    public void noSortedJobsReturnsEmptyString() {
        assertEquals("", orderedJobs.sort());
    }

    @Test
    public void singleJobReturnsJobWhenSorted() {
        orderedJobs.register('a');
        assertEquals("a", orderedJobs.sort());
    }

    @Test
    public void twoIndependentJobsWhenSortedReturnInTheOrderTheyWereRegistered() {
        orderedJobs.register('a');
        orderedJobs.register('b');
        assertEquals("ab", orderedJobs.sort());
    }

    @Test
    public void jobSortedBeforeDependentJob() {
        orderedJobs.register('a', 'b');
        assertEquals("ba", orderedJobs.sort());
    }

    @Test
    public void twoJobsWithTwoDependencies() {
        orderedJobs.register('b', 'a');
        orderedJobs.register('c', 'd');
        assertEquals("abdc", orderedJobs.sort());
    }

    @Test
    public void dependencyChain() {
        orderedJobs.register('a', 'b'); // b -> a
        orderedJobs.register('b', 'c'); // c -> b
        assertEquals("cba", orderedJobs.sort()); // c -> b - > a
    }

    // independents c
    // dependents b a
}
