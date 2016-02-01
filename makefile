CC=javac
FLAGS=-g
TARGETS=MinMax.class

all: $(TARGETS)

%.class: %.java
	$(CC) $(FLAGS) $<

run:
	java MinMax

clean:
	rm *.class
