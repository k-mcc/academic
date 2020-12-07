# practicing basic API integration with python
# 12.5.20

import requests
import json
import random

def json_extract(obj, key):
    """Recursively fetch values from nested JSON."""
    arr = []

    def extract(obj, arr, key):
        """Recursively search for values of key in JSON tree."""
        if isinstance(obj, dict):
            for k, v in obj.items():
                if isinstance(v, (dict, list)):
                    extract(v, arr, key)
                elif k == key:
                    arr.append(v)
        elif isinstance(obj, list):
            for item in obj:
                extract(item, arr, key)
        return arr

    values = extract(obj, arr, key)
    return values

def promptWords(prompt):
    input = raw_input("{}:\t".format(prompt))
    return input

def getRhyme(word):
    response = requests.get('https://rhymebrain.com/talk?function=getRhymes&word={}'.format(str(word)))
    response_json = response.json()
    rhymingWords = json_extract(response_json, "word")
    return rhymingWords


word1 = promptWords("Please enter your first name")

words = getRhyme(word1)

for i in range(10): #len(rhymingWords)
    print(words[i])

print("Word: {}".format(random.choice(words)))
