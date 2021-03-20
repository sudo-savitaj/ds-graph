public class SteppingNumbers {
    public void display() {
        int count = steppingNumbers(10,15);
        System.out.println(count);

    }
    int steppingNumbers(int n, int m){
        int count =0;
        for(int i=n;i<=m;i++)
            if(dfs(i,-1))
                count++;
        return count;
    }

    private boolean dfs( int num,int prev) {
        if(num == 0) return true;
        int digit = num%10;
        int remaining = num/10;
        if(prev ==-1) return dfs(remaining,digit);
        return Math.abs(digit-prev) == 1 && dfs(remaining,digit);
    }
}
