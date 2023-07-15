package ez.swordOffer042.RecentCounter;

import java.util.ArrayList;
import java.util.List;

class RecentCounter {

    List<Integer> requests;
    
    public RecentCounter() {
        requests = new ArrayList<>();
    }
    
    public int ping(int t) {
        requests.add(t);

        for (int i = 0; i < requests.size(); i++) {
            if(requests.get(i) < t-3000){
                requests.remove(requests.get(i));
                i--;
            } else {
                break;
            }
        }
        System.out.print("size is " + requests.size());
        return  requests.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
        recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
    }
}