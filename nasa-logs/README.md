Teste feito utilizando a linguagem de programação Scala. Os códigos tiveram como base o desenvolvimento dos usuários @esdrascosta e @dbalduini, mas a ideia principal foi observar e entender o que cada linha de código estava fazendo

**1) Qual o objetivo do comando cache em Spark?**

	O cache serve para armazenar na memória o valor de alguma variável,
	para que ela fique disponível rapidamente caso seja usada novamente
	em alguma operação futuramente

**2) O mesmo código implementado em Spark é normalmente mais rápido que a implementação equivalente em
MapReduce. Por quê?**

	Isso acontece pois o MapReduce é baseado em plataformas mais antigas e menos eficientes, já 
	as bibliotecas de Machine Learning usadas no Spark aproveitam os recursos de processamento na memória dele,
	que deixam o tempo de processamento mais rápido, além da capacidaed do Spark de poder executar operações 
	paralelas e em várias máquinas 	ao mesmo tempo.

**3)Qual é a função do SparkContext?**

	O SparkContext contém todos os código e objetos necessários para processar dados no Cluster e ajuda
	a obter recursos solicitados pela aplicação, ou seja, para uma aplicação se tornar uma aplicação Spark,
	uma instancia da biblioteca SparkContext deve ser instanciada. 

**4) Explique com suas palavras o que é Resilient Distributed Datasets (RDD).**

	O RDD é uma forma do Spark realizar o processamento dos dados em conjunto, que podem ser operados 
	paralelamente.	Ele é composto por uma ou mais partições que são imutáveis,resilientes e que podem 
	ser distribuídas entre	os nós do	Cluster para melhorar a performance e a escalabilidade. 

**5) GroupByKey é menos eficiente que reduceByKey em grandes dataset. Por quê?**

	Quando o groupByKey é usado, ele apenas agrupa todas as chaves de mesmo valor encontradas. Já o reduceByKey, 
	pega os valores repetidos e cria uma nova chave-valor com os elementos duplicados, para ser a única utilizada.
	outro motivo do reduceByKey ser mais eficiente é por conta das partições hash que são criadas por padrão. 

**6) Explique o que o código Scala abaixo faz.
val textFile = sc.textFile("hdfs://...")
val counts = textFile.flatMap(line => line.split(" 
"))
.map(word => (word, 1))
.reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://...")**

	A variável textFile importa como um arquivo de texto o arquivo da url passada;
	A variável counts "quebra" o conteúdo do arquivo, em palavras individuais;
	O ".map" está sendo usado para criar um RDD que converte cada elemento em um par de chave-valor com um 
	valor de 1;
	O "reduceByKey" reduz o que está criado na variável counts para que cada palavra só apareça uma vez, 
	mas tenha um valor igual ao numero de vezes que ele aparece no RDD original;
	A última linha (saveAsTextFile) serve para salvar como texto o centeúdo que foi gerado pela variável counts;


