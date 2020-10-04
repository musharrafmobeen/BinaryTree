public class BinaryTree<T> {
	//Variable Declaration
	private TreeNode<T> root;
	
	
	class TreeNode<T> {
		//Variable Declaration
		private T Data;
		private TreeNode<T> leftChild, rightChild;
		
		//Constructor
		public TreeNode() {
			Data = null;
			leftChild = null;
			rightChild = null;
		}
		
		//Getters And Setters//
		public T getData() {
			return Data;
		}
		public void setData(T data) {
			Data = data;
		}
		public TreeNode<T> getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}
		public TreeNode<T> getRightChild() {
			return rightChild;
		}
		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}
	}
	
	
	//Constructor
	public BinaryTree(){
		root = null;
	}
	

	//Function to add data to a Binary Tree
	public void insert(T Data) {	
		TreeNode<T> previous = root;
		while(true) {
			if(isEmpty()) {
				root.setData(Data);
				break;
			}
			else if(Data.hashCode() < previous.getData().hashCode()) {
				if(previous.getLeftChild() == null) {
					TreeNode<T> newNode = new TreeNode<T>();
					newNode.setData(Data);
					previous.setLeftChild(newNode);
					break;
				}
				else {
					previous = previous.getLeftChild();
				}
					
			}
			else{
				if(previous.getRightChild() == null) {
					TreeNode<T> newNode = new TreeNode<T>();
					newNode.setData(Data);
					previous.setRightChild(newNode);
					break;
				}
				else {
					previous = previous.getRightChild();
				}
				
			}
		}
	}
	
	//Function to Delete data from a Binary Tree
	public TreeNode<T> Delete(T Data) {
		Integer direction = 0;
		TreeNode<T> current = root;
		TreeNode<T> parent = current;
		if(!isEmpty()) {
			while(true) {
				if(current.getData() == null) {
					return null;
				}
				
				else if(current.getData() == Data) {
					DeleteRecord(direction, parent, current);
					return current;
				}
				
				else if(Data.hashCode() < current.getData().hashCode()) {
					direction = 1;
					parent = current;
					current = current.getLeftChild();
				}
						
				else{
					direction = 2;
					parent = current;
					current = current.getRightChild();
				}
			}
		}
		return current;
	}
	
	
	//Function to Delete data and check which child to insert to the parent node
	private void DeleteRecord(Integer direction, TreeNode<T> parent,TreeNode<T> node) {
		if(node.getLeftChild() == null && node.getRightChild() == null) {
			if(direction == 0) {
				root = null;
			}
			else if(direction == 1){
				parent.setLeftChild(null);
			}
			else {
				parent.setRightChild(null);
			}
			System.out.println("Node Deleted (no child)");
		}
		else if(node.getLeftChild() != null && node.getRightChild() != null) {
			TreeNode<T> nodeToBeDeleted = node;
			node = node.getLeftChild();
			while(true) {
				if(node.getRightChild() == null) {
					nodeToBeDeleted.setData(node.getData());
					node.setData(node.getLeftChild().getData());
					node.setLeftChild(node.getLeftChild().getLeftChild());
					node.setRightChild(node.getLeftChild().getRightChild());	
					break;
				}
				
				node = node.getRightChild();
			}
			System.out.println("Node Deleted (two children)");
		}
		else {
			if(direction == 0) {
				if(root.getLeftChild() != null){
					root = root.getLeftChild();
				}
				else {
					root = root.getRightChild();
				}
			}
			else if(direction == 1){
				if(node.getLeftChild() != null) {
					node = node.getLeftChild();
					parent.setLeftChild(node);
				}
				else {
					node = node.getRightChild();
					parent.setLeftChild(node);
				}
			}
			else {
				if(node.getLeftChild() != null) {
					node = node.getLeftChild();
					parent.setRightChild(node);
				}
				else {
					
					node = node.getRightChild();
					parent.setRightChild(node);
				}
			}
			System.out.println("Node Deleted (one child)");
		}
	}
			
	//Function to Search data from a Binary Tree
	public TreeNode<T> Search(T Data) {
		TreeNode<T> current = root;
		
		if(!isEmpty()) {
			while(true) {
				if(current.getData() == null) {
					return null;  
				}
				
				else if(current.getData() == Data) {
					return current;
				}
				
				else if(Data.hashCode() < current.getData().hashCode()) {					
					current = current.getLeftChild();
				}
						
				else {	
					current = current.getRightChild();
				}
			}
		}
		return current;
	}
	
	
	//Inorder Traversal Of Binary Tree
	public void inorder(TreeNode<T> node)
	{
	    if (node == null)
	        return;
	 
	    inorder(node.getLeftChild());
	    System.out.println(node.getData());
	    inorder(node.getRightChild());
	}
	
	//Postorder Traversal Of Binary Tree
	public void Postorder(TreeNode<T> node) 
	{ 
	    if (node == null) 
	        return; 
	  
	    Postorder(node.getLeftChild());
	    Postorder(node.getRightChild());
	    System.out.println(node.getData());
	} 
	
	//Preorder Traversal Of Binary Tree
	public void Preorder(TreeNode<T> node) 
	{ 
	    if (node == null) 
	        return; 
	  
	    System.out.println(node.getData());
	    Preorder(node.getLeftChild());
	    Preorder(node.getRightChild());
	} 
	
	//Return root of the tree
	public TreeNode<T> getRoot() {
		return root;
	}

	//check to see if tree is empty
	private boolean isEmpty() {
		return root == null;
	}
}
