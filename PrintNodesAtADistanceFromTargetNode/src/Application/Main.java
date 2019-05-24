package Application;

import java.util.Scanner;
import BinaryTree.BinaryTree;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Print nodes at a distance from a node");
		System.out.println("-------------------------------------");
		
		try {
			System.out.println("Enter the number of nodes in the binary tree");
			Scanner scanner = new Scanner(System.in);
			int numberNodes = scanner.nextInt();			
			BinaryTree binaryTree = new BinaryTree(null);
			for(int index = 0; index <numberNodes; index++) {
				System.out.println("Enter the element");
				binaryTree.SetBinaryTreeRoot(binaryTree.Insert(binaryTree.GetBinaryTreeRoot(), scanner.nextInt()));
			}
			System.out.println("--------The Inorder traversal of the tree -----------");
			binaryTree.PrintInorderTraversal(binaryTree.GetBinaryTreeRoot());
			System.out.println("Enter the target node from which nodes at a certain has to be found");
			int targetNode = scanner.nextInt();
			System.out.println("Enter the distance from the target node for which nodes that are at that distance have to be printed");
			int distanceFromTarget = scanner.nextInt();
			binaryTree.PrintNodesAtDistanceFromTargetNode(binaryTree.GetBinaryTreeRoot(), targetNode, distanceFromTarget);
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
}
