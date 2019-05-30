package com.scala.datastructure

import java.util.Arrays

/**
 * 选择排序
 * 主要思路：首先，找到数组中最小的那个元素，其次，将它和数组的第一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。其次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序
 */
object SelectSort {
  
  def main(args: Array[String]): Unit = {
    val arr = Array(78,34,12,64,5,4,62,99,98,54,56)
    println("排序前数组:" + Arrays.toString(arr))
    selectSort(arr)
    println("排序后数组:" + Arrays.toString(arr))
  }
  
  def selectSort(arr: Array[Int]) = {
    val length = arr.length
    for(i <- 0 until length - 1){    //需要比较的元素个数
      //最小值的下标，默认数组第一个元素
      var min = i  
      for(j <- i + 1 until length){
        //大于的话改变最小值的下标
        if(arr(min) > arr(j)) min = j    
      }
      
      //交换一开始默认的最小值下标与找到最小值的值的下标
      val temp = arr(i)
      arr(i) = arr(min)
      arr(min) = temp
    }
  }
}