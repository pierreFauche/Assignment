package com.aamend.hadoop.hadoop;


import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Exo2 {

public static class TokenizerMapper
            extends Mapper<Object, Text, Text, IntWritable>{

        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();
        private int i=0;
        private int j=0;
        public void map(Object key, Text value, Context context
        ) throws IOException, InterruptedException {

            String[] result = value.toString().split(";");

            try{

                j=Integer.parseInt(result[2]);

                if (j>=0 && j<=5){
                    word.set("0-5 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=6 && j<=12){
                    word.set("6-12 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=13 && j<=17){
                    word.set("13-17 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=18 && j<=25){
                    word.set("18-25 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=26 && j<=35){
                    word.set("26-35 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=36 && j<=45){
                    word.set("36-45 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>=46 && j<=60){
                    word.set("46-59 Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

                if (j>60){
                    word.set("60+ Years");
                    i = Integer.parseInt(result[4]);
                    one.set(i);
                }

            }
            catch(Exception e){
                i=0;
                word.set("0");
                one.set(i);
            }

            context.write(word, one);
        }
    }

public static class IntSumReducer
        extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
                       Context context
    ) throws IOException, InterruptedException {
        int sum = 0;
        int average = 0;
        int nb=0;

        for (IntWritable val : values) {
            sum += val.get();
            nb++;
        }
        average = sum / nb;
        result.set(average);
        context.write(key, result);
    }
}


  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(WordCount.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}