/*
Emma Vukelj
HW39
APCS1 pd9
2015-12-01
 */
/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

public class SuperArray {

		//~~~~~INSTANCE VARS~~~~~
		//underlying container, or "core" of this data structure:
    private int[] _data;

		//position of last meaningful value
    private int _lastPos;

		//size of this instance of SuperArray
    private int _size;
	
		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
	_lastPos = -1;
	_size = 0;
	_data = new int[10];
    }
		
    //output array in [a,b,c] format, eg
    // {1,2,3}.toString() -> "[1,2,3]"
    public String toString() {
	String retArray = "[";
	for (int i = 0; i < _data.length; i++){
	    retArray += _data[i];
	    retArray += ",";}
	if (retArray.length() > 1){
	    retArray = retArray.substring(0, retArray.length()-1) ;}
        retArray += "]";
	return retArray;
    }

		
    //double capacity of this SuperArray
    private void expand() { 
        int[] modArr = new int[_data.length *2];
	for (int i=0; i< _data.length; i++){
	    modArr[i] = _data[i];
	}
	_data = modArr;
    }
		
    //accessor -- return value at specified index
    public int get( int index ) { 
	return _data[index];
    }

		
    //mutator -- set value at index to newVal, 
    //           return old value at index
    public int set( int index, int newVal ) {
	int old = _data[index];
	_data[index] = newVal;
	return old;
    }


    //main method for testing
    public static void main( String[] args ) {
	SuperArray fleetwood = new SuperArray(); //next, populate superArray
	for (int i=0;i<fleetwood._data.length; i++) fleetwood.set(i,i+1);
	System.out.println( fleetwood.toString()); //test

	System.out.println("Fleetwood.get(5):\t" + fleetwood.get(5) + "\n");
	
	fleetwood.expand();
	System.out.println("EXPANDED:\n" + fleetwood.toString());
    }//end main	
}//end class
