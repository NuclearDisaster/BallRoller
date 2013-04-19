package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	int timer = (int) System.currentTimeMillis();
	Image bg, gameOver, scene1, scene2, scene3, scene4, scene5, scene6, scene7,
			scene8, scene9, scene10, scene11, scene12, scene13, scene14,
			scene15, arrow; // Start Background
	// Booleans
	boolean quit = false;
	boolean nextSlide = false; 
	boolean prevSlide = false;
	boolean decision = false; // If system prints out the 4 selections or not
	boolean correct; // is answer correct?
	byte gamePart = 1;
	// Switch Statement Variables
	int leSlide = 0;
	byte leSpeed = 80; // Speed of Text :S
	byte choice; // Which one chosen?
	byte showArrow; // Where to show the arrow
	//Traits
	byte empathy;
	byte skill;
	byte knowledge;
	// Printing String Variables
	String currentPrint;
	String textBreak;
	String decisions;

	int counter = 1;
	// Decisions
	String d1;
	String d2;
	String d3;
	String d4;
	// Choices
	String c1;
	String c2;
	String c3;
	String c4; 
	String ERROR = "You have encountered an error, please exit the game!"; // ErrorMessage
	String mouseOver = "NO DATA";

	public Play(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		// IMAGE OBJECTS
		bg = new Image("res/z.jpg");
		gameOver = new Image("res/gameover.jpg");
		scene1 = new Image("res/Scene 1.jpg");
		scene2 = new Image("res/Scene 2.jpg");
		scene3 = new Image("res/Scene 3.jpg");
		scene4 = new Image("res/Scene 4.jpg");
		scene5 = new Image("res/Scene 5.jpg");
		scene6 = new Image("res/Scene 6.jpg");
		scene7 = new Image("res/Scene 7.jpg");
		scene8 = new Image("res/Scene 8.jpg");
		scene9 = new Image("res/Scene 9.jpg");
		scene10 = new Image("res/Scene 10.jpg");
		scene11 = new Image("res/Scene 11.jpg");
		scene12 = new Image("res/Scene 12.jpg");
		scene13 = new Image("res/Scene 13.jpg");
		scene14 = new Image("res/Scene 14.jpg");
		scene15 = new Image("res/Scene 15.jpg");
		arrow = new Image("res/arrow.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		int xpos = Mouse.getX(), ypos = Mouse.getY(); // mouse coordinates
		Input input = gc.getInput(); // get input from mouse 
		// Switch leSlide case 1-8
		switch (leSlide) {
		case 0:
			bg.draw();
			if (gamePart == 1) {
				scene1.draw();
				currentPrint = Part1.INTRO;
				decision = true;
				d1 = "Decision 1: Ignore the mass influx of statuses and treat this as a joke";
				/* answer */d2 = "Decision 2: Inform the class";
				d3 = "Decision 3: Sprint out the door by myself";
				d4 = "Decision 4: Barricade the door";
				// Choices
				c1 = "Soon after, the PA came on again and someone informed us that the undead \n"
						+ "were wandering around the school.. we had run out of time... with little to nothing\n"
						+ "to eat in the classroom we slowly started to starve. YOU FAILED!, RESTART?";
				c2 = "Since we were in a room filled with computers, i loaded up a news website on the \n"
						+ "computer and informed the class, I stated that we should leave as soon as possible \n"
						+ "but others opinions were different, some wanted the police to come save us, so they \n"
						+ "stayed put.. some were too scared to move and some thought of it as a joke.......";
				c3 = "I sprinted out as fast as I could. I had no time to tell anyone where I was going. \n"
						+ "In fact, I didn’t even know where I was going. I sprinted outside and was immediately \n"
						+ "greeted by walkers. I died fighting. GAME OVER.";
				c4 = "Soon after the undead filled the school, since we were trapped inside a classroom \n"
						+ "with no alternative exit the undead eventually broke through the door. GAME OVER";
				if (c2 == currentPrint) {
					correct = true;
				}
			} else {
				currentPrint = Part2.INTRO;
				// Go next
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
				decision = false;
			}
			break;
		case 1:
			if (gamePart == 1) {
				scene2.draw();
				currentPrint = Part1.s1;
				decision = true;
				d1 = "Decision 5: Close the door and leave your friend to his doom";
				d2 = "Decision 6: Attack the undead on your friend";
				d3 = "Decision 7: Pick up a chair and push the zombie away from your friend ";
				/* answer */d4 = "Decision 8: Run away with the remaining 2 people who support you";
				// Choices
				c1 = "After the undead was finished with your friend it seemed he got reinforcements, \n"
						+ "you realise the door wouldn't hold against such an intense amount of the undead, \n"
						+ "not soon after the door broke down.... GAME OVER";
				c2 = "I attempted to attack the undead which looks to be twice my weight and is enhanced \n"
						+ "with super undead strength, luckily my friend escaped but I took his place \n"
						+ "instead. GAMEOVER";
				c3 = "I pushed the zombie back with a chair with 2 other people. Unfortunately, all three \n"
						+ "of us were grabbing the chair and it became clumsy to handle. I fell forward right \n"
						+ "into the walker. GAME OVER";
				c4 = " I decided it was too late to save my friend. I wiped away a tear on my cheek and \n"
						+ "urged my 2 remaining friends to follow. Thankfully, they followed me and we ran \n"
						+ "from the room where my friend was being eaten. We had to decide where to go next.";
			} else {
				scene9.draw();
				currentPrint = Part2.s1;
				decision = true;
				/* answer */d1 = "Decision A - wear jeans and leather jacket";
				/* answer */d2 = "Decision B - wear sweater and track pants";
				d3 = "Decision C - wear boxers and muscle shirt";
				d4 = "Decision D - wear a bathrobe";
				// RESULTS
				/* correct */c1 = "I decided to wear jeans and a leather jacket, the pockets are large and the leather \n"
						+ "will provide enough protection.";
				/* correct */c2 = "I decided to wear sweater and track pants to allow ease of movement. The clothes \n"
						+ "will keep me warm if I have to run and begin to sweat.";
				c3 = "I decided to wear boxers and a muscle shirt because that is what I’m wearing right \n"
						+ "now and I’m too lazy to change. As I stepped outside I was immediately attacked by \n"
						+ "a walker, I fought him off but I was bitten multiple times on my exposed arms and \n"
						+ "legs. I could feel the fever taking over now. It won’t be long before I was one of\n"
						+ "them. GAME OVER.";
				c4 = "I decided to wear a bathrobe, since it was the most comfortable thing I could find. \n"
						+ "As I stepped outside I was attacked by a walker. I tried to fight him off but he \n"
						+ "grabbed my bathrobe and yanked on it. He then continued to rip me limb from limb. \n"
						+ "GAME OVER.";
			}
			break;

		case 2:
			if (gamePart == 1) {
				scene3.draw();
				currentPrint = Part1.s2;
				decision = true;
				/* answer */d1 = "Decision 9: Find some weapons at the Auto Tech Room";
				d2 = "Decision 10: Run to Tim Hortons";
				d3 = "Decision 11: Go to the Bathroom first (you might not have another chance)";
				d4 = "Decision 12: Run to the Calming Room";
				// Choices
				c1 = "This was a good move as the auto tech room consists of many tools and weapons... \n"
						+ "As the 3 students approach the auto tech room they find to their devastation that \n"
						+ "the door is locked.";
				c2 = "We decided that we would barricade ourselves inside a place with food, so we ran \n"
						+ "outside towards tim hortons, we had forgotten the fact that the undead was already \n"
						+ "at the door and had ourselves surrounded... GAME OVER";
				c3 = "You decide its best to stop by the washroom as you may not get another chance to \n"
						+ "go, as you are doing your business you failed to notice the zombie sneaking up on \n"
						+ "you... GAME OVER";
				c4 = "You start to feel anxious as you feel your grip on reality loosening, you ditch \n"
						+ "your friends and run for the calming room, before you can successfully reach the \n"
						+ "room you finally realised the fact we were in a lockdown and the doors are all \n"
						+ "locked.... GAME OVER";
			} else {
				scene10.draw();
				currentPrint = Part2.s2;
				decision = true;
				/* answer */d1 = "Decision E - find something to break to window with";
				d2 = "Decision F - try to pick the lock";
				d3 = "Decision G - break the window using bare fists";
				d4 = "Decision H - climb the building and look for an entrance on the roof";
				// RESULTS
				c1 = "I decided to try and find something to break the window with since I didn't have \n"
						+ "the time to pick the lock and didn’t want to risk getting cut on the glass by \n"
						+ "punching it with my own hands. I later found a metal pole on the ground that used \n"
						+ "to be the shaft of a traffic sign, I rammed the windows with it. Luckily, no \n"
						+ "walkers were around to hear the sound. I stepped through the broken glass with \n"
						+ "caution.";
				c2 = "I decided to pick the lock because I didn’t want to attract any unnecessary attention \n"
						+ "by breaking the window. Unfortunately I’ve never picked a lock before and it was \n"
						+ "taking me a long time. While I was concentrating, I failed to notice a walker \n"
						+ "sneaking up on me. I tried to defend myself but it was too late. The walker bit \n"
						+ "into my neck and processed to eat me alive. GAME OVER.";
				c3 = "I decided that I didn’t have time to find something to break the window with or try\n"
						+ "and pick the lock. I decided to try and break the window by punching it with my \n"
						+ "bare fists. The window broke after a few punches, but with horror I realized that \n"
						+ "one of the shards of glass had cut open one of my wrists badly. I tried to apply \n"
						+ "pressure on the wound but it seems that I’ve cut open an artery and blood was \n"
						+ "spilling out uncontrollably. I feel on the floor, bleeding to death. GAME OVER.";
				c4 = "I needed to think of a strategy, I needed to get in fast. I decided it was best \n"
						+ "that I try and climb the building and gain access from the roof. I looked to \n"
						+ "one of the pillars that supported the building. I made it halfway before I lost \n"
						+ "grip of the thing and slipped. I fell backwards onto the cold hard asphalt. I \n"
						+ "growled in pain and one of the walkers heard. It came stumbling towards me at a \n"
						+ "slow but steady pace. I tried to get away but I think one of my legs was broken. \n"
						+ "I could only crawl. Eventually, the walker caught up to me. And I knew I was doomed.\n"
						+ "GAME OVER.";
			}
			break;
		case 3:
			if (gamePart == 1) {
				scene4.draw();
				currentPrint = Part1.s3;
				decision = true;
				d1 = "Decision 13: Charge at the door";
				d2 = "Decision 14: Pound on the door";
				/* answer */d3 = "Decision 15: Find something to break the window with";
				d4 = "Decision 16: Just leave the school, you’re not getting in the auto tech room";
				// Choices
				c1 = "Charging at the door didn't really work, we did not realise that a student charging \n"
						+ "at a steel door does not work too well, we made a lot of noise and before we knew \n"
						+ "it we were surrounded.... GAME OVER";
				c2 = "Pounding at the door did not really help, we were quite panicked so we tried pounding \n"
						+ "as hard as we can but if there were anyone inside they probably thought we were the \n"
						+ "undead.... We attracted too much attention with the pounding... GAME OVER";
				c3 = "We needed to get in to get the tools. The door was not going to budge, so we need to \n"
						+ "get through the window. One of my friends had an old nokia phone that we threw at \n"
						+ "the window. The window shattered with a loud crash. I hope that didn’t attract any \n"
						+ "walkers...";
				c4 = "We decided to just leave the school. It was beginning to be overwhelmed by the \n"
						+ "undead. Staying could mean that we end up joining them. We ran out the nearest exit.\n"
						+ "Unfortunately, the outside world was filled with even more walkers, we tried to dart \n"
						+ "back, but to our stupidity we forgot to hold the door open. The door shut and we \n"
						+ "were locked outside. With no way back to the school, we were pinned down by walkers. \n"
						+ "We died fighting. GAME OVER.";
			} else {
				scene11.draw();
				currentPrint = Part2.s3;
				decision = true;
				d1 = "Decision I - fight him";
				/* answer */d2 = "Decision J - run away";
				d3 = "Decision K - grab Twinkies then run away";
				d4 = "Decision L - try and reason with him";
				// RESULTS
				c1 = "I wasn’t going to let anyone come in between me and my Twinkies. I didn’t have any \n"
						+ "weapons, but I had my bare fists. I punched out at him furiously. The walker was \n"
						+ "stronger than I thought, he grabbed me by the arm and then bit into it. I screamed \n"
						+ "out in pain as he proceeded to eat the rest of me. GAME OVER.";
				c2 = "I decided that my life was worth more than a box of Twinkies. I realized that this \n"
						+ "is a grown adult man turned into a bloodthirsty walker and there was no way I can \n"
						+ "fight him without a weapon. So I bolted out the same way I came. Thankfully, the \n"
						+ "walker was slower than me and I was able to get away.";
				c3 = "I decided that he was too strong to fight, but that doesn’t me that I can’t have my \n"
						+ "Twinkies. I took a step forward and grabbed the Twinkies, but by then the walker \n"
						+ "was within grasping distance of me. It was too late to run, I had no other choice \n"
						+ "but to fight. I smashed him in the head as hard as I could with the box of Twinkies. \n"
						+ "It did little good, the cardboard box did no harm to the walker as he reached, \n"
						+ "grabbed me and bit me in the neck. GAME OVER.";
				c4 = "I head from the media that this disease was merely an infection. If he was just \n"
						+ "merely sick, I may be able to reason with him. The walker was too strong to fight, \n"
						+ "and I didn’t know if I had time to run away. And besides, I really wanted those \n"
						+ "boxes of Twinkies. So I tried to ask him politely to get by so I can grab the \n"
						+ "boxes. He responded me with outstretched arms and a grunt which I could not \n"
						+ "comprehend. When I asked him for clarification he grabbed me and started to tear \n"
						+ "off my flesh. GAME OVER.";
			}
			break;
		case 4:
			if (gamePart == 1) {
				scene5.draw();
				currentPrint = Part1.s4;
				decision = true;
				/* answer */d1 = "Decision 17: grab a small metal hammer";
				/* answer */d2 = "Decision 18: grab large metal hammer";
				d3 = "Decision 19: Don’t grab a hammer at all, go for a pair of needle nose pliers";
				d4 = "Decision 20: Don’t grab a hammer at all, go for a piece of wood";
				// Choices
				c1 = "";
				c2 = "";
				c3 = "I saw one of my friends grabbing a pair of needle-nose pliers. I decided to join him \n"
						+ "and grab a pair for myself. It might come in handy later, and it can be used as a \n"
						+ "weapon if necessary. Unfortunately, it wasn’t an effective weapon as I thought as \n"
						+ "a wave of zombies burst into the room. I stabbed the nearest walker furiously with \n"
						+ "my pliers, for all the good it did me. I died fighting. GAME OVER.";
				c4 = "On second thought, I decided that a piece of wood would be better than a hammer. \n"
						+ "Once i’m safe, I can find a crafting table and make a wooden sword out of it. \n"
						+ "I gasped as horde of zombies burst through the door. Unfortunately, the plank \n"
						+ "of wood wasn’t a very effective weapon. It was rather clumsy to swing. The horde \n"
						+ "of zombies washed over me. GAME OVER.";
			} else {
				scene12.draw();
				currentPrint = Part2.s4;
				decision = true;
				d1 = "Decision M - take gardening scissors";
				d2 = "Decision N - take snow shovel";
				/* answer */d3 = "Decision O - take framing hammer";
				d4 = "Decision P - take wooden plank";
				// RESULTS
				c1 = "I decided to take gardening scissors, I can cut the walkers to pieces if they come \n"
						+ "near me. I had no time to waste. I ran out of the hardware store and immediately \n"
						+ "encountered a walker. I used my gardening scissors on him. Unfortunately it got \n"
						+ "stuck in his chest as I tried to cut and stab my way to escape. I thought a pair \n"
						+ "of scissors stabbed into his torso would stop him, but it didn’t. He kept coming \n"
						+ "at me and I had no way to defend myself and nowhere to run. I died fighting. \n"
						+ "GAME OVER";
				c2 = "I decided to take the snow shovel because I could swing it and it was long so I \n"
						+ "could use it to keep a distance between myself and the walker if it becomes \n"
						+ "necessary. \n\n"
						+ "I had no time to waste. I ran out of the hardware store and immediately encountered \n"
						+ "a walker. I used my snow shovel on him. Unfortunately it was very big and clumsy to \n"
						+ "swing, and the head of the shovel was made of plastic so it did little damage. The \n"
						+ "walker kept coming at me and I had no way to defend myself and nowhere to run. I \n"
						+ "died fighting. GAME OVER";
				c3 = "I decided to take the framing hammer. It had a good weight to it that would make it \n"
						+ "quick to swing but also do a lot of damage. \n\n"
						+ "I had no time to waste. I ran out of the hardware store and immediately encountered \n"
						+ "a walker. I used my hammer on him. I swung the hammer quick and hard, and buried \n"
						+ "the sharp end right into the walker’s head. That stopped the walker dead in his \n"
						+ "track. I tucked away the hammer, hopefully I would not need to use it again today.";
				c4 = "I decided to take the wooden plank. It was long so I can use it to keep a distance \n"
						+ "between myself and a walker if I encounter one. I could also sharpen it or make \n"
						+ "it into a wooden sword when I got home to my crafting table. \n\n"
						+ "I had no time to waste. I ran out of the hardware store and immediately encountered\n"
						+ "a walker. I used my wooden plank on him. Unfortunately, it was clumsy and difficult\n"
						+ "to swing. My first swing missed the walker completely, and I stumbled and fell from \n"
						+ "the momentum, I dropped the wooden plank in the process. The walker kept coming at \n"
						+ "me and I had no way to defend myself and nowhere to run. I died fighting. \n"
						+ "GAME OVER";
			}
			break;
		case 5:
			if (gamePart == 1) {

				currentPrint = Part1.s5;
				decision = false;
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
			} else {
				scene13.draw();
				currentPrint = Part2.s5;
				decision = true;
				d1 = "Decision Q - hit him with hammer";
				d2 = "Decision R - threaten him";
				d3 = "Decision S - give him all the Twinkies";
				/* answer */d4 = "Decision T - try and negotiate with him";
				// RESULTS
				c1 = "I tried to fight him. I wasn’t about to just let him take my Twinkies. I would have \n"
						+ "almost gotten killed twice for nothing if I went home empty handed. I pulled out \n"
						+ "my hammer and ran towards him. He was faster though, I didn’t even make it halfway \n"
						+ "before I heard the first gunshot. I was hit in the chest and fell flat on my face. \n"
						+ "He was yanking off my backpack as I breathed my last breath. GAME OVER";
				c2 = "I warned him that if he tried to take my food, I would kill him. He only laughed \n"
						+ "coldly and raised his gun another couple of inches. The last thing I saw was the \n"
						+ "bright flash of the muzzle as he pulled the trigger. GAME OVER";
				c3 = "I saw no other alternative than to give him what he wanted. The gunman also took the \n"
						+ "rest of the food in the convenience store. My hopes dwindled as my stomach growled. \n\n"
						+ "I made it home and ate nothing for dinner. All the nearby stores were out of food. \n"
						+ "I would have to make another trip to somewhere farther next time. That never \n"
						+ "happened though. Very soon I was too weak to walk. I laid in my bed dying from \n"
						+ "starvation, the end came slowly and painfully. GAME OVER";
				c4 = "I decided it was best to try and reason with him. He had a gun and I only had a \n"
						+ "hammer. I offered to give him half of my Twinkies. The gunman also took the \n"
						+ "rest of the food in the convenience store. I lied and said that I knew the \n"
						+ "location a food storage warehouse nearby. When he demanded evidence, I showed \n"
						+ "him the keys that I had taken from the first convenience store. I told him that \n"
						+ "there would be enough food for both of us if he let me live and show him where \n"
						+ "the warehouse is. Thankfully, he accepted my offer and we proceeded out of the \n"
						+ "convenience store. And fortunately, he didn’t notice that I still had my hammer.";
			}
			break;
		case 6:
			if (gamePart == 1) {
				scene6.draw();
				currentPrint = Part1.s6;
				decision = true;
				/* answer */d1 = "Decision 21: Go to my house";
				d2 = "Decision 22: Go to the supermarket to find food";
				d3 = "Decision 23: Go to the carnival";
				d4 = "Decision 24: Go to the bathroom";
				// Choices
				c1 = "I decided it was too dangerous to go and find food now. My house was nearby and \n"
						+ "I have a good supply of food at my house that should at least last a few weeks. \n"
						+ "We ran across fields and parking lots. Sounds of chaos were assaulting my ears \n"
						+ "from all directions.";
				c2 = "We decided to go to the grocery store to get food. We’re going to need a lot of \n"
						+ "it if we mean to survive. We approached the grocery store cautiously. The store \n"
						+ "was nearly empty. There were a few survivors grabbing what little supplies \n"
						+ "remained. We stayed well away from them, I realized they could be just as \n"
						+ "dangerous as the undead. I grabbed some Twinkies, luckily there were still a \n"
						+ "couple of boxes left. My friend and I emptied out our backpacks and stuffed them \n"
						+ "with Twinkies. Unfortunately a man with a gun saw us with the Twinkies and \n"
						+ "demanded them at gunpoint. My friend was unwilling to give up the Twinkies \n"
						+ "however, and lunged at the gunman. He shot us both. GAME OVER.";
				c3 = "I decided to go to the carnival just then. It might be my last chance ever to \n"
						+ "ride the ferris wheel. There might also be some food also. I could use some \n"
						+ "popcorn right now. My other friend appeared just as eager as me to ride the \n"
						+ "ferris wheel. Happily, we made our way to the carnival. The gates were closed \n"
						+ "but that didn’t stop us, we climbed over the fence. Our happiness quickly ended \n"
						+ "when a horde of zombies rushed out from the prize tents and greeted us with open \n"
						+ "bloody mouths and rotted teeth. We tried to climb back over the fence, but it was \n"
						+ "too late. I was panicking and the fence seemed both higher and slipperier than it \n"
						+ "had been. I died a painful death. GAME OVER.";
				c4 = "I had to go real bad. I couldn’t just go right here, it would be really awkward \n"
						+ "with my friend watching. I missed the flushing toilet, you never notice that fact \n"
						+ "until it’s gone. The water system might still be working, this might be my last \n"
						+ "chance to pee in a toilet. I made my way back to the school. I can hear my friend \n"
						+ "yelling at me wondering what the heck I was doing. But if he felt the same urge \n"
						+ "to pee as I did he would understand. I told him that I would be right back and \n"
						+ "told him to wait for me. I opened up the door, and to my horror I remembered \n"
						+ "that the school was filled with the undead. They rushed out in hordes and teared \n"
						+ "me from limb to limb. GAME OVER.";
			} else {
				scene14.draw();
				currentPrint = Part2.s6;
				decision = true;
				d1 = "Decision U - wrestle the gun from him";
				d2 = "Decision V - try and run away";
				d3 = "Decision W - shove him into horde of zombies";
				/* answer */d4 = "Decision X - kill the gunman with hammer";
				// RESULTS
				c1 = "I decided to wrestle the gun from him. I lunged towards him and grabbed the gun.\n"
						+ "He was strong though, we fought while the walkers proceeded to stumble towards us. \n"
						+ "I was able to overpower him but not before we were both surrounded by the horde. \n"
						+ "The zombies ate us both. GAME OVER";
				c2 = "I bolted away as fast as I could. Leaving the horde and the gunman behind. I heard \n"
						+ "a yell and then a gunshot. I fell hard on the ground. I’ve been shot. The gunman ran \n"
						+ "over and finished me off. GAME OVER";
				c3 = "I decided it was the best opportunity to be rid of the gunman and distract the \n"
						+ "walkers in one shot. I grabbed the gunman’s shirt and gave him a good shove. \n"
						+ "Unfortunately the gunman realized what I was doing before I could let go. He \n"
						+ "grabbed me by the arm and then shot me. I fell on the ground bleeding. The \n"
						+ "walkers would be on me in a second. GAME OVER";
				c4 = "I pulled out my hammer and hit the gunman on the head as hard as I could. Whether\n"
						+ "it killed him or only knocked him out I don’t know, but the gunman’s legs \n"
						+ "turned to jelly as he fell. I grabbed his gun and his pack of food and made \n"
						+ "my escape. I need not fear him coming after me. If he’s not dead already, the \n"
						+ "walkers would get him.";
			}
			break;
		case 7:
			if (gamePart == 1) {
				scene7.draw();
				currentPrint = Part1.s7;
				decision = true;
				/* answer */d1 = "Decision 25: Leave friend to his death";
				d2 = "Decision 26: Laugh in his face for inability to ride a bike";
				d3 = "Decision 27: Grab his shears, they might come in handy later";
				d4 = "";
				// Choices
				c1 = "It was too late to save him, and the horde was being distracted. I biked away as \n"
						+ "fast as I could, shedding a tear in the process for my slain friend. I was able \n"
						+ "to get away. I made it to my house without any more close calls. This morning I \n"
						+ "had everything and now I have nothing. ";
				c2 = "I laughed at him as he fell off his bike . My friend cursed me loudly and demanded \n"
						+ "that I help him. By that time I was on the ground rolling in laughter. Unfortunately \n"
						+ "I forgot that we were both surrounded by zombies. My laughter turned to screams as \n"
						+ "zombies grabbed me from behind. My friend cursed me for my stupidity as we were both \n"
						+ "ripped from limb to limb.";
				c3 = "I decided it was too late to save him. But on second thought, if he was going to \n"
						+ "die I should have his shears. They might come in handy later. By then my friend \n"
						+ "was screaming for me to help him. I dismounted from the bike, and ran towards him. \n"
						+ "I ignored his cries for help as I grabbed his shears. I barely got the shears free \n"
						+ "from his belt as a walker bit into his neck. I turned to run but realized to my \n"
						+ "horror that I was surrounded by walkers. Karma’s got me now. I died fighting. \n"
						+ "GAME OVER.";
				c4 = "";
			} else {
				scene15.draw();
				currentPrint = Part2.s7;
				decision = true;
				/* answer */d1 = "Decision Y - find a bicycle";
				/* answer */d2 = "Decision Z - just walk home";
				d3 = "Decision AA - ride a segway home";
				d4 = "Decision AB - ride a dragon";
				// RESULTS
				c1 = "I decided to search for a bicycle. It was too big of a risk to walk home and I \n"
						+ "needed to get back quickly. I found a rusty old bike abandon by the side of the \n"
						+ "road. It looked old but the chain was still intact. I rode the bike home without \n"
						+ "any more close calls.";
				c2 = "I decided not to be a lazy bum and just walk home. It took me a good 20 minutes but \n"
						+ "I made it without any more close calls.";
				c3 = "I decided to look for a segway. I have never ridden one before and it looked fun. \n"
						+ "I decided that since the world ended it would be the best time to buy one since \n"
						+ "it would be free. I searched for another hour before I found a store that sold \n"
						+ "segways. I got on one and was surprised that it still worked. Unfortunately, I \n"
						+ "had pushed my luck too far and didn’t realize that a few walkers followed me into \n"
						+ "the segway store. I tried to ride them down with my segway but that didn’t work as \n"
						+ "well as I thought it would. The walkers yanked me off of the segway and proceed \n"
						+ "to tear my flesh apart. Ah well, at least I rode a segway. GAME OVER";
				c4 = "I have gone without Twinkies for too long. My brain was malnutritioned and I was \n"
						+ "tired. I became so delusional as I have come to believe that I am the reincarnation\n"
						+ "of Sir Erlenmeyer Flask, a medieval knight who fought on the back of a dragon. After \n"
						+ "hours of searching, I finally found a dragon and tried to mount it. Unfortunately, \n"
						+ "and to my horror, my dragon turned out to be a walker. He flung me off and began to\n"
						+ "eat my flesh. GAME OVER.";
			}
			break;
		case 8:
			if (gamePart == 1) {
				scene8.draw(); // draw bg
				currentPrint = Part1.s8;
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
				decision = false;
			} else {
				currentPrint = Part2.s8;
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
				decision = false;
			}
			break;
		default:
			if (gamePart == 1) {
				if ((empathy >= 3) && (skill >= 3) && (knowledge >= 3)) {
					// Ranking // ultimate bullshit
					currentPrint = "End of Part 1 \n\n" +
							"Empathy Rank = A!\n" +
							"Skill Rank = A!\n" +
							"Knowledge Rank = A!";
				} else {
					currentPrint = "End of Part 1 \n\n" +
							"Empathy Rank = B!\n" +
							"Skill Rank = B!\n" +
							"Knowledge Rank = B!";
				}
				g.drawString("Start Part 2?", 600, 400);
				if ((xpos > 600 && xpos < 780) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						gamePart = 2;
						leSlide = 0;
						counter = 0;
						leSpeed = 80;
					}
				}
			} else {
				currentPrint = "End of Part 2";
				g.drawString("Congrats you beat the game!", 600, 400);
			}
			break;
		}
		// sigh more switch statements -__-
		// Choice Handler
		switch (choice) {
		case 1:
			g.clear();
			if (correct != true) {
				gameOver.draw();
				g.drawString("Retry", 600, 400);
				g.drawString("Quit", 660, 400);
				if ((xpos > 600 && xpos < 650) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						prevSlide = true;
						leSpeed = 80;
					}
				}
				if ((xpos > 660 && xpos < 710) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						sbg.enterState(0);
					}
				}
			} else {
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
			}
			if (gamePart == 1) {
				switch (leSlide) {
				case 0:
					correct = false;
					break;
				case 1:
					correct = false;
					break;
				case 2:
					correct = true;
					knowledge += 1;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = true;
					knowledge += 1;
					break;
				case 5:
					break;
				case 6:
					correct = true;
					empathy += 1;
					break;
				case 7:
					correct = true;
					skill += 1;
					break;
				}
			} else if (gamePart == 2) {
				switch (leSlide) {
				case 0:
					break;
				case 1:
					correct = true;
					skill += 1;
					break;
				case 2:
					correct = true;
					empathy += 1;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = false;
					break;
				case 5:
					correct = false;
					break;
				case 6:
					correct = false;
					break;
				case 7:
					knowledge += 1;
					correct = true;
					break;
				}
			}
			// above decides which one is correct
			currentPrint = c1;
			decision = false;
			break;
		case 2:
			g.clear();
			if (correct != true) {
				gameOver.draw();
				g.drawString("Retry", 600, 400);
				g.drawString("Quit", 660, 400);
				if ((xpos > 600 && xpos < 650) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						prevSlide = true;
						leSpeed = 80;
					}
				}
				if ((xpos > 660 && xpos < 710) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						sbg.enterState(0);
					}
				}
			} else {
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
			}
			if (gamePart == 1) {
				switch (leSlide) {
				case 0:
					correct = true;
					empathy += 2;
					break;
				case 1:
					correct = false;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = true;
					knowledge += 1;
					break;
				case 5:
					break;
				case 6:
					correct = false;
					break;
				case 7:
					correct = false;
					break;
				}
				// above decides which one is correct
			} else if (gamePart == 2) {
				switch (leSlide) {
				case 0:
					// not needed
					break;
				case 1:
					correct = true;
					skill += 1;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = true;
					empathy += 1;
					break;
				case 4:
					correct = false;
					break;
				case 5:
					correct = false;
					break;
				case 6:
					correct = false;
					break;
				case 7:
					correct = true;
					knowledge += 1;
					break;
				}
			}
				// above decides which one is correct
			currentPrint = c2;
			decision = false;
			break;
		case 3:
			g.clear();
			if (correct != true) {
				gameOver.draw(); // Game Over Screen
				g.drawString("Retry", 600, 400);
				g.drawString("Quit", 660, 400);
				if ((xpos > 600 && xpos < 650) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						prevSlide = true;
						leSpeed = 80;
					}
				}
				if ((xpos > 660 && xpos < 710) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						sbg.enterState(0);
					}
				}
			} else {
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
			}
			if (gamePart == 1) {
				switch (leSlide) {
				case 0:
					correct = false;
					break;
				case 1:
					correct = false;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = true;
					skill += 1;
					break;
				case 4:
					correct = false;
					break;
				case 5:

					break;
				case 6:
					correct = false;
					break;
				case 7:
					correct = false;
					break;
				}
				// above decides which one is correct
			} else if (gamePart == 2) {
				switch (leSlide) {
				case 0:
					// not needed
					break;
				case 1:
					correct = false;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = true;
					knowledge += 1;
					break;
				case 5:
					correct = false;
					break;
				case 6:
					correct = false;
					break;
				case 7:
					correct = false;
					break;
				}
			}
			// above decides which one is correct
			currentPrint = c3;
			decision = false;
			break;
		case 4:
			g.clear();
			if (correct != true) {
				gameOver.draw();
				g.drawString("Retry", 600, 400);
				g.drawString("Quit", 660, 400);
				if ((xpos > 600 && xpos < 650) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						prevSlide = true;
						leSpeed = 80;
					}
				}
				if ((xpos > 660 && xpos < 710) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						sbg.enterState(0);
					}
				}
			} else {
				g.drawString("Next", 710, 400);
				if ((xpos > 700 && xpos < 750) && (ypos > 30 && ypos < 60)) {
					if (input.isMousePressed(0)) {
						nextSlide = true;
						leSpeed = 80;

					}
				}
			}
			if (gamePart == 1) {
				switch (leSlide) {
				case 0:
					correct = false;
					break;
				case 1:
					correct = true;
					skill += 1;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = false;
					break;
				case 5:
					break;
				case 6:
					correct = false;
					break;
				case 7:
					correct = false;
					break;
				}
				// above decides which one is correct
			} else if (gamePart == 2) {
				switch (leSlide) {
				case 0:
					// not needed
					break;
				case 1:
					correct = false;
					break;
				case 2:
					correct = false;
					break;
				case 3:
					correct = false;
					break;
				case 4:
					correct = false;
					break;
				case 5:
					correct = true;
					empathy += 1;
					break;
				case 6:
					correct = true;
					skill += 1;
					break;
				case 7:
					correct = false;
					break;
				}
			}
			// above decides which one is correct
			currentPrint = c4;
			decision = false;
			break;
		default:
			break;
		}
		int now = (int) System.currentTimeMillis();
		while ((now - timer) >= leSpeed) { // While loop for typewriter style text display
			timer = (int) System.currentTimeMillis();
			textBreak = currentPrint.substring(0, counter); // print letter by letter
			if (counter < currentPrint.length()) {
				counter++;
			}
		}
		if (nextSlide == true) { // when slides switch
			g.clear(); // clear graphics
			leSlide++; // add 1 to leSlide
			choice = Byte.MAX_VALUE; // resets choice to something outside of switch statement
			counter = 0; // counter = 0 for typewriter text, resets it
			nextSlide = false; // sets it to false
			if (nextSlide == false) { 
				g.clear();// clears again
			}
		}
		if (prevSlide == true) {
			g.clear();
			choice = Byte.MAX_VALUE;
			counter = 0;
			prevSlide = false;
			if (prevSlide == false) {
				g.clear();
			}
		} 
		// opposite of nextSlide ^
		// Arrow Handler (displays arrow on mouse hover)
		switch (showArrow) {
		case 1:
			arrow.draw(7, 270);
			break;
		case 2:
			arrow.draw(7, 300);
			break;
		case 3:
			arrow.draw(7, 330);
			break;
		case 4:
			arrow.draw(7, 360);
			break;
		}
		// prints strings to screen
		g.drawString(mouseOver, 750, 0);
		g.drawString(textBreak, 35, 35);
		// draw decisions
		if (decision == true) {
			g.drawString(d1, 100, 280);
			g.drawString(d2, 100, 310);
			g.drawString(d3, 100, 340);
			g.drawString(d4, 100, 370);
		}
		// Pause menu
		if (quit == true) {
			g.drawString("Resume(R)", 15, 380);
			g.drawString("Main Menu(M)", 15, 400);
			g.drawString("Quit Game(Q)", 15, 420);
			if (quit == false) {
				g.clear();
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int xpos = Mouse.getX(), ypos = Mouse.getY();
		// Right click to show all text, skip animation
		if (input.isMousePressed(1)) {
			leSpeed = 0;
		}
		// mouse click handler if decision display is true
		if (decision == true) {
			// c1
			if ((xpos > 80 && xpos < 600) && (ypos > 155 && ypos < 170)) {
				showArrow = 1;
				if (input.isMouseButtonDown(0)) {
					choice = 1;
					counter = 0;
					showArrow = 0;
				}
			}
			// c2
			if ((xpos > 80 && xpos < 600) && (ypos > 125 && ypos < 140)) {
				showArrow = 2;
				if (input.isMousePressed(0)) {
					choice = 2;
					counter = 0;
					showArrow = 0;
				}
			}
			// c3
			if ((xpos > 80 && xpos < 600) && (ypos > 95 && ypos < 110)) {
				showArrow = 3;
				if (input.isMousePressed(0)) {
					choice = 3;
					counter = 0;
					showArrow = 0;
				}
			}
			// c4
			if ((xpos > 80 && xpos < 600) && (ypos > 65 && ypos < 80)) {
				showArrow = 4;
				if (input.isMousePressed(0)) {
					choice = 4;
					counter = 0;
					showArrow = 0;
				}
			}
		}
		// Keyboard key listeners
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			quit = true;
		}
		if (quit == true) {
			if (input.isKeyDown(Input.KEY_R)) {
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_M)) {
				sbg.enterState(0);
				quit = false;
			}
			if (input.isKeyDown(Input.KEY_Q)) {
				System.exit(0);
			}
		}
		// shows mouse coordinates in the corner
		mouseOver = "x:" + xpos + "\ny:" + ypos;
	}

	public int getID() {
		return 1;
	}
}