colour = color(random(255), random(255), random(255));

def setup() :
  size(800, 800)
  smooth()
  
def draw():
  global colour;
  
  background(253)
  stroke(colour) 
  noFill()  
  constantFactor = 1.3
  circleSize = 20 
  
  for i in range(0,20):
    #draws 20 concentric circles of decreasing diameter and decreasing lineWeight
    strokeWeight(circleSize/25.0) 
    ellipse(width/2,height, circleSize, circleSize)
    circleSize = circleSize * constantFactor 
