# Kate McCarthy
# Python Practice
# 12.4.2020

import random

class Song:

    subjects = {"I":True, "They":True, "People":True, "Real friends":True, "Fake friends":True, "You":True}
    verbs = {"Respect":2,"Know":1,"Get":1,"Joke about":3,"Win":1,"Jump on":2,"Buy":1,"Take":1,"Love":1,"Like":1,"Hate":1,"Run":1,"Hide":1,"Sleep through":2,"Chill in":2}
    nouns = {"Chopper":2,"Scooter":2,"Easter":2,"Customers":3,"The Freezer":3,"Laser tag":3,"October":3,"The Astronaut":3,"Swag":1,"Nike":1,"Tech":1,"Project":2,"Pluto":2,"Instagram":3,"Tempo":2,"My Spaghetti":4,"Aftermath":3,"A Bandwagon":4,"A Sermon":23,"Some Bamboo":3,"Zero":2,"Confession":3,"Toronto":3,"Your Evidence":4,"Funk":1,"Kodak":2,"Lemonade":3,"Private Jet":3,"Zoom":1,"Reputation":4,"Superhero":4,"Metaphor":3,"Award":2}

    def __init__(self, title, artist):
        self.title = title
        self.artist = artist
        self.rating = 0
        self.lyrics = []

    def printLyrics(self):
        if len(self.lyrics) > 0:
            for i in range(len(self.lyrics)):
                print(self.lyrics[i])
        else:
            print("Song has no lyrics")

    def generateLyric(self):
        self.subject = str(random.choice(list(self.subjects.keys())))
        self.verb = str(random.choice(list(self.verbs.keys())))
        self.noun = str(random.choice(list(self.nouns.keys())))
        self.combined = self.subject + " " + self.verb + " " + self.noun + "."
        self.lyrics.append((self.combined).capitalize())


s1 = Song("Stars", "The Band")



print(s1.title)
print(s1.artist)
print(s1.rating)

for i in range(random.randint(3,5)):
    s1.generateLyric()

s1.printLyrics()
