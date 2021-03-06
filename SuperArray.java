/*
Team Gidiots: Emma Vukelj, James Cao
HW40: Array of Grade 316
APCS1 pd9
2015-12-02
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
    public void expand() { 
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
    
    //help from some old friends
    public static boolean linSearch (int[] a, int target){
	for (int i = 0; i < a.length; i++){
	    if  (a[i] == target){return true;}
	}
	return false;
    }

    public static int freq (int[] a, int target){
	int counter = 0;
	if (linSearch (a,target) == false){return 0;}
	else {
	    for (int i = 0; i < a.length; i++){
		if (a[i] == (target)){counter += 1;}}
	}
	return counter;
    }
    //#throwbackthursdays

    public void alignLeft() {
	int counter = freq (_data,0); // records the number of 0s
	int[] modArr = new int [_data.length - counter]; //new array with length subtracted by number of zeroes
	int shifter = 0; // skips over 0s
	
	for (int i = 0; i < modArr.length; i++){
	    if((i+shifter) < _data.length){
	    if (_data[i+shifter] != 0){
		modArr[i] =_data[i+shifter];}
	    else {
		while ((_data[i+shifter]) == 0){
		    shifter += 1;}
		modArr[i] =_data[i+shifter];}}}
	_data = modArr;}

    //I didn't use alignLeft in remove because the user might still want 0s in their array. 
    public void remove (int index){
	set (index, 0);
	int [] modArr= new int [_data.length-1];
	int shifter = 0;
	for (int i = 0; i < modArr.length; i++){
	     if((i+shifter) < _data.length){
	    if (_data[i+shifter] != 0){
		modArr[i] =_data[i+shifter];}
	    else {
		if ((_data[i+shifter]) == 0){
		    shifter = 1;}
		modArr[i] =_data[i+shifter];}}}
	_data = modArr;
    }

    public void add (int newVal) {
	int[] modArr = new int[_data.length + 1];
	for (int i=0; i<_data.length; i++){modArr[i] = _data[i];}
	modArr[_data.length] = newVal;
	_data = modArr;
    }

    public void addAtIndex(int index, int newVal) {
	int[] modArr = new int[_data.length + 1];
	int modCtr = 0;
	for (int i=0; i<_data.length; i++){
	    if (i==index){
		modArr[i] = newVal;
		modCtr = 1;
	    }
	    modArr[i + modCtr] = _data[i];
	}
	_data = modArr;
    }
	
    //main method for testing
    public static void main( String[] args ) {
	SuperArray fleetwood = new SuperArray(); //next, populate superArray
	for (int i=0;i<fleetwood._data.length; i++) fleetwood.set(i,i+1);
	System.out.println( fleetwood.toString()); //test

	System.out.println("Fleetwood.get(5):\t" + fleetwood.get(5) + "\n");
	
	fleetwood.expand();
	System.out.println("EXPANDED:\n" + fleetwood.toString());

	fleetwood.remove (0);//removes 1
	fleetwood.remove (11);//removes 0
	fleetwood.remove (3);//removes 5
	System.out.println("REMOVED:\n" + fleetwood.toString());

	fleetwood.set (0,0);
	fleetwood.set (1,0);
	fleetwood.set (5,0);
	System.out.println("ADDED UGLY ZEROES:\n" + fleetwood.toString());//For testing left alignment

	fleetwood.alignLeft();
	System.out.println("LEFTED:\n" + fleetwood.toString());//To the left, to the left

	fleetwood.add(9);
	System.out.println("ADDED A 9:\n" + fleetwood.toString());

	fleetwood.addAtIndex(4,3);
	System.out.println("ADDED A 3 AT INDEX 4:\n" + fleetwood.toString());

    }//end main	
}//end class
