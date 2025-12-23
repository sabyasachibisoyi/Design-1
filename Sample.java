// Time Complexity : O(n) -> as we have the base impl of LinkedList it's time complexity refers here
// Space Complexity : O(n) -> where n is the number of inerstions, range for hashing can be constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//I started with int[] arr = new int[Integer.MAX_VALUE]
//where time complexity is O(1) but got memory limit excceded
//So proceed with having limited number of keys for range, and each array can accomdate a list

// Your code here along with comments explaining your approach
class MyHashSet {
    Bucket[] bucket;

    public MyHashSet() {
        this.bucket = new Bucket[1000];
        for(int i = 0;i<1000;i++)
        {
            this.bucket[i] = new Bucket();
        }
    }

    protected int _hash(int key)
    {
        return (key % 1000);
    }

    public void add(int key) {
        int bucketIndex = this._hash(key);
        this.bucket[bucketIndex].insert(key);
    }

    public void remove(int key) {
        int bucketIndex = this._hash(key);
        this.bucket[bucketIndex].remove(key);
    }

    public boolean contains(int key) {
        int bucketIndex = this._hash(key);
        return this.bucket[bucketIndex].exists(key);
    }
}

class Bucket
{
    private LinkedList<Integer> list;

    public Bucket()
    {
        list = new LinkedList<Integer>();
    }

    public void insert(Integer key)
    {
        int index = this.list.indexOf(key);
        if(index==-1)
        {
            this.list.addFirst(key);
        }
    }

    public void remove(Integer key)
    {
        this.list.remove(key);
    }

    public boolean exists(Integer key)
    {
        int index = this.list.indexOf(key);
        return (index!=-1);
    }
}
