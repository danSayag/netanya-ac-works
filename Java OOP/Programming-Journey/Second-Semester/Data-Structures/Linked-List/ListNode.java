

public class ListNode {

	private Object data;
	private ListNode nextNode;
	

	public ListNode(Object o){
		this(o,null);
	}
	public ListNode(Object o,ListNode node){
		data=o;
		nextNode=node;
	}
	public Object getObject(){
		return data;
	}
	public ListNode getNext(){
		return nextNode;
	}
	public void setNext(ListNode ln){
		nextNode = ln;
	}
	public String toString(){
		return data.toString();
	}
	

	public void show(){
		if(data == null)
		((ListNode)data).show();
		    
		System.out.print(data.toString()+" ");
		if(nextNode != null){
		   nextNode.show();
		}
	}

	public void showRev(){
		if(nextNode == null)
		System.out.print(toString()+' ');
		if (nextNode != null) {
            nextNode.showRev();
			System.out.print(toString()+' ');
        }
    }
}