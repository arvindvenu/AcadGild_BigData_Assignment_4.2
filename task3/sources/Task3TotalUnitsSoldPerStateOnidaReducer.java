package mapreduce.task3;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author arvind
 * This class provides the reducer implementation for Assignment 4.1 task 2
 */
public class Task3TotalUnitsSoldPerStateOnidaReducer 
extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	/**
	 * The mapper outputs stateName as key and value as 1
	 * Now the reducer will take a particular stateName 
	 * and the list of values associated with it. It will sum up these values and
	 * output stateName as key and the total as the value thereby giving the total 
	 * units sold in each state for Onida
	 */
	@Override
	protected void reduce(Text stateName, Iterable<IntWritable> listOfUnitsSold,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) 
					throws IOException, InterruptedException {
		int totalOnidaUnitsSoldInAState = 0;
		for(IntWritable unitsSold : listOfUnitsSold) {
			totalOnidaUnitsSoldInAState += unitsSold.get();
		}
		context.write(stateName, new IntWritable(totalOnidaUnitsSoldInAState));
	}
	
}
