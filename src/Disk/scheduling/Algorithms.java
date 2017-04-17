package Disk.scheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.abs;
import java.io.File;

public class Algorithms
{
	private int start ;
	private  ArrayList<Integer> queue =new ArrayList<Integer>() ;
	private int arr [];
	private	Scanner cin = new Scanner(System.in);
	
	public Algorithms()
	{
		
		try
		{
			cin=new Scanner(new File ("input.txt"));
		}catch(Exception e)
		{
			System.out.println("Can't Open File");
		}
		while(cin.hasNext())
		{
			queue.add(cin.nextInt());
		}
		
		int n = queue.size() ;
		
		arr=new int [n] ;
		
		for(int i=0 ;i<n ;i++)
			arr[i]=queue.get(i);
		
		cin = new Scanner(System.in);
		System.out.print("Enter Head Start: ");
			start=cin.nextInt();
	}	
	
	public void FCFS ()
	{
		int totalMovements=0 , served , s=start;

		System.out.print("Sequnce of serving: ");
		for(int i=0 ; i<queue.size() ;i++)
		{
			served=queue.get(i);
			totalMovements+=abs(s-served);
			s=queue.get(i);
			System.out.print(served+ " ");
		}
		
		System.out.println("\ntotal number of Movments = " + totalMovements);
	}
	
	public int Nearest (int s)
	{
		int temp=Integer.MAX_VALUE ;
		int index=-1 ;
				
		for(int i=0 ;i< arr.length ;i++)
		{
			//System.out.print(arr[i]+" ");
			if(abs(arr[i]-s)< temp)
			{
				temp=abs(arr[i]-s);
				index=i;
			//	System.out.println("temp= "+ temp);
			}
			
		}
		
		arr[index]=Integer.MAX_VALUE;
		
		return queue.get(index) ;
	}
	
	public void SSTF ()
	{
		int totalMovement=0   , s=start , temp=0 ;
		
		System.out.print("Sequence of serving: ");

		for(int i =0 ;i<queue.size() ;i++)
		{
			temp=Nearest(s);
			totalMovement+=abs(s-temp);
			System.out.print(temp+" ");
			s=temp;
		}
		
		
		
		System.out.println("\nTotal Number of Movement= " + totalMovement);
		
			
	}

	public void Scan ()
	{
		int totalMovement=0 , s=start , FIndex=-1 , n=queue.size() ;
		  
		int arr[] = new int [n];
		
		for(int i=0 ;i<n ;i++)
			arr[i]=queue.get(i);
		
		Arrays.sort(arr);
		
		for(int i=0 ;i<n ;i++)
		{
			if(arr[i]>=s){
				FIndex=i;
				break;
			}
		}
		
		
		System.out.println("Sequence of serving from left to right : ");
		
		for(int i=FIndex ;i<n ;i++)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
		}
		
		
		totalMovement+=abs(199-s);
		s=arr[FIndex-1];
		totalMovement+=abs(199-s);
		
		System.out.print(s+" ");
		
		for(int i= FIndex-2 ; i>=0 ;i--)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
			
		}
		
		System.out.println("\nTotal Number of Movements= "+totalMovement);
		
		
		totalMovement=0;
		s=start;
		for(int i=0 ;i<n ;i++)
		{
			if(arr[i]<=s){
				FIndex=i;
			}
		}
		
		System.out.println("Sequence of serving from right to left : ");

		
		for( int i=FIndex ; i>=0 ;i--)
		{

			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
			
		}
		
		totalMovement+=s;
		s=arr[FIndex+1];
		totalMovement+=s;
		System.out.print(s+" ");
		for(int i = FIndex+2 ; i<n ;i++)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
		}
			
		System.out.println("\nTotal Number of Movements= "+ totalMovement);
		
		
		
	}

	public void Look()
	{
		int totalMovement=0 , s=start , FIndex=-1 , n=queue.size() ;
		
		int arr[] = new int [n];
		
		for(int i=0 ;i<n ;i++)
			arr[i]=queue.get(i);
		
		Arrays.sort(arr);
		
		for(int i=0 ;i<n ;i++)
		{
			if(arr[i]>=s){
				FIndex=i;
				break;
			}
		}
		
		
		System.out.println("Sequence of serving from left to right : ");
		
		for(int i=FIndex ;i<n ;i++)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
		}
		
		
		
		for(int i= FIndex-1 ; i>=0 ;i--)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
			
		}
		
		System.out.println("\nTotal Number of Movements= "+totalMovement);
		
		
		
		totalMovement=0;
		s=start;
		for(int i=0 ;i<n ;i++)
		{
			if(arr[i]<=s){
				FIndex=i;
			}
		}
		
		System.out.println("Sequence of serving from right to left : ");

		
		for( int i=FIndex ; i>=0 ;i--)
		{

			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
			
		}
		/*
		s=arr[FIndex+1];
		totalMovement+=s;
		System.out.print(s+" ");
		*/
		for(int i = FIndex+1 ; i<n ;i++)
		{
			totalMovement+=abs(s-arr[i]);
			s=arr[i];
			System.out.print(s+" ");
		}
			
		System.out.println("\nTotal Number of Movements= "+ totalMovement);
		
	}
}
