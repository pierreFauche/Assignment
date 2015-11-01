***********
Exo1
***********

vim WordCount.java + code

export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar

bin/hadoop com.sun.tools.javac.Main WordCount.java
jar cf wc.jar WordCount*.class

rm Word*

hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output2

[fauche@hadoop ~]$ hdfs dfs -cat /user/fauche/todl/output2/part-r-00000

Bordeaux        15146906
Grenoble        15100664
Lille           15870332
Lyon            14500047
Marseille       15708634
Nantes          15984687
Nice            13719135
Paris           15733403
Reims           15486616
Strasbourg      14987973
city            0

***********
Exo2
***********

vim WordCount.java + code

export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar

bin/hadoop com.sun.tools.javac.Main WordCount.java
jar cf wc.jar WordCount*.class

rm Word*

hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output3

[fauche@hadoop ~]$ hdfs dfs -cat /user/fauche/todl/output3/part-r-00000

0               0
0-5 Years       4
13-17 Years     29
18-25 Years     29
26-35 Years     29
36-45 Years     12
46-59 Years     12
6-12 Years      12
60+ Years       4


