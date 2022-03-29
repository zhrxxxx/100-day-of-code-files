numRings = 163; 

ring = [0]*numRings; 

currentRing = 0;

colour = None;
c, d= None, None

ro = 0;
rou = 0;
a = None;
tenT = 0;


# 2. how to setup: setup(), draw() - like always 
def setup():
  size(600,600);
  smooth();
  global numRings, ring;
  global c, d
  c= color(random(255), random(255), random(255))
  d= color(random(255), random(255), random(255))

  for i in range(numRings): 
    global c, d, ro;
    ro += 1
    if (ro % 2) == 0:
      #colour = color(c); # maybe look at HSL instead of RGB
      ring[i] = Ring(0, 0, 0, False, colour) # Create each object with our initial parameters
    elif (ro % 2) == 1:
      #colour = color(d); # maybe look at HSL instead of RGB
      ring[i] = Ring(0, 0, 0, False, colour); # Create each object with our initial parameters    

def draw():

  global numRings, ring, colour;

  for x in range(width): # loop through every x
      p = lerpColor(c, d, 1.0 * x/width) # transition smoothly
      stroke(p)
      line(x, 0, x, height)  



  for i in range(numRings):
    # so we check for each ring object that could possibly exist 
    # and this is why we scan the whole array from 0 to numRings = 40
    # at each element of the array we check if there are any conditions
    # or attributes 
    ring[i].grow(); # a condition _we_ defined in class
    ring[i].display(); # the draw conditions _we_ defined in class



# 3. because we want some interactivity - let's use the same form as in Week 4
def mousePressed():
  global currentRing, ring, c, d, a, ro, rou, tenT;
  # when we click our mouse button we want to activate a ring
  # at the location of the cursor...
  # so our xpos = mouseX
  # and the ypos = mouseY
  ro = ro+1;
  r = 1 + int(random(9));
  a = random(10);
  ran2 = int(random(2));
  print ran2;
  
  if mouseX < width/2:
    for i in range(r):
      if ran2 == 0:
        ring[currentRing].start(mouseX , mouseY); 
        rou = 0;
      else:
        ring[currentRing].start(mouseX+ i*random(10) - i*random(10), mouseY+ i*random(10) - i*random(10));
        rou = 1;
      
      currentRing += 1;
      if (currentRing >= numRings):
          currentRing = 0;

  else:
    for i in range(r):
      if ran2 == 1:
        ring[currentRing].start(mouseX , mouseY); 
        rou = 1;
      else:
        ring[currentRing].start(mouseX+ i*random(10) - i*random(10), mouseY+ i*random(10) - i*random(10));
        rou = 0;
        
      currentRing += 1;
      if (currentRing >= numRings):
          currentRing = 0;
      
  
  tenT += 1;
  if (tenT%5 == 0):
    c= d
    d= color(random(255), random(255), random(255))
    

# 4. THE POINT OF LECTURE 09 / WEEK 5 -- OOP setup for a python class 
class Ring(object):
  # we need to ask ourselves
  # what attributes, or characteristics
  # do we want our rings to have?

  # A NOTE ON `self`: we need this object to know about
  # _ its own self_, so _it_ can make
  # changes to its _self_


  # 1. initialize -> think of me as a 1-to-1 with def setup()
  # I am needed for an instance of class to exist ( I self, therefore I am )
  def __init__(self, x, y, diameter, on, colour):
    self.x = x;
    self.y = y;
    self.diameter = diameter;
    self.on = False;


  # 2. start -> think of me as a 1-to-1 with the trigger - def mousePressed()
  def start(self, xpos, ypos):
    global rou;

    self.x = xpos;
    self.y = ypos;
    self.on = True;
    self.diameter = int(random(100));

  # 3. grow -> think of me as an option in def draw():
  def grow(self):
    global a;
    #print a;
    md = 100 + random(300)
    if (self.on == True):
      self.diameter += a;
      if (self.diameter > md):
        self.on = False;

  # 4. display -> think of me as a 1-to-1 with def draw():
  def display(self):
    global rou, c, d;
    
    if (self.on == True):
      noFill();
      strokeWeight(int(random(10)));
      if rou == 1:
        stroke(c)
      else:
        stroke(d);
      
      ellipse(self.x, self.y, self.diameter, self.diameter);



  # assigning a new random colour
  # you can try adding the random colour generator here or as an optional 
  # parameter passed in to self.colour = colour;

  #def colour(colour):
    #self.colour = colour; # you can use this method or try another way 

  # did you want to add sound? try it here and follow the pattern from Week 04 
  # maybe you want to initialize something in def __init__(): ?
  def sound():
    pass # place holder until you think of something to add
