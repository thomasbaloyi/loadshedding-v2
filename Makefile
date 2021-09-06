JAVAC=/usr/bin/javac

.SUFFIXES: .java .class


SRCDIR=src/
BINDIR=bin/

all:
	javac -d bin $(SRCDIR)*.java

clean:
	rm $(BINDIR)*.class

docs:
	javadoc -d doc src/*.java