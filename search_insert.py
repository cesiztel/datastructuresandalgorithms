"""
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

    Input: nums = [1,3,5,6], target = 5
    Output: 2
    Example 2:

    Input: nums = [1,3,5,6], target = 2
    Output: 1
    Example 3:

    Input: nums = [1,3,5,6], target = 7
    Output: 4
 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums contains distinct values sorted in ascending order.
    -104 <= target <= 104

"""
def search(nums: list, target: int) -> int:
    max: int = len(nums) - 1
    min: int = 0
    pivot: int = 0

    while min <= max:
        pivot = int(((max - min) / 2) + min)

        if nums[pivot] == target:
            return pivot

        if target > nums[pivot]:
            min = pivot + 1
        else:
            max = pivot - 1
    
    return min