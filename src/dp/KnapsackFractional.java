package dp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KnapsackFractional {

  public static void main(String[] args) {
    int[] wt = {10, 40, 20, 30};
    int[] val = {60, 40, 100, 120};
    int capacity = 50;

    double maxValue = getMaxValue(wt, val, capacity);

    // Function call
    System.out.println("Maximum value we can obtain = "
        + maxValue);
  }

  private static double getMaxValue(int[] wt, int[] val, int capacity) {
    List<ItemValue> itemValues=new ArrayList<>();
    for(int i=0;i<wt.length;i++) {
      ItemValue itemValue=new ItemValue(wt[i],val[i],i);
      itemValues.add(itemValue);
    }
    itemValues.sort(new Comparator<ItemValue>() {
      @Override
      public int compare(ItemValue o1, ItemValue o2) {
        return o2.cost.compareTo(o1.cost);
      }
    });

    double maxValue=0;

    for(ItemValue itemValue:itemValues) {

      if(capacity-itemValue.wt>=0) {

        capacity= (int) (capacity-itemValue.wt);
        maxValue=maxValue+itemValue.val;
      } else {

        double fraction=capacity/itemValue.wt;
        double fractionVal=itemValue.val*fraction;
        maxValue=maxValue+fractionVal;
        break;
      }

    }

    return maxValue;
  }

  public static class ItemValue {

    double wt;
    double val;
    double index;
    Double cost;

    ItemValue(int wt, int val, int index) {
      this.wt = wt;
      this.val = val;
      this.index = index;
      this.cost = (double) val/wt;
    }


  }

}
