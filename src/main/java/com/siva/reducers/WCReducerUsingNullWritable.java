package com.siva.reducers;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Sivakumar on 24/4/15.
 */
public class WCReducerUsingNullWritable extends Reducer<NullWritable,LongWritable,NullWritable,LongWritable> {
    public void reduce(NullWritable key,Iterable<LongWritable> values,Context context) throws IOException, InterruptedException {
        // initialize the variable sum
        long sum=0;

        // Iterate the list of values for the key and sum it
        for(LongWritable value:values){
            sum = sum + value.get();
        }

        // In the end you got the word(as key) and corresponding count(as sum). Write to context object.
        context.write(NullWritable.get(),new LongWritable(sum));
    }
}
