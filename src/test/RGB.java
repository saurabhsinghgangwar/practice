package test;

public class RGB {

    static void sortArray(char arr[]){
        int low=0;
        int high=arr.length-1;

        for(int i=0; i<=high; i++){
            if(low < high){
                if(arr[i] == 'r'){
                    char tmp = arr[i];
                    arr[i] = arr[low];
                    arr[low] = tmp;
                    low++;
                }
                else if(arr[i] == 'b'){
                    char tmp = arr[i];
                    arr[i] = arr[high];
                    arr[high] = tmp;
                    high--;
                    i--;
                }
            }
        }
    }

    public static void main(String args[]){
        char arr[] = {'g','b','r','r','b','g','b','r','g','g','b'};

        sortArray(arr);
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] +" ");
    }
}