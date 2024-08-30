package SnakeGame;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class snake {
    static Queue <Node> queue = new LinkedList<Node>();
    static Queue<Node> food = new LinkedList<Node>();
	static char[][] snakeBoard = null;
	
	
	snake(int row,int col){
		
		snakeBoard=new char[row][col];
		queue.add(new Node(0,0));
		food.add(new Node(1,3));
		food.add(new Node(2,1));
		food.add(new Node(3,2));
		food.add(new Node(4,1));
		food.add(new Node(3,3));
		displayFood(food.poll());
		
	}
	public static void snakeMove(int row,int col) {
		if(row>=0&&row<snakeBoard.length&&col>=0&&col<snakeBoard.length) {
			queue.add(new Node(row,col));
			
			if(snakeBoard[row][col]!='X') {
				Node node = queue.poll();
				int c=node.col;
				int r = node.row;
				snakeBoard[r][c]='\0';
				
			}
			
			if(snakeBoard[row][col]=='X') {
				if(food.isEmpty()) {
					moveForwardAndPrint(row,col);
					System.out.println("YOU WON");
					System.exit(0);
					
				}
				displayFood(food.poll());
			}
			
			if(snakeBoard[row][col]=='.') {
				System.out.println("Game over-DUE TO SELF EAT");
				System.exit(0);
			}
			
			moveForwardAndPrint(row,col);
			if(!queue.isEmpty()) {
				System.out.println("enter a position:");
				Scanner sc = new Scanner(System.in);
				char d = sc.next().charAt(0);
				
				switch(d){
				case 'U':{
					snakeMove(--row,col);
					break;
				}
				case 'D':{
					snakeMove(++row,col);
					break;
				}
				case 'R':{
					snakeMove(row,++col);
					break;
				}
				case 'L':{
					snakeMove(row,--col);
					break;
				}
				
				
				}
				
				
			}
		}
		else {
			System.out.println("Game Over-DUE TO INVALID MOVE");
			System.exit(0);
		}
	}
	public static void displayFood(Node n) {
		int r =n.getRow();
		int c =n.getColumn();
		snakeBoard[r][c]='X';
	}
	public static void moveForwardAndPrint(int row,int col) {
		snakeBoard[row][col]='.';
		print();
	}
	public static void print() {
		for(char[] c:snakeBoard) {
			for(int j=0;j<snakeBoard.length;j++) {
				System.out.print(c[j]+" ");
			}
			System.out.println();
		}
	}
}
