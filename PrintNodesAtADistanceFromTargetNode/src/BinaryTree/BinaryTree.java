package BinaryTree;

public class BinaryTree {
	private BinaryTreeNode root;
	
	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void SetBinaryTreeRoot(BinaryTreeNode binaryTreeNode) {
		this.root = binaryTreeNode;
	}
	
	public BinaryTreeNode GetBinaryTreeRoot() {
		return this.root;
	}
	
	public BinaryTreeNode Insert(BinaryTreeNode binaryTreeNode, int data) {
		
		if(binaryTreeNode == null) {
			binaryTreeNode = new BinaryTreeNode(data);
			return binaryTreeNode;
		}
		
		if(binaryTreeNode.GetBinaryTreeNodeData() < data) {
			binaryTreeNode.SetBinaryTreeNodeRight(Insert(binaryTreeNode.GetBinaryTreeNodeRight(), data));
		}else {
			binaryTreeNode.SetBinaryTreeNodeLeft(Insert(binaryTreeNode.GetBinaryTreeNodeLeft(), data));
		}
		
		return binaryTreeNode;
	}
	
	public void PrintInorderTraversal(BinaryTreeNode binaryTreeNode) {
		if(binaryTreeNode == null) {
			return;
		}
		PrintInorderTraversal(binaryTreeNode.GetBinaryTreeNodeLeft());
		System.out.println(binaryTreeNode.GetBinaryTreeNodeData()+" ");
		PrintInorderTraversal(binaryTreeNode.GetBinaryTreeNodeRight());
	}
	
	public int PrintNodesAtDistanceFromTargetNode(BinaryTreeNode binaryTreeNode, int targetValue, int distanceFromTargetNode) {
		if(binaryTreeNode == null) {
			return -1;
		}		
		if(binaryTreeNode.GetBinaryTreeNodeData() == targetValue) {
			PrintNodesAtDistanceFromRoot(binaryTreeNode, distanceFromTargetNode);
			return 0;
		}
		
		int distanceOfLeftFromTarget = PrintNodesAtDistanceFromTargetNode(binaryTreeNode.GetBinaryTreeNodeLeft(), targetValue, distanceFromTargetNode);
		if(distanceOfLeftFromTarget != -1) {
			if(distanceOfLeftFromTarget + 1 == distanceFromTargetNode) {
				System.out.println(binaryTreeNode.GetBinaryTreeNodeData()+" ");
			}else {
				PrintNodesAtDistanceFromRoot(binaryTreeNode.GetBinaryTreeNodeRight(), distanceFromTargetNode - distanceOfLeftFromTarget -2);				
			}
			return distanceOfLeftFromTarget+1;
		}
		
		int distanceOfTargetFromRight = PrintNodesAtDistanceFromTargetNode(binaryTreeNode.GetBinaryTreeNodeRight(), targetValue, distanceFromTargetNode);
		if(distanceOfTargetFromRight != -1) {
			if(distanceOfTargetFromRight + 1 == distanceFromTargetNode) {
				System.out.println(binaryTreeNode.GetBinaryTreeNodeData()+" ");
			}else {
				PrintNodesAtDistanceFromRoot(binaryTreeNode.GetBinaryTreeNodeLeft(), distanceFromTargetNode - distanceOfTargetFromRight - 2);
			}
			return 1+distanceOfTargetFromRight;
		}
		return -1;
	}
	
	public int PrintNodesAtDistanceFromRoot(BinaryTreeNode binaryTreeNode, int distanceFromTargetNode) {
		if(binaryTreeNode == null) {
			return 0;
		}
		if(distanceFromTargetNode == 0) {
			System.out.println(binaryTreeNode.GetBinaryTreeNodeData()+" ");
		}else{
			PrintNodesAtDistanceFromRoot(binaryTreeNode.GetBinaryTreeNodeLeft(), distanceFromTargetNode-1);
			PrintNodesAtDistanceFromRoot(binaryTreeNode.GetBinaryTreeNodeRight(), distanceFromTargetNode-1);
		}
		return 0;
	}
}
