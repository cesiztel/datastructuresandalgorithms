"""
Problem statement:

Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?
"""
def isUniqueCharsBF(input: str) -> bool:
    """
        Time complexity: O(n^2) / Space complexity: O(1)
    """
    if  len(input) > 128:
        return False # Bigger than the alphabet, so there duplicates

    for index in range(len(input)):
        single_char = input[index]

        for second_index in range(index + 1, len(input)):
            if single_char == input[second_index]:
                return False

    return True #  

def isUniqueCharsWithASCII(input: str) -> bool:
    """
        Time complexity: O(n) / Space complexity: O(1)
    """
    if  len(input) > 128:
        return False # Bigger than the alphabet, so there duplicates
    
    # Note1: can be 256 on the extended ASCII
    # Note2: all the boolean init as false
    char_set = [False for i in range(128)]
    for index in range(len(input)):
        ascii_value = ord(input[index])
        if char_set[ascii_value]:
            return False
        
        char_set[ascii_value] = True
    
    return True