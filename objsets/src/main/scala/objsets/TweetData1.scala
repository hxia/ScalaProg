package objsets

// real tweet data, collected on Oct 1
object TweetData1 {
  val gizmodo = """[
{ "user": "gizmodo", "text": "Meet the new Apple, where things don't just work http://t.co/XS36kHWi", "retweets": 146.0 },
{ "user": "gizmodo", "text": "Cheap goodies on Google Play for the next five days: http://t.co/dT3bRBzZ", "retweets": 52.0 },
{ "user": "gizmodo", "text": "Do phones need to come with chargers these days? http://t.co/AZMsPUeD", "retweets": 21.0 },
{ "user": "gizmodo", "text": "Foxconn has shut down a factory after 2,000 of its employees started a massive brawl. http://t.co/d7TXo3K9", "retweets": 90.0 },
{ "user": "gizmodo", "text": "If you thought the NES Zapper was cool before, watch it set things on fire with a laser. http://t.co/t3f0oE8O", "retweets": 37.0 },
{ "user": "gizmodo", "text": "Want to hack NFC to get free train rides? There's an app for that. http://t.co/eAp6yTbE", "retweets": 82.0 },
{ "user": "gizmodo", "text": "The weirdest thing people hate about the iPhone 5: http://t.co/GMwuRp8D", "retweets": 202.0 },
{ "user": "gizmodo", "text": "This $50 stick turns any HDTV into an Android-powered smart TV: http://t.co/8FpZUnIE", "retweets": 101.0 },
{ "user": "gizmodo", "text": "If you're going to get a Nexus 7, you should just go out and buy it right now. http://t.co/tACY1YYG", "retweets": 33.0 },
{ "user": "gizmodo", "text": "Data centers waste a completely absurd amount of energy. http://t.co/NcO9pXqb", "retweets": 58.0 }
]"""
  val TechCrunch = """[
{ "user": "TechCrunch", "text": "PadPivot NST Review: The Best Available iPad Stand Just Got Better http://t.co/YJWkwkDd by @drizzled", "retweets": 11.0 },
{ "user": "TechCrunch", "text": "AngelList Wings Is A Handy App For Searching AngelList On Your iPhone http://t.co/tJwqOMdi by @sarahintampa", "retweets": 7.0 },
{ "user": "TechCrunch", "text": "Google Updates Gmail For iOS With Support For The iPhone 5's Larger Screen http://t.co/4fQ7YqYn by @fredericl", "retweets": 41.0 },
{ "user": "TechCrunch", "text": "Well Played On Maps, Apple. Your Move, Google. http://t.co/kJvuAfw9 by @thatdrew", "retweets": 70.0 },
{ "user": "TechCrunch", "text": "Soon-To-Be-Acquired BlueSprig's AirCover Family Locator Is An iOS/Android App That Lets You Track ... http://t.co/qSQquuLS by @ingridlunden", "retweets": 24.0 },
{ "user": "TechCrunch", "text": "Data Markets: The Emerging Data Economy   http://t.co/lnTekycH by @gilelbaz", "retweets": 63.0 },
{ "user": "TechCrunch", "text": "Flat-Fee, Dongle-free Card Payments Startup Emu Opens For Business In U.K., Registrations In Europe http://t.co/cILxZAVn by @riptari", "retweets": 27.0 },
{ "user": "TechCrunch", "text": "Report: Apple's Pandora-Killer Hits Licensing Trouble With Sony/ATV http://t.co/7sV1BMb8 by @drizzled", "retweets": 55.0 },
{ "user": "TechCrunch", "text": "LinkedIn Shuts Off API Access To Fellow Professional Social Network Viadeo For TOS Violations http://t.co/nAFHWLQ4 by @leenarao", "retweets": 31.0 },
{ "user": "TechCrunch", "text": "iOS 6 Adoption At Just Over One Week: 60% For iPhone And 41% For iPad http://t.co/Q0HAgCz8 by @drizzled", "retweets": 125.0 },
{ "user": "TechCrunch", "text": "Business Dashboards Get Instant Widgets, And Geckoboard Gets $1.5M From A Group Of Top Investors http://t.co/lDMDJUMQ by @ingridlunden", "retweets": 29.0 },
{ "user": "TechCrunch", "text": "BlackBerry 10 Touch, Qwerty Devices Leak In Video; RIM Wants Lady Gaga To Help Sell BB10 http://t.co/7rFGECgA by @riptari", "retweets": 36.0 },
{ "user": "TechCrunch", "text": "Neil Young Begins His Long Quest Towards True Audio Fidelity With Pono, A New Music Service And Device http://t.co/t1Ez2d26 by @johnbiggs", "retweets": 34.0 },
{ "user": "TechCrunch", "text": "Socialize's New Ad Platform Turns Passbook Passes Into Mobile Ads http://t.co/I2aku6yx by @sarahintampa", "retweets": 21.0 },
{ "user": "TechCrunch", "text": "An Afternoon With Bad Piggies, Rovio's Next Hit http://t.co/KpYlmFSQ by @jordanrcrook", "retweets": 18.0 },
{ "user": "TechCrunch", "text": "Most Docks Should Work With The Lightning Adapter And iPhone 5 http://t.co/oGlTupcK by @johnbiggs", "retweets": 13.0 }
]"""
  val engadget = """[
{ "user": "engadget", "text": "Sony reveals Japan prices for Windows 8 VAIO machines -  http://t.co/FRCu2XVb", "retweets": 18.0 },
{ "user": "engadget", "text": "FreedomPop's pay-as-you-go data service launches in beta, offering 500MB of free WiMAX per month -  http://t.co/Ny48yXUl", "retweets": 10.0 },
{ "user": "engadget", "text": "Lenovo intros ThinkCentre M78 with AMD A-Series APU and a starting price of $449 -  http://t.co/OEDe1EwW", "retweets": 22.0 },
{ "user": "engadget", "text": "HP announces the ElitePad 900, a business-friendly Windows 8 tablet arriving in January -  http://t.co/RjSj2cms", "retweets": 33.0 },
{ "user": "engadget", "text": "How would you change Nokia's Lumia 900? -  http://t.co/kW4MqiCv", "retweets": 8.0 },
{ "user": "engadget", "text": "Cubify lets you skin, 3D print your own personal Android -  http://t.co/S6nimh5R", "retweets": 23.0 },
{ "user": "engadget", "text": "PSA: $25 Google Play credit for Nexus 7 ends this weekend -  http://t.co/3iyUo8iK", "retweets": 32.0 },
{ "user": "engadget", "text": "Facebook Messenger for BlackBerry reaches App World, sates compulsive chatters -  http://t.co/ZmuNQLjs", "retweets": 20.0 },
{ "user": "engadget", "text": "RIM: first BlackBerry 10 devices to focus on mid-range and up, entry-level may be ready in 2013 -  http://t.co/OMQMLJvs", "retweets": 34.0 },
{ "user": "engadget", "text": "RT @EngadgetDistro: Since iOS 6's launch, how happy are you with Apple's Maps app?", "retweets": 25.0 },
{ "user": "engadget", "text": "Harman shows off its upcomming JBL docks and speakers, we go eyes-on -  http://t.co/5bz8UCBo", "retweets": 7.0 },
{ "user": "engadget", "text": "From the lab: Lumia 920 image stabilization and 808 drop test at Nokia R&amp;D (video) -  http://t.co/s9zFp7hU", "retweets": 13.0 },
{ "user": "engadget", "text": "Sony's Xperia T is now available on O2 and ThreeUK, Walther PPK/S not included -  http://t.co/LlZsSzqQ", "retweets": 7.0 }
]"""
  val amazondeals = """[
{ "user": "amazondeals", "text": "Deal of the Day: 50% Off Select BEARPAW Boots &amp; Slippers http://t.co/ZBvpSN33", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $38.69 - Honeywell Portable Wireless Door Chime and Push Button http://t.co/yYBV4ebr", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $124.99 - Ritmo Mundo Unisex White Sport Quartz Watch http://t.co/RfungjJC", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $129.99 - Giulio Romano Piemonte Black Silicone Watch http://t.co/7v1ovQCQ", "retweets": 1.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $59.99 - Stuhrling Original Men's Roulette Swiss Quartz Watch http://t.co/vreVCFvJ", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! Marware Microshell for Fire (not for HD) http://t.co/Mtb1Uoea", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! Belkin Quilted Case for Fire HD 7\" http://t.co/gxpUszgw", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $9.99 - Brother PT90 Personal Labeler http://t.co/pJuiSxZn", "retweets": 0.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $39.99 - TRENDnet 200 Mbps Powerline Ethernet AV Adapter Kit http://t.co/AhwHHIUD", "retweets": 2.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $299.99 - Neato XV-11 All-Floor Robotic Vacuum System http://t.co/jQTTi3Im", "retweets": 2.0 },
{ "user": "amazondeals", "text": "Lightning Deal! $101.15 - BISSELL Lift-Off Steam Mop http://t.co/kE5YhYZZ", "retweets": 2.0 },
{ "user": "amazondeals", "text": "Deal of the Day: Starting from $3.99 Each: Essential MP3 Albums for Your Collection http://t.co/wotNjjir", "retweets": 5.0 }
]"""
  val CNET = """[
{ "user": "CNET", "text": "HP aims for business users with ElitePad 900 Windows 8 tablet http://t.co/XyOipAdL", "retweets": 10.0 },
{ "user": "CNET", "text": "RT @CNETNews: Apple rolls out fix for iPhone 5 Wi-Fi network data bug http://t.co/Gz13JfDD", "retweets": 93.0 },
{ "user": "CNET", "text": "Ever wonder how your iPhone screen got its color? (Video) http://t.co/Fq9FFbnc", "retweets": 29.0 },
{ "user": "CNET", "text": "The Kindle Paperwhite rises to the top of the e-reader pack  http://t.co/QVXp6P0H", "retweets": 19.0 },
{ "user": "CNET", "text": "How to switch from iPhone to Android http://t.co/M8I9lwua", "retweets": 131.0 },
{ "user": "CNET", "text": "Let's crack open the iPhone 5! (video) http://t.co/4tiuroNg", "retweets": 30.0 },
{ "user": "CNET", "text": "Leak: Photos of RIM's BlackBerry 10 phones hit the web http://t.co/X0OvqMwL", "retweets": 46.0 },
{ "user": "CNET", "text": "RT @CNETNews: Apple's Tim Cook: We are \"extremely sorry\" about those problems with iOS 6 Maps http://t.co/rlcCUgQO", "retweets": 114.0 },
{ "user": "CNET", "text": "Samsung Galaxy Music leak shows budget music phone http://t.co/aTAjDKk2", "retweets": 14.0 },
{ "user": "CNET", "text": "Bad Piggies review: Angry Birds follow-up bolts on complexity http://t.co/lmfK0Yjd", "retweets": 16.0 },
{ "user": "CNET", "text": "HTC One X+ turns up in O2 brochure, Jelly Bean in tow http://t.co/MGvjw24E", "retweets": 26.0 }
]"""
  val gadgetlab = """[
{ "user": "gadgetlab", "text": "A Clean, Well-Lighted Face: The Kindle Paperwhite http://t.co/WlUPzZbS by @strngwys", "retweets": 11.0 },
{ "user": "gadgetlab", "text": "Maps? Purple halos in photos? Screen glitches? What? iPhone 5 'problems' explained http://t.co/xVGBVhGE by @redgirlsays", "retweets": 22.0 },
{ "user": "gadgetlab", "text": "Tim Cook apologizes for Mapocalypse debacle, offers interim fixes http://t.co/ahPbLcU5 by @redgirlsays", "retweets": 18.0 },
{ "user": "gadgetlab", "text": "Pretty Cities: Google Maps Improves Aerial Images http://t.co/nEopgNpY by @alexandra_chang", "retweets": 7.0 },
{ "user": "gadgetlab", "text": "#Apple: More than 700,000 apps in App Store &amp; 250,000 specifically for iPad http://t.co/DwtKQkSu #iPhone5 LIVEBLOG by @redgirlsays", "retweets": 6.0 },
{ "user": "gadgetlab", "text": "#Apple CEO Tim Cook: 7million copies of Mountain Lion downloaded so far. Fastest selling version of OS X ever http://t.co/DwtKQkSu LIVEBLOG", "retweets": 10.0 },
{ "user": "gadgetlab", "text": "Apple has 380 stores in 12 countries. On Friday it will open a store in its 13th, Sweden. http://t.co/5AtpHCfY #Apple #iPhone5 LIVEBLOG", "retweets": 11.0 },
{ "user": "gadgetlab", "text": "#Apple CEO Tim Cook takes the stage at #iPhone5 event, has \"really cool stuff to show you.? http://t.co/DwtKQkSu liveblog by @redgirlsays", "retweets": 25.0 },
{ "user": "gadgetlab", "text": "RT @wired: FYI, @wired's liveblog photos are Creative Commons - repost, if you like, with link and license http://t.co/PewWjvwX", "retweets": 26.0 },
{ "user": "gadgetlab", "text": "Soon, photos from the inside of Apple's iPhone 5 event. @redgirlsays + @johnwbradley are on the scene... http://t.co/2mqmIhVB", "retweets": 14.0 },
{ "user": "gadgetlab", "text": "Apple iPhone 5 event LIVEBLOG: the event starts in 30 mins but we've got some photos of reporters standing in line! http://t.co/2mqmIhVB", "retweets": 26.0 },
{ "user": "gadgetlab", "text": "http://t.co/z7Dsi93S Search Confirms iPhone 5 with LTE Support, Plus New iPods http://t.co/a7mZnloy by @alexandra_chang", "retweets": 30.0 },
{ "user": "gadgetlab", "text": "@redgirlsays on the scene at Apple's iPhone 5 unveiling &amp; she has photos...of the outside of the event. Inside soon! http://t.co/5AtpHCfY", "retweets": 0.0 },
{ "user": "gadgetlab", "text": "Demoing at an Apple Event: Secretive, Stressful, and (Probably) Worth It http://t.co/7NOIDSJw by @strngwys", "retweets": 11.0 }
]"""
  val mashable = """[
{ "user": "mashable", "text": "Which is sorriest, #Apple Maps or #Siri? @Charlie_White has the comic - http://t.co/YRXXJXGY", "retweets": 55.0 },
{ "user": "mashable", "text": "Watch These Quadrotor #Robots Learn to Play Catch [VIDEO] http://t.co/CHZ5BPfL", "retweets": 21.0 },
{ "user": "mashable", "text": "10 Funny @YouTube Clips of Sleeping Dogs http://t.co/ukPgWZjH", "retweets": 34.0 },
{ "user": "mashable", "text": "65 Digital Media Resources You May Have Missed http://t.co/u1LJWc22", "retweets": 64.0 },
{ "user": "mashable", "text": ".@HP Shows What @Windows 8 #Tablets for Business Will Look Like [PICS] http://t.co/Md6ua8Xc", "retweets": 32.0 },
{ "user": "mashable", "text": "Twice as Many #Mobile News Readers Prefer Browsers to #Apps [STUDY] http://t.co/lEXhVLLJ", "retweets": 40.0 },
{ "user": "mashable", "text": "7 Free #Android Apps for Killing Time in Lines http://t.co/eKu5hhsh", "retweets": 42.0 },
{ "user": "mashable", "text": "Spookiest Smartphone Malware Yet? http://t.co/5Kk1DyPg via @TheAtlantic", "retweets": 57.0 },
{ "user": "mashable", "text": "5 Mobile Photographers Capturing the World With #Android http://t.co/786NneBt", "retweets": 78.0 },
{ "user": "mashable", "text": "Take 100 NASA Photos, Stir, Make Van Gogh's 'Starry Night' http://t.co/dQv6mvwI", "retweets": 73.0 },
{ "user": "mashable", "text": "Why Being Unfriended on Facebook Hurts [STUDY] http://t.co/0eHHUrTo", "retweets": 51.0 },
{ "user": "mashable", "text": "Think Apple Maps Is Bad? Remember the Tale of MobileMe http://t.co/Koeew9eU", "retweets": 41.0 }
]"""
}
