CC=javac
FLAGS=-g
TARGETS=MinMax.class

all: $(TARGETS)

%.class: %.java
	$(CC) $(FLAGS) $<

run:
	java -ea MinMax

debug:$(TARGETS)
	jdb MinMax
	#gcj-5 -g --main=MinMax -o MinMax MinMax.class MinMax$$Pair.class && gdb MinMax

clean:
	rm *.class
