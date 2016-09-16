package com.rentalcars.dojos.tdd.queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderedJobsTest {

    private OrderedJobs orderedJobs;

    @Before
    public void setup() {
        orderedJobs = new OrderedJobs();
    }

    @Test
    public void sortedEmptyOrderedListReturnsEmpty() {
        assertEquals("", orderedJobs.sort());
    }
}
