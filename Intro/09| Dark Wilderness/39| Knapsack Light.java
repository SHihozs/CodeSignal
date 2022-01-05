int solution(int value1, int weight1, int value2, int weight2, int maxW) {
    
    int[] value  = {value1,value2};
    int[] weight = {weight1,weight2};
    int i = 0;
  
    return knapsack(value, weight, maxW, i);
  }
  
  
  int knapsack(int[] value, int[] weight, int maxW, int i){
      
      //BASE CASE
      if(i==2){
          return 0;
      }
      if(weight[i] > maxW)
      {
          return knapsack(value,weight,maxW,i+1);
      }
      else
      {
          return Math.max(knapsack(value, weight,maxW - weight[i],i+1) + value[i],knapsack(value, weight, maxW, i+1));
      }
      
  }
  
