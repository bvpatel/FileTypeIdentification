File type Identification
=============
Version number: 1.0 R1

The File type Identification application allow a user to get information about file type from data sources which are find in data-sources.properties under src/main/resources 

Tools and Technologies used
---------------------------
 * Java
 * Maven 
 * JUnit
 
Prerequisite
-------------
1. Java (1.8)
2. Maven (3.3.9)

Getting started
---------------
1. Goto Project folder
2. Install maven dependencies
   ```sh
   mvn install
   ```
2. To run application. Please pass input file path and output file path in args.
   ```sh
   mvn package
   mvn exec:java -Dexec.args="-i input.txt -o output.txt"
   ```