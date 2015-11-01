# HDFS MapReduce Assignment
### Exo1


Pour editer fichier .java 
(nommé ici WordCount-->qu'on aurait pu appeler autrement comme Exo1.java )
```sh
vim WordCount.java
```
on rajoute notre code ensuite qui se situe ...



pour connaitre l'emplacement de son JDK
```sh
echo $JAVA_HOME
```

pour definir les variables d'environement
```sh
export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
```
pour compiler le .java
```sh
bin/hadoop com.sun.tools.javac.Main WordCount.java
```
créer le jar
```sh
jar cf wc.jar WordCount*.class
```
pour ne laisser que le .jar dans le dossier courant pour permettre de run
```sh
rm Word*
```
pour run l'application nb on a créé prealablement un dossier output avec mkdir
```sh
hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output2
```

voici le resultat obtenu qu'on affiche a l'aide de la commande cat
```sh
[fauche@hadoop ~]$ hdfs dfs -cat /user/fauche/todl/output2/part-r-00000
```

Bordeaux         15146906  
Grenoble         15100664  
Lille            15870332  
Lyon             14500047  
Marseille        15708634  
Nantes           15984687  
Nice             13719135  
Paris            15733403  
Reims            15486616  
Strasbourg       14987973  
city             0

***********
Exo2
***********
```sh
vim WordCount.java + code
```


```sh
export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
```

bin/hadoop com.sun.tools.javac.Main WordCount.java
```sh
jar cf wc.jar WordCount*.class
```

```sh
rm Word*
```

```sh
hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output3
```

```sh
[fauche@hadoop ~]$ hdfs dfs -cat /user/fauche/todl/output3/part-r-00000
```

0               0  
0-5 Years       4  
13-17 Years     29  
18-25 Years     29  
26-35 Years     29  
36-45 Years     12  
46-59 Years     12  
6-12 Years      12  
60+ Years       4  


