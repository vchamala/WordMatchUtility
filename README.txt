Word Match Utility:

Description:
Write a program that reads a file and finds matches against a predefined set of words. There can be up to 10K entries in the list of predefined words.
Requirement details:
1. Input file is a plain text (ascii) file, every record separated by a new line.
2. For this exercise, assume English words only
3. The file size can be up to 20 MB
4. The predefined words are defined in a text file, every word separated by a newline. Use a sample file of your choice for the set of predefined keywords for the exercise.

Code:
src/main/java/org/example/WordMatchUtility.java

Command Line Run:
java {ProjectLocationPath}/src/main/java/org/example/WordMatchUtility.java

Algorithm:
As the input file could be up to 20mb, it is optimal to load all the predefined words into a Set as the first step, and
then while reading the input file, we check for the matching words.
Steps:
1. Load all the predefined words into a Set. Use BufferedReader to read the file, as this reads line-by-line of a file.
(every word separated by a newline in the file.)
2. Read the input file, and for each line, verify if there is a matched word. Use BufferedReader to read the file as we
read the file line-by-line.

Tests:
Currently, I have not included unit tests in the initial revision, but tests would be advised and can add the tests if we would
want them in scope.
