package com.rentalcars.dojos.tdd.queues;

import java.util.*;

/**
 * Created by murphyj on 09/09/2016.
 */
public class OrderedJobs implements IOrderedJobs {

    private Map<Character, Character> dependencyMap = new HashMap<Character, Character>();

    public void register(char dependentJob, char independentJob) {
        dependencyMap.put(independentJob, dependentJob);
    }

    public void register(char job) {
        dependencyMap.put(job, null);
    }

    public String sort() {
        StringBuffer jobs = new StringBuffer();

        Iterator<Character> iterator = dependencyMap.keySet().iterator();
        while(iterator.hasNext()) {
            Character independent = iterator.next();
            jobs.append(independent);
            Character dependent = dependencyMap.get(independent);
            if (dependent != null) {
                jobs.append(dependent);
            }
        }

        return jobs.toString();
    }
}
