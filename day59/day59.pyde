numRings = 100; 

ring = [0]*numRings; 

currentRing = 0;

colour = None;
c, d= None, None
col = None;
side = 9;

# 2. how to setup: setup(), draw() - like always 
def setup():
  size(600,600);
  smooth();
  global numRings, ring;
  global c, d, side;
  c= color(random(255), random(255), random(255))
  d= color(random(255), random(255), random(255))

  for i in range(numRings): 
      if side == 1:
        colour = color(random(255), random(255), random(255)); # maybe look at HSL instead of RGB
        ring[i] = Ring(0, 0, 0, False, colour); # Create each object with our initial parameters
      else:
        colour = color(255, 255, 255); # maybe look at HSL instead of RGB
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
  global currentRing, ring, c, d, col;
  # when we click our mouse button we want to activate a ring
  # at the location of the cursor...
  # so our xpos = mouseX
  # and the ypos = mouseY
  c= color(random(255), random(255), random(255))
  d= color(random(255), random(255), random(255))
  
  r = int(random(9));
  
  if mouseX > (width/2):
    col = color(255, 255, 255);
    print col;
  else:
    col = color(0, 0, 0);
  
  for i in range(r):
    ring[currentRing].start(mouseX+ i*random(10) - i*random(10), mouseY+ i*random(10) - i*random(10)); # an activation _we_ defined in class
    # we won't let more than a total amount of numRings number of rings
    # to be present on the canvas at the same time 
    # so we scan for mouse clicks that translate into ring activations/constructions
    # and when or if that number of mouse clicks hits our max of numRings
    # we will .. disappear.. all the rings and start back at no rings, then 1 ring etc.
    currentRing += 1;
    if (currentRing >= numRings):
        currentRing = 0;
    i += 1;


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
    self.colour = colour;

  # 2. start -> think of me as a 1-to-1 with the trigger - def mousePressed()
  def start(self, xpos, ypos):
    self.x = xpos;
    self.y = ypos;
    self.on = True;
    self.diameter = int(random(100));

  # 3. grow -> think of me as an option in def draw():
  def grow(self):

    if (self.on == True):
      x = random(10);
      self.diameter += random(10);
      if (self.diameter > 400):
        self.on = False;

  # 4. display -> think of me as a 1-to-1 with def draw():
  def display(self):

    if (self.on == True):
      noFill();
      strokeWeight(4);
      stroke(col); #stroke(255, 153)
      ellipse(self.x, self.y, self.diameter, self.diameter);



  # assigning a new random colour
  # you can try adding the random colour generator here or as an optional 
  # parameter passed in to self.colour = colour;

  #def colour(colour):
    #self.colour = colour; # you can use this method or try another way 

  # did you want to add sound? try it here and follow the pattern from Week 04 
  # maybe you want to initialize something in def __init__(): ?
