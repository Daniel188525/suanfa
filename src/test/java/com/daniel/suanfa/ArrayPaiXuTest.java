/**   
 * Copyright © 2020 trustlife. All rights reserved.
 * 
 * @author: daniel.zhao   
 * @date: 2020年9月25日 下午5:09:47 
 * @version: V1.0   
 */
package com.daniel.suanfa;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ArrayPaiXuTest
 * @Description: 数组排序测试[冒泡/选择/插入]
 * @author: daniel.zhao
 * @date: 2020年9月25日 下午5:09:47
 */
public class ArrayPaiXuTest {

	private static final Logger logger = LoggerFactory.getLogger(ArrayPaiXuTest.class);

	// 大O记法: 只关注步数不关注所用时间
	// O(1) 大 O 1 [常数查找: 表示所有数据增长但步数不变的算法]
	// O(logN) 大 O 对数N [二分查找: 当数据量翻倍时，步数加1]
	// O(N) 大 O N [线性查找: 查找步数在O(1)到O(N之间)]
	// O(N*N) 大 O N方

	// n个元素时: 比较次数 n*(n-1)/2
	// n个元素时: 最大交换次数 n*(n-1)/2
	// n个元素时: 时间复杂度接近于 n*n
	// 冒泡排序: 比较两个相邻的元素，将值大的元素交换至右端
	// 轮回次数: 元素个数 - 1 [外层循环次数]
	// 时间复杂度 大O(N*N)
	/**
	 * 
	 * @Title: testMaoPao
	 * @Description: 冒泡排序[每次轮回都会找出一个最大的数值,排在最右边] 时间复杂度 大O(N*N)
	 * @return: void
	 */
	@Test
	public void testMaoPao() {
		int[] maopao = new int[] { 5, 4, 3, 2, 1 };
		// 比较次数 n*(n-1)/2
		int compareTimes = 0;
		// 交换次数 n*(n-1)/2
		int exchangeTimes = 0;
		for (int i = 0; i < maopao.length - 1; i++) {
			for (int j = 0; j < maopao.length - 1 - i; j++) {
				compareTimes++;
				// 左边的值比右边的大,则交互位置[要求:右边的一定要大于左边的]
				if (maopao[j] > maopao[j + 1]) {
					exchangeTimes++;
					// 交换, 保证右边的大于左边
					int tmp = maopao[j];
					maopao[j] = maopao[j + 1];
					maopao[j + 1] = tmp;
				}
			}
			logger.info("第{}次轮回后: {}", i + 1, maopao);
		}
		logger.info("总的比较次数: {}, 总的交换次数: {}", new Object[] { compareTimes, exchangeTimes });
		logger.info("排序后: {}", maopao);
	}

	// 选择排序[每一个轮回都找出最小值下标,然后和起始位置的值交换]
	// n个元素时
	// 轮回次数: n
	// 比较次数: n*(n-1)/2
	// 最多交换次数: n-1
	// 时间复杂度 大O(N*N/2)
	/**
	 * 
	 * @Title: testXuanZe
	 * @Description: 选择排序[每一个轮回都找出最小值下标,然后和起始位置的值交换, 交换位置后起始位置向后移动]
	 * @return: void
	 */
	@Test
	public void testXuanZe() {
		int[] xuanze = new int[] { 5, 3, 2, 1, 4 };
		// 第一次轮回: 1. 找出最小值下标-3, 起始位置-0; 2. 交换值 -->{ 1, 3, 2, 5, 4 }
		// 第二次轮回: 1. 找出最小值下标-2, 起始位置-1; 2. 交换值 -->{ 1, 2, 3, 5, 4 }
		// 第三次轮回: 1. 找出最小值下标-2, 起始位置-2; 2. 无需交换值 -->{ 1, 2, 3, 5, 4 }
		// 第四次轮回: 1. 找出最小值下标-4, 起始位置-3; 2. 交换之 -->{ 1, 2, 3, 4, 5 }
		for (int i = 0; i < xuanze.length; i++) {
			// 默认起始位置是最小的
			int minIndex = i;
			// 找出最小值下标
			for (int j = i; j < xuanze.length; j++) {
				if (xuanze[minIndex] > xuanze[j]) {
					minIndex = j;
				}
			}
			// 交换起始位置与最小值下标对应的值, 交换位置后起始位置向后移动
			if (minIndex != i) {
				// 起始位置的值
				int tmp = xuanze[i];
				// 最小值
				int min = xuanze[minIndex];
				xuanze[i] = min;
				xuanze[minIndex] = tmp;
			}
			logger.info("第{}次轮回后: {}", i + 1, xuanze);
		}
		logger.info("排序后: {}", xuanze);
	}

