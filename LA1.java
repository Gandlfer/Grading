package edu.wmich.cs1120.LA1Lee;
import java.util.Scanner;

import java.io.*;

//main class
public class LA1 {
	 public static void main(String args[]) throws FileNotFoundException{
		 try {
			 Scanner scanFile =new Scanner(new File ("mcq.txt"));
			 Scanner input=new Scanner(System.in);
			 
			 String data="";
			 boolean flag=true;
			 
			 System.out.println("File found!\n");
			 print();
			 System.out.println("If you are ready, press 1 (Press any numbers to end)");
			 if(input.nextInt()!=1) {
				 flag=false;
			 }
			 if (flag==true) {
				 try {
					 while(scanFile.hasNextLine()) {
						 data= data + scanFile.nextLine()+ " ";
					 }
					 scanFile.close();
					 
					 String splited[]=data.split(" ");
	
					 for(int i=0;i<Integer.parseInt(splited[2]);i++){
						 if(Integer.parseInt(splited[2])!=(splited.length-3)) {
							 flag=false;
							 break;
						 }
						 else {
							 if(Integer.parseInt(splited[0])!=splited[i+3].length()) {
								 flag=false;
								 break;
							 }
						 }
					 }
					 if((Integer.parseInt(splited[0])==splited[1].length())&&(flag==true)) {
						 MultipleChoiceQuestion mcq =new MultipleChoiceQuestion(toArray(splited[1]),to2DArray(splited));
					 	 mcq.printAll();
					 }
					 else {
						 System.out.println("Error!!!");
						 print();
					 }
				 }
				 catch(NumberFormatException e){
					 System.out.println("Error!!!");
					 print();
				 }
			 }
		 }
		 catch(Exception e) {
				 System.out.println("Error!!!\nNote: Make sure the path of the file to be read is correct in the computer");
		 }
		 System.out.println("\n\nEnd.Shutting down...");
	 }

	 public static char[] toArray(String split) {
		 char ans[]=split.toCharArray();
		 return ans;
	 }
	 
	public static char[][] to2DArray(String splited[]){
		 char [][] student = new char[splited.length-3][splited[3].length()];
		 for(int i=3;i<splited.length;i++) {
			 for(int j=0;j<splited[i].length();j++) {
				 student[i-3][j]=splited[i].charAt(j);
			 }
		 }
		 return student;
	 }
	public static void print() {
		 System.out.println("Please make sure your file is in the correct format\n(number of questions)\n(answer key)\n(numberof  students)\n(the answer from each students line by line)");
		 System.out.println("Note:\n1)Make sure the number of question is the same for all the data given\n2)The number of students and the number of students' answer is the same");
	}
}