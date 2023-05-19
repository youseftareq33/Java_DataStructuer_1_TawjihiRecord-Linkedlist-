package application;

public class LinkedList <E extends Comparable<E> > {
    private Node<E> head;

    //////////////////////////////--- insert at last ---/////////////////////
    public void insertatlast(E data) {
        Node<E> newnode = new Node<E>(data);
        
        if(head==null) {
            head=newnode;
        }
        else {
            Node<E> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(newnode);
        }
    }

    /////////////////////////////--- insert sorted ---//////////////////////
	public void insertsorted(E data) {
		Node<E> newnode = new Node<E>(data);
		if (head == null) {
			head = newnode;
		}
		else {
			Node<E> curr = head;
			Node<E> prev = null;
			while (curr != null && curr.getData().compareTo(data) < 0) {
				prev = curr;
				curr = curr.getNext();
			}
			if (prev == null) { // case at head
				newnode.setNext(head);
				head = newnode;
			}
			else { // case at middle or last
				newnode.setNext(curr);
				prev.setNext(newnode);
			}
		}
	}
	
	
    /////////////////////////////--- search ---/////////////////////////////
    public E search (E data) {
    	Node<E> curr = head;
    	String x[];
    	//scan_x=sc_scan.nextLine().split(",");
    	while(curr != null) {
    		x=curr.getData().toString().split(",");
    		if(x[0].equals(data) ) {
    			return curr.getData();
        		
    		}
    		else {
    			curr = curr.getNext(); 	   	
    		}
    			
    	}    	
    	return null;
    }
		
    /////////////////////////////--- delete ---/////////////////////////
    public void delete (E data){
        Node<E> curr = head;
        Node<E> prev = null;
        while (curr != null) {
            if (curr.getData().compareTo(data) == 0) { // found
                if (prev == null) { // case at head
                    head = curr.getNext();
                } else { // case at middle or last
                    prev.setNext(curr.getNext());
                }
            } // not found
            prev = curr;
            curr = curr.getNext();
        }
    }
    
    /////////////////////////////--- empty ---/////////////////////////
    public boolean isEmpty() {
    	if(head==null) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
   
    /////////////////////////////--- delete all data---//////////////////
    public void deleteAll() {
    	head=null;
    }
    
    ////////////////////////////--- show data ---////////////////////////
    public void show() {
		Node<E> curr=head;
		while(curr != null) {
			//System.out.print(curr.getData()+" --> ");
			
			System.out.print("\n"+"                          "+curr.getData()+"\n\n"
			+ "                                     |"
			+ "\n"+"                                     V\n\n");
			
			//////////////////////////////////////////////////////////////////
			curr=curr.getNext();
			
			///////////////////////////////////////////////////////////////
		}
		System.out.print("                                    "+"null"+"\n\n\n");
	}
    
    
    public String showFx() {
    	 
    	    	Node<E> curr=head;
    	    	String s[] = null;
    	    	String print="";
    	    	while(curr!=null) {
    	    		s=curr.getData().toString().split(",");
    	    		print+=s[0]+","+s[1]+","+s[2]+"\n";
    	    		curr=curr.getNext();
    	    		
    	    	}
    			return print;
    	    
    }
    ///////////////////////////---
    
    public boolean duplicate_seatnum(E data) {
    	Node<E> curr=head;
    	String y[];
    	boolean b=false;
		while(curr != null) {
			y=curr.getData().toString().split(",");
			if(y[0].equals(data)) {
				return b=true;
			}
			else {
				curr=curr.getNext();
			}
			
		}
		return b;
    }
    
    //////////////////////////---case 4/////////////////////
    public String topTenstud() {
    	Node<E> curr=head;
    	String s[] = null;
    	String print="";
    	for(int i=0;i<10;i++) {
    		s=curr.getData().toString().split(",");
    		print+=(i+1)+")  "+s[2]+","+s[1]+","+s[0]+"\n\n";
    		
    		curr=curr.getNext();
    		
    	}
		return print;
    }
    
    
    public void traverseinsertsorted(E data) {
		Node<E> newnode = new Node<E>(data);
		if (head == null) {
			head = newnode;
		}
		else {
			Node<E> curr = head;
			Node<E> prev = null;
			
			while (curr != null && curr.getData().compareTo(data) > 0) {
				prev = curr;
				curr = curr.getNext();
			}
			if (prev == null) { // case at head
				newnode.setNext(head);
				head = newnode;
			}
			else { // case at middle or last
				newnode.setNext(curr);
				prev.setNext(newnode);
			}
		}
	}
    ////////////////////////////////////////////////////////////////////////////
    
    
    
    
    /////////////////////////---
    
    ////////////////////////---
    public double mean() {
    	Node<E> curr=head;
    	String y[];
    	
    	int count=0;
    	double sum=0;
    	
		while(curr != null) {
			y=curr.getData().toString().split(",");
			curr=curr.getNext();
			sum=sum+(Double.parseDouble(y[2]));
			count++;
		}
		
		double res;
		
		return res=sum/count;
    }
    
    /////////////////////////---
    // case 7
    public int count_spesificStud(double data) {
    	Node<E> curr=head;
    	String y[];
    	
    	int count_spesificStud=0;
    	
    	
		while(curr != null) {
			y=curr.getData().toString().split(",");
			if(data<=Double.parseDouble(y[2])) {
				count_spesificStud++;
			}
			curr=curr.getNext();
			
		}
		
		return count_spesificStud;
    }
    
    public int count_brunch() {
    	int count_brunch=0;
    	Node<E> curr=head;
		while(curr != null) {
			
			curr=curr.getNext();
			count_brunch++;
		}
		return count_brunch;
    }

    ////////////////////////
    
    public double mode() {
		Node<E> curr1 = head;

		int max = -1; 
		double result = 0; 
		
		String s1[]=null;
		String s2[]=null;
		
		while (curr1 != null) {
			s1=curr1.getData().toString().split(",");
			Node<E> curr2 = curr1.getNext();
			int count = 1;
			while (curr2 != null) {
				s2=curr2.getData().toString().split(",");
				if (Double.parseDouble(s1[2]) == Double.parseDouble(s2[2])) {
					count++;
				}
				curr2 = curr2.getNext();
			}

			if (count > max) {
				result = Double.parseDouble(s1[2]);
				max = count;
			}
			curr1 = curr1.getNext();
		}
		return result;

	}
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////////////////////////--- to string ---///////////////////////
    @Override
    public String toString() {
        String str = "head-->";
        Node<E> curr = head;
        while (curr != null) {
            str += curr.toString();
           
            curr = curr.getNext();
            return str+"-->null";
        }
        
        return curr.toString();
    }

    
    
    
}