	// 插入排序: [大致有序时建议使用插入算法, 若大致逆序则使用选择算法]
	// 1. 以第二个元素为参考值-作为空隙位置,并用一个临时变量保存该参考值;
	// 2. 拿空隙左侧的每一个值与临时变量做对比, 如果左侧的值大于该参考值, 则左侧该值右移一格(a[i] =
	// a[i-1]), 直到最左位置或者参考值大于左侧值-参考值插回该位置
	// 已排好序的有序区: R[1．．i-1]
	// 无序区: R[i．．n]
	// n个元素时: n*n + 2*n -2
	// 轮回次数: n-1
	// 最大比较次数: (n-1)*n/2 接近有 N*N/2
	// 最大移动次数: (n-1)*n/2 接近于 N*N/2
	// 移除次数: n-1
	// 插入次数: n-1
	/**
	 * 
	 * @Title: testChaRu
	 * @Description: 插入排序[Insertion Sort, 类似于整扑克牌]
	 * @return: void
	 */
	@Test
	public void testChaRu() {
		int[] charu = new int[] { 1, 3, 4, 2 };
		int target;
		for (int i = 1; i < charu.length; i++) {
			// 移走的值, 需要插入的数
			target = charu[i];
			int exchangeTimes = 0;
			int j = i;
			while (j > 0 && target < charu[j - 1]) {
				// 右移一位[j-1移动到j位置, 空出j-1用于下次移动]
				charu[j] = charu[j - 1];
				exchangeTimes++;
				logger.info("第{}次轮回, 第{}次移动后: {}", new Object[] { i, exchangeTimes, charu });
				j--;
			}
			// 直到最左边-j为0或者参考值大于左侧值时,直接插回数组移出位置i
			charu[j] = target;
			logger.info("第{}次轮回后: {}", i, charu);
		}
		logger.info("排序后: {}", charu);
	}

	/**
	 * 搜索过程从数组的中间元素开始, 如果中间元素正好是要查找的元素, 则搜索过程结束; 如果某一特定元素大于或者小于中间元素,
	 * 则在数组大于或小于中间元素的那一半中查找, 而且跟开始一样从中间元素开始比较. 如果在某一步骤数组为空，则代表找不到
	 * 
	 * @Title: testErFen
	 * @Description: 二分查找-有序数组
	 * @return: void
	 */
	@Test
	public void testErFen() {
		int index = -1;
		int key = 6;
		int[] erfen = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		// int low = 0;
		// int high = erfen.length - 1;
		// index = recursionBinarySearch(erfen, key, low, high);
		index = commonBinarySearch(erfen, key);
		logger.info("二分查找元素下标为: {}", index);
	}

	/**
	 * 
	 * @Title: recursionBinarySearch
	 * @Description: 二分查找递归实现
	 * @return: int
	 */
	private int recursionBinarySearch(int[] arr, int key, int low, int high) {
		if (key < arr[low] || key > arr[high] || low > high) {
			return -1;
		}
		int mid = (high + low) / 2;
		if (arr[mid] > key) {
			return recursionBinarySearch(arr, key, low, mid - 1);
		} else if (arr[mid] < key) {
			return recursionBinarySearch(arr, key, mid + 1, high);
		} else {
			return mid;
		}
	}

	/**
	 * 
	 * @Title: commonBinarySearch
	 * @Description: 传统非递归方式的二分查找
	 * @return: int
	 */
	private int commonBinarySearch(int[] arr, int key) {
		int mid;
		int low = 0;
		int high = arr.length - 1;
		if (key < arr[low] || key > arr[high] || low > high) {
			return -1;
		}
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] > key) {
				high = mid - 1;
			} else if (arr[mid] < key) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	// 以选定值为轴进行左右分区, 小于选定值的在左边, 大于选定值的在右边, 选定值放在中间
	// 时间复杂度O(N*N)
	/**
	 * 
	 * @Title: quickSort
	 * @Description: 快速排序
	 * @return: void
	 */
	@Test
	public void quickSort() {
		int[] quickSort = new int[] { 6, 1, 2, 7, 9, 3, 4, 5, 10, 8 };
		// 左侧哨兵索引
		int left = 0;
		// 右侧哨兵索引
		int rigth = quickSort.length - 1;
		quickSort(quickSort, left, rigth);
		logger.info("quick sort: {}", quickSort);
	}

	/**
	 * 
	 * @Title: quickSort
	 * @Description: 快速排序
	 * @return: void
	 */
	private void quickSort(int[] arr, int left, int rigth) {
		if (left > rigth) {
			return;
		}
		int i = left;
		int j = rigth;
		// 以最左边为基准数,
		// 1. 当已最左边为基准数时需要先从右边往左找,直到找到比base小的数停下;
		// 2. 然后,左指定向右移动,直到找到比base大的数停下,交换两个位置上的值
		// 3. 循环上面的 1 2 步骤,直到左右指针在同一个位置,然后与base交换
		int base = arr[left];
		while (i < j) {
			// 先看右边, 一直往左移动, 直到遇到比base小的值停下
			while (base < arr[j] && i < j) {
				// 右侧指定一直向左移动
				// 当所指定的值比base大时,则继续左移[j--操作]
				// 直到找到比base小时,不满足while条件则终止循环
				j--;
			}
			// 然后看左边, 一直往右移动, 直到遇到比base大的值停下
			while (base >= arr[i] && i < j) {
				i++;
			}
			// 索引没重合时, 则交换
			if (i < j) {
				int tmpLeft = arr[i];
				int tmpRigth = arr[j];

				arr[i] = tmpRigth;
				arr[j] = tmpLeft;
			}
		}
		// 最后交换基准值
		arr[left] = arr[i];
		arr[i] = base;

		// 递归调用 快速排序左侧数组
		quickSort(arr, left, j - 1);

		// 递归调用 快速排序右侧数组
		quickSort(arr, j + 1, rigth);
	}
}
