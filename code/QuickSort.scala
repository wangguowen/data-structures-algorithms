package com.scala.datastructure

import java.util.Arrays

/**
 * 快速排序
 * 主要思路：选定一个目标数(哨兵),默认数组第一个为目标数，从右边开始找小于等于此目标数的数，然后再从左边开始找大于等于此目标数的值，
 * 满足条件的情况下交换这两个值的位置，当左边开始的下标索引大于等于右边开始的下标索引时，交换此时目标数与左边下标数的位置，这样目标数左边部分都是
 * 小于目标数的值，右边部分都是大于目标数的值，分别再对左边部分，右边部分递归做快速排序即可
 */
object QuickSort {

  def main(args: Array[String]): Unit = {
    val arr = Array(34, 78, 12, 64, 5, 4, 62, 99, 98, 54, 16)
    println("排序前数组:" + Arrays.toString(arr))
    quickSort(arr, 0, arr.length - 1)
    println("排序后数组:" + Arrays.toString(arr))
  }

  /**
   * @param arr 原始数组
   * @param left 数组左边部分
   * @param right 数组右边部分
   */
  def quickSort(arr: Array[Int], left: Int, right: Int): Array[Int] = {
    var start = left
    var end = right
    val target = arr(left) //定义一个目标数(哨兵)，默认从数组第一个，左边开始

    while (start < end) {
      //先从右边部分开始移动，下标往左滑动
      while (target <= arr(end) && start < end) {
        end -= 1
      }
      //再从左边开始移动，下标往右滑动
      while (target >= arr(start) && start < end) {
        start += 1
      }

      //满足条件时，交换这两个数的位置，即把大于目标数的放到右边，小于目标数的放到左边
      if (start < end) {
        val temp = arr(end)
        arr(end) = arr(start)
        arr(start) = temp
        println("start:" + start + ",end:" + end + ",满足条件后排序:" + Arrays.toString(arr))
      }
    }
    
    println("start大于等于end时:" + "target为" + target + ",start为" + start + ",end为" + end + ",left为" + left + ",right为" + right)
    println("----------------------------------------------------------")
    //当左右两边下标相遇时，交换
    arr(left) = arr(start)
    arr(start) = target
    //递归对左边部分,右边部分快速排序
    if (start > left) quickSort(arr, left, end - 1)
    if (end < right) quickSort(arr, end + 1, right)
    arr
  }
}