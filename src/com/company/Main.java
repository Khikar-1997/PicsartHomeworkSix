package com.company;

public class Main {

    public static void main(String[] args) {
        int[] array = {1,3,5,3,7,2,8,3};
        System.out.println("___________________Array before sorting__________________");
        printArray(array);
        System.out.println("_________________________________________________________");

        mergeSort(array, array.length);
        System.out.println("___________________Array after sorting___________________");
        printArray(array);
        System.out.println("_________________________________________________________");
    }

    public static void mergeSort(int[] array, int arrayLength){
        if (arrayLength < 2) return;
        int mid = arrayLength / 2;
        int[] midArray1 = new int[mid];
        int[] midArray2 = new int[arrayLength - mid];

        for (int i = 0; i < mid; i++) {
            midArray1[i] = array[i];
        }

        for (int i = mid; i < arrayLength; i++) {
            midArray2[i - mid] = array[i];
        }

        mergeSort(midArray1,mid);
        mergeSort(midArray2,arrayLength - mid);
        sortArrayByAscOrdering(array,midArray1,midArray2,mid,arrayLength - mid);
    }

    public static void sortArrayByAscOrdering(int[] array, int[] midArray1, int[] midArray2, int midArray1Length, int midArray2Length){
        int i = 0, j = 0, k = 0;
        while (i < midArray1Length && j < midArray2Length){
            if (midArray1[i] > midArray2[j]){
                array[k++] = midArray2[j++];
            } else {
                array[k++] = midArray1[i++];
            }
        }

        while (i < midArray1Length) {
            array[k++] = midArray1[i++];
        }
        while (j < midArray2Length) {
            array[k++] = midArray2[j++];
        }
    }

    public static void printArray(int[] array){
        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
