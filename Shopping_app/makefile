CLASSPATH = "LIB/okhttp-5.0.0-alpha.14.jar;LIB/selenium-os-4.29.0.jar;LIB/selenium-json-4.29.0.jar;LIB/selenium-manager-4.29.0.jar;LIB/selenium-chromium-driver-4.29.0.jar;LIB/selenium-java-4.29.0.jar;LIB/selenium-api-4.29.0.jar;LIB/selenium-chrome-driver-4.29.0.jar;LIB/selenium-remote-driver-4.29.0.jar;LIB/jsoup-1.19.1.jar;LIB/httpclient5-5.4.2.jar;LIB/httpcore5-5.3.3.jar;LIB/commons-codec-1.18.0.jar;LIB/commons-logging-1.3.5.jar;LIB/slf4j-api-2.0.9.jar;LIB/slf4j-simple-2.0.9.jar;."

# Define the target class (replace 'Data' with your actual class name)
CLASS = Data

# Default target
all:
	compile run

# Compile the Java code
compile:
	javac -cp $(CLASSPATH) $(CLASS).java

# Run the compiled code
run:
	java -cp $(CLASSPATH) $(CLASS)

# Clean the compiled class files
clean:
	del *.class  # Use 'del' for Windows
