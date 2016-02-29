/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aasorts;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Cesar
 */
public class AASorts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 1;
        //10 100 1000 10000 100000 1000000
        //Buble Sort
        for (int d = 0; d < 60; d += 10) {
            System.out.println("");

            n = n * 10;
            for (int z = 0; z < 10; z++) {

                int arr[] = new int[n];
                for (int k = 0; k < arr.length; k++) {
                    arr[k] = (int) (Math.random() * (n * 10 - 0) + 0);
                }
                long startTime = System.nanoTime();
                //start
                //quitar el comment del que quiera probar
                //quickSort(arr,0,arr.length-1); 
                //heapSort(arr);
                radixSort(arr);
                
                //selectionSort(arr);
                //insertionSort(arr);
                //mergeSort(arr);
                //bubbleSort(arr);

                //finish
                long endTime = System.nanoTime();
                long duration = (endTime - startTime);
                System.out.println(duration + " ns");
            }

        }

    }

      public static int[] radixSort(int[] old) {
    // Loop for every bit in the integers
    for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
        // The array to put the partially sorted array into
        int[] tmp = new int[old.length];
        // The number of 0s
        int j = 0;
 
        // Move the 0s to the new array, and the 1s to the old one
        for (int i = 0; i < old.length; i++) {
            // If there is a 1 in the bit we are testing, the number will be negative
            boolean move = old[i] << shift >= 0;
 
            // If this is the last bit, negative numbers are actually lower
            if (shift == 0 ? !move : move) {
                tmp[j] = old[i];
                j++;
            } else {
                // It's a 1, so stick it in the old array for now
                old[i - j] = old[i];
            }
        }
 
        // Copy over the 1s from the old array
        for (int i = j; i < tmp.length; i++) {
            tmp[i] = old[i - j];
        }
 
        // And now the tmp array gets switched for another round of sorting
        old = tmp;
    }
 
    return old;
}
        
    static int partition(int arr[], int left, int right)
{
      int i = left, j = right;
      int tmp;
      int pivot = arr[(left + right) / 2];
     
      while (i <= j) {
            while (arr[i] < pivot)
                  i++;
            while (arr[j] > pivot)
                  j--;
            if (i <= j) {
                  tmp = arr[i];
                  arr[i] = arr[j];
                  arr[j] = tmp;
                  i++;
                  j--;
            }
      };
     
      return i;
}
 
static void quickSort(int arr[], int left, int right) {
      int index = partition(arr, left, right);
      if (left < index - 1)
            quickSort(arr, left, index - 1);
      if (index < right)
            quickSort(arr, index, right);
}

//
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;

    public static void buildheap(int[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxheap(a, i);
        }
    }

    public static void maxheap(int[] a, int i) {
        left = 2 * i;
        right = 2 * i + 1;
        if (left <= n && a[left] > a[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right <= n && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(i, largest);
            maxheap(a, largest);
        }
    }

    public static void exchange(int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void heapSort(int[] a0) {
        a = a0;
        buildheap(a);

        for (int i = n; i > 0; i--) {
            exchange(0, i);
            n = n - 1;
            maxheap(a, 0);
        }
    }

    //
    
    
    static void selectionSort(int[] arr) {
        int i, j, minIndex, tmp;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    static void insertionSort(int[] arr) {
        int i, j, newValue;
        for (i = 1; i < arr.length; i++) {
            newValue = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > newValue) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = newValue;
        }
    }

    static void mergeSort(int[] A) {
        if (A.length > 1) {
            int q = A.length / 2;
            int[] leftArray = Arrays.copyOfRange(A, 0, q);
            int[] rightArray = Arrays.copyOfRange(A, q + 1, A.length);
            mergeSort(leftArray);
            mergeSort(rightArray);
            A = merge(leftArray, rightArray);
        }

    }

    static int[] merge(int[] l, int[] r) {
        int totElem = l.length + r.length;
        int[] a = new int[totElem];
        int i, li, ri;
        i = li = ri = 0;
        while (i < totElem) {
            if ((li < l.length) && (ri < r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                } else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            } else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        return a;

    }

    public static void bubbleSort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

}
