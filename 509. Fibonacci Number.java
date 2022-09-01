class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        else if (n==1) return 1;
        else {
            int a = 0, b = 1;
            n -= 1;
            while(n-->0){
                // first computing f(i-1) + f(i-2) then updating the a and b where a is f(i-2) and b is f(i-1)
                // at the end returning the b.
                int c = a+b;
                a = b;
                b = c;
                
            }
            return b;
        }
    }
}
