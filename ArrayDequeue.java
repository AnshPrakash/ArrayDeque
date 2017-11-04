
public class ArrayDequeue implements DequeInterface {
	private int dequesize = 0;
	private Object myarray[];
	private int front = -1;
	private int tail = -1;

	public void insertFirst(Object o) {
		try {
			// you need to implement this
			if (dequesize == 0) {
				myarray = new Object[1];
				// System.out.println("hi");
				myarray[0] = o;
				front = 0;
				tail = 0;
				dequesize++;
			}
			else if (myarray.length == tail + 1) {
				Object arr[] = new Object[2 * dequesize];
				int j = 1;
				for (int i = front; i < tail + 1; i++) {
					arr[j] = myarray[i];
					j++;
				}
				front = 0;
				dequesize++;
				tail = front + dequesize - 1;
				myarray = arr;
				myarray[front] = o;

			} else {
				Object arr[] = new Object[myarray.length];
				// System.out.println("hello");
				int j = 1;
				for (int i = front; i < tail + 1; i++) {
					arr[j] = myarray[i];
					j++;
				}
				arr[0] = o;
				myarray = arr;
				dequesize++;
				front = 0;
				tail = front + dequesize - 1;
				
			}
			//System.out.println(toString());
		} 
		
		
		catch (Exception e) {
			System.out.println(e);
			//new UnsupportedOperationException("Not implemented yet.");
		}
	}

	public void insertLast(Object o) {
		// you need to implement this
		try {
			if (dequesize == 0) {
				myarray = new Object[1];
				myarray[0] = o;

				front = 0;
				tail = 0;
				dequesize++;
				// System.out.println(o);
			} else if (myarray.length == (tail + 1)) {
				// System.out.println("hello");
				Object arr[] = new Object[2 * dequesize];
				int j = 0;
				for (int i = front; i < tail+1; i++) {
					arr[j] = myarray[i];

				}
				front = 0;
				tail = front + dequesize - 1;
				myarray = arr;
				myarray[tail + 1] = o;

				tail++;
				dequesize++;
			} else {
				myarray[tail + 1] = o;

				tail++;
				dequesize++;
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new java.lang.UnsupportedOperationException("Not implemented yet.");
		}
		//System.out.println(toString());
	}

	public Object removeFirst() throws EmptyDequeException{
		
			if(dequesize!=0)
			{front++;
			 dequesize--;
			 return myarray[front];
			
			}
			else {throw new EmptyDequeException("Empty Deque");}
		
		
	}

	public Object removeLast() throws EmptyDequeException {
	         if(dequesize!=0)
	         {
	        	 Object t;
	        	 t=myarray[tail];
	        	 tail=tail-1;
	        	 dequesize--;
	        	 return t;
	         }else {
	        	  
	        	 throw new EmptyDequeException("Empty Deque");
	         }
	
	}

	public Object first() throws EmptyDequeException{
		             if(dequesize!=0)
		             { Object k;
		              k=myarray[front];
		              return k;
		              }
		             else {
		            	 throw new EmptyDequeException("Empty Deque");
		            	 //System.out.println("Empty Deque");
		            	 //return null;
		             }
		            
	   
	  }

	public Object last() throws EmptyDequeException { 
		Object t;
		if(dequesize!=0)
		{ t=myarray[tail];
			return t;
		}else {throw new EmptyDequeException("Empty Deque");}
	
	}

	public int size() {
		try {
			return dequesize;
		} catch (Exception e) {
			throw new java.lang.UnsupportedOperationException("Not implemented yet.");
		}
	}

	public boolean isEmpty() {
		try {if (dequesize==0)
			   return true;
		    else 
			  return false;
		}catch(Exception e) {
		throw new java.lang.UnsupportedOperationException("Not implemented yet.");
		}
	}

	public String toString() {
		 if(dequesize!=0)
			{String s = "[";
			//System.out.println(front + " " + " " + tail);
			for (int i = front; i < tail + 1; i++) {
				if(i==tail)
					s+=(myarray[i]);
				else
		    		s += (myarray[i] + ",");

			}
			s += "]";
			return s;
			}
		else 
			return ("[]");}
		
	

	public static void main(String[] args) {
		int N = 10;
		DequeInterface myDeque = new ArrayDequeue();
		for (int i = 0; i < N; i++) {

			myDeque.insertFirst(i);
			//System.out.println(myDeque.size());
			myDeque.insertLast(-1 * i);
			//System.out.println(myDeque.size());
		}
		//System.out.println(myDeque.toString());//

		int size1 = myDeque.size();
		System.out.println("Size: " + size1);
		System.out.println(myDeque.toString());

		if (size1 != 2 * N) {
			System.err.println("Incorrect size of the queue.");
		}

		// Test first() operation
		try {
			int first = (int) myDeque.first();
			int size2 = myDeque.size(); // Should be same as size1
			if (size1 != size2) {
				System.err.println("Error. Size modified after first()");
			}
		} catch (EmptyDequeException e) {
			System.out.println("Empty queue");
		}

		// Remove first N elements
		for (int i = 0; i < N; i++) {
			try {
				int first = (Integer) myDeque.removeFirst();
			} catch (EmptyDequeException e) {
				System.out.println("Cant remove from empty queue");
			}

		}

		int size3 = myDeque.size();
		System.out.println("Size: " + myDeque.size());
		System.out.println(myDeque.toString());

		if (size3 != N) {
			System.err.println("Incorrect size of the queue.");
		}

		try {
			int last = (int) myDeque.last();
			int size4 = myDeque.size(); // Should be same as size3
			if (size3 != size4) {
				System.err.println("Error. Size modified after last()");
			}
		} catch (EmptyDequeException e) {
			System.out.println("Empty queue");
		}

		// empty the queue - test removeLast() operation as well
		while (!myDeque.isEmpty()) {
			try {
				int last = (int) myDeque.removeLast();
			} catch (EmptyDequeException e) {
				System.out.println("Cant remove from empty queue");
			}
		}

		int size5 = myDeque.size();
		if (size5 != 0) {
			System.err.println("Incorrect size of the queue.");
		}
		/* my testing code
        *
        *@Author Ansh Prakash 2016CS10367
        *	    
	     */
		DequeInterface deq=new ArrayDequeue();
		try {
		//deq.first();
		//deq.last();
		//deq.removeLast();
	        System.out.println(deq.toString());
		deq.removeFirst();
		deq.insertFirst(7);
		}
		catch (EmptyDequeException e) {
		 System.out.println(e.getMessage()+" "+deq.isEmpty());
		}
	 } 
	 

}
