import java.util.Random;

public class Recursion {
    public static void fill(final int array[]) {
        final Random gen = new Random();
        for (int i = 0; i < array.length; i++)
            array[i] = gen.nextInt();
    }

    public static void display(final int arr[]) {
        System.out.println("The elements of the array are : ");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
        System.out.println();
    }

    public static void merge(final int data[], int low, final int mid, final int high) {
        int first = mid;
        int second = mid + 1;
        final int l = low;
        while ((l <= first) && (second <= high)) {
            if (data[low] < data[second])
                low++;
            else {
                final int temp = data[second];
                for (int j = second - 1; j >= low; j--)
                    data[j + 1] = data[j];
                data[low] = temp;
                low++;
                first++;
                second++;
            }
        }
    }

    public static void mergeSort(final int data[], final int low, final int high) {
        if (low >= high)
            return;
        final int mid = (low + high) / 2;
        mergeSort(data, low, mid);
        mergeSort(data, mid + 1, high);
        merge(data, low, mid, high);
    }

    public static void main(final String[] args) {
        final int[] data = new int[100];
        fill(data);
        display(data);
        mergeSort(data,0,99);
        display(data);
    }
}