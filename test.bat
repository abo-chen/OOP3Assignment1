@echo off
REM Batch file for testing

echo -------------------------------
echo Testing Invalid file name...
echo -------------------------------
java -jar sort.jar -fnonexistentfile.txt -Tv -Sm

echo -------------------------------
echo Testing Invalid Compare Type...
echo -------------------------------
java -jar sort.jar -fpolyfor1.txt -Tk -Sm

echo -------------------------------
echo Testing Invalid Sort Type...
echo -------------------------------
java -jar sort.jar -fpolyfor1.txt -Tv -Sk

echo -------------------------------
echo Testing existing file: polyfor1.txt...
echo -------------------------------

echo -----
echo Testing height (h) sorting type:
echo -----

echo Using Bubble Sort:
java -jar sort.jar -fpolyfor1.txt -Th -Sb
echo Using Insertion Sort:
java -jar sort.jar -fpolyfor1.txt -Th -Si
echo Using Selection Sort:
java -jar sort.jar -fpolyfor1.txt -Th -Ss
echo Using Merge Sort:
java -jar sort.jar -fpolyfor1.txt -Th -Sm
echo Using QuickSort:
java -jar sort.jar -fpolyfor1.txt -Th -Sq
echo Using Custom Sort:
java -jar sort.jar -fpolyfor1.txt -Th -Sz

echo -----
echo Testing Area (a) sorting type:
echo -----

echo Using Bubble Sort:
java -jar sort.jar -fpolyfor1.txt -Ta -Sb
echo Using Insertion Sort:
java -jar sort.jar -fpolyfor1.txt -Ta -Si
echo Using Selection Sort:
java -jar sort.jar -fpolyfor1.txt -Ta -Ss
echo Using Merge Sort:
java -jar sort.jar -fpolyfor1.txt -Ta -Sm
echo Using QuickSort:
java -jar sort.jar -fpolyfor1.txt -Ta -Sq
echo Using Custom Sort:
java -jar sort.jar -fpolyfor1.txt -Ta -Sz

echo -----
echo Testing volume (v) sorting type:
echo -----

echo Using Bubble Sort:
java -jar sort.jar -fpolyfor1.txt -Tv -Sb
echo Using Insertion Sort:
java -jar sort.jar -fpolyfor1.txt -Tv -Si
echo Using Selection Sort:
java -jar sort.jar -fpolyfor1.txt -Tv -Ss
echo Using Merge Sort:
java -jar sort.jar -fpolyfor1.txt -Tv -Sm
echo Using QuickSort:
java -jar sort.jar -fpolyfor1.txt -Tv -Sq
echo Using Custom Sort:
java -jar sort.jar -fpolyfor1.txt -Tv -Sz

REM Further tests for polyfor5.txt can be added in a similar fashion if needed.

echo Tests complete!
