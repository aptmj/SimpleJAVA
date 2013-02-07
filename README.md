SimpleJAVA
==========

Code test example
rowCount.java is a solution to the following specificaion:


Business Case:
A customer needs the ability to read a text file (this could be a file in a .txt format or a .csv file) When the file is read, the customer wants to have the row count displayed in the console.
Requirements:
•  The customer should be able to provide the filename as a parameter of executing the code (e.g. Countlines.exe myfile.txt or java countlines.jar myfile.txt)
•	The program should auto-detect which file type has been specified (hint: a CSV file may have carriage returns or line feeds in the middle of the record, so we much account for that and make sure we don’t do an additional row count for those
•	The program should open the file, read it, then close it, and finally output the number of lines
•	The program should reject any files that don’t end in either .txt or .csv
•	The code must be documented
•	The code must handle errors and provide a user friendly error message
