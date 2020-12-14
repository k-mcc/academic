# practicing basic API integration with python
# 12.7.20

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


def getSentence(word1,word2): # if word2 == thisPartOfSpeech then ...
    response = requests.get('https://lt-nlgservice.herokuapp.com/rest/english/{0}?subject={1}&verb={2}&object={3}'.format("realise",str(word1),"want",str(word2)))
    response_json = response.json()
    sentence = json_extract(response_json, "sentence")
    return sentence[0]

#def getPos(words):

#    for w in words:
#        tmp = wn.synsets(w)[0].pos()
#        print w, ":", tmp



def syllableCount(word):
    word = word.lower()
    count = 0
    vowels = "aeiouy"
    if word[0] in vowels:
        count += 1
    for index in range(1, len(word)):
        if word[index] in vowels and word[index - 1] not in vowels:
            count += 1
    if word.endswith("e"):
        count -= 1
    if count == 0:
        count += 1
    return count



word1 = promptWords("Please enter your first name")

words = getRhyme(word1)

#pos = getPos(words[:31])
#for i in range(30):
    #print(words[i])

words = words[:31]
randomWord = random.choice(words)

print("Word: {}".format(randomWord))

sentence = getSentence(word1,randomWord)[4:]
print("Sentence: {}".format(sentence))

print(syllableCount(sentence))
