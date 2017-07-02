package testProject;

import java.util.Random;

public class ArraySort {
	/**
	 * 四种排序算法
	 * @param args
	 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int arr[] = new int[15];
			initialize(arr);
//			bubbleSort(arr);
//			insertSort(arr);
//			chooseSort(arr);
			quickSort(arr,0,arr.length-1);
			print(arr);
		}
		
		//随机生成不重复的数组
		public static void initialize(int arr[]){
			int len = arr.length;
			if(len == 0){
				System.out.println("数组没有初始化的长度，不能进行操作");
			}
			Random rand = new Random();
			boolean flag;
			for(int i = 0;i < len;){
				flag = true;
				int x = rand.nextInt(100);
				for(int j = 0;j < i;j++){
					if(arr[j] == x){
						flag = false;
						break;
					}
				}
				if(flag){
					arr[i] = x;
					i++;
				}
			}
		}
		
		public static void print(int[] arr){
			for(int i = 0,len=arr.length;i < len;i++){
				System.out.print(arr[i]+" ");
			}
		}
		
		//冒泡排序
		public static void bubbleSort(int[] arr){
			for(int i = 0,len = arr.length;i < len -1;i++){
				int tmp;
				for(int j = 0;j < len - i -1;j++){
					if(arr[j] > arr[j+1]){
						tmp = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = tmp;
					}
				}
			}
		}
		
		//插入排序
		public static void insertSort(int[] arr){
			for(int i = 1,len=arr.length;i < len;i++){
				int tmp = arr[i];
				int j;
				for(j = i;j>0 && arr[j-1]>tmp;j--){
					arr[j] = arr[j-1];
				}
				if(j != i){
					arr[j] = tmp;
				}
			}
		}
		
		//选择排序
		public static void chooseSort(int[] arr){
			for(int i = 0,len = arr.length;i<len-1;i++){
				int min = i;
				for(int j = i+1;j < len;j++){
					if(arr[min] > arr[j]){
						min = j;
					}
				}
				if(min != i){
					int tmp = arr[i];
					arr[i] = arr[min];
					arr[min] = tmp;
				}
			}
		}
		
		//快速排序
		public static void quickSort(int[] arr,int begin,int end){
			int midindex = (begin+end)/2;
			int priovt = arr[midindex];
			for(int i = begin,j = end;i < j;){
				while(i < midindex && arr[i] < priovt){
					i++;
				}
				if(i < midindex){
					arr[midindex] = arr[i];
					midindex = i;
				}
				
				while(j > midindex && arr[j] >= priovt){
					j--;
				}
				if(j > midindex){
					arr[midindex] = arr[j];
					midindex = j;
				}
			}
			arr[midindex] = priovt;
			if(midindex - begin >= 2){
				quickSort(arr,begin,midindex-1);
			}
			if(end - midindex >= 2){
				quickSort(arr,midindex+1,end);
			}
		}
}
