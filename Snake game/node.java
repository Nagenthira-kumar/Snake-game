package SnakeGame;

public class Node {

	 int row;
	 int col;
	 
	 Node(int row,int col){
		 this.col=col;
		 this.row=row;
	 }
	 public int getColumn(){return this.col;}
	 public int  getRow(){return this.row;}
}
