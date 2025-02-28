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
As the input file could be up to 20mb, it is optimal to load all the predefined words into a Set as the first step, and then while reading the input file, we check for the matching words.
Steps:
1. Load all the predefined words into a Set. Use BufferedReader to read the file, as this reads line-by-line of a file.
(every word is separated by a newline in the file.)
2. Read the input file, and for each line, verify if there is a matched word. Use BufferedReader to read the file as we read the file line-by-line.
(An English word does not contain a space in it, hence as we read each line in the input file, we check all words present in the line with the predefined set of Words for the match)

Additional Utility: findMatchesIncludingSubStrings
This utility finds If the word in the input file is exact match or is a sbstring for any of the predetermined words.

Tests:
Currently, I have not included unit tests in the initial revision, but tests would be advised and I can add the tests if we would want them in scope.

Sample Output for exact match of words:
Predefined word     Match Count
word111              1
word1                1
word2                2

Sample output for: If the word in file is exact match or is a sbstring for any of the predetermined words:
Predefined word     Match Count
word111              1
word1                4
word2                4
