package medium.q1604.alertNames;
/*Unsolved*/
import java.util.*;

class Solution {
    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, String> timeMap = new HashMap<>();
        HashMap<String, Integer> timeCount = new HashMap<>();
        Set<String> names = new HashSet<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            if(timeMap.get(name)==null ){
                timeMap.put(name,keyTime[i]);
                timeCount.put(name,1);
            }
            if (!ifInAnHour(timeMap.get(name), keyTime[i])){
                timeMap.put(name,keyTime[i]);
            }else {
                Integer count = timeCount.get(name);
                count++;
                if(count==3){
                    names.add(name);
                    timeCount.put(name,0);
                }else {
                    timeCount.put(name,count);
                }
            }
        }
        Comparator<String> compareName =  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] chars1=o1.toCharArray();
                char[] chars2=o2.toCharArray();
                int i=0;
                while(i<chars1.length && i<chars2.length){
                    if(chars1[i]>chars2[i]){
                        return 1;
                    }else if(chars1[i]<chars2[i]){
                        return -1;
                    }else{
                        i++;
                    }
                }
                if(i==chars1.length){  //o1到头
                    return -1;
                }
                if(i== chars2.length){ //o2到头
                    return 1;
                }
                return 0;
            }
        };
        ArrayList<String> nameList = new ArrayList<>(names);
        nameList.sort(compareName);
        return nameList;


    }

    private static Boolean ifInAnHour (String preTime, String afterTime){
        int preHour = Integer.parseInt(preTime.split(":")[0]);
        int afterHour = Integer.parseInt(afterTime.split(":")[0]);
        if(afterHour==preHour){
            return true;
        }
        if(afterHour-preHour==1){
            int preMin = Integer.parseInt(preTime.split(":")[1]);
            int aftMin = Integer.parseInt(afterTime.split(":")[1]);
            return preMin >= aftMin;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] keyName = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        String[] keyTime = {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"};
        System.out.println(alertNames(keyName, keyTime));

    }




}