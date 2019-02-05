package edu.wmich.cs1120.LA1Lee;

//Create class MultipleChoiceQuestion
public class MultipleChoiceQuestion {
	//initialization
	private char answer[]; //1 1-dimensional array to store the Answer key
	private char student[][]; //1 2-dimensional array to store the Students answer
	
	//Default constructor with parameters assigned to answer[] and student[][] 
	public MultipleChoiceQuestion(char ans[], char stud[][]){
		setAnswer(ans);
		setStudent(stud);
	}
	
	//Setter
	public void setAnswer(char ans[]) {answer=ans;}
	public void setStudent(char stud[][]) {student=stud;}
	
	public double marks(int counter) { return ((double) counter/student[0].length)*100;}//calculations for student's mark and return the double value
	
	//receive the marks and give the grades
	public char grades(double counter) {
		//conditions for giving the grades
		/*A: 90% or greater
		  B: 80% – 89%
		  C: 70% – 79%
		  D: 60% – 69%
 		  E: 59% or lower*/
		if(counter<60) {return 'E';}
		else if(counter<70) {return 'D';}
		else if(counter<80) {return 'C';}
		else if(counter<90) {return 'B';}
		else {return 'A';}
	}
	
	//a method to print the answer[];
	public void printArray() {
		System.out.println("Answer Key");
		//a loop to loop through the answer array
		for(int i=0;i<answer.length;i++) {
			//to align the answer array for index before 9 
			if(i<9) {
				System.out.println(" "+(i+1)+") "+ answer[i]);
			}
			//normal print out array for 9 and greater
			else {
				System.out.println((i+1)+") "+ answer[i]);
			}
		}
	}
	
	//a method to print the student[][]
	public void print2DArray() {
		System.out.println("Student's Answer");
		for(int i=0;i<student.length;i++) {
			if(i==0) {
				System.out.printf("%s%d","Student",(i+1));
			}
			else {
				System.out.printf("%19s%d","Student",(i+1));
			}
		}
		System.out.println();
		//a loop to loop through the 2d Array vertically instead
		for(int i=0;i<student[0].length;i++) {
			String tempString="";//created a string to store the answers of 1 question from different students;
			for(int j=0;j<student.length;j++) {
				//to align the array for index for 9 and greater
				if(i>8){
					//if the student[j][i] equals answer[i] the print out would be shorter, so requires more spacing.
					if(student[j][i]==answer[i]){
						tempString=(i+1)+") "+Character.toString(student[j][i])+"               ";
					}
					//if the student[j][i] not equals answer[i] the print out would be longer, so requires less spacing.
					else {
						tempString=(i+1)+") "+Character.toString(student[j][i])+" ("+Character.toString(answer[i])+")"+"           ";
					}
				}
				//to align the index for 8 or below
				else {
					//if the student[j][i] equals answer[i] the print out would be shorter, so requires more spacing.
					if(student[j][i]==answer[i]){
						tempString=" "+(i+1)+") "+Character.toString(student[j][i])+"               ";
					}
					//if the student[j][i] not equals answer[i] the print out would be longer, so requires less spacing.
					else {
						tempString=" "+(i+1)+") "+Character.toString(student[j][i])+" ("+Character.toString(answer[i])+")"+"           ";
					}
				}
				System.out.print(tempString);//print out the whole tempString saved
			}
			System.out.println();//to go to next line
		}
	}
	
	public void printGrade() {
		for(int i=0;i<student.length;i++) {
			int counter=0;
			for(int j=0;j<student[i].length;j++) {
				if(student[i][j]==answer[j]){
					counter++;
				}
			}
			System.out.printf("Student %d: %.2f%s (%c)\n",(i+1),(marks(counter)),"%",grades(marks(counter)));			
		}
	}
	
	public void printAll() {
		 printArray();
		 System.out.println();
		 print2DArray();
		 System.out.println();
		 printGrade();
	}
}
