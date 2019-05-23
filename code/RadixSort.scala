package com.scala.datastructure

import java.util.Arrays

/**
 * 基数排序
 * 主要思想：从最低位开始，对该位数上的值依次进行一次计数排序，这样从最低位排序一直到最高位排序完成以后, 数组就变成一个有序序列
 */
object RadixSort {

  def main(args: Array[String]): Unit = {
    val arr = Array(53,3,542,748,14,214,154,63,616)
    println("排序前:" + Arrays.toString(arr))
    radixSort(arr)
    println("排序后:" + Arrays.toString(arr))
  }

  def radixSort(arr: Array[Int]) = {
    
    val length = arr.length

    if (arr == null || length == 0) {
      null
    }
    
    //数组中的最大值
    var max = arr.max
    
    //最大值的位数
    var maxDigits = 0 
    while(max > 0){
      max = max / 10
      maxDigits += 1
    }
    
    var digits = 1 //位数（1-个数，10-十位，依次类推）,从最低位个位开始比较 
    for(i <- 1 to maxDigits){
      countSort(arr, length, digits)
      digits = digits * 10
    }

  }

  /**
   * 对每一个位数上的数字进行计数排序
   * @param arr 原始数组
   * @param length 原始数组的长度
   * @param digits 位数（1-个数，10-十位，依次类推）
   */
  def countSort(arr: Array[Int], length: Int, digits: Int) = {
    //定义一个中间数组
    val temp = new Array[Int](length)

    //定义一个桶(概念)数组，长度是10，用来存放0-9数字
    val bucket = new Array[Int](10)

    /**
     * 将数组中出现的数字次数存储到桶数组中
     * 下标对应数字出现的次数，比如Array(53,3,542,748,14,214,154,63,616),按个位上的数字存储bucket为(0,0,1,3,3,0,1,0,1,0)
     */
    for (i <- 0 to length - 1) {
      val num = arr(i) / digits % 10
      bucket(num) += 1
    }

    //将桶数组的每个下标的值转换成小于等于它的值的个数
    for (i <- 1 to 9) {
      bucket(i) += bucket(i - 1)  //按照示例数据，个位数时bucket为(0,0,1,4,7,7,8,8,9,9)
    }

    //倒序遍历数组，将元素放入正确的位置
    for (i <- (0 to length - 1).reverse) {
      temp(bucket(arr(i) / digits % 10) - 1) = arr(i) //个数上的数字依次是(3,3,2,8,4,4,4,3,6),根据上一步bucket(6)=8,因为有9个数字，说明616要放在temp的第8个位置上，也就是下标为7的位置
      bucket(arr(i) / digits % 10) -= 1       //对应数字上的次数要减1
    }
    
    //将排好序的数据赋值给原数组
    for(i <- 0 to length - 1){
      arr(i) = temp(i)
    }

  }

}