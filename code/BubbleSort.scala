package com.scala.datastructure

import java.util.Arrays

/**
 * 冒泡排序
 * 主要思路：每一趟比较相邻的元素，如果第一个比第二个大，就交换这两个数的位置
 */
object BubbleSort {
  
  def main(args: Array[String]): Unit = {
    val arr = Array(78,34,12,64,5,4,62,99,98,54,56)
    bubbleSort(arr)
    println(Arrays.toString(arr))
  }
  
  def bubbleSort(arr: Array[Int]) = {
    for(i <- 0 until arr.length - 1){
      for(j <- 0 until arr.length - 1 - i){//完成一次外循环，末尾就是最大值，不参与下一次外循环的比较
        if(arr(j) > arr(j + 1)){
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
      println(s"""第${i + 1}趟排序:""" + Arrays.toString(arr))
    }
  }
  
}
