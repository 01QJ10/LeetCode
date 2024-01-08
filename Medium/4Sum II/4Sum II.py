class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        from collections import defaultdict
        result = 0
        temp = defaultdict(int)
        for i in nums1:
            for j in nums2:
                count = i + j
                temp[count]+= 1
        for k in nums3:
            for l in nums4:
                count = k + l
                result += temp[-count]
        return result