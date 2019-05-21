package com.scala.datastructure

import java.util.Arrays

/**
 * 计数排序
 * 自己的理解：就是先找出原始数组的最小值和最大值，然后新建一个中间数组（长度为最大值-最小值+1），这个数组的下标用来保存原始数组每个数字出现的次数，最后根据中间数组的结果还原回去
 * 注意事项：原始数组必须是一个确定范围整数数组
 */
object CountingSort {
  
  def main(args: Array[String]): Unit = {
    val arr = Array(2, 5, 3, 0, 2, 3, 0, 3)
    val arr2 = countSort(arr)
    println(Arrays.toString(arr2))
    
  }
  
  def countSort(arr: Array[Int]):Array[Int] = {
    if(arr == null || arr.length == 0){
      null
    }
    
    var max = Integer.MIN_VALUE
    var min = Integer.MAX_VALUE
    
    //1.找出数组中的最小值和最大值
    for(i <- 0 to arr.length - 1){
      max = Math.max(max, arr(i))
      min = Math.min(min, arr(i))
    }
    
    //也可以直接用scala数组方法直接获取最小，最大值
/*    val max = arr.max
    val min = arr.min*/
    
    //2.定义一个新的数组，用来保存每个元素出现的次数,数组长度为:max - min + 1
    val temp = new Array[Int](max - min + 1)
    for(i <- arr){
      temp(i - min) += 1
    }
    
    val res = new Array[Int](arr.length)    //3.定义一个存储最终结果的数组
    var index = 0 //结果数组的下标
    for(i <- 0 to temp.length - 1){
      for(j <- 0 to arr.length - 1;if j < temp(i)){  //temp(i)为这个数出现的频率
        res(index) = i + min //上一步是 i-min,这一步相当于把之前的对应值还原回去
        index += 1
      }
    }
    res
  }
  
}
