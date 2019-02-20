# Matrix_Multiplication
Multithreading

There is a file that contains the names of the other 5 files. In each of these 5 files, 2 matrices by size 3x3 are recorded. 
You need to multiply these matrices with each other and write the result to a new file, and save all the files to a zip archive (everything should happen inmemory). 
For each file - a separate stream. 
Threads should work parallel to each other.

- find files by name
- read the contents of each file and perform the multiplication
- the result of matrix multiplication is written in Map. As the key - the file name, the value - future
- create zip archive (in-memory)
- closing threads