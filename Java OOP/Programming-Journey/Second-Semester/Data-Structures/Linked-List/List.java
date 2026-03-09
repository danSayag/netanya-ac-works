

public class List {

	private ListNode firstNode;
	private ListNode lastNode;
	private String name;

	

	public List(){
		this("list");
	}


	public List(String listName){
		name=listName;
		firstNode=lastNode=null;
	}


	public void insertAtFront(Object insertItem){
		if(isEmpty())
			firstNode=lastNode=new ListNode(insertItem);
		else
			firstNode=new ListNode(insertItem,firstNode);
	}


	public void insertAtBack(Object insertItem){
		if(isEmpty())
			firstNode=lastNode=new ListNode(insertItem);
		else {
		    ListNode last=new ListNode(insertItem);
			lastNode.setNext(last);
			lastNode=last;
		}
	}


	public Object removeFromFront()throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException(name);
		Object removedItem=firstNode.getObject();

		if(firstNode==lastNode)
			firstNode=lastNode=null;
		else
			firstNode=firstNode.getNext();
		return removedItem;
	}



	public Object removeFromBack() throws EmptyListException{
		if(isEmpty())
			throw new EmptyListException(name);

		Object removedItem=lastNode.getObject();
		if(firstNode==lastNode)
			firstNode=lastNode=null;
		else{
			ListNode current=firstNode;

			while(current.getNext()!=lastNode)
				current=current.getNext();
				
			lastNode=current;
			current.setNext(null);
		}
		return removedItem;
	}



	public boolean isEmpty(){
		return firstNode==null;
	}



	public void print(){
		if(isEmpty()){
			System.out.println("Empty "+ name);
			return;
		}
		System.out.println("The "+ name+ " is : ");
		ListNode current=firstNode;

		while(current != null){
			System.out.println(current.getObject());
			current=current.getNext();
		}
		System.out.println();
	}



	public String toString(){
		if(isEmpty()){
			return "Empty "+ name;
	    }
		String result="(";
		ListNode current=firstNode;
		while(current!=null){
			result+=current.getObject();
			    if(current.getNext()!=null)
				    result+=",";
			    if(current.getNext()==null){
				    return result+=")";
			    }
			current=current.getNext();
		}
		return result;
	}



	public Object removeAt(int k){
		if(isEmpty())
			throw new EmptyListException(name);
		if(k==0)
			return removeFromFront();
		if(k==size()-1)
			return removeFromBack();
		ListNode current=firstNode;
		for(int i=0;i<k-1;i++){
			current=current.getNext();
		}
		Object removedItem=current.getNext().getObject();
		current.setNext(current.getNext().getNext());
		return removedItem;
	}
	

	public int size() {
		int size = 0;
		ListNode current = firstNode;
		while (current != null) {
			size++;
			current = current.getNext();
			}
		return size;
	}

			

	public void show(){
		if (firstNode == null )
		    return;
		else
			firstNode.show();
			System.out.println();
		}

		
	public void showRev(){
		if (firstNode == null )
			return;
		else
			firstNode.showRev();
			System.out.println();
		  }


	
		
	public List addAt(int k,Object...obj){
		if(k>size()||k<0)
			throw new ListIndexOutOfBounds();

		ListNode first = this.firstNode;
		List nList = new List();	
		for(int i = 0 ; i < size() ; i++ ){
			if(i==k){
				for(int j = 0 ; j < obj.length ; j++ ){
					nList.insertAtBack(obj[j]);
				}
			}
			nList.insertAtBack(first);
		       first = first.getNext();
		}
		return nList;
	}	


	public ListNode[] toArray(){
		int x = size();
        ListNode[] result = new ListNode[x];
		for(int i = 0 ; i < x ; i++){
			result[i] = firstNode;
			firstNode = firstNode.getNext();
		}
		return result;
	}
}