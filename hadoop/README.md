# HDFS MapReduce Assignment  
### Exo1

Editons le source code avec l'utilitaire vim. Nous avons nommé ici notre .java: WordCount.java, mais nous aurions pu l'appeler autrement, Exo1.java par exemple. 
Vous pouvez trouver notre source code ici:
Assignment/hadoop/src/main/java/com/aamend/hadoop/hadoop/Exo1.java  
```sh
vim WordCount.java
```
Il nous faut à présent définir les variables d'environnement. Pour cela nous affichons d'abord le chemin de notre jdk.
```sh
echo $JAVA_HOME
```
Puis nous definissons les variables comme suit:
```sh
export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
```
Compilons maintenant notre code source:
```sh
bin/hadoop com.sun.tools.javac.Main WordCount.java
```
Puis créons le .jar
```sh
jar cf wc.jar WordCount*.class
```
Afin de ne pas avoir de problèmes lors du lancement de l'application nous devons supprimer tous les autres fichier que le .jar dans le dossier courant:
```sh
rm Word*
```
Nous pouvons donc maintenant "runer" l'application. On note ici le fichier d'entré file.csv qui se trouve sur le serveur hdfs, ainsi que le dossier de sortie que nous avons créé préalablement a l'aide de mkdir, qui se trouve sur notre espace dédié sur le serveur.
```sh
hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output2
```

Voici le résultat obtenu qu'on affiche à l'aide de la commande cat
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


Question:

Le combiner est une fonction qui permet de réduire la quantité d'information qui sera traité par le reducer.
Dans certains cas, la fonction accomplie par le combiner peut être la même que le reducer, en fonction de la nature de l'algorithme.
Nous supposons ici que le combiner fait de même que la reducer. Donc il est possible d'utiliser la classe reducer comme un combiner, mais totalement inutile.




***
### Exo2  
Editons le source code avec l'utilitaire vim. Nous avons nommé ici notre .java: WordCount.java, mais nous aurions pu l'appeler autrement, Exo1.java par exemple. 
Vous pouvez trouver notre source code ici:
Assignment/hadoop/src/main/java/com/aamend/hadoop/hadoop/Exo2.java 
```sh
vim WordCount.java
```
Il nous faut à présent définir les variables d'environnement. Pour cela nous affichons d'abord le chemin de notre jdk.
```sh
echo $JAVA_HOME
```
Puis nous definissons les variables comme suit:
```sh
export JAVA_HOME=/usr/jdk64/jdk1.8.0_40/
export PATH=${JAVA_HOME}/bin:${PATH}
export HADOOP_CLASSPATH=${JAVA_HOME}/lib/tools.jar
```
Compilons maintenant notre code source:
```sh
bin/hadoop com.sun.tools.javac.Main WordCount.java
```
Puis créons le .jar
```sh
jar cf wc.jar WordCount*.class
```
Afin de ne pas avoir de problèmes lors du lancement de l'application nous devons supprimer tous les autres fichier que le .jar dans le dossier courant:
```sh
rm Word*
```
Nous pouvons donc maintenant "runer" l'application. On note ici le fichier d'entré file.csv qui se trouve sur le serveur hdfs, ainsi que le dossier de sortie que nous avons créé préalablement a l'aide de mkdir, qui se trouve sur notre espace dédié sur le serveur.
```sh
hadoop jar wc.jar WordCount /res/mapred_assignment/file.csv /user/fauche/todl/output3
```
voici le résultat obtenu qu'on affiche à l'aide de la commande cat
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


d
