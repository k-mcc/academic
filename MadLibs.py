# Kate McCarthy
# Python Practice
# 12.4.2020
import random

pos1 = ["noun","organization", "verb ending in \"s\"", "plural nickname", "verb ending in \"ing\"", "command", "command"]
s1 = "What came first, the chicken or the {}? \nAccording to {}, the first domesticated chicken sightings in Egypt \nearned chickens the nickname of the \"bird that {} every day.\" \nIn the modern day, however, we usually refer to chickens as \"{}.\" \nFlocks typically establish a {} order. This important order dictates which chickens of the flock will {} and which ones will {}."

pos2 = ["bad movie", "person", "posession", "verb ending in \"ing\"", "thing", "person", "first thing you said when you woke up today", "fictional character", "super specific location", "something you make", "verb ending in \"ing\"", "description of a person", "opposite of your previous response", "CVS product", "liquid", "underrated snack", "plural animal"]
s2 = "Like they say in {}, \"All I want for Christmas is {}\'s {}\". \n\'Tis the season of {}, so I bought a {} as a gift for {}. I hope they say \"{}\" when they open it. \n{} is real and they are coming to {} at the end of the month. They are making a {} and {} it twice. \nThey WILL see who is {} or {}. \nBe sure to leave out {} and {}! Oh, and don't forget the {} for the {}."

pos3 = ["specific adjective", "if your hair style had a name", "mood", "something annoying, plural", "slang phrase", "comparative adjective (ends in \"est\" or \"er\")", "instrument", "tv show from your childhood"]
s3 = "Music is {}. The song {} by the {} {} demonstrates my point perfectly. \nIn the first verse, the lead singer says, \"{}\" I cannot help but tear up every time. \nThe {} part is at the {} drop when they sing the theme song from {}."

prompts = [pos1, pos2, pos3]
stories = [s1, s2, s3]

story = random.choice(stories)
prompt = prompts[stories.index(story)]

fullStory = story[:]

for i in range(len(prompt)):
    if i == 0:
        input_variable = raw_input("Enter a {}:\t\t".format(prompt[i]))
    input_variable = raw_input("{}:\t\t".format(prompt[i]))
    fullStory = fullStory.replace("{}", str(input_variable), 1)

print(fullStory)
