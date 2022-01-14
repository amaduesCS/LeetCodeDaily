package ez.q1773.countMatches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。

另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。

如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：

ruleKey == "type" 且 ruleValue == typei 。
ruleKey == "color" 且 ruleValue == colori 。
ruleKey == "name" 且 ruleValue == namei 。
统计并返回 匹配检索规则的物品数量 。

 

示例 1：

输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
输出：1
解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
示例 2：

输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
输出：2
解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
 

提示：

1 <= items.length <= 104
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey 等于 "type"、"color" 或 "name"
所有字符串仅由小写字母组成
*/

class Solution {
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String,Integer> map = new HashMap<>();
        for (List<String> item : items) {
            map.put("type_" + item.get(0),map.getOrDefault("type_" + item.get(0),0)+1);
            map.put("color_" + item.get(1),map.getOrDefault("color_" + item.get(1),0)+1);
            map.put("name_" + item.get(2),map.getOrDefault("name_" + item.get(2),0)+1);
        }
        return map.getOrDefault(ruleKey+"_"+ruleValue,0);
    }

}